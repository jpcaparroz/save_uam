package com.api.server.modules.user;

import com.api.server.configs.IgnoreUnmappedMapperConfig;
import com.api.server.modules.movies.MoviesMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class, uses = {MoviesMapper.class})
public interface UserMapper {
    UserDto toUserDto(User user);
    User toUserModel(UserDto user);
}
