package com.jimsimrodev.foroconnet.domain.topico;

import java.time.LocalDateTime;
import java.util.List;

import com.jimsimrodev.foroconnet.domain.curso.Curso;
import com.jimsimrodev.foroconnet.domain.respuesta.Respuesta;
import com.jimsimrodev.foroconnet.domain.usuario.Usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Topico")
@Table(name = "topico")
public class Topico 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)// cascade = CascadeType.ALL, fetch = FetchType.LAZY
    private List<Respuesta> respuestas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario autor;

    public Topico(DatosRegistroTopicos datosRegistroTopicos)
    {
        this.titulo = datosRegistroTopicos.titulo();
        this.mensaje = datosRegistroTopicos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = datosRegistroTopicos.status();
        this.autor = datosRegistroTopicos.autor();
        this.curso = datosRegistroTopicos.curso();
    }

    /* String mensaje,
         String status,
         String titulo*/

    public void actualizarTopico(DatosActualizarTopico datosActualizarTopico) 
    {
        if(datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }

        if(datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.status() != null) {
            this.status = datosActualizarTopico.status();
        }
    }
}
