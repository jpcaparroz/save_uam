package com.api.server.modules.omdb;

import com.api.server.modules.movies.MoviesDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class OmdbTestIT {

    @Autowired
    OmdbClient omdbClient;

    @Test
    void shouldGetTop250() {
        ResponseEntity<List<MoviesDto>> movieList = omdbClient.getTopChart();

        assertThat(movieList)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(200));

        assertThat(movieList.getBody())
                .hasSize(250)
                .extracting(MoviesDto::getName)
                .contains("The Shawshank Redemption");
    }

    @Test
    void shouldSearchForAMovie() {

        String movieName =  "Donnie Darko";

        ResponseEntity<List<MoviesDto>> movieList = omdbClient.searchMovies(movieName, "1");

        assertThat(movieList)
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.resolve(200));

        assertThat(movieList.getBody())
                .extracting(MoviesDto::getName)
                .contains("Donnie Darko");
    }


}
