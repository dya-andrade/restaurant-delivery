CREATE TABLE `entrega_pedidos` (
  `entrega_id` bigint NOT NULL,
  `pedidos_id` bigint NOT NULL,
  UNIQUE KEY `UK_pedidos` (`pedidos_id`),
  KEY `FK_entrega` (`entrega_id`),
  CONSTRAINT `FK_entrega` FOREIGN KEY (`entrega_id`) REFERENCES `entrega` (`id`),
  CONSTRAINT `FK_pedidos` FOREIGN KEY (`pedidos_id`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;