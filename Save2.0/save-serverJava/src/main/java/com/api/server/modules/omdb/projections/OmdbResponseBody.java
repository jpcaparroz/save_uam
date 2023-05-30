package com.api.server.modules.omdb.projections;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OmdbResponseBody {
    @JsonProperty("Search")
    private List<OmdbMovieDto> movieDtoList;
}
