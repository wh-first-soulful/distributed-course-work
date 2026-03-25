-- 商品测试数据
INSERT INTO t_goods (goods_name, goods_img, goods_detail, goods_price, status) VALUES
('iPhone 15 Pro Max', 'https://example.com/iphone15.jpg', '最新款iPhone，搭载A17 Pro芯片', 9999.99, 1),
('MacBook Pro 16', 'https://example.com/macbook.jpg', 'M3 Pro芯片，16英寸屏幕', 19999.99, 1);

-- 库存测试数据
INSERT INTO t_stock (goods_id, stock) VALUES
(1, 100),
(2, 50);

-- 秒杀商品测试数据
INSERT INTO t_seckill_goods (goods_id, seckill_price, stock_count, start_time, end_time, status) VALUES
(1, 7999.99, 10, NOW() - INTERVAL 1 HOUR, NOW() + INTERVAL 23 HOUR, 1),
(2, 15999.99, 5, NOW() - INTERVAL 1 HOUR, NOW() + INTERVAL 23 HOUR, 1);
