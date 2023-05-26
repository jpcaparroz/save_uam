package com.api.server.modules.omdb;

import com.api.server.modules.movies.MoviesDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class OmdbController {

    final
    OmdbService omdbService;

    public OmdbController(OmdbService omdbService) {
        this.omdbService = omdbService;
    }

    @GetMapping("/search")
    ResponseEntity<List<MoviesDto>> searchMovies(@RequestParam("s") String s,
                                                 @RequestParam(value = "page", required = false, defaultValue = "1") String page) {
        return ResponseEntity.ok()
                .body(omdbService.searchMovies(s, page));
    }

    @GetMapping("/topChart")
    ResponseEntity<List<MoviesDto>> searchMovies() {
        return ResponseEntity.ok()
                .body(omdbService.getTopChart());
    }


}
