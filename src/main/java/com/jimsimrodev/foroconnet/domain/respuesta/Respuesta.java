
package com.jimsimrodev.foroconnet.domain.respuesta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.jimsimrodev.foroconnet.domain.topico.Topico;
import com.jimsimrodev.foroconnet.domain.usuario.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Respuesta")
@Table(name = "respuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_topico")
    private Topico topico;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario autor;
    private String solucion;

    public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta) {
        this.mensaje = datosRegistroRespuesta.mensaje();
        this.topico = datosRegistroRespuesta.topico();
        this.fechaCreacion = LocalDateTime.now();
        this.autor = datosRegistroRespuesta.autor();
        this.solucion = datosRegistroRespuesta.solucion();
    }
}
