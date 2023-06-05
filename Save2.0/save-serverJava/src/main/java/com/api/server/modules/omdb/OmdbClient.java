package com.api.server.modules.omdb;

import com.api.server.modules.movies.MoviesDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "omdbClient", url = "http://127.0.0.1:5000")
public interface OmdbClient {

    @GetMapping("/search")
    ResponseEntity<List<MoviesDto>> searchMovies(@RequestParam("s") String s,
                                                 @RequestParam(value = "page", required = false, defaultValue = "1") String page);

    @GetMapping("/topChart")
    ResponseEntity<List<MoviesDto>> getTopChart();

}
