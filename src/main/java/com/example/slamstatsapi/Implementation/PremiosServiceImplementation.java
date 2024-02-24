package com.example.slamstatsapi.Implementation;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Models.Estadistica;
import com.example.slamstatsapi.Models.Jugador;
import com.example.slamstatsapi.Models.Premios;
import com.example.slamstatsapi.Repository.JugadorRepository;
import com.example.slamstatsapi.Repository.PremiosRepository;
import com.example.slamstatsapi.Service.PremiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PremiosServiceImplementation implements PremiosService
{
    @Autowired
    PremiosRepository pr;
    @Autowired
    JugadorRepository jr;

    @Override
    public List<Premios> getAllPremios() {
        return (List<Premios>) pr.findAll();
    }

    @Override
    public Premios getPremiosById(Long id) throws IdNotFoundException
    {
        Optional<Premios> premios = pr.findById(id);

        if(premios.isEmpty())
        {
            throw new IdNotFoundException("There is no Tropies for that ID.");
        }

        return premios.get();
    }

    @Override
    public Premios getPremiosByPlayerId(Long id) throws IdNotFoundException
    {
        Optional<Jugador> j = jr.findById(id);

        if(j.isEmpty())
        {
            throw new IdNotFoundException("There is no player with thar id");
        }

        return pr.findByJugador_Id(id);
    }
}
