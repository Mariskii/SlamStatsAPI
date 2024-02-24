package com.example.slamstatsapi.Implementation;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Models.Equipo;
import com.example.slamstatsapi.Models.Estadistica;
import com.example.slamstatsapi.Models.Jugador;
import com.example.slamstatsapi.Models.Premios;
import com.example.slamstatsapi.Repository.JugadorRepository;
import com.example.slamstatsapi.Service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorServiceImplementation implements JugadorService
{
    @Autowired
    JugadorRepository jr;


    @Override
    public Page<Jugador> getAllJugadores(Pageable pageable) {
        return jr.findAll(pageable);
    }

    @Override
    public Optional<Jugador> getJugadorById(Long id) throws IdNotFoundException
    {
        Optional<Jugador> j = jr.findById(id);

        if(!j.isPresent())
        {
            throw new IdNotFoundException("There is no player whith that id");
        }

        return j;
    }

    @Override
    public List<Jugador> getJugadorByNombreCompleto(String n, Pageable pageable) {
        return jr.findByNombreCompletoContaining(n,pageable);
    }

    @Override
    public List<Equipo> getEquiposJugadorById(Long id) throws IdNotFoundException
    {
        List<Equipo> equipos = null;

        Optional<Jugador> j = jr.findById(id);

        if(j.isEmpty())
        {
            throw new IdNotFoundException("There is no player with that id");
        }

        equipos = j.get().getEquipos();

        return equipos;
    }
}
