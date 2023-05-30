package com.api.server.modules.omdb;

import com.api.server.modules.omdb.projections.TopChartResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "topChart", url = "${top-chart.url}")
public interface TopChartConsumer {

    @GetMapping
    TopChartResponseBody getTopChartMovies();

}
