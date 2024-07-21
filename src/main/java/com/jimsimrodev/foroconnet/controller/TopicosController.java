package com.jimsimrodev.foroconnet.controller;

import com.jimsimrodev.foroconnet.domain.curso.Curso;
import com.jimsimrodev.foroconnet.domain.curso.ICursoRepository;
import com.jimsimrodev.foroconnet.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/topicos")
public class TopicosController {

  @Autowired
  private ITopicoRepository topicoRepository;

  @Autowired
  private ICursoRepository cursoRepository;

  @GetMapping
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 10)Pageable paginacion) {

    return ResponseEntity.ok(topicoRepository.findBy(paginacion).map(DatosListadoTopico::new));
  }

  @PostMapping
  public ResponseEntity<DatosRespuestaTopico> guardarTopico(

          @RequestBody @Valid DatosRegistroTopicos datosRegistroTopicos,
          UriComponentsBuilder uriComponentsBuilder){

    Curso curso = cursoRepository.findById(datosRegistroTopicos.idCurso()).orElseThrow();

    //Asignar el curso al DTO
    datosRegistroTopicos = new DatosRegistroTopicos(
            datosRegistroTopicos.titulo(),
            datosRegistroTopicos.mensaje(),
            datosRegistroTopicos.status(),
            datosRegistroTopicos.autor(),
            datosRegistroTopicos.idCurso(),
            curso
    );

    Topico topico = topicoRepository.save(new Topico(datosRegistroTopicos));

    DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getMensaje(), topico.getStatus(), topico.getAutor());

    URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
    return ResponseEntity.created(url).body(datosRespuestaTopico);
  }
}
