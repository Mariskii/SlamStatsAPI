package com.example.slamstatsapi.Controller;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Exceptions.PasswordMismatchException;
import com.example.slamstatsapi.Exceptions.UserExistsException;
import com.example.slamstatsapi.Exceptions.UserNotFoundException;
import com.example.slamstatsapi.Implementation.UsuarioServiceImplementation;
import com.example.slamstatsapi.Models.Usuario;
import com.example.slamstatsapi.Models.dto.JugadorDTO;
import com.example.slamstatsapi.Models.dto.Responses.GlobalResponse;
import com.example.slamstatsapi.Models.dto.UsuarioLoginDTO;
import com.example.slamstatsapi.Models.dto.UsuarioRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/slamstats")
public class UsuarioController
{
    @Autowired
    UsuarioServiceImplementation usi;

    @PostMapping("user/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GlobalResponse> registerUser(@Valid @RequestBody UsuarioRegisterDTO usuario) throws UserExistsException
    {
        Usuario user = new Usuario();

        user.setNombreUsuario(usuario.getNombreUsuario());
        user.setCorreo(usuario.getCorreo());
        user.setPasswd(usuario.getPasswd());

        return usi.registerUser(user);
    }

    @PostMapping(value = "user/addFavorite", params = {"idPlayer","idUser"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GlobalResponse> addFavoritePlayer(@RequestParam Long idPlayer, @RequestParam Long idUser) throws UserNotFoundException, IdNotFoundException {
        return usi.addFavoritePlayer(idPlayer,idUser);
    }

    @DeleteMapping(value = "user/deleteFavorite", params = {"idPlayer","idUser"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GlobalResponse> deleteFavoritePlayer(@RequestParam Long idPlayer, @RequestParam Long idUser)throws UserNotFoundException, IdNotFoundException
    {
        return usi.deleteFavoritePlayer(idPlayer,idUser);
    }

    @GetMapping("user/{id}/favoritePlayers")
    public List<JugadorDTO> getFavoritePlayers(@PathVariable Long id) throws UserNotFoundException
    {
        return usi.getFavoriteJugadores(id)
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

    @GetMapping(value = "user/login", params = {"userName","passwd"})
    public Optional<UsuarioLoginDTO> loginUser(@RequestParam String userName, @RequestParam String passwd) throws UserNotFoundException, PasswordMismatchException
    {
        return usi.login(userName,passwd)
                .map(usuario -> new UsuarioLoginDTO(
                usuario.getId(),
                usuario.getNombreUsuario(),
                usuario.getCorreo()
        ));
    }

    @GetMapping("user/{idUser}/favoritePlayers/{idPlayer}")
    public boolean isPlayerFavorito(@PathVariable Long idUser,@PathVariable Long idPlayer) throws UserNotFoundException, IdNotFoundException
    {
        return usi.isPlayerFavorito(idPlayer, idUser);
    }
}
