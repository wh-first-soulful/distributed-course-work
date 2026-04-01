package com.lightmall.order.controller;

import com.lightmall.common.Result;
import com.lightmall.order.model.Order;
import com.lightmall.order.model.OrderDTO;
import com.lightmall.order.model.OrderUpdateDTO;
import com.lightmall.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "订单管理")
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "获取订单列表")
    @GetMapping("/list")
    public Result getOrderList() {
        try {
            List<Order> orderList = orderService.getOrderList();
            return Result.success(orderList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "获取用户订单列表")
    @GetMapping("/user/{userId}")
    public Result getOrderListByUserId(@ApiParam(name = "用户ID", required = true) @PathVariable Long userId) {
        try {
            List<Order> orderList = orderService.getOrderListByUserId(userId);
            return Result.success(orderList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "根据ID获取订单详情")
    @GetMapping("/{id}")
    public Result getOrderById(@ApiParam(name = "订单ID", required = true) @PathVariable Long id) {
        try {
            Order order = orderService.getOrderById(id);
            return Result.success(order);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "根据订单号获取订单")
    @GetMapping("/order-no/{orderNo}")
    public Result getOrderByOrderNo(@ApiParam(name = "订单号", required = true) @PathVariable String orderNo) {
        try {
            Order order = orderService.getOrderByOrderNo(orderNo);
            return Result.success(order);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "创建订单")
    @PostMapping
    public Result createOrder(@ApiParam(name = "订单信息", required = true) @RequestBody OrderDTO orderDTO) {
        try {
            boolean success = orderService.createOrder(orderDTO);
            return success ? Result.success() : Result.error("创建订单失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "更新订单")
    @PutMapping
    public Result updateOrder(@ApiParam(name = "订单信息", required = true) @RequestBody OrderUpdateDTO orderUpdateDTO) {
        try {
            boolean success = orderService.updateOrder(orderUpdateDTO);
            return success ? Result.success() : Result.error("更新订单失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "取消订单")
    @PutMapping("/cancel/{id}")
    public Result cancelOrder(@ApiParam(name = "订单ID", required = true) @PathVariable Long id) {
        try {
            boolean success = orderService.cancelOrder(id);
            return success ? Result.success() : Result.error("取消订单失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "删除订单")
    @DeleteMapping("/delete/{id}")
    public Result deleteOrder(@ApiParam(name = "订单ID", required = true) @PathVariable Long id) {
        try {
            boolean success = orderService.deleteOrder(id);
            return success ? Result.success() : Result.error("删除订单失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }
}
