package com.jimsimrodev.foroconnet.controller;

import com.jimsimrodev.foroconnet.domain.respuesta.DatosRegistroRespuesta;
import com.jimsimrodev.foroconnet.domain.respuesta.DatosRespuesta;
import com.jimsimrodev.foroconnet.domain.respuesta.IRespuestaRepository;
import com.jimsimrodev.foroconnet.domain.respuesta.Respuesta;
import com.jimsimrodev.foroconnet.domain.topico.ITopicoRepository;
import com.jimsimrodev.foroconnet.domain.topico.Topico;
import com.jimsimrodev.foroconnet.domain.usuario.IUsuarioRepesitory;
import com.jimsimrodev.foroconnet.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private ITopicoRepository topicoRepository;

    @Autowired
    private IUsuarioRepesitory usuarioRepesitory;

    @Autowired
    private IRespuestaRepository respuestaRepository;

    @PostMapping
    public ResponseEntity<DatosRespuesta> guardarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta){

        Topico topico = topicoRepository.findById(datosRegistroRespuesta.idTopico()).orElseThrow();
        Usuario autor = usuarioRepesitory.findById(datosRegistroRespuesta.idUsuario()).orElseThrow();


        datosRegistroRespuesta = new DatosRegistroRespuesta(
                datosRegistroRespuesta.mensaje(),
                datosRegistroRespuesta.idTopico(),
                topico,
                datosRegistroRespuesta.idUsuario(),
                autor,
                datosRegistroRespuesta.solucion()
        );

        Respuesta respuesta = respuestaRepository.save(new Respuesta(datosRegistroRespuesta));
       // topico.getRespuestas().add(respuesta);
        return ResponseEntity.ok().build();
    }
}
