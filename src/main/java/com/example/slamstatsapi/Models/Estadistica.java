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
@Table(name = "estadisticasportemporadajugador")
public class Estadistica
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "temporada")
    private String season;

    @Column(name = "pj")
    private int pj;

    @Column(name = "ppp")
    private double ppp;

    @Column(name = "tc")
    private String tc;

    @Column(name = "tl")
    private String tl;

    @Column(name = "rpp")
    private double rpp;

    @Column(name = "app")
    private double app;

    @Column(name = "stl")
    private double stl;

    @Column(name = "blk")
    private double blk;

    @Column(name = "_3pm")
    private double pm3;

    @Column(name = "_3perc")
    private String perc3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jugadorid")
    @JsonIgnore
    private Jugador jugador;
}
