package com.example.slamstatsapi.Controller;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Implementation.EquipoServiceImplementation;
import com.example.slamstatsapi.Models.Equipo;
import com.example.slamstatsapi.Models.NumeroRetirado;
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
    public List<Equipo> getAllTeams(){return esi.getAllTeams();}

    @GetMapping("team/{id}")
    public Optional<Equipo> getTeamById(@PathVariable Long id) throws IdNotFoundException
    {
        return esi.getTeamById(id);
    }

    @GetMapping("team")
    public List<Equipo> getTeamsByName(@RequestParam String nombre){return esi.getTeamByName(nombre);}

    @GetMapping("team/{id}/retiredNumbers")
    public List<NumeroRetirado> getRetiredNumbers(@PathVariable Long id) throws IdNotFoundException
    {
        return esi.getRetiredNumbersByTeamId(id);
    }
}
