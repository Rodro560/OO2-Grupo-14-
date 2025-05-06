CREATE DATABASE IF NOT EXISTS `sistema_turnos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `sistema_turnos`;

-- Tabla base: Usuario
CREATE TABLE `usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `contrasenia` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB;

-- Cliente hereda de Usuario
CREATE TABLE `cliente` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `apellido` VARCHAR(100) NOT NULL,
  `dni` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cliente_usuario` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB;

-- Prestador hereda de Usuario
CREATE TABLE `prestador` (
  `id` INT NOT NULL,
  `razonSocial` VARCHAR(100) NOT NULL,
  `direccionCentral` VARCHAR(200),
  `habilitado` TINYINT(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_prestador_usuario` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB;

-- Servicio (debe venir antes de especificacion)
CREATE TABLE `servicio` (
  `idServicio` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `descripcion` TEXT,
  `duracionMin` INT NOT NULL,
  `precio` FLOAT NOT NULL,
  `prestador_id` INT NOT NULL,
  PRIMARY KEY (`idServicio`),
  KEY `prestador_id` (`prestador_id`),
  CONSTRAINT `fk_servicio_prestador` FOREIGN KEY (`prestador_id`) REFERENCES `prestador` (`id`)
) ENGINE=InnoDB;

-- Especificacion (relación uno a uno con Servicio)
CREATE TABLE `especificacion` (
  `idEspecificacion` INT NOT NULL AUTO_INCREMENT,
  `rubro` VARCHAR(100) NOT NULL,
  `responsable` VARCHAR(100),
  `detalleDelPersonal` TEXT,
  `servicio_id` INT UNIQUE,
  PRIMARY KEY (`idEspecificacion`),
  CONSTRAINT `fk_especificacion_servicio` FOREIGN KEY (`servicio_id`) REFERENCES `servicio` (`idServicio`)
) ENGINE=InnoDB;

-- Perfil (uno a uno con Cliente)
CREATE TABLE `perfil` (
  `idPerfil` INT NOT NULL AUTO_INCREMENT,
  `telefono` VARCHAR(20),
  `direccion` VARCHAR(200),
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`idPerfil`),
  UNIQUE KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `fk_perfil_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB;

-- Disponibilidad (uno a muchos con Servicio)
CREATE TABLE `disponibilidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `diaSemana` ENUM('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES','SABADO','DOMINGO') NOT NULL,
  `horaInicio` TIME NOT NULL,
  `horaFin` TIME NOT NULL,
  `servicio_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_disponibilidad_servicio` FOREIGN KEY (`servicio_id`) REFERENCES `servicio` (`idServicio`)
) ENGINE=InnoDB;

-- Turno
CREATE TABLE `turno` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `estado` ENUM('PENDIENTE','COMPLETADO','CANCELADO') NOT NULL,
  `cliente_id` INT NOT NULL,
  `disponibilidad_id` INT NOT NULL,
  `servicio_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  KEY `disponibilidad_id` (`disponibilidad_id`),
  KEY `servicio_id` (`servicio_id`),
  CONSTRAINT `fk_turno_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `fk_turno_disponibilidad` FOREIGN KEY (`disponibilidad_id`) REFERENCES `disponibilidad` (`id`),
  CONSTRAINT `fk_turno_servicio` FOREIGN KEY (`servicio_id`) REFERENCES `servicio` (`idServicio`)
) ENGINE=InnoDB;
