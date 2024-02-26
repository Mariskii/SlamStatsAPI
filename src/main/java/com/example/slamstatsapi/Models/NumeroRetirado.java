package com.example.slamstatsapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "numerosretirados")
public class NumeroRetirado
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numeros")
    private String numero;

    @Column(name = "jugador")
    private String jugador;

    @ManyToOne
    @JoinColumn(name = "equipoid")
    private Equipo equipo;
}
