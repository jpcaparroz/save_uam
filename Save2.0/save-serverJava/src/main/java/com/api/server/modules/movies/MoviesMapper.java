package com.api.server.modules.movies;

import com.api.server.configs.IgnoreUnmappedMapperConfig;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface MoviesMapper {

    MoviesDto toMoviesDto(Movies movies);

    Movies toMoviesModel(MoviesDto moviesDto);

}
