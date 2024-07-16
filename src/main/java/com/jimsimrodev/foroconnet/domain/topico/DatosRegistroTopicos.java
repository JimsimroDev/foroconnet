package com.jimsimrodev.foroconnet.domain.topico;

import com.jimsimrodev.foroconnet.domain.curso.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopicos(
        @NotBlank(message = "{titulo.obligatorio}")
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotBlank
        @Valid
        Curso curso
) {
}
