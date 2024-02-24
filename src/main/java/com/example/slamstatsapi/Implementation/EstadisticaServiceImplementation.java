package com.example.slamstatsapi.Implementation;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Models.Estadistica;
import com.example.slamstatsapi.Models.Jugador;
import com.example.slamstatsapi.Repository.EstadisticaRepository;
import com.example.slamstatsapi.Repository.JugadorRepository;
import com.example.slamstatsapi.Service.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticaServiceImplementation implements EstadisticaService
{
    @Autowired
    EstadisticaRepository ei;
    @Autowired
    JugadorRepository jr;


    @Override
    public List<Estadistica> getAll() {
        return (List<Estadistica>) ei.findAll();
    }

    @Override
    public List<Estadistica> getEstadisticasByJugadorId(Long id) throws IdNotFoundException
    {
        Optional<Jugador> jugador = jr.findById(id);

        if(jugador.isEmpty())
        {
            throw new IdNotFoundException("There is no player with that id.");
        }

        return ei.findByJugadorId(id);
    }

    @Override
    public Optional<Estadistica> getEstadisticaById(Long id) throws IdNotFoundException
    {
        Optional<Estadistica> estadistica = ei.findById(id);

        if(estadistica.isEmpty())
        {
            throw new IdNotFoundException("There is no statistic with that id.");
        }

        return ei.findById(id);
    }
}
