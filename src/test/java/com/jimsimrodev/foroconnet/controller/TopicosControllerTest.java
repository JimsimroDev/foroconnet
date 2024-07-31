/*package com.jimsimrodev.foroconnet.controller;


import com.jimsimrodev.foroconnet.domain.curso.Curso;
import com.jimsimrodev.foroconnet.domain.curso.ICursoRepository;
import com.jimsimrodev.foroconnet.domain.topico.*;
import com.jimsimrodev.foroconnet.domain.usuario.DatosUsuario;
import com.jimsimrodev.foroconnet.domain.usuario.IUsuarioRepesitory;
import com.jimsimrodev.foroconnet.domain.usuario.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TopicosControllerTest {

    @Mock
    private ITopicoRepository topicoRepository;

    @Mock
    private ICursoRepository cursoRepository;

    @Mock
    private IUsuarioRepesitory usuarioRepesitory;

    @InjectMocks
    private TopicosController topicosController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarTopico() {
        DatosRegistroTopicos datosRegistroTopicos = new DatosRegistroTopicos("titulo", "mensaje", "status", 1L, null, 1L, null);
        Curso curso = new Curso();
        Usuario usuario = new Usuario();
        Topico topico = new Topico(datosRegistroTopicos);
        when(cursoRepository.findById(1L)).thenReturn(Optional.of(curso));
        when(usuarioRepesitory.findById(1L)).thenReturn(Optional.of(usuario));
        when(topicoRepository.save(any(Topico.class))).thenReturn(topico);
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();

        ResponseEntity<DatosRespuestaTopico> response = topicosController.guardarTopico(datosRegistroTopicos, uriComponentsBuilder);

        assertEquals(201, response.getStatusCodeValue());
        verify(cursoRepository, times(1)).findById(1L);
        verify(usuarioRepesitory, times(1)).findById(1L);
        verify(topicoRepository, times(1)).save(any(Topico.class));
    }

    @Test
    public void testActualizarTopico() {
        DatosActualizarTopico datosActualizarTopico = new DatosActualizarTopico(1L, "nuevoTitulo", "nuevoMensaje", "nuevoStatus");
        Topico topico = new Topico();
        when(topicoRepository.getReferenceById(1L)).thenReturn(topico);

        ResponseEntity response = topicosController.actualizarTopico(datosActualizarTopico);

        assertEquals(200, response.getStatusCodeValue());
        verify(topicoRepository, times(1)).getReferenceById(1L);
    }

    @Test
    public void testEliminarTopico() {
        Topico topico = new Topico();
        when(topicoRepository.getReferenceById(1L)).thenReturn(topico);

        ResponseEntity response = topicosController.eliminarTopico(1L);

        assertEquals(200, response.getStatusCodeValue());
        verify(topicoRepository, times(1)).getReferenceById(1L);
        verify(topicoRepository, times(1)).deleteById(1L);
    }


}*/
