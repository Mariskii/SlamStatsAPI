package com.example.slamstatsapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreusuario")
    private String nombreUsuario;

    @Column(name = "correo")
    private String correo;

    @Column(name = "passwd")
    private String passwd;

    @ManyToMany
    @JoinTable(
            name = "jugadoresfavoritos",
            joinColumns = @JoinColumn(name = "usuarioid"),
            inverseJoinColumns = @JoinColumn(name = "jugadorid"))
    List<Jugador> jugadoresFavoritos;
}
