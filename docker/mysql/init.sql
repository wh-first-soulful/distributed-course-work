-- docker/mysql/init.sql
CREATE DATABASE IF NOT EXISTS lightmall;
USE lightmall;

-- 用户表
CREATE TABLE IF NOT EXISTS `user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100),
  `phone` VARCHAR(20),
  `status` INT DEFAULT 1,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 商品表
CREATE TABLE IF NOT EXISTS `goods` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `goods_name` VARCHAR(100) NOT NULL,
  `goods_img` VARCHAR(255),
  `goods_detail` TEXT,
  `goods_price` DECIMAL(10,2) NOT NULL,
  `status` INT DEFAULT 1,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 秒杀商品表
CREATE TABLE IF NOT EXISTS `seckill_goods` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `goods_id` BIGINT NOT NULL,
  `seckill_price` DECIMAL(10,2) NOT NULL,
  `stock_count` INT NOT NULL,
  `start_time` DATETIME NOT NULL,
  `end_time` DATETIME NOT NULL,
  `status` INT DEFAULT 1,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`goods_id`) REFERENCES `goods`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 订单表
CREATE TABLE IF NOT EXISTS `order` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(50) NOT NULL,
  `user_id` BIGINT NOT NULL,
  `goods_id` BIGINT NOT NULL,
  `goods_count` INT NOT NULL,
  `goods_price` DECIMAL(10,2) NOT NULL,
  `total_amount` DECIMAL(10,2) NOT NULL,
  `status` INT DEFAULT 1,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_no` (`order_no`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
  FOREIGN KEY (`goods_id`) REFERENCES `goods`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 秒杀订单表
CREATE TABLE IF NOT EXISTS `seckill_order` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(50) NOT NULL,
  `user_id` BIGINT NOT NULL,
  `goods_id` BIGINT NOT NULL,
  `seckill_goods_id` BIGINT NOT NULL,
  `goods_count` INT NOT NULL,
  `seckill_price` DECIMAL(10,2) NOT NULL,
  `total_amount` DECIMAL(10,2) NOT NULL,
  `status` INT DEFAULT 1,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_no` (`order_no`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
  FOREIGN KEY (`goods_id`) REFERENCES `goods`(`id`),
  FOREIGN KEY (`seckill_goods_id`) REFERENCES `seckill_goods`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 库存表
CREATE TABLE IF NOT EXISTS `stock` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `goods_id` BIGINT NOT NULL,
  `stock_num` INT NOT NULL,
  `lock_num` INT DEFAULT 0,
  `available_num` INT NOT NULL,
  `status` INT DEFAULT 1,
  `version` INT DEFAULT 1,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `goods_id` (`goods_id`),
  FOREIGN KEY (`goods_id`) REFERENCES `goods`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 插入测试数据
INSERT INTO `user` (`username`, `password`, `email`, `phone`) VALUES
('admin', '123456', 'admin@example.com', '13800138000'),
('user1', '123456', 'user1@example.com', '13800138001');

INSERT INTO `goods` (`goods_name`, `goods_img`, `goods_detail`, `goods_price`) VALUES
('Apple iPhone 13', 'https://example.com/iphone13.jpg', 'Apple iPhone 13 128GB', 5999.00),
('Samsung Galaxy S21', 'https://example.com/s21.jpg', 'Samsung Galaxy S21 128GB', 4999.00),
('Xiaomi Mi 11', 'https://example.com/mi11.jpg', 'Xiaomi Mi 11 128GB', 3999.00);

INSERT INTO `stock` (`goods_id`, `stock_num`, `available_num`) VALUES
(1, 100, 100),
(2, 200, 200),
(3, 300, 300);

INSERT INTO `seckill_goods` (`goods_id`, `seckill_price`, `stock_count`, `start_time`, `end_time`) VALUES
(1, 4999.00, 10, NOW(), DATE_ADD(NOW(), INTERVAL 1 HOUR)),
(2, 3999.00, 20, NOW(), DATE_ADD(NOW(), INTERVAL 1 HOUR));