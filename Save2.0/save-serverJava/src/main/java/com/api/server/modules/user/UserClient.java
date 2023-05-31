package com.api.server.modules.user;

import com.api.server.modules.movies.MoviesDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@FeignClient(name = "userClient", url = "http://127.0.0.1:5000")
public interface UserClient {

    @PostMapping("/user")
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto);

    @GetMapping("/user/list")
    ResponseEntity<List<UserDto>> getUsers();

    @GetMapping("/user")
    ResponseEntity<UserDto> getUserByEmail(@RequestParam("email") String email);

    @GetMapping("/user/movies")
    ResponseEntity<Set<MoviesDto>> getMoviesFromUser(@RequestParam("email") String email);

    @PutMapping("/user")
    ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,
                                       @RequestParam("id") Long id);

    @DeleteMapping("/user")
    ResponseEntity<UserDto> deleteUser(@RequestParam("email") String email);

}
