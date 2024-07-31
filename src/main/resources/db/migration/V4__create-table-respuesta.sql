CREATE TABLE IF NOT EXISTS `foroconnet`.`respuesta` (
  `email` VARCHAR(255) NULL,
  `id` INT NOT NULL,
  `mensaje` VARCHAR(250) NOT NULL,
  `fechaCreacion` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  `solucion` VARCHAR(250) NOT NULL,
  `id_topico` INT NOT NULL,
  `id_usuario` INT NOT NULL,
  PRIMARY KEY (`id`),

  INDEX `id_topico_idx` (`id_topico` ASC) VISIBLE,
  INDEX `id_usuario_idx` (`id_usuario` ASC) VISIBLE,

  CONSTRAINT `fk_respuesta_topico`
    FOREIGN KEY (`id_topico`)
    REFERENCES `foroconnet`.`topico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_respuesta_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `foroconnet`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);