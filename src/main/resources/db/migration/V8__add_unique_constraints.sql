-- Esta migración agrega restriciones dee unicidad a las columnas titulo y mensaje
ALTER TABLE topico
ADD CONSTRAINT unique_titulo UNIQUE (titulo);

ALTER TABLE topico
ADD CONSTRAINT unique_mensaje UNIQUE (mensaje);
