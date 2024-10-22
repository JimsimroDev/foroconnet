-- Esta migración agrega la culmna activo en la tabla usuario
ALTER TABLE usuario ADD COLUMN activo boolean;

