package com.example.slamstatsapi.Models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipoJugadorDTO
{
    private Long id;

    private String nombreEquipo;

    private String abreviatura;
}
