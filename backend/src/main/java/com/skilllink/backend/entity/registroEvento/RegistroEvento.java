package com.skilllink.backend.entity.registroEvento;

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
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "id_evento")
    private Long idEvento;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public RegistroEvento(DatosRegistroRegistroEvento datosRegistroEvento) {
        this.idUsuario = datosRegistroEvento.idUsuario();
        this.idEvento = datosRegistroEvento.idEvento();
        this.fechaRegistro = LocalDateTime.now();
    }
}
