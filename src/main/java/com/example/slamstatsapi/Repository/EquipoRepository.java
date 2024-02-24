package com.example.slamstatsapi.Repository;

import com.example.slamstatsapi.Models.Equipo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EquipoRepository extends CrudRepository<Equipo, Long> {
    List<Equipo> findEquiposByNombreEquipoContaining(String nombreEquipo);
}
