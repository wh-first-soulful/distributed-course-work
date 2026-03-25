package com.lightmall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lightmall.goods.model.SeckillGoods;

import java.util.List;

public interface SeckillGoodsService extends IService<SeckillGoods> {
    List<SeckillGoods> getSeckillGoodsList();
    SeckillGoods getSeckillGoodsById(Long id);
    boolean addSeckillGoods(SeckillGoods seckillGoods);
    boolean updateSeckillGoods(SeckillGoods seckillGoods);
    boolean deleteSeckillGoods(Long id);
}