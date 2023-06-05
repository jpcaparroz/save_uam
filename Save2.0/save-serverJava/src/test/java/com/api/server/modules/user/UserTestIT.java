package com.api.server.modules.user;

import com.api.server.modules.movies.MoviesClient;
import com.api.server.modules.movies.MoviesDto;
import com.api.server.modules.movies.MoviesRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class UserTestIT {

    @Autowired
    UserClient userClient;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MoviesClient moviesClient;

    @Autowired
    MoviesRepository moviesRepository;

    UserDto user;
    MoviesDto movie;
    UserDto user2;
    MoviesDto movie2;

    @BeforeEach
    void setup() {
        user = UserDto.builder()
                .name("Test")
                .email("test@test.com")
                .build();

        ResponseEntity<UserDto> userResponse = userClient.createUser(user);

        assertThat(userResponse)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(201));

        user = userResponse.getBody();

        user2 = UserDto.builder()
                .name("Test2")
                .email("test2@test.com")
                .build();

        movie = MoviesDto.builder()
                .name("TestMovie")
                .year("2023")
                .rating("5")
                .poster("https://test.com")
                .user(user)
                .build();

        ResponseEntity<MoviesDto> movieResponse = moviesClient.createMovie(movie);

        assertThat(movieResponse)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(201));

        movie = movieResponse.getBody();

        movie2 = MoviesDto.builder()
                .name("TestMovie2")
                .year("2024")
                .rating("3")
                .poster("https://test2.com")
                .build();
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
        moviesRepository.deleteAll();
    }

    @Test
    void shouldSaveUser() {

        UserDto newUser = UserDto.builder()
                .name("UserTest")
                .email("user.test@test.com")
                .build();

        ResponseEntity<UserDto> response = userClient.createUser(newUser);

        assertThat(response)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(201));

        assertThat(response.getBody())
                .extracting(UserDto::getName)
                .isEqualTo(newUser.getName());

        assertThat(response.getBody())
                .extracting(UserDto::getEmail)
                .isEqualTo(newUser.getEmail());

        assertThat(response.getBody())
                .extracting(UserDto::getId)
                .isNotNull();
    }

    @Test
    void shouldGetUserByEmail() {

        ResponseEntity<UserDto> response = userClient.getUserByEmail(user.getEmail());

        assertThat(response)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(200));

        assertThat(response.getBody())
                .extracting(UserDto::getId)
                .isEqualTo(user.getId());
    }

    @Test
    void shouldGetUserMovies() {

        ResponseEntity<Set<MoviesDto>> response = userClient.getMoviesFromUser(user.getEmail());

        assertThat(response)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(200));

        assertThat(response.getBody())
                .extracting(MoviesDto::getId)
                .containsExactlyInAnyOrder(movie.getId());
    }

    @Test
    void shouldGetUsers() {

        user2 = userClient.createUser(user2).getBody();

        ResponseEntity<List<UserDto>> response = userClient.getUsers();

        assertThat(response)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(200));

        assertThat(response.getBody())
                .extracting(UserDto::getId)
                .containsAnyOf(user.getId(), user2.getId());
    }

    @Test
    void shouldUpdateUser() {

        UserDto newUser = UserDto.builder()
                .email("testUpdate@ittest.com")
                .name("TestUpdate")
                .build();

        ResponseEntity<UserDto> response = userClient.updateUser(newUser, user.getId());

        assertThat(response)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(200));

        assertThat(response.getBody())
                .extracting(UserDto::getId)
                .isEqualTo(user.getId());

        assertThat(response.getBody())
                .extracting(UserDto::getName)
                .isEqualTo(newUser.getName());

        assertThat(response.getBody())
                .extracting(UserDto::getEmail)
                .isEqualTo(newUser.getEmail());
    }

    @Test
    void shouldDeleteUser() {

        ResponseEntity<Boolean> response = userClient.deleteUser(user.getEmail());

        assertThat(response)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(200));
    }

}
