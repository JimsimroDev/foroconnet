CREATE TABLE IF NOT EXISTS `foroconnet`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL,
  `correo_electronico` VARCHAR(250) NOT NULL,
  `contrasena` VARCHAR(250),
  PRIMARY KEY (`id`)
);
