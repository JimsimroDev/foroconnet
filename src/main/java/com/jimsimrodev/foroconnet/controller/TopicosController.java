package com.jimsimrodev.foroconnet.controller;

import com.jimsimrodev.foroconnet.domain.curso.DatosCurso;
import com.jimsimrodev.foroconnet.domain.curso.ICursoRepository;
import com.jimsimrodev.foroconnet.domain.topico.*;
import com.jimsimrodev.foroconnet.domain.usuario.DatosUsuario;
import com.jimsimrodev.foroconnet.domain.usuario.IUsuarioRepesitory;
import com.jimsimrodev.foroconnet.domain.usuario.Usuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.jimsimrodev.foroconnet.domain.curso.Curso;


@RestController
@RequestMapping("/topicos.")
public class TopicosController {

  @Autowired
  private ITopicoRepository topicoRepository;

  @Autowired
  private ICursoRepository cursoRepository;

  @Autowired
  private IUsuarioRepesitory usuarioRepesitory;

  @GetMapping
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 5) Pageable paginacion) {

    return ResponseEntity.ok(topicoRepository.findBy(paginacion).map(DatosListadoTopico::new));
  }


  @PostMapping
  @PreAuthorize("hasRole('ADMIN'")
  public ResponseEntity<DatosRespuestaTopico> guardarTopico(

      @RequestBody @Valid DatosRegistroTopicos datosRegistroTopicos,
      UriComponentsBuilder uriComponentsBuilder) {

    Curso curso = cursoRepository.findById(datosRegistroTopicos.idCurso()).orElseThrow();
    Usuario usuario = usuarioRepesitory.findById(datosRegistroTopicos.idUsuario()).orElseThrow();

    // Asignar el curso al DTO
    datosRegistroTopicos = new DatosRegistroTopicos(
        datosRegistroTopicos.titulo(),
        datosRegistroTopicos.mensaje(),
        datosRegistroTopicos.status(),
        datosRegistroTopicos.idUsuario(),
        usuario,
        datosRegistroTopicos.idCurso(),
        curso);

    Topico topico = topicoRepository.save(new Topico(datosRegistroTopicos));

    DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
        topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(),
        topico.getCurso() != null
            ? new DatosCurso(topico.getCurso().getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria())
            : null // valido si no tiene curso asignado devuelve null
        ,
        topico.getAutor() != null ? new DatosUsuario(topico.getAutor().getId(), topico.getAutor().getNombre()) : null);

    URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
    return ResponseEntity.created(url).body(datosRespuestaTopico);
  }

  @PutMapping
  @Transactional
  public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
    Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
    topico.actualizarTopico(datosActualizarTopico);

    return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
            topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(),
            topico.getCurso() != null
                    ? new DatosCurso(topico.getCurso().getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria())
                    : null // valido si no tiene curso asignado devuelve null
            ,
            topico.getAutor() != null ? new DatosUsuario(topico.getAutor().getId(), topico.getAutor().getNombre()) : null));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity eliminarTopico(@PathVariable Long id) {
    Topico topico = topicoRepository.getReferenceById(id);
    topicoRepository.deleteById(id);
    return ResponseEntity.ok().build();
  }


  @GetMapping("/{id}")
  public ResponseEntity<DatosListadoTopico> mostrandoDatosTopico(@PathVariable Long id){
    Topico topico = topicoRepository.getReferenceById(id);

    var datsoTopico = new DatosListadoTopico(topico);

            /*DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
            topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(),
            topico.getCurso() != null
                    ? new DatosCurso(topico.getCurso().getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria())
                    : null // valido si no tiene curso asignado devuelve null
            ,
            topico.getAutor() != null ? new DatosUsuario(topico.getAutor().getId(), topico.getAutor().getNombre()) : null);*/


    return ResponseEntity.ok(datsoTopico);
  }
}
