package com.jimsimrodev.foroconnet.domain.topico;

import com.jimsimrodev.foroconnet.domain.curso.DatosCurso;
import com.jimsimrodev.foroconnet.domain.usuario.DatosUsuario;

import java.time.LocalDate;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fehcaCreacion,
        String estado,
        DatosCurso curso,
        DatosUsuario autor
        ){

    public  DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),topico.getStatus(),
                topico.getCurso() != null ? new DatosCurso(topico.getCurso().getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria()) : null //valido si no tiene curso asignado devuelve null
                ,topico.getAutor() != null ? new DatosUsuario(topico.getAutor().getId(), topico.getAutor().getNombre()) : null);//valido si no tiene un usuario asignado devuelve null
    }
}
/*
título, mensaje, fecha de creación, estado, autor y curso.

 */