--CREATE TABLE IF NOT EXISTS `foroconnet`.`perfiles` (
 -- `usuario_id` INT NOT NULL,
 ---- `perfil_id` INT NOT NULL,
--  `id` INT NOT NULL,
--  PRIMARY KEY (`id`),
--  INDEX `fk_usuario_has_perfil_perfil1_idx` (`perfil_id` ASC) VISIBLE,
 -- INDEX `fk_usuario_has_perfil_usuario1_idx` (`usuario_id` ASC) VISIBLE,
 -- CONSTRAINT `fk_usuario_has_perfil_usuario1`
 --   FOREIGN KEY (`usuario_id`)
 ----   REFERENCES `foroconnet`.`usuario` (`id`)
  --  ON DELETE NO ACTION
 --   ON UPDATE NO ACTION,
 -- CONSTRAINT `fk_usuario_has_perfil_perfil1`
 --   FOREIGN KEY (`perfil_id`)
 --   REFERENCES `foroconnet`.`perfil` (`id`)
  ----  ON DELETE NO ACTION
 --   ON UPDATE NO ACTION);