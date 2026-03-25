package com.lightmall.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lightmall.goods.mapper.SeckillGoodsMapper;
import com.lightmall.goods.model.SeckillGoods;
import com.lightmall.goods.service.SeckillGoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeckillGoodsServiceImpl extends ServiceImpl<SeckillGoodsMapper, SeckillGoods> implements SeckillGoodsService {
    @Override
    public List<SeckillGoods> getSeckillGoodsList() {
        return list();
    }

    @Override
    public SeckillGoods getSeckillGoodsById(Long id) {
        return getById(id);
    }

    @Override
    public boolean addSeckillGoods(SeckillGoods seckillGoods) {
        return save(seckillGoods);
    }

    @Override
    public boolean updateSeckillGoods(SeckillGoods seckillGoods) {
        return updateById(seckillGoods);
    }

    @Override
    public boolean deleteSeckillGoods(Long id) {
        return removeById(id);
    }
}
