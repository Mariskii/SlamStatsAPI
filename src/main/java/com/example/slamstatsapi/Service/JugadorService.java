package com.example.slamstatsapi.Service;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Models.Equipo;
import com.example.slamstatsapi.Models.Estadistica;
import com.example.slamstatsapi.Models.Jugador;
import com.example.slamstatsapi.Models.Premios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface JugadorService
{
    Page<Jugador> getAllJugadores(Pageable pageable);
    Optional<Jugador> getJugadorById(Long id) throws IdNotFoundException;
    List<Jugador> getJugadorByNombreCompleto(String n, Pageable pageable);
    List<Equipo> getEquiposJugadorById(Long id) throws IdNotFoundException;
}
