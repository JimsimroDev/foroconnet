package com.jimsimrodev.foroconnet.domain.respuesta;

import com.jimsimrodev.foroconnet.domain.topico.Topico;
import com.jimsimrodev.foroconnet.domain.usuario.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
    @NotBlank String mensaje,
    @NotNull Long idTopico,
    Topico topico,
    @NotNull Long idUsuario,
    Usuario autor,
    @NotBlank String solucion) {
}
