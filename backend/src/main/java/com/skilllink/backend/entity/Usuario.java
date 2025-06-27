package com.skilllink.backend.entity;

import com.skilllink.backend.enums.RolUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.Mapping;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Table(name = "Usuario")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "idUsuario")

public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_usuario")
    private Long idUsuario;
    private String nombre;
    private String email;
    @Column(name = "contrasea")
    private String contrasena;
    @Enumerated(EnumType.STRING)
    private RolUsuario rol;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
    private String nickname;

    @OneToOne (mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Perfil perfil;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}



