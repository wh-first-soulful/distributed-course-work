package com.lightmall.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lightmall.goods.mapper.GoodsMapper;
import com.lightmall.goods.model.Goods;
import com.lightmall.goods.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Override
    public List<Goods> getGoodsList() {
        return list();
    }

    @Override
    public Goods getGoodsById(Long id) {
        return getById(id);
    }

    @Override
    public boolean addGoods(Goods goods) {
        return save(goods);
    }

    @Override
    public boolean updateGoods(Goods goods) {
        return updateById(goods);
    }

    @Override
    public boolean deleteGoods(Long id) {
        return removeById(id);
    }

    @Override
    public boolean updateStatus(Long id, Integer status) {
        Goods goods = getById(id);
        if (goods != null) {
            goods.setStatus(status);
            return updateById(goods);
        }
        return false;
    }
}
