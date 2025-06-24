package com.skilllink.backend.entity;

import com.skilllink.backend.dto.registroEvento.DatosEntradaRegistroEvento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Registro_Evento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idRegistro")
public class RegistroEvento {
    @Column(name = "id_registro")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistro;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public RegistroEvento(DatosEntradaRegistroEvento datosEntradaRegistroEvento, Usuario usuario, Evento evento) {
        this.usuario = usuario;
        this.evento = evento;
        this.fechaRegistro = LocalDateTime.now();
    }
}
