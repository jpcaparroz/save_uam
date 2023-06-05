package com.api.server.modules.movies;

import com.api.server.modules.user.UserClient;
import com.api.server.modules.user.UserDto;
import com.api.server.modules.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class MoviesTestIT {

    @Autowired
    MoviesClient moviesClient;

    @Autowired
    MoviesRepository moviesRepository;

    @Autowired
    UserClient userClient;

    @Autowired
    UserRepository userRepository;

    UserDto user;
    MoviesDto movie;

    @BeforeEach
    void setup() {

        user = UserDto.builder()
                .name("test")
                .email("test@test.com")
                .build();

        ResponseEntity<UserDto> userResponse = userClient.createUser(user);

        assertThat(userResponse)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(201));

        user = userResponse.getBody();

        movie = MoviesDto.builder()
                .name("MovieTest")
                .rating("5")
                .year("2003")
                .user(user)
                .poster("poster.com")
                .build();

        ResponseEntity<MoviesDto> movieResponse = moviesClient.createMovie(movie);

        assertThat(movieResponse)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(201));

        movie = movieResponse.getBody();
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
        moviesRepository.deleteAll();
    }

    @Test
    void shouldCreateMovie() {

        MoviesDto newMovie = MoviesDto.builder()
                .name("NewMovieTest")
                .year("2023")
                .rating("5")
                .poster("poster.com")
                .user(user)
                .build();

        ResponseEntity<MoviesDto> movieResponse = moviesClient.createMovie(newMovie);

        assertThat(movieResponse)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(201));

        ResponseEntity<List<MoviesDto>> moviesList = moviesClient.getMovies();

        assertThat(moviesList)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(200));

        assertThat(moviesList.getBody())
                .extracting(MoviesDto::getId)
                .containsExactlyInAnyOrder(movie.getId(), movieResponse.getBody().getId());
    }

    @Test
    void shouldUpdateMovie() {
        UserDto newUser = UserDto.builder()
                .email("newUser@test.com")
                .name("New User")
                .build();

        ResponseEntity<UserDto> userResponse = userClient.createUser(newUser);

        assertThat(userResponse)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(201));

        newUser = userResponse.getBody();

        MoviesDto updatedMovie = MoviesDto.builder()
                .name("updatedMovie")
                .year("2024")
                .rating("2")
                .poster("poster.com")
                .user(newUser)
                .build();

        ResponseEntity<MoviesDto> movieResponse = moviesClient.updateMovie(movie.getId(), updatedMovie);

        assertThat(movieResponse)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(200));

        assertThat(movieResponse.getBody())
                .extracting(MoviesDto::getName)
                .isEqualTo("updatedMovie");

        assertThat(movieResponse.getBody().getUser())
                .extracting(UserDto::getId)
                .isEqualTo(newUser.getId());
    }

    @Test
    void shouldGetMovieById() {
        ResponseEntity<MoviesDto> movieResponse = moviesClient.getMovie(movie.getId());

        assertThat(movieResponse)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(200));

        assertThat(movieResponse.getBody())
                .extracting(MoviesDto::getId)
                .isEqualTo(movie.getId());
    }

    @Test
    void shouldGetListOfMovies() {

        MoviesDto movieA = MoviesDto.builder()
                .name("movieA")
                .year("2000")
                .rating("1")
                .poster("poster.com")
                .user(user)
                .build();

        MoviesDto movieB = MoviesDto.builder()
                .name("movieB")
                .year("2001")
                .rating("2")
                .poster("poster.com")
                .user(user)
                .build();

        ResponseEntity<MoviesDto> movieResponseA = moviesClient.createMovie(movieA);
        ResponseEntity<MoviesDto> movieResponseB = moviesClient.createMovie(movieB);

        assertThat(movieResponseA)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(201));

        assertThat(movieResponseB)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(201));

        ResponseEntity<List<MoviesDto>> moviesList = moviesClient.getMovies();

        assertThat(moviesList)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(200));

        assertThat(moviesList.getBody())
                .extracting(MoviesDto::getId)
                .containsExactlyInAnyOrder(movie.getId(), movieResponseA.getBody().getId(), movieResponseB.getBody().getId());
    }

    @Test
    void shouldDeleteMovie() {
        ResponseEntity<Boolean> movieResponse = moviesClient.deleteMovie(movie.getId());

        assertThat(movieResponse)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(200));
    }

}
