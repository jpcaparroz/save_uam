package com.api.server.modules.movies;

import com.api.server.modules.user.UserDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(NON_NULL)
public class MoviesDto {

    private Long id;
    private String name;
    private String year;
    private String poster;
    private String rating;
    private UserDto user;

}
