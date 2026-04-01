-- 订单表测试数据
INSERT INTO `t_order` (`order_no`, `user_id`, `goods_id`, `goods_name`, `goods_price`, `quantity`, `total_amount`, `status`, `pay_time`, `create_time`, `update_time`, `deleted`) VALUES
('ORDER2026032512345678', 1, 1, '测试商品1', 100.00, 1, 100.00, 0, NULL, NOW(), NOW(), 0),
('ORDER2026032587654321', 1, 2, '测试商品2', 200.00, 2, 400.00, 1, NOW(), NOW(), NOW(), 0),
('ORDER2026032511223344', 2, 1, '测试商品1', 100.00, 3, 300.00, 2, NULL, NOW(), NOW(), 0),
('ORDER2026032544332211', 2, 3, '测试商品3', 150.00, 1, 150.00, 0, NULL, NOW(), NOW(), 0),
('ORDER2026032555667788', 1, 3, '测试商品3', 150.00, 2, 300.00, 1, NOW(), NOW(), NOW(), 0);
