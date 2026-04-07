DROP TABLE IF EXISTS t_stock;
-- 创建库存表
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='库存表';

-- 插入测试数据
INSERT INTO `t_stock` (`goods_id`, `stock_num`, `lock_num`, `available_num`, `status`) VALUES
(1, 100, 0, 100, 1),
(2, 200, 0, 200, 1),
(3, 150, 0, 150, 1),
(4, 50, 0, 50, 1),
(5, 300, 0, 300, 1);