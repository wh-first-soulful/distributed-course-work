package com.lightmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lightmall.order.model.Order;
import com.lightmall.order.model.OrderDTO;
import com.lightmall.order.model.OrderUpdateDTO;

import java.util.List;

public interface OrderService extends IService<Order> {
    List<Order> getOrderList();
    List<Order> getOrderListByUserId(Long userId);
    Order getOrderById(Long id);
    Order getOrderByOrderNo(String orderNo);
    boolean createOrder(OrderDTO orderDTO);
    boolean updateOrder(OrderUpdateDTO orderUpdateDTO);
    boolean cancelOrder(Long id);
    boolean deleteOrder(Long id);
}