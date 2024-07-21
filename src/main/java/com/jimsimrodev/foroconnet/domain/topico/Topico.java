package com.jimsimrodev.foroconnet.domain.topico;

import com.jimsimrodev.foroconnet.domain.curso.Curso;
import com.jimsimrodev.foroconnet.domain.respuesta.Respuesta;
import com.jimsimrodev.foroconnet.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Topico")
@Table(name = "topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    private String status;
    private String autor;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @OneToMany(mappedBy = "topico")// cascade = CascadeType.ALL, fetch = FetchType.LAZY
    private List<Respuesta> respuestas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Topico(DatosRegistroTopicos datosRegistroTopicos){
        this.titulo = datosRegistroTopicos.titulo();
        this.mensaje = datosRegistroTopicos.mensaje();
        this.fechaCreacion = LocalDate.now();
        this.status = datosRegistroTopicos.status();
        this.autor = datosRegistroTopicos.autor();
        this.curso = datosRegistroTopicos.curso();
    }
}