CREATE TABLE `pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data` datetime(6) DEFAULT NULL,
  `desconto` decimal(19,2) DEFAULT NULL,
  `valor_total` decimal(19,2) DEFAULT NULL,
  `id_cliente` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cliente` (`id_cliente`),
  CONSTRAINT `FK_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
