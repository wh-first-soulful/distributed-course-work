package com.lightmall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lightmall.goods.model.Goods;
import com.lightmall.goods.model.SeckillGoods;

import java.util.List;

public interface GoodsService extends IService<Goods> {
    List<Goods> getGoodsList();
    Goods getGoodsById(Long id);
    boolean addGoods(Goods goods);
    boolean updateGoods(Goods goods);
    boolean deleteGoods(Long id);
    boolean updateStatus(Long id, Integer status);
}
