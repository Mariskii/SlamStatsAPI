package com.example.slamstatsapi.Repository;

import com.example.slamstatsapi.Models.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    Optional<Usuario> findUsuarioByNombreUsuario(String nombreusuario);
    boolean existsUsuarioByNombreUsuario(String nombreusuario);
}
