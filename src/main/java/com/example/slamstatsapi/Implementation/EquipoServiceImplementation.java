package com.example.slamstatsapi.Implementation;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Models.Equipo;
import com.example.slamstatsapi.Models.NumeroRetirado;
import com.example.slamstatsapi.Repository.EquipoRepository;
import com.example.slamstatsapi.Service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImplementation implements EquipoService
{
    @Autowired
    EquipoRepository er;

    @Override
    public List<Equipo> getAllTeams() {
        return (List<Equipo>) er.findAll();
    }

    @Override
    public Optional<Equipo> getTeamById(Long id) throws IdNotFoundException
    {
        Optional<Equipo> equipo = er.findById(id);

        if(equipo.isEmpty())
        {
            throw new IdNotFoundException("There is no team with that id");
        }

        return er.findById(id);
    }

    @Override
    public List<Equipo> getTeamByName(String n) {
        return er.findEquiposByNombreEquipoContaining(n);
    }

    @Override
    public List<NumeroRetirado> getRetiredNumbersByTeamId(Long id) throws IdNotFoundException
    {
        Equipo equipo = er.findById(id)
                .orElseThrow(() -> new IdNotFoundException("There is no team with that id"));

        return equipo.getNumeroRetirados();
    }
}
