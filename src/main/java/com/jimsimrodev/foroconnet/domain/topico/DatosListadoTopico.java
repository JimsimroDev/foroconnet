package com.jimsimrodev.foroconnet.domain.topico;

import com.jimsimrodev.foroconnet.domain.curso.DatosCurso;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fehcaCreacion,
        String estado,
        String autor,
        DatosCurso curso){

    public  DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatus(), topico.getAutor(), new DatosCurso(topico.getCurso().getId(), topico.getCurso().getNombre(),
                        topico.getCurso().getCategoria()));
    }
}
/*
título, mensaje, fecha de creación, estado, autor y curso.

 */