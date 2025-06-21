package com.skilllink.backend.entity.mentoriaCategoria;

import com.skilllink.backend.entity.categoria.Categoria;
import com.skilllink.backend.entity.mentoria.Mentoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Mentoria_Categoria")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MentoriaCategoria {

    @Column(name = "id_mentoria_categoria")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMentoriaCategoria;

    @ManyToOne
    @JoinColumn(name = "id_mentoria")
    private Mentoria mentoria;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public MentoriaCategoria(Mentoria mentoria, Categoria categoria) {
        this.mentoria = mentoria;
        this.categoria = categoria;
    }
}
