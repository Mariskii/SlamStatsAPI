package com.example.slamstatsapi.Service;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Models.Jugador;
import com.example.slamstatsapi.Models.Premios;

import java.util.List;
import java.util.Optional;

public interface PremiosService
{
    List<Premios> getAllPremios();
    Optional<Premios> getPremiosById(Long id) throws IdNotFoundException;
    Optional<Premios> getPremiosByPlayerId(Long id) throws IdNotFoundException;
}
