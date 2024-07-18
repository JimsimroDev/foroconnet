package com.jimsimrodev.foroconnet.domain.curso;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCurso(
        @NotNull
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        String categoria
) {
}
