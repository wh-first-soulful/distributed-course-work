-- docker/mysql/init.sql
CREATE DATABASE IF NOT EXISTS lightmall CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 授权root用户从所有IP地址访问
CREATE USER IF NOT EXISTS 'root'@'%' IDENTIFIED BY 'jhx714050';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

USE lightmall;

-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    nickname VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(20),
    status INT DEFAULT 1,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- 插入用户测试数据
INSERT INTO user (username, password, nickname, email, phone) VALUES
('admin', '123456', '管理员', 'admin@example.com', '13800138000'),
('user1', '123456', '用户1', 'user1@example.com', '13800138001');

-- 商品表
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
    `id`           BIGINT         NOT NULL AUTO_INCREMENT COMMENT '商品ID',
    `goods_name`   VARCHAR(256)   NOT NULL COMMENT '商品名称',
    `goods_img`    VARCHAR(512)   DEFAULT NULL COMMENT '商品图片URL',
    `goods_detail` TEXT           DEFAULT NULL COMMENT '商品详情',
    `goods_price`  DECIMAL(10, 2) NOT NULL COMMENT '商品价格',
    `status`       TINYINT        NOT NULL DEFAULT 0 COMMENT '状态: 0-下架 1-上架',
    `create_time`  DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`      TINYINT        NOT NULL DEFAULT 0 COMMENT '逻辑删除: 0-未删除 1-已删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品表';

-- 插入商品测试数据
INSERT INTO t_goods (goods_name, goods_img, goods_detail, goods_price, status) VALUES
('Apple iPhone 13', 'https://example.com/iphone13.jpg', 'Apple iPhone 13 128GB', 5999.00, 1),
('Samsung Galaxy S21', 'https://example.com/s21.jpg', 'Samsung Galaxy S21 128GB', 4999.00, 1),
('Xiaomi Mi 11', 'https://example.com/mi11.jpg', 'Xiaomi Mi 11 128GB', 3999.00, 1),
('iPhone 15 Pro Max', 'https://example.com/iphone15.jpg', '最新款iPhone，搭载A17 Pro芯片', 9999.99, 1),
('MacBook Pro 16', 'https://example.com/macbook.jpg', 'M3 Pro芯片，16英寸屏幕', 19999.99, 1);

-- 库存表
DROP TABLE IF EXISTS `t_stock`;
CREATE TABLE IF NOT EXISTS `t_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
  `stock_num` int(11) NOT NULL COMMENT '库存数量',
  `lock_num` int(11) NOT NULL DEFAULT '0' COMMENT '锁定数量',
  `available_num` int(11) NOT NULL COMMENT '可用数量',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态：0-不可用，1-可用',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_goods_id` (`goods_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='库存表';

-- 插入库存测试数据
INSERT INTO `t_stock` (`goods_id`, `stock_num`, `lock_num`, `available_num`, `status`) VALUES
(1, 100, 0, 100, 1),
(2, 200, 0, 200, 1),
(3, 150, 0, 150, 1),
(4, 50, 0, 50, 1),
(5, 300, 0, 300, 1);

-- 秒杀商品表
DROP TABLE IF EXISTS `t_seckill_goods`;
CREATE TABLE `t_seckill_goods` (
    `id`            BIGINT         NOT NULL AUTO_INCREMENT COMMENT '秒杀商品ID',
    `goods_id`      BIGINT         NOT NULL COMMENT '商品ID',
    `seckill_price` DECIMAL(10, 2) NOT NULL COMMENT '秒杀价格',
    `stock_count`   INT            NOT NULL DEFAULT 0 COMMENT '秒杀库存数量',
    `start_time`    DATETIME       NOT NULL COMMENT '秒杀开始时间',
    `end_time`      DATETIME       NOT NULL COMMENT '秒杀结束时间',
    `status`        TINYINT        NOT NULL DEFAULT 0 COMMENT '状态: 0-未开始 1-进行中 2-已结束',
    `create_time`   DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`       TINYINT        NOT NULL DEFAULT 0 COMMENT '逻辑删除: 0-未删除 1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_goods_id` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='秒杀商品表';

-- 插入秒杀商品测试数据
INSERT INTO t_seckill_goods (goods_id, seckill_price, stock_count, start_time, end_time, status) VALUES
(1, 4999.00, 10, NOW(), DATE_ADD(NOW(), INTERVAL 1 HOUR), 1),
(2, 3999.00, 20, NOW(), DATE_ADD(NOW(), INTERVAL 1 HOUR), 1),
(4, 7999.99, 10, NOW() - INTERVAL 1 HOUR, NOW() + INTERVAL 23 HOUR, 1),
(5, 15999.99, 5, NOW() - INTERVAL 1 HOUR, NOW() + INTERVAL 23 HOUR, 1);

-- 订单表
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
    `id`           BIGINT         NOT NULL AUTO_INCREMENT COMMENT '订单ID',
    `order_no`     VARCHAR(64)    NOT NULL COMMENT '订单编号（雪花算法）',
    `user_id`      BIGINT         NOT NULL COMMENT '用户ID',
    `goods_id`     BIGINT         NOT NULL COMMENT '商品ID',
    `goods_name`   VARCHAR(256)   NOT NULL COMMENT '商品名称（冗余）',
    `goods_price`  DECIMAL(10, 2) NOT NULL COMMENT '商品单价',
    `quantity`     INT            NOT NULL DEFAULT 1 COMMENT '购买数量',
    `total_amount` DECIMAL(10, 2) NOT NULL COMMENT '订单总金额',
    `status`       TINYINT        NOT NULL DEFAULT 0 COMMENT '状态: 0-待支付 1-已支付 2-已取消 3-已退款',
    `pay_time`     DATETIME       DEFAULT NULL COMMENT '支付时间',
    `create_time`  DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`      TINYINT        NOT NULL DEFAULT 0 COMMENT '逻辑删除: 0-未删除 1-已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_order_no` (`order_no`),
    KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单表';

-- 插入订单测试数据
INSERT INTO `t_order` (`order_no`, `user_id`, `goods_id`, `goods_name`, `goods_price`, `quantity`, `total_amount`, `status`, `pay_time`, `create_time`, `update_time`, `deleted`) VALUES
('ORDER2026032512345678', 1, 1, '测试商品1', 100.00, 1, 100.00, 0, NULL, NOW(), NOW(), 0),
('ORDER2026032587654321', 1, 2, '测试商品2', 200.00, 2, 400.00, 1, NOW(), NOW(), NOW(), 0),
('ORDER2026032511223344', 2, 1, '测试商品1', 100.00, 3, 300.00, 2, NULL, NOW(), NOW(), 0),
('ORDER2026032544332211', 2, 3, '测试商品3', 150.00, 1, 150.00, 0, NULL, NOW(), NOW(), 0),
('ORDER2026032555667788', 1, 3, '测试商品3', 150.00, 2, 300.00, 1, NOW(), NOW(), NOW(), 0);

-- 秒杀订单表
DROP TABLE IF EXISTS `t_seckill_order`;
CREATE TABLE `t_seckill_order` (
    `id`          BIGINT   NOT NULL AUTO_INCREMENT COMMENT '秒杀订单ID',
    `user_id`     BIGINT   NOT NULL COMMENT '用户ID',
    `goods_id`    BIGINT   NOT NULL COMMENT '秒杀商品ID',
    `order_id`    BIGINT   NOT NULL COMMENT '关联订单ID',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_goods` (`user_id`, `goods_id`) COMMENT '防止重复秒杀'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='秒杀订单表';
