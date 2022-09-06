CREATE TABLE `cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `forma_pagamento` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `id_endereco` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_telefone` (`telefone`),
  KEY `FK_endereco` (`id_endereco`),
  CONSTRAINT `FK_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;