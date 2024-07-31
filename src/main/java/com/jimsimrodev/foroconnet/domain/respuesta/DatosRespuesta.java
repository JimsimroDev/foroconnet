package com.jimsimrodev.foroconnet.domain.respuesta;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosRespuesta(
        Long id,
        String mensaje,
        String solucion,
        LocalDateTime fechaCreacion
) {
}
