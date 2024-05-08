package com.example.slamstatsapi.Repository;

import com.example.slamstatsapi.Models.Equipo;
import com.example.slamstatsapi.Models.Estadistica;
import com.example.slamstatsapi.Models.Jugador;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface JugadorRepository extends CrudRepository<Jugador, Long> {

    long count();

    //Pageable sirve para agregar paginación a los resultados de la cunsulta
    List<Jugador> findByNombreCompletoContaining(String nombreCompleto, Pageable pageable);
    Page<Jugador> findAll(Pageable page);
}
