package com.example.slamstatsapi.Models.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumeroRetiradoDTO
{
    private Long id;

    private String numero;

    private String jugador;
}
