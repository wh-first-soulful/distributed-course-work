package com.lightmall.stock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lightmall.stock.model.Stock;

public interface StockMapper extends BaseMapper<Stock> {
    int decreaseStock(Long goodsId, Integer quantity);
    int increaseStock(Long goodsId, Integer quantity);
}