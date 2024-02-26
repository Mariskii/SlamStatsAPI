package com.example.slamstatsapi.Implementation;

import com.example.slamstatsapi.Exceptions.IdNotFoundException;
import com.example.slamstatsapi.Exceptions.PasswordMismatchException;
import com.example.slamstatsapi.Exceptions.UserExistsException;
import com.example.slamstatsapi.Exceptions.UserNotFoundException;
import com.example.slamstatsapi.Models.Jugador;
import com.example.slamstatsapi.Models.Usuario;
import com.example.slamstatsapi.Repository.JugadorRepository;
import com.example.slamstatsapi.Repository.UsuarioRepository;
import com.example.slamstatsapi.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplementation implements UsuarioService
{
    @Autowired
    UsuarioRepository ur;
    @Autowired
    JugadorRepository jr;

    //Objeto constante para Hashear las contraseñas
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void registerUser(Usuario usuario) throws UserExistsException
    {
        if(ur.existsUsuarioByNombreUsuario(usuario.getNombreUsuario()))
        {
            throw new UserExistsException("This user already exists");
        }
        else
        {
            //Settear como nueva contraseña la contraseña hasheada
            usuario.setPasswd(passwordEncoder.encode(usuario.getPasswd()));

            ur.save(usuario);
        }
    }

    @Override
    public void addFavoritePlayer(Long idPlayer, Long idUser) throws UserNotFoundException, IdNotFoundException
    {
        Jugador j = jr.findById(idPlayer)
                .orElseThrow(() -> new IdNotFoundException("There is no player with that id."));

        Usuario u = ur.findById(idUser)
                .orElseThrow(() -> new UserNotFoundException("The user provided does not exist."));

        u.getJugadoresFavoritos().add(j);
        ur.save(u);
    }


    @Override
    public void deleteFavoritePlayer(Long idPlayer, Long idUser) throws UserNotFoundException, IdNotFoundException
    {
        Jugador j = jr.findById(idPlayer)
                .orElseThrow(() -> new IdNotFoundException(""));

        Usuario u = ur.findById(idUser)
                .orElseThrow(() -> new UserNotFoundException("The user provided does not exist."));

        List<Jugador> jugadors = u.getJugadoresFavoritos();
        jugadors.remove(j);

        u.setJugadoresFavoritos(jugadors);
        ur.save(u);
    }

    @Override
    public List<Jugador> getFavoriteJugadores(Long id) throws UserNotFoundException
    {
        Usuario user = ur.findById(id)
                .orElseThrow(() -> new UserNotFoundException("The user provided does not exist."));

        return  user.getJugadoresFavoritos();
    }

    @Override
    public boolean isPlayerFavorito(Long idPlayer, Long idUser) throws IdNotFoundException, UserNotFoundException
    {
        Usuario u = ur.findById(idUser)
                .orElseThrow(() -> new UserNotFoundException("The user provided does not exist."));

        List<Jugador> jugadoresFavoritos = u.getJugadoresFavoritos();

        return jugadoresFavoritos.stream().anyMatch(jugador -> jugador.getId().equals(idPlayer));
    }


    @Override
    public Optional<Usuario> login(String userName, String passwd) throws UserNotFoundException, PasswordMismatchException
    {

        Optional<Usuario> user = ur.findUsuarioByNombreUsuario(userName);

        if(user.isEmpty())
        {
            throw  new UserNotFoundException("The user provided does not exist.");
        }

        //Comprobar si la contraseña es correcta
        if (!passwordEncoder.matches(passwd, user.get().getPasswd())) {
            throw new PasswordMismatchException("Incorrect password for the user");
        }

        return user;
    }


}
