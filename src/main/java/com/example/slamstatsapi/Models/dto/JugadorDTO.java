package com.example.slamstatsapi.Models.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JugadorDTO
{
    private Long id;

    private String nombreCompleto;

    private String nacionalidad;

    private Date fNacimiento;

    private String altura;

    private String peso;

    private String posicion;

    private String dorsal;

    private String fotoCabeza;

    private String fotoCompleta;
}
