package com.example.slamstatsapi.Service;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Models.Equipo;
import com.example.slamstatsapi.Models.NumeroRetirado;

import java.util.List;
import java.util.Optional;

public interface EquipoService
{
    List<Equipo> getAllTeams();
    Optional<Equipo> getTeamById(Long id) throws IdNotFoundException;
    List<Equipo> getTeamByName(String n);
    List<NumeroRetirado> getRetiredNumbersByTeamId(Long id) throws IdNotFoundException;
}
