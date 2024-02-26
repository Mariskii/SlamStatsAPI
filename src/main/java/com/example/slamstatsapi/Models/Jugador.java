package com.example.slamstatsapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Jugador")
public class Jugador
{
    @Id
    @Column(name = "id_player")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombrecompleto")
    private String nombreCompleto;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Column(name = "fechanacimiento")
    private Date fNacimiento;

    @Column(name = "altura")
    private String altura;

    @Column(name = "peso")
    private String peso;

    @Column(name = "posicion")
    private String posicion;

    @Column(name = "dorsal")
    private String dorsal;

    @Column(name = "fotocabeza")
    private String fotoCabeza;

    @Column(name = "fotocompleta")
    private String fotoCompleta;

    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL)
    private List<Estadistica> estadisticas;

    @ManyToMany
    @JoinTable(
            name = "jugadorequipo",
            joinColumns = @JoinColumn(name = "jugadorid"),
            inverseJoinColumns = @JoinColumn(name = "equipoid"))
    private List<Equipo> equipos;
}
