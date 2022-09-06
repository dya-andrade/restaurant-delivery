CREATE TABLE `item_pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comida_bebida` varchar(255) DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  `valor_total` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;