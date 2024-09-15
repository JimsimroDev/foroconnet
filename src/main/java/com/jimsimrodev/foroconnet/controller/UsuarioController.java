package com.jimsimrodev.foroconnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jimsimrodev.foroconnet.config.PasswordEncoderService;
import com.jimsimrodev.foroconnet.domain.perfil.IPerfilRepository;
import com.jimsimrodev.foroconnet.domain.perfil.Perfil;
import com.jimsimrodev.foroconnet.domain.usuario.DatosCrearUsuario;
import com.jimsimrodev.foroconnet.domain.usuario.DatosRespuetaUsuario;
import com.jimsimrodev.foroconnet.domain.usuario.IUsuarioRepesitory;
import com.jimsimrodev.foroconnet.domain.usuario.Usuario;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private IUsuarioRepesitory usuarioRepesitory;

  @Autowired
  private IPerfilRepository perfilRepository;

  @Autowired
  private PasswordEncoderService passwordEncoder;

  @PostMapping
  public ResponseEntity<DatosRespuetaUsuario> crearUsuario(
      @RequestBody @Valid DatosCrearUsuario datosCrearUsuario) {

    Perfil perfil = perfilRepository.findById(datosCrearUsuario.idPerfil()).orElseThrow();

    String contrasenaEncriptada = passwordEncoder.encodePassword(datosCrearUsuario.contrasena());

    datosCrearUsuario = new DatosCrearUsuario(
        datosCrearUsuario.id(),
        datosCrearUsuario.nombre(),
        datosCrearUsuario.correo_electronico(),
        contrasenaEncriptada,
        datosCrearUsuario.idPerfil(),
        perfil);

    usuarioRepesitory.save(new Usuario(datosCrearUsuario));
    return ResponseEntity.ok().build();
  }
}
