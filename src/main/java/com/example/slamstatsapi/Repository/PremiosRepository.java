package com.example.slamstatsapi.Repository;

import com.example.slamstatsapi.Models.Jugador;
import com.example.slamstatsapi.Models.Premios;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PremiosRepository extends CrudRepository<Premios, Long> {
    Optional<Premios> findByJugador_Id(Long id);
}
