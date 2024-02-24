package com.example.slamstatsapi.Controller;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Implementation.EstadisticaServiceImplementation;
import com.example.slamstatsapi.Models.Estadistica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/slamstats")
public class EstadisticaController
{
    @Autowired
    EstadisticaServiceImplementation esi;

    @GetMapping("stats/player/{id}")
    public List<Estadistica> getEstadisticasByPlayerId(@PathVariable Long id) throws IdNotFoundException
    {
        return esi.getEstadisticasByJugadorId(id);
    }

    @GetMapping("stats/{id}")
    public Optional<Estadistica> getEstadisticaById(@PathVariable Long id) throws IdNotFoundException
    {
        return esi.getEstadisticaById(id);
    }

    @GetMapping("stats")
    public List<Estadistica> getAllEstadistica(){return esi.getAll();}
}
