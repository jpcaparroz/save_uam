package com.api.server.modules.movies;

import com.api.server.configs.IgnoreUnmappedMapperConfig;
import com.api.server.modules.user.UserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface MoviesMapper {

    MoviesDto toMoviesDto(Movies movies);

    Movies toMoviesModel(MoviesDto moviesDto);

}
