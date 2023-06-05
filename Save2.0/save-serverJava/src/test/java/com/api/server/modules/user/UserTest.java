package com.api.server.modules.user;

import com.api.server.modules.movies.Movies;
import com.api.server.modules.movies.MoviesDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @Spy
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @Spy
    @InjectMocks
    UserService userService;

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
    void shouldGetUser() {

        when(userRepository.findUserByEmail(any()))
                .thenReturn(Optional.of(userEntity));

        when(userService.getUserByEmail(any()))
                .thenReturn(user);

        assertThat(userService.getUserByEmail(any()))
                .isEqualTo(user);

        verify(userService, times(1))
                .getUserByEmail(any());
    }

    @Test
    void shouldGetMovies() {
        when(userRepository.findUserByEmail(any()))
                .thenReturn(Optional.of(userEntity));

        when(userService.getUserByEmail(any()))
                .thenReturn(user);

        assertThat(userService.getMovies(any()))
                .isEqualTo(movies);

        verify(userService, times(1))
                .getMovies(any());
    }
}
