package com.example.slamstatsapi.Controller;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Implementation.JugadorServiceImplementation;
import com.example.slamstatsapi.Models.Equipo;
import com.example.slamstatsapi.Models.Jugador;
import com.example.slamstatsapi.Models.Premios;
import com.example.slamstatsapi.Models.dto.EquipoDTO;
import com.example.slamstatsapi.Models.dto.EquipoJugadorDTO;
import com.example.slamstatsapi.Models.dto.JugadorDTO;
import org.apache.catalina.mapper.Mapper;
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

    @GetMapping("players/all")
    public List<JugadorDTO> getAllPlayers(@RequestParam(defaultValue = "0") int page)
    {
        Pageable pageable = PageRequest.of(page,25);

        return jsi.getAllJugadores(pageable)
                .stream()
                .map(jugador -> new JugadorDTO(
                        jugador.getId(),
                        jugador.getNombreCompleto(),
                        jugador.getNacionalidad(),
                        jugador.getFNacimiento(),
                        jugador.getAltura(),
                        jugador.getPeso(),
                        jugador.getPosicion(),
                        jugador.getDorsal(),
                        jugador.getFotoCabeza(),
                        jugador.getFotoCompleta()
                )).toList();
    }

    //Obtener un jugador por su ID
    @GetMapping("players/{id}")
    public Optional<JugadorDTO> getJugadorById(@PathVariable Long id) throws IdNotFoundException
    {
        return jsi.getJugadorById(id)
                .map(jugador -> new JugadorDTO(
                        jugador.getId(),
                        jugador.getNombreCompleto(),
                        jugador.getNacionalidad(),
                        jugador.getFNacimiento(),
                        jugador.getAltura(),
                        jugador.getPeso(),
                        jugador.getPosicion(),
                        jugador.getDorsal(),
                        jugador.getFotoCabeza(),
                        jugador.getFotoCompleta()
                ));
    }

    //Obtener una lista de jugadores que tengan el nombre introducido en la petición
    @GetMapping("players")
    public List<JugadorDTO> getJugadorByName(
            @RequestParam String nombre,
            @RequestParam(defaultValue = "0") int page
    ){
        Pageable pageable = PageRequest.of(page,25);
        return jsi.getJugadorByNombreCompleto(nombre,pageable)
                .stream()
                .map(jugador -> new JugadorDTO(
                        jugador.getId(),
                        jugador.getNombreCompleto(),
                        jugador.getNacionalidad(),
                        jugador.getFNacimiento(),
                        jugador.getAltura(),
                        jugador.getPeso(),
                        jugador.getPosicion(),
                        jugador.getDorsal(),
                        jugador.getFotoCabeza(),
                        jugador.getFotoCompleta()
                )).toList();
    }

    @GetMapping("players/{id}/teams")
    public List<EquipoJugadorDTO> getPlayerTeamsById(@PathVariable Long id) throws IdNotFoundException
    {
        return jsi.getEquiposJugadorById(id)
                .stream()
                .map(equipo -> new EquipoJugadorDTO(
                        equipo.getId(),
                        equipo.getNombreEquipo(),
                        equipo.getAbreviatura()
                )).toList();
    }
}
