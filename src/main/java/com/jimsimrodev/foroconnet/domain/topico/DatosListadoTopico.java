package com.jimsimrodev.foroconnet.domain.topico;

import com.jimsimrodev.foroconnet.domain.curso.DatosCurso;
import com.jimsimrodev.foroconnet.domain.respuesta.DatosRespuesta;
import com.jimsimrodev.foroconnet.domain.usuario.DatosUsuario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DatosListadoTopico(
    Long id,
    String titulo,
    String mensaje,
    LocalDateTime fehcaCreacion,
    String estado,
    DatosCurso curso,
    DatosUsuario autor,
    List<DatosRespuesta> respuestas) {

  public DatosListadoTopico(Topico topico) {

    this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(),
        topico.getCurso() != null
            ? new DatosCurso(topico.getCurso().getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria())
            : null // valido si no tiene curso asignado devuelve null
        , topico.getAutor() != null ? new DatosUsuario(topico.getAutor().getId(), topico.getAutor().getNombre()) : null, // valido
                                                                                                                         // si
                                                                                                                         // no
                                                                                                                         // tiene
                                                                                                                         // un
                                                                                                                         // usuario
                                                                                                                         // asignado
                                                                                                                         // devuelve
                                                                                                                         // null
        topico.getRespuestas().stream()
            .map(r -> new DatosRespuesta(r.getId(), r.getMensaje(), r.getSolucion(), r.getFechaCreacion()))
            .collect(Collectors.toList()));
  }
}
/*
 * título, mensaje, fecha de creación, estado, autor y curso.
 * 
 */
