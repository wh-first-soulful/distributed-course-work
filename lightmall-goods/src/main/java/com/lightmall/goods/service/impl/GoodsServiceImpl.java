package com.lightmall.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lightmall.common.redis.BloomFilterUtil;
import com.lightmall.common.redis.RedisUtil;
import com.lightmall.goods.mapper.GoodsMapper;
import com.lightmall.goods.model.Goods;
import com.lightmall.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private BloomFilterUtil bloomFilterUtil;

    // 用于处理缓存击穿的锁
    private final ReentrantLock lock = new ReentrantLock();

    // 缓存前缀
    private static final String GOODS_CACHE_PREFIX = "goods:id:";

    @Override
    public List<Goods> getGoodsList() {
        return list();
    }

    @Override
    public Goods getGoodsById(Long id) {
        // 1. 先检查布隆过滤器，防止缓存穿透
        String key = GOODS_CACHE_PREFIX + id;
        boolean mightContain = bloomFilterUtil.mightContain(key);
        System.out.println("Bloom filter check for key " + key + ": " + mightContain);

        // 2. 尝试从缓存获取
        Goods goods = (Goods) redisUtil.get(key);
        System.out.println("Cache check for key " + key + ": " + (goods != null ? "hit" : "miss"));
        if (goods != null) {
            return goods;
        }

        // 3. 缓存击穿处理：使用锁确保只有一个线程查询数据库
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                try {
                    // 再次检查缓存，防止其他线程已经更新了缓存
                    goods = (Goods) redisUtil.get(key);
                    System.out.println("Double cache check for key " + key + ": " + (goods != null ? "hit" : "miss"));
                    if (goods != null) {
                        return goods;
                    }

                    // 4. 从数据库获取
                    System.out.println("Querying database for goods id: " + id);
                    goods = getById(id);
                    if (goods != null) {
                        // 5. 设置随机过期时间，防止缓存雪崩
                        int expireTime = 3600 + new Random().nextInt(3600);
                        System.out.println("Setting cache for key " + key + " with expire time: " + expireTime);
                        redisUtil.set(key, goods, expireTime);
                        // 添加到布隆过滤器
                        System.out.println("Adding key " + key + " to bloom filter");
                        bloomFilterUtil.add(key);
                    } else {
                        // 对于不存在的数据，也设置一个短期缓存，防止缓存穿透
                        System.out.println("Setting null cache for key " + key + " with expire time: 60");
                        redisUtil.set(key, null, 60);
                    }
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 6. 如果获取锁失败，直接从数据库获取
        if (goods == null) {
            System.out.println("Lock failed, querying database for goods id: " + id);
            goods = getById(id);
            if (goods != null) {
                int expireTime = 3600 + new Random().nextInt(3600);
                System.out.println("Setting cache for key " + key + " with expire time: " + expireTime);
                redisUtil.set(key, goods, expireTime);
                System.out.println("Adding key " + key + " to bloom filter");
                bloomFilterUtil.add(key);
            } else {
                // 对于不存在的数据，也设置一个短期缓存，防止缓存穿透
                System.out.println("Setting null cache for key " + key + " with expire time: 60");
                redisUtil.set(key, null, 60);
            }
        }

        return goods;
    }

    @Override
    public boolean addGoods(Goods goods) {
        boolean result = save(goods);
        if (result) {
            // 清除缓存
            String key = GOODS_CACHE_PREFIX + goods.getId();
            redisUtil.del(key);
            // 添加到布隆过滤器
            bloomFilterUtil.add(key);
        }
        return result;
    }

    @Override
    public boolean updateGoods(Goods goods) {
        boolean result = updateById(goods);
        if (result) {
            // 清除缓存
            String key = GOODS_CACHE_PREFIX + goods.getId();
            redisUtil.del(key);
        }
        return result;
    }

    @Override
    public boolean deleteGoods(Long id) {
        boolean result = removeById(id);
        if (result) {
            // 清除缓存
            String key = GOODS_CACHE_PREFIX + id;
            redisUtil.del(key);
        }
        return result;
    }

    @Override
    public boolean updateStatus(Long id, Integer status) {
        Goods goods = getById(id);
        if (goods != null) {
            goods.setStatus(status);
            boolean result = updateById(goods);
            if (result) {
                // 清除缓存
                String key = GOODS_CACHE_PREFIX + id;
                redisUtil.del(key);
            }
            return result;
        }
        return false;
    }
}
