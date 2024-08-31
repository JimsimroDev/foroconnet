package com.jimsimrodev.foroconnet.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosUsuario(@NotNull Long id,
    @NotBlank String nombre) {
}
