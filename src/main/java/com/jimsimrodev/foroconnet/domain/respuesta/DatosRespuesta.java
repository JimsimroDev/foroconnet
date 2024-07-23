package com.jimsimrodev.foroconnet.domain.respuesta;

import java.time.LocalDate;

public record DatosRespuesta(String mensaje,
                             String solucion,
                             LocalDate fechaCreacion
                             ) {
}
