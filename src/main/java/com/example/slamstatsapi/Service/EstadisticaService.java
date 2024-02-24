package com.example.slamstatsapi.Service;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Models.Estadistica;

import java.util.List;
import java.util.Optional;

public interface EstadisticaService
{
    List<Estadistica> getAll();
    List<Estadistica> getEstadisticasByJugadorId(Long id) throws IdNotFoundException;
    Optional<Estadistica> getEstadisticaById(Long id) throws IdNotFoundException;
}
