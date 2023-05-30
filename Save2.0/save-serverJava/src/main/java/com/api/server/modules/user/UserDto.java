package com.api.server.modules.user;

import com.api.server.modules.movies.MoviesDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(NON_NULL)
public class UserDto {
    private Long id;
    private String email;
    private String name;
    @JsonIgnoreProperties({"user.movies", "user"})
    private Set<MoviesDto> movies;
}