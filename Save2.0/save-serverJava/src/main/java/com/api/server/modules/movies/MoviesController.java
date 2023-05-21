package com.api.server.modules.movies;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    final
    MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @PostMapping
    ResponseEntity<MoviesDto> createMovie(@RequestBody MoviesDto moviesDto) {
        return ResponseEntity.status(201)
                .body(moviesService.createMovie(moviesDto));
    }

    @GetMapping("/list")
    ResponseEntity<List<MoviesDto>> getMovies() {
        return ResponseEntity.ok()
                .body(moviesService.getMovies());
    }

    @GetMapping
    ResponseEntity<MoviesDto> getMovie(@RequestParam("id") Long id) {
        return ResponseEntity.ok()
                .body(moviesService.getMovie(id));
    }

    @DeleteMapping
    ResponseEntity<Boolean> deleteMovie(@RequestParam("id") Long id) {
        return ResponseEntity.ok()
                .body(moviesService.deleteMovie(id));
    }

    @PutMapping
    ResponseEntity<MoviesDto> updateMovie(@RequestParam("id") Long id,
                                          @RequestBody MoviesDto moviesDto) {
        return ResponseEntity.ok()
                .body(moviesService.updateMovie(id, moviesDto));
    }

}
