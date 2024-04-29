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
@Table(name = "Equipo")
public class Equipo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreEQUIPO")
    private String nombreEquipo;

    @Column(name = "abreviatura")
    private String abreviatura;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechafundacion")
    private Date fechaFundacion;

    @Column(name = "titulos")
    private int titulos;

    @Column(name = "imagenequipo")
    private String imagenEquipo;

    @OneToMany(mappedBy = "equipo")
    List<NumeroRetirado> numeroRetirados;
}
