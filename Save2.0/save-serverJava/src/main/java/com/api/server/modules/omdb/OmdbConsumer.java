package com.api.server.modules.omdb;

import com.api.server.modules.omdb.projections.OmdbResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "omdbConsumer", url = "${omdb.url}")
public interface OmdbConsumer {

    @GetMapping()
    OmdbResponseBody searchMovies(@RequestParam("apikey") String apiKey,
                                  @RequestParam("s") String search,
                                  @RequestParam(value = "page", required = false) String page);

    @GetMapping()
    OmdbResponseBody searchMovies(@RequestParam("apikey") String apiKey,
                                  @RequestParam("s") String search);


}
