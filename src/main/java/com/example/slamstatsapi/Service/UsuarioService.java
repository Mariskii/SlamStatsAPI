package com.example.slamstatsapi.Service;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Exceptions.PasswordMismatchException;
import com.example.slamstatsapi.Exceptions.UserExistsException;
import com.example.slamstatsapi.Exceptions.UserNotFoundException;
import com.example.slamstatsapi.Models.Jugador;
import com.example.slamstatsapi.Models.Usuario;
import com.example.slamstatsapi.Models.dto.Responses.GlobalResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioService
{
    ResponseEntity<GlobalResponse> registerUser(Usuario usuario) throws UserExistsException;
    ResponseEntity<GlobalResponse>  addFavoritePlayer(Long idPlayer, Long idUser) throws UserNotFoundException, IdNotFoundException;
    ResponseEntity<GlobalResponse> deleteFavoritePlayer(Long idPlayer, Long idUser) throws UserNotFoundException, IdNotFoundException;
    List<Jugador> getFavoriteJugadores(Long id) throws UserNotFoundException;
    boolean isPlayerFavorito(Long idPlayer, Long idUser) throws IdNotFoundException,UserNotFoundException;
    Optional<Usuario> login(String userName, String passwd) throws UserNotFoundException, PasswordMismatchException;
}
