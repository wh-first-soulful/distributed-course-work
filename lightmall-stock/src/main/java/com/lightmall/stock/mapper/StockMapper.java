package com.lightmall.stock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lightmall.stock.model.Stock;
import org.apache.ibatis.annotations.Param;

public interface StockMapper extends BaseMapper<Stock> {
    int decreaseStock(@Param("goodsId") Long goodsId, @Param("quantity") Integer quantity);
    int increaseStock(@Param("goodsId") Long goodsId, @Param("quantity") Integer quantity);
    int lockStock(@Param("goodsId") Long goodsId, @Param("quantity") Integer quantity);
    int unlockStock(@Param("goodsId") Long goodsId, @Param("quantity") Integer quantity);
}