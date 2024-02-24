package com.example.slamstatsapi.Service;

import com.example.slamstatsapi.Exceptions.PasswordMismatchException;
import com.example.slamstatsapi.Exceptions.UserExistsException;
import com.example.slamstatsapi.Exceptions.UserNotFoundException;
import com.example.slamstatsapi.Models.Jugador;
import com.example.slamstatsapi.Models.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioService
{
    void registerUser(Usuario usuario) throws UserExistsException;
    void addFavoritePlayer(Long idPlayer, Long idUser);
    void deleteFavoritePlayer(Long idPlayer, Long idUser);
    List<Jugador> getFavoriteJugadores(Long id);

    Usuario login(String userName, String passwd) throws UserNotFoundException, PasswordMismatchException;
}
