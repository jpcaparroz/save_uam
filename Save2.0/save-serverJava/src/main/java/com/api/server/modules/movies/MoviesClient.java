package com.api.server.modules.movies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "moviesClient", url = "http://127.0.0.1:5000")
public interface MoviesClient {

    @PostMapping("/movies")
    ResponseEntity<MoviesDto> createMovie(@RequestBody MoviesDto moviesDto);

    @GetMapping("/movies/list")
    ResponseEntity<List<MoviesDto>> getMovies();

    @GetMapping("/movies")
    ResponseEntity<MoviesDto> getMovie(@RequestParam("id") Long id);

    @DeleteMapping("/movies")
    ResponseEntity<Boolean> deleteMovie(@RequestParam("id") Long id);

    @PutMapping("/movies")
    ResponseEntity<MoviesDto> updateMovie(@RequestParam("id") Long id,
                                          @RequestBody MoviesDto moviesDto);
}
