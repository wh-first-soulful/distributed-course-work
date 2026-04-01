package com.lightmall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lightmall.order.mapper.OrderMapper;
import com.lightmall.order.model.Order;
import com.lightmall.order.model.OrderDTO;
import com.lightmall.order.model.OrderUpdateDTO;
import com.lightmall.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

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
    public boolean createOrder(OrderDTO orderDTO) {
        // 生成订单号
        String orderNo = generateOrderNo();
        
        // 创建订单对象
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setUserId(orderDTO.getUserId());
        order.setGoodsId(orderDTO.getGoodsId());
        
        // 模拟商品信息（实际应该从goods服务获取）
        order.setGoodsName("商品" + orderDTO.getGoodsId());
        order.setGoodsPrice(new BigDecimal(100));
        order.setQuantity(orderDTO.getQuantity());
        
        // 计算总金额
        BigDecimal totalAmount = order.getGoodsPrice().multiply(new BigDecimal(orderDTO.getQuantity()));
        order.setTotalAmount(totalAmount);
        
        // 设置初始状态
        order.setStatus(0); // 0-待支付
        
        return save(order);
    }

    @Override
    public boolean updateOrder(OrderUpdateDTO orderUpdateDTO) {
        Order order = getById(orderUpdateDTO.getId());
        if (order != null) {
            if (orderUpdateDTO.getStatus() != null) {
                order.setStatus(orderUpdateDTO.getStatus());
            }
            if (orderUpdateDTO.getPayTime() != null) {
                order.setPayTime(orderUpdateDTO.getPayTime());
            }
            return updateById(order);
        }
        return false;
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

    @Override
    public boolean deleteOrder(Long id) {
        return removeById(id);
    }

    // 生成订单号
    private String generateOrderNo() {
        return "ORDER" + System.currentTimeMillis() + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
