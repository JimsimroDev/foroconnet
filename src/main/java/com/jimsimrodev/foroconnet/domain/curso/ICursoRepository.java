package com.jimsimrodev.foroconnet.domain.curso;

import com.jimsimrodev.foroconnet.domain.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ICursoRepository extends JpaRepository<Curso, Long> {

}
