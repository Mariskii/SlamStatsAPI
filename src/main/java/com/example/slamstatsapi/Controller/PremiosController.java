package com.example.slamstatsapi.Controller;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Implementation.PremiosServiceImplementation;
import com.example.slamstatsapi.Models.Premios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/slamstats")
public class PremiosController
{
    @Autowired
    PremiosServiceImplementation psi;

    @GetMapping("trophies")
    public List<Premios> getAllPremios(){return psi.getAllPremios();}

    @GetMapping("trophies/{id}")
    public Premios getPremiosById(@PathVariable Long id) throws IdNotFoundException
    {
        return psi.getPremiosById(id);
    }

    @GetMapping("trophies/players/{id}")
    public Premios getPremiosByPlayerId(@PathVariable Long id) throws IdNotFoundException
    {
        return psi.getPremiosByPlayerId(id);
    }
}
