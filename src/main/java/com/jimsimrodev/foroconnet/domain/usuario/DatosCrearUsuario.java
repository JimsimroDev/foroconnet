package com.jimsimrodev.foroconnet.domain.usuario;

import com.jimsimrodev.foroconnet.domain.perfil.Perfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosCrearUsuario(
    @NotNull Long id,
    @NotBlank String nombre,
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") String correo_electronico,
    @Pattern(regexp = "^(?=(?:.*\\d){2})(?=.*[A-Z]).{8,20}$") String contrasena,
    @NotNull Long idPerfil,
    Perfil perfil) {
}
