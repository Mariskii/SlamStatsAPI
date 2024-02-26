package com.example.slamstatsapi.Models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PremiosDTO
{
    private Long id;

    private int anillos;

    private int fmvp;

    private int mvp;

    private int allstar;

    private int dpoy;

    private int roy;
}
