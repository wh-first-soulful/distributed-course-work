package com.lightmall.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lightmall.common.redis.BloomFilterUtil;
import com.lightmall.common.redis.RedisUtil;
import com.lightmall.goods.mapper.SeckillGoodsMapper;
import com.lightmall.goods.model.SeckillGoods;
import com.lightmall.goods.service.SeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class SeckillGoodsServiceImpl extends ServiceImpl<SeckillGoodsMapper, SeckillGoods> implements SeckillGoodsService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private BloomFilterUtil bloomFilterUtil;

    // 用于处理缓存击穿的锁
    private final ReentrantLock lock = new ReentrantLock();

    // 缓存前缀
    private static final String SECKILL_GOODS_CACHE_PREFIX = "seckill:goods:id:";

    @Override
    public List<SeckillGoods> getSeckillGoodsList() {
        return list();
    }

    @Override
    public SeckillGoods getSeckillGoodsById(Long id) {
        // 1. 先检查布隆过滤器，防止缓存穿透
        String key = SECKILL_GOODS_CACHE_PREFIX + id;
        if (!bloomFilterUtil.mightContain(key)) {
            return null;
        }

        // 2. 尝试从缓存获取
        SeckillGoods seckillGoods = (SeckillGoods) redisUtil.get(key);
        if (seckillGoods != null) {
            return seckillGoods;
        }

        // 3. 缓存击穿处理：使用锁确保只有一个线程查询数据库
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                try {
                    // 再次检查缓存，防止其他线程已经更新了缓存
                    seckillGoods = (SeckillGoods) redisUtil.get(key);
                    if (seckillGoods != null) {
                        return seckillGoods;
                    }

                    // 4. 从数据库获取
                    seckillGoods = getById(id);
                    if (seckillGoods != null) {
                        // 5. 设置随机过期时间，防止缓存雪崩
                        int expireTime = 3600 + new Random().nextInt(3600);
                        redisUtil.set(key, seckillGoods, expireTime);
                        // 添加到布隆过滤器
                        bloomFilterUtil.add(key);
                    }
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 6. 如果获取锁失败，直接从数据库获取
        if (seckillGoods == null) {
            seckillGoods = getById(id);
            if (seckillGoods != null) {
                int expireTime = 3600 + new Random().nextInt(3600);
                redisUtil.set(key, seckillGoods, expireTime);
                bloomFilterUtil.add(key);
            } else {
                // 对于不存在的数据，也设置一个短期缓存，防止缓存穿透
                redisUtil.set(key, null, 60);
            }
        }

        return seckillGoods;
    }

    @Override
    public boolean addSeckillGoods(SeckillGoods seckillGoods) {
        boolean result = save(seckillGoods);
        if (result) {
            // 清除缓存
            String key = SECKILL_GOODS_CACHE_PREFIX + seckillGoods.getId();
            redisUtil.del(key);
            // 添加到布隆过滤器
            bloomFilterUtil.add(key);
        }
        return result;
    }

    @Override
    public boolean updateSeckillGoods(SeckillGoods seckillGoods) {
        boolean result = updateById(seckillGoods);
        if (result) {
            // 清除缓存
            String key = SECKILL_GOODS_CACHE_PREFIX + seckillGoods.getId();
            redisUtil.del(key);
        }
        return result;
    }

    @Override
    public boolean deleteSeckillGoods(Long id) {
        boolean result = removeById(id);
        if (result) {
            // 清除缓存
            String key = SECKILL_GOODS_CACHE_PREFIX + id;
            redisUtil.del(key);
        }
        return result;
    }
}
