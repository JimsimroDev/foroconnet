package com.jimsimrodev.foroconnet.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico>findBy(Pageable paginacion);
}
