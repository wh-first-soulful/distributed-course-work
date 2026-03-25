package com.lightmall.stock.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lightmall.stock.mapper.StockMapper;
import com.lightmall.stock.model.Stock;
import com.lightmall.stock.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {
    @Override
    public Stock getStockByGoodsId(Long goodsId) {
        return lambdaQuery().eq(Stock::getGoodsId, goodsId).one();
    }

    @Override
    @Transactional
    public boolean decreaseStock(Long goodsId, Integer quantity) {
        int result = getBaseMapper().decreaseStock(goodsId, quantity);
        return result > 0;
    }

    @Override
    @Transactional
    public boolean increaseStock(Long goodsId, Integer quantity) {
        int result = getBaseMapper().increaseStock(goodsId, quantity);
        return result > 0;
    }

    @Override
    public boolean updateStock(Stock stock) {
        return updateById(stock);
    }
}
