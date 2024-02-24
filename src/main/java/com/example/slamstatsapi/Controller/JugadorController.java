package com.example.slamstatsapi.Controller;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Implementation.JugadorServiceImplementation;
import com.example.slamstatsapi.Models.Equipo;
import com.example.slamstatsapi.Models.Jugador;
import com.example.slamstatsapi.Models.Premios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/slamstats")
public class JugadorController
{
    @Autowired
    JugadorServiceImplementation jsi;

    //METODOS GET

    @GetMapping("players/all")
    public List<Jugador> getAllPlayers(@RequestParam(defaultValue = "0") int page)
    {
        Pageable pageable = PageRequest.of(page,25);

        return jsi.getAllJugadores(pageable).toList();
    }

    //Obtener un jugador por su ID
    @GetMapping("players/{id}")
    public Optional<Jugador> getJugadorById(@PathVariable Long id) throws IdNotFoundException
    {
        return jsi.getJugadorById(id);
    }

    //Obtener una lista de jugadores que tengan el nombre introducido en la petición
    @GetMapping("players")
    public List<Jugador> getJugadorByName(
            @RequestParam String nombre,
            @RequestParam(defaultValue = "0") int page
    ){
        Pageable pageable = PageRequest.of(page,10);
        return jsi.getJugadorByNombreCompleto(nombre,pageable);
    }

    @GetMapping("players/{id}/teams")
    public List<Equipo> getPlayerTeamsById(@PathVariable Long id) throws IdNotFoundException
    {
        return jsi.getEquiposJugadorById(id);
    }
}
