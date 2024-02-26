package com.example.slamstatsapi.Models.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadisticaDTO
{
    private Long id;

    private String season;

    private int pj;

    private double ppp;

    private String tc;

    private String tl;

    private double rpp;

    private double app;

    private double stl;

    private double blk;

    private double pm3;

    private String perc3;
}
