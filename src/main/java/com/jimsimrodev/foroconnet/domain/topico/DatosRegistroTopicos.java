package com.jimsimrodev.foroconnet.domain.topico;

import com.jimsimrodev.foroconnet.domain.curso.Curso;
import com.jimsimrodev.foroconnet.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopicos(
    @NotBlank(message = "{titulo.obligatorio}") String titulo,
    @NotBlank(message = "{el mensaje es obligatorio}") String mensaje,
    @NotBlank String status,
    @NotNull Long idUsuario,
    Usuario autor,
    @NotNull Long idCurso,
    Curso curso) {

}
