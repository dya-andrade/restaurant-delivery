CREATE TABLE `endereco` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `localidade` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;