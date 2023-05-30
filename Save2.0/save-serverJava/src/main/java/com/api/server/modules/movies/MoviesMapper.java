package com.api.server.modules.movies;

import com.api.server.configs.IgnoreUnmappedMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface MoviesMapper {

    @Mapping(target = "user.movies", ignore = true)
    MoviesDto toMoviesDto(Movies movies);

    @Mapping(target = "user.movies", ignore = true)
    Movies toMoviesModel(MoviesDto moviesDto);

}
