package com.api.server.integrationTest;

import com.api.server.modules.movies.MoviesClient;
import com.api.server.modules.movies.MoviesDto;
import com.api.server.modules.movies.MoviesRepository;
import com.api.server.modules.user.UserClient;
import com.api.server.modules.user.UserDto;
import com.api.server.modules.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserTestIT {

    @Autowired
    UserClient userClient;
    UserRepository userRepository;
    MoviesClient moviesClient;
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

        user = userClient.createUser(user)
                .getBody();

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

        movie = moviesClient.createMovie(movie)
                .getBody();

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

}
