package com.skilllink.backend.entity.registroEvento;

import com.skilllink.backend.entity.Evento;
import com.skilllink.backend.entity.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Registro_Evento")
@Getter
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

    public RegistroEvento(DatosRegistroRegistroEvento datosRegistroRegistroEvento, Usuario usuario, Evento evento) {
        this.usuario = usuario;
        this.evento = evento;
        this.fechaRegistro = LocalDateTime.now();
    }
}
