package com.example.slamstatsapi.Models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRegisterDTO
{
    @NotBlank(message = "nombreUsuario cant be blank")
    private String nombreUsuario;

    @NotBlank
    @Email(message = "correo cant be blank")
    private String correo;

    @NotBlank(message = "passwd cant be blank")
    private String passwd;
}
