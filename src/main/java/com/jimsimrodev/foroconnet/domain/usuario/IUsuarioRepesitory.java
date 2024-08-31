package com.jimsimrodev.foroconnet.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepesitory extends JpaRepository<Usuario, Long> {

  UserDetails findByNombre(String username);
}
