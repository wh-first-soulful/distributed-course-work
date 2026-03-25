package com.lightmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lightmall.order.model.SeckillOrder;

public interface SeckillOrderService extends IService<SeckillOrder> {
    SeckillOrder getSeckillOrderByUserIdAndGoodsId(Long userId, Long goodsId);
    boolean createSeckillOrder(SeckillOrder seckillOrder);
}