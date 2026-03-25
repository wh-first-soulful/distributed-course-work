package com.lightmall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lightmall.order.mapper.SeckillOrderMapper;
import com.lightmall.order.model.SeckillOrder;
import com.lightmall.order.service.SeckillOrderService;
import org.springframework.stereotype.Service;

@Service
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements SeckillOrderService {
    @Override
    public SeckillOrder getSeckillOrderByUserIdAndGoodsId(Long userId, Long goodsId) {
        return lambdaQuery()
                .eq(SeckillOrder::getUserId, userId)
                .eq(SeckillOrder::getGoodsId, goodsId)
                .one();
    }

    @Override
    public boolean createSeckillOrder(SeckillOrder seckillOrder) {
        return save(seckillOrder);
    }
}
