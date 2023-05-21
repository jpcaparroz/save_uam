package com.api.server.modules.movies;

import com.api.server.configs.handlers.notfound.NotFoundException;
import com.api.server.modules.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MoviesService {

    final
    MoviesRepository moviesRepository;

    final
    MoviesMapper moviesMapper;

    final
    UserService userService;

    public MoviesService(MoviesRepository moviesRepository, MoviesMapper moviesMapper, UserService userService) {
        this.moviesRepository = moviesRepository;
        this.moviesMapper = moviesMapper;
        this.userService = userService;
    }

    @Transactional
    public MoviesDto createMovie(MoviesDto moviesDto) {
        return moviesMapper.toMoviesDto(moviesRepository
                .save(moviesMapper.toMoviesModel(moviesDto)));
    }

    @Transactional(readOnly = true)
    public List<MoviesDto> getMovies() {

        return moviesRepository.findAll().stream()
                .map(moviesMapper::toMoviesDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MoviesDto getMovie(Long id) {

        Optional<Movies> movie = moviesRepository.findById(id);

        if (movie.isEmpty()) {
            throw new NotFoundException("Movie not found!");
        }

        return moviesMapper.toMoviesDto(movie.get());
    }

    @Transactional
    public boolean deleteMovie(Long id) {

        try {
            moviesRepository.deleteById(id);
        } catch(Exception e) {
            throw new NotFoundException(e.getMessage());
        }

        return true;
    }

    @Transactional
    public MoviesDto updateMovie(Long id, MoviesDto moviesDto) {
        MoviesDto movie = getMovie(id);

        moviesDto.setId(movie.getId());

        return moviesMapper.toMoviesDto(moviesRepository
                .save(moviesMapper.toMoviesModel(moviesDto)));
    }
}
