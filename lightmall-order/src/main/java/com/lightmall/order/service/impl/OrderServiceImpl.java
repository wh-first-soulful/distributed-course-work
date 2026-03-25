package com.lightmall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lightmall.order.mapper.OrderMapper;
import com.lightmall.order.model.Order;
import com.lightmall.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Override
    public List<Order> getOrderList() {
        return list();
    }

    @Override
    public List<Order> getOrderListByUserId(Long userId) {
        return lambdaQuery().eq(Order::getUserId, userId).list();
    }

    @Override
    public Order getOrderById(Long id) {
        return getById(id);
    }

    @Override
    public Order getOrderByOrderNo(String orderNo) {
        return lambdaQuery().eq(Order::getOrderNo, orderNo).one();
    }

    @Override
    public boolean createOrder(Order order) {
        return save(order);
    }

    @Override
    public boolean updateOrder(Order order) {
        return updateById(order);
    }

    @Override
    public boolean cancelOrder(Long id) {
        Order order = getById(id);
        if (order != null) {
            order.setStatus(2); // 2-已取消
            return updateById(order);
        }
        return false;
    }
}
