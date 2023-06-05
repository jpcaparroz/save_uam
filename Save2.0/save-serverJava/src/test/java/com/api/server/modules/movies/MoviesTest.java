package com.api.server.modules.movies;

import com.api.server.modules.user.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MoviesTest {

    @Spy
    MoviesRepository moviesRepository;

    @Mock
    MoviesMapper moviesMapper;

    @Spy
    @InjectMocks
    MoviesService moviesService;

    UserDto user;
    User userEntity;
    MoviesDto movieA;
    MoviesDto movieB;
    Movies movieAEntity;
    Movies movieBEntity;
    Set<MoviesDto> movies;
    Set<Movies> moviesEntity;


    @BeforeEach
    public void setup(){

        user = UserDto.builder()
                .id(1L)
                .name("Test")
                .email("test@test.com")
                .build();

        movieA = MoviesDto.builder()
                .id(1L)
                .user(user)
                .rating("5")
                .name("testMovieA")
                .year("1999")
                .poster("posterA.com")
                .build();

        movieB = MoviesDto.builder()
                .id(2L)
                .user(user)
                .rating("3")
                .name("testMovieB")
                .year("2000")
                .poster("posterB.com")
                .build();

        movies = new HashSet<>() {{
            add(movieA);
            add(movieB);
        }};

        user.setMovies(movies);

        userEntity = User.builder()
                .id(1L)
                .name("Test")
                .email("test@test.com")
                .build();

        movieAEntity = Movies.builder()
                .id(1L)
                .user(userEntity)
                .rating("5")
                .name("testMovieA")
                .year("1999")
                .poster("posterA.com")
                .build();

        movieBEntity = Movies.builder()
                .id(2L)
                .user(userEntity)
                .rating("3")
                .name("testMovieB")
                .year("2000")
                .poster("posterB.com")
                .build();

        moviesEntity = new HashSet<>() {{
            add(movieAEntity);
            add(movieBEntity);
        }};

        userEntity.setMovies(moviesEntity);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldGetMovie() {
        when(moviesRepository.findById(any()))
                .thenReturn(Optional.of(movieAEntity));

        when(moviesService.getMovie(any()))
                .thenReturn(movieA);

        assertThat(moviesService.getMovie(any()))
                .isEqualTo(movieA);

        verify(moviesService, times(1))
                .getMovie(any());
    }

    @Test
    void shouldGetMovies() {

        List<Movies> moviesList = moviesEntity.stream()
                .toList();

        List<MoviesDto> moviesDtoList = movies.stream()
                .toList();

        when(moviesRepository.findAll())
                .thenReturn(moviesList);

        when(moviesService.getMovies())
                .thenReturn(moviesDtoList);

        assertThat(moviesService.getMovies())
                .isEqualTo(moviesDtoList);

        verify(moviesService, times(1))
                .getMovies();
    }

}
