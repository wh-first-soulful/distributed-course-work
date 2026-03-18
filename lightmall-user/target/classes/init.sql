CREATE DATABASE IF NOT EXISTS lightmall CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE lightmall;

CREATE TABLE IF NOT EXISTS user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    nickname VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(20),
    status INT DEFAULT 1,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 插入测试数据
INSERT INTO user (username, password, nickname, email, phone) VALUES
('admin', '123456', '管理员', 'admin@example.com', '13800138000'),
('user1', '123456', '用户1', 'user1@example.com', '13800138001');