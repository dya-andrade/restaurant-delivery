CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `id_perfil_acesso` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_email` (`email`),
  KEY `FK_perfil_acesso` (`id_perfil_acesso`),
  CONSTRAINT `FK_perfil_acesso` FOREIGN KEY (`id_perfil_acesso`) REFERENCES `perfil_acesso` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
