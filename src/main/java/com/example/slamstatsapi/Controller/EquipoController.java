package com.example.slamstatsapi.Controller;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Implementation.EquipoServiceImplementation;
import com.example.slamstatsapi.Models.Equipo;
import com.example.slamstatsapi.Models.NumeroRetirado;
import com.example.slamstatsapi.Models.dto.EquipoDTO;
import com.example.slamstatsapi.Models.dto.NumeroRetiradoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/slamstats")
public class EquipoController
{
    @Autowired
    EquipoServiceImplementation esi;

    @GetMapping("teams")
    public List<EquipoDTO> getAllTeams()
    {
        return esi.getAllTeams()
                .stream()
                .map(equipo -> new EquipoDTO(
                        equipo.getId(),
                        equipo.getNombreEquipo(),
                        equipo.getAbreviatura(),
                        equipo.getDescripcion(),
                        equipo.getFechaFundacion(),
                        equipo.getTitulos(),
                        equipo.getNumeroRetirados()
                )).toList();
    }

    @GetMapping("team/{id}")
    public Optional<EquipoDTO> getTeamById(@PathVariable Long id) throws IdNotFoundException
    {
        return esi.getTeamById(id)
                .map(equipo -> new EquipoDTO(
                        equipo.getId(),
                        equipo.getNombreEquipo(),
                        equipo.getAbreviatura(),
                        equipo.getDescripcion(),
                        equipo.getFechaFundacion(),
                        equipo.getTitulos(),
                        equipo.getNumeroRetirados()
                ));
    }

    @GetMapping("team")
    public List<EquipoDTO> getTeamsByName(@RequestParam String nombre)
    {
        return esi.getTeamByName(nombre)
                .stream()
                .map(equipo -> new EquipoDTO(
                        equipo.getId(),
                        equipo.getNombreEquipo(),
                        equipo.getAbreviatura(),
                        equipo.getDescripcion(),
                        equipo.getFechaFundacion(),
                        equipo.getTitulos(),
                        equipo.getNumeroRetirados()
                )).toList();
    }

    @GetMapping("team/{id}/retiredNumbers")
    public List<NumeroRetiradoDTO> getRetiredNumbers(@PathVariable Long id) throws IdNotFoundException
    {
        return esi.getRetiredNumbersByTeamId(id)
                .stream()
                .map(numeroRetirado -> new NumeroRetiradoDTO(
                        numeroRetirado.getId(),
                        numeroRetirado.getNumero(),
                        numeroRetirado.getNumero()
                )).toList();
    }
}
