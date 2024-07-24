package com.jimsimrodev.foroconnet.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
         String mensaje,
         String status,
         String titulo
) {
}
