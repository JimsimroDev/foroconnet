package com.jimsimrodev.foroconnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jimsimrodev.foroconnet.domain.usuario.DatosAutenticacion;
import com.jimsimrodev.foroconnet.domain.usuario.Usuario;
import com.jimsimrodev.foroconnet.infra.security.DatosJWTtokens;
import com.jimsimrodev.foroconnet.infra.security.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private TokenService tokenService;

  @PostMapping
  public ResponseEntity<?> autenticarUsuario(@RequestBody @Valid DatosAutenticacion datosAutenticaicon) {
    Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticaicon.nombre(),
        datosAutenticaicon.contrasena());
    var usuarioAutenticado = authenticationManager.authenticate(authToken);
    var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
    return ResponseEntity.ok(new DatosJWTtokens(JWTtoken));
  }
}
