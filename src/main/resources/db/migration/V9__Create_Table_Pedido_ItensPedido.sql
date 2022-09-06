CREATE TABLE `pedido_itens_pedido` (
  `pedido_id` bigint NOT NULL,
  `itens_pedido_id` bigint NOT NULL,
  UNIQUE KEY `UK_itens_pedido` (`itens_pedido_id`),
  KEY `FK_pedido` (`pedido_id`),
  CONSTRAINT `FK_itens_pedido` FOREIGN KEY (`itens_pedido_id`) REFERENCES `item_pedido` (`id`),
  CONSTRAINT `FK_pedido` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;