package com.example.slamstatsapi.Controller;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Implementation.EstadisticaServiceImplementation;
import com.example.slamstatsapi.Models.Estadistica;
import com.example.slamstatsapi.Models.dto.EstadisticaDTO;
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
    public List<EstadisticaDTO> getEstadisticasByPlayerId(@PathVariable Long id) throws IdNotFoundException
    {
        return esi.getEstadisticasByJugadorId(id)
                .stream()
                .map(estadistica -> new EstadisticaDTO(
                        estadistica.getId(),
                        estadistica.getSeason(),
                        estadistica.getPj(),
                        estadistica.getPpp(),
                        estadistica.getTc(),
                        estadistica.getTl(),
                        estadistica.getRpp(),
                        estadistica.getApp(),
                        estadistica.getStl(),
                        estadistica.getBlk(),
                        estadistica.getPm3(),
                        estadistica.getPerc3()
                )).toList();
    }

    @GetMapping("stats/{id}")
    public Optional<EstadisticaDTO> getEstadisticaById(@PathVariable Long id) throws IdNotFoundException
    {
        return esi.getEstadisticaById(id)
                .map(estadistica -> new EstadisticaDTO(
                        estadistica.getId(),
                        estadistica.getSeason(),
                        estadistica.getPj(),
                        estadistica.getPpp(),
                        estadistica.getTc(),
                        estadistica.getTl(),
                        estadistica.getRpp(),
                        estadistica.getApp(),
                        estadistica.getStl(),
                        estadistica.getBlk(),
                        estadistica.getPm3(),
                        estadistica.getPerc3()
                ));
    }

    @GetMapping("stats")
    public List<EstadisticaDTO> getAllEstadistica()
    {
        return esi.getAll()
                .stream()
                .map(estadistica -> new EstadisticaDTO(
                        estadistica.getId(),
                        estadistica.getSeason(),
                        estadistica.getPj(),
                        estadistica.getPpp(),
                        estadistica.getTc(),
                        estadistica.getTl(),
                        estadistica.getRpp(),
                        estadistica.getApp(),
                        estadistica.getStl(),
                        estadistica.getBlk(),
                        estadistica.getPm3(),
                        estadistica.getPerc3()
                )).toList();
    }
}
