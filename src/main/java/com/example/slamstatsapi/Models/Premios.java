package com.example.slamstatsapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "premios")
public class Premios
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "anillos")
    private int anillos;

    @Column(name = "fmvp")
    private int fmvp;

    @Column(name = "mvp")
    private int mvp;

    @Column(name = "allstar")
    private int allstar;

    @Column(name = "dpoy")
    private int dpoy;

    @Column(name = "roy")
    private int roy;

    @OneToOne
    @JoinColumn(name = "jugadorid")
    @JsonIgnore
    private Jugador jugador;
}
