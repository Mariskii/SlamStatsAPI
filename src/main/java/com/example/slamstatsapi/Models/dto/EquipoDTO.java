package com.example.slamstatsapi.Models.dto;

import com.example.slamstatsapi.Models.NumeroRetirado;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipoDTO
{
    private Long id;

    private String nombreEquipo;

    private String abreviatura;

    private String descripcion;

    private Date fechaFundacion;

    private int titulos;

    private List<NumeroRetiradoDTO> numeroRetirados;
}
