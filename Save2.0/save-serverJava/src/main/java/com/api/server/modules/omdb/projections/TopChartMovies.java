package com.api.server.modules.omdb.projections;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopChartMovies {

    private String title;

    private String year;

    @JsonProperty("image")
    private String poster;

}
