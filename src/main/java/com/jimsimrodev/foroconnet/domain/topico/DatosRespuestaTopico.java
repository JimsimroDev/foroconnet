package com.jimsimrodev.foroconnet.domain.topico;

import com.jimsimrodev.foroconnet.domain.curso.DatosCurso;
import com.jimsimrodev.foroconnet.domain.usuario.DatosUsuario;

import java.time.LocalDate;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fehcaCreacion,
        String estado,
        DatosCurso curso,
        DatosUsuario autor
){
}
