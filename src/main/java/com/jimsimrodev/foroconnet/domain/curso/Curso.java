
package com.jimsimrodev.foroconnet.domain.curso;

import com.jimsimrodev.foroconnet.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Curso")
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Topico> topicos;

    public Curso(DatosCurso curso) {
        this.nombre = curso.nombre();
        this.categoria = curso.categoria();
    }

    public Curso(Curso curso) {
    }

}
