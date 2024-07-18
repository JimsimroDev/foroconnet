package com.jimsimrodev.foroconnet.domain.topico;

import com.jimsimrodev.foroconnet.domain.curso.DatosCurso;
import com.jimsimrodev.foroconnet.domain.usuario.DatosUsuario;

public record DatosRespuestaTopico(
        Long id,
        String mensaje,
        String status,
        String autor,
        DatosCurso curso,
        DatosUsuario usuario
) {
}
