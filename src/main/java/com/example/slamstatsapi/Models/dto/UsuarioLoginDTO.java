package com.example.slamstatsapi.Models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLoginDTO
{
    private Long id;

    private String nombreUsuario;

    private String correo;
}
