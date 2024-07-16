CREATE TABLE IF NOT EXISTS `foroconnet`.`usuario` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(255) NULL,
  `correoElectronico` VARCHAR(250) NOT NULL,
  `contrasena` VARCHAR(250),
  `perfiles` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));