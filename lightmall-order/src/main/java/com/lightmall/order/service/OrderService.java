package com.lightmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lightmall.order.model.Order;

import java.util.List;

public interface OrderService extends IService<Order> {
    List<Order> getOrderList();
    List<Order> getOrderListByUserId(Long userId);
    Order getOrderById(Long id);
    Order getOrderByOrderNo(String orderNo);
    boolean createOrder(Order order);
    boolean updateOrder(Order order);
    boolean cancelOrder(Long id);
}