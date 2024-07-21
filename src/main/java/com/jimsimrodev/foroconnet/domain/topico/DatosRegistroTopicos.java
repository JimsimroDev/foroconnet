package com.jimsimrodev.foroconnet.domain.topico;

import com.jimsimrodev.foroconnet.domain.curso.Curso;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public record DatosRegistroTopicos(
        @NotBlank(message = "{titulo.obligatorio}")
        String titulo,
        @NotBlank
        String mensaje,
      //  @NotNull
    //    @Future
       // @DateTimeFormat(pattern = "yyyy-MM-dd")
     //   LocalDate fecha_creacion,
        @NotBlank
        String status,
        @NotBlank
        String autor,
        @NotNull
      //  DatosCurso curso
     //   @NotNull
        Long idCurso,
        Curso curso
) {

}
