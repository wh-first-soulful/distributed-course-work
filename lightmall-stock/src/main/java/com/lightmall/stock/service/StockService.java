package com.lightmall.stock.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lightmall.stock.model.Stock;

public interface StockService extends IService<Stock> {
    Stock getStockByGoodsId(Long goodsId);
    boolean decreaseStock(Long goodsId, Integer quantity);
    boolean increaseStock(Long goodsId, Integer quantity);
    boolean lockStock(Long goodsId, Integer quantity);
    boolean unlockStock(Long goodsId, Integer quantity);
    boolean updateStock(Stock stock);
}