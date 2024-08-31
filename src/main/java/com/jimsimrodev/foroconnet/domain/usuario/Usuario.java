
package com.jimsimrodev.foroconnet.domain.usuario;

import com.jimsimrodev.foroconnet.domain.perfil.Perfil;
import com.jimsimrodev.foroconnet.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Usuario")
@Table(name = "usuario")
public class Usuario implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String correoElectronico;
  private String contrasena;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "perfil_id"))
  private List<Perfil> perfiles;

  @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Topico> topicos;

  public Usuario(DatosUsuario usuario) {
    this.id = usuario.id();
    this.nombre = usuario.nombre();
  }

  public Usuario(DatosCrearUsuario datosCrearUsuario) {
    this.id = datosCrearUsuario.id();
    this.nombre = datosCrearUsuario.nombre();
    this.correoElectronico = datosCrearUsuario.correo_electronico();
    this.contrasena = datosCrearUsuario.contrasena();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority("ROLE_USER"));
  }

  @Override
  public String getPassword() {
    return contrasena;
  }

  @Override
  public String getUsername() {
    return nombre;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
