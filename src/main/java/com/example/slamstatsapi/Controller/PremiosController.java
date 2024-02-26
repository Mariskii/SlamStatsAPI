package com.example.slamstatsapi.Controller;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Implementation.PremiosServiceImplementation;
import com.example.slamstatsapi.Models.dto.PremiosDTO;
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
    public List<PremiosDTO> getAllPremios()
    {
        return psi.getAllPremios()
                .stream()
                .map(premios -> new PremiosDTO(
                        premios.getId(),
                        premios.getAnillos(),
                        premios.getFmvp(),
                        premios.getMvp(),
                        premios.getAllstar(),
                        premios.getDpoy(),
                        premios.getRoy()
                )).toList();
    }

    @GetMapping("trophies/{id}")
    public Optional<PremiosDTO> getPremiosById(@PathVariable Long id) throws IdNotFoundException
    {
        return psi.getPremiosById(id)
                .map(premios -> new PremiosDTO(
                        premios.getId(),
                        premios.getAnillos(),
                        premios.getFmvp(),
                        premios.getMvp(),
                        premios.getAllstar(),
                        premios.getDpoy(),
                        premios.getRoy()
                ));
    }

    @GetMapping("trophies/players/{id}")
    public Optional<PremiosDTO> getPremiosByPlayerId(@PathVariable Long id) throws IdNotFoundException
    {
        return psi.getPremiosByPlayerId(id)
                .map(premios -> new PremiosDTO(
                        premios.getId(),
                        premios.getAnillos(),
                        premios.getFmvp(),
                        premios.getMvp(),
                        premios.getAllstar(),
                        premios.getDpoy(),
                        premios.getRoy()
                ));
    }
}
