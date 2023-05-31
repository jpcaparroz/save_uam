package com.api.server.rmi;

import com.api.server.modules.movies.MoviesDto;
import com.api.server.modules.movies.MoviesService;
import com.api.server.modules.omdb.OmdbService;
import com.api.server.modules.user.UserDto;
import com.api.server.modules.user.UserService;
import com.api.server.rmi.modules.Filme;
import com.api.server.rmi.modules.FilmeUsuario;
import com.api.server.rmi.modules.Usuario;
import org.hibernate.tool.schema.spi.SqlScriptException;
import org.springframework.stereotype.Component;

import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;

@Component
public class SaveImpl implements SaveService  {

    final
    UserService userService;

    final
    MoviesService moviesService;

    final
    OmdbService omdbService;

    public SaveImpl(UserService userService, MoviesService moviesService, OmdbService omdbService) {
        this.userService = userService;
        this.moviesService = moviesService;
        this.omdbService = omdbService;
    }

    public boolean cadastrar(String email, String nome) throws RemoteException {
        try {
            UserDto user = mapToUserDto(email, nome);
            userService.createUser(user);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean login(String login) throws RemoteException {

        try {
            UserDto user = userService.getUserByEmail(login);
            return !user.getName().isEmpty();
        } catch (SqlScriptException e) {
            return false;
        }

    }

    public Usuario getUsuario(String login) throws RemoteException {
        try {
            return mapToUsuario(userService.getUserByEmail(login));
        } catch (Exception e) {
            return null;
        }
    }

    public List<FilmeUsuario> getFilmeUsuario(String email) throws RemoteException {
        try {
            return userService.getUserByEmail(email)
                    .getMovies()
                    .stream()
                    .map(this::mapToFilmeUsuario)
                    .toList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<FilmeUsuario> getFilme() throws RemoteException {
        try {
            return moviesService.getMovies().stream()
                    .map(this::mapToFilmeUsuario)
                    .toList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Usuario> getUsuarios() throws RemoteException {
        try {
            return userService.getAllUsers().stream()
                    .map(this::mapToUsuario)
                    .toList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public boolean excluirUsuario(String email) throws RemoteException {
        try{
            return userService.deleteUser(email);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean adicionarFilme(FilmeUsuario filme, String email) throws RemoteException {

        try {
            UserDto user = userService.getUserByEmail(email);

            MoviesDto movie = mapToMoviesDto(filme);
            movie.setUser(user);

            moviesService.createMovie(movie);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<Filme> getFilme2(String filme) throws RemoteException {
        try {
            return omdbService.searchMovies(filme).stream()
                    .map(this::toFilme)
                    .toList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Filme> getMelhoresFilmes() throws RemoteException {
        try {
            return omdbService.getTopChart().stream()
                    .map(this::toFilme)
                    .toList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private Usuario mapToUsuario(UserDto userDto) {
        return Usuario.builder()
                .email(userDto.getEmail())
                .nome(userDto.getName())
                .build();
    }

    private UserDto mapToUserDto(String email, String nome) {
        return UserDto.builder()
                .name(nome)
                .email(email)
                .build();
    }

    private FilmeUsuario mapToFilmeUsuario(MoviesDto moviesDto) {
        return FilmeUsuario.builder()
                .id(Math.toIntExact(moviesDto.getId()))
                .nomeFilme(moviesDto.getName())
                .posterFilme(moviesDto.getPoster())
                .notaFilme(Integer.parseInt(moviesDto.getRating()))
                .anoFilme(Integer.parseInt(moviesDto.getYear()))
                .emailUsuario(moviesDto.getUser().getEmail())
                .build();
    }

    private MoviesDto mapToMoviesDto(FilmeUsuario filmeUsuario) {
        return MoviesDto.builder()
                .id((long) filmeUsuario.getId())
                .name(filmeUsuario.getNomeFilme())
                .poster(filmeUsuario.getPosterFilme())
                .year(String.valueOf(filmeUsuario.getAnoFilme()))
                .rating(String.valueOf(filmeUsuario.getNotaFilme()))
                .build();
    }

    private Filme toFilme(MoviesDto moviesDto) {
        return Filme.builder()
                .nomeFilme(moviesDto.getName())
                .anoFilme(Integer.parseInt(moviesDto.getYear().substring(0,4)))
                .posterFilme(moviesDto.getPoster())
                .build();
    }

}
