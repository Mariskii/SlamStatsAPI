package com.example.slamstatsapi.Controller;

import com.example.slamstatsapi.Exceptions.PasswordMismatchException;
import com.example.slamstatsapi.Exceptions.UserExistsException;
import com.example.slamstatsapi.Exceptions.UserNotFoundException;
import com.example.slamstatsapi.Implementation.UsuarioServiceImplementation;
import com.example.slamstatsapi.Models.Jugador;
import com.example.slamstatsapi.Models.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slamstats")
public class UsuarioController
{
    @Autowired
    UsuarioServiceImplementation usi;

    @PostMapping("user/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody Usuario usuario) throws UserExistsException
    {
        usi.registerUser(usuario);
    }

    @PostMapping(value = "user/addFavorite", params = {"idPlayer","idUser"})
    @ResponseStatus(HttpStatus.CREATED)
    public void addFavoritePlayer(@RequestParam Long idPlayer, @RequestParam Long idUser)
    {
        usi.addFavoritePlayer(idPlayer,idUser);
    }

    @DeleteMapping(value = "user/deleteFavorite", params = {"idPlayer","idUser"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteFavoritePlayer(@RequestParam Long idPlayer, @RequestParam Long idUser)
    {
        usi.deleteFavoritePlayer(idPlayer,idUser);
    }

    @GetMapping("user/{id}/favoritePlayers")
    public List<Jugador> getFavoritePlayers(@PathVariable Long id){return usi.getFavoriteJugadores(id);}

    @GetMapping(value = "user/login", params = {"userName","passwd"})
    public Usuario loginUser(@RequestParam String userName, @RequestParam String passwd) throws UserNotFoundException, PasswordMismatchException
    {
        return usi.login(userName,passwd);
    }
}
