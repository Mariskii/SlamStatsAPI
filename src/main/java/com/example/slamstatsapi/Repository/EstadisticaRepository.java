package com.example.slamstatsapi.Repository;

import com.example.slamstatsapi.Models.Estadistica;
import com.example.slamstatsapi.Models.Jugador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstadisticaRepository extends CrudRepository<Estadistica, Long> {
    @Query("SELECT e FROM Estadistica e WHERE e.jugador.id= :jugadorId")
    List<Estadistica> findByJugadorId(@Param("jugadorId") Long jugadorId);
}
