package com.jimsimrodev.foroconnet.domain.topico;

import com.jimsimrodev.foroconnet.domain.curso.DatosCurso;
import com.jimsimrodev.foroconnet.domain.usuario.DatosUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
        DatosCurso curso
     //   @NotNull
       // Long idUsuario
) {

}
