package com.jimsimrodev.foroconnet.domain.topico;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fehcaCreacion,
        String estado,
        String autor){

    public  DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getAutor());
    }
}
/*
título, mensaje, fecha de creación, estado, autor y curso.

 */