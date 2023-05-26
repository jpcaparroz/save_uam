package com.api.server.modules.omdb.projections;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopChartResponseBody {
    List<TopChartMovies> items;
}
