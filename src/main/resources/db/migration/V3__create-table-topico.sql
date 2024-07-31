CREATE TABLE IF NOT EXISTS `foroconnet`.`topico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(255) NOT NULL,
  `mensaje` VARCHAR(250) NOT NULL,
  `fecha_creacion` datetime not null,
  `status` VARCHAR(250) NOT NULL,
  `id_curso` INT ,
  `id_usuario` INT ,
  PRIMARY KEY (`id`),
  INDEX `id_curso_idx` (`id_curso` ASC) VISIBLE,
  INDEX `id_usuario_idx` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `id_curso`
    FOREIGN KEY (`id_curso`)
    REFERENCES `foroconnet`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `foroconnet`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
