package com.jimsimrodev.foroconnet.domain.topico;

import com.jimsimrodev.foroconnet.domain.curso.DatosCurso;

public record DatosRespuestaTopico(
        Long id,
        String mensaje,
        String autor,
        DatosCurso curso
) {
}
