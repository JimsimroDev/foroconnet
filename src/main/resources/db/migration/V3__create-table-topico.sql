CREATE TABLE IF NOT EXISTS `foroconnet`.`topico` (
  `id` INT NOT NULL,
  `titulo` VARCHAR(255) NOT NULL,
  `mensaje` VARCHAR(250) NOT NULL,
  `fecha_creacion` datetime not null,
  `status` VARCHAR(250) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  `curso` VARCHAR(250) NOT NULL,
  `respuestas` VARCHAR(250) NOT NULL,
  `id_curso` INT NOT NULL,
  `id_usuario` INT NOT NULL,
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