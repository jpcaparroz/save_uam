package com.api.server.modules.user;

import com.api.server.modules.movies.MoviesDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(201)
                .body(userService.createUser(userDto));
    }

    @GetMapping("/list")
    ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok()
                .body(userService.getAllUsers());
    }

    @GetMapping
    ResponseEntity<UserDto> getUserByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok()
                .body(userService.getUserByEmail(email));
    }

    @GetMapping("/movies")
    ResponseEntity<Set<MoviesDto>> getMoviesFromUser(@RequestParam("email") String email) {
        return ResponseEntity.ok()
                .body(userService.getMovies(email));
    }

    @PutMapping
    ResponseEntity<UserDto> updateUser(@RequestParam("email") String email) {
        return ResponseEntity.ok()
                .body(userService.getUserByEmail(email));
    }

    @DeleteMapping
    ResponseEntity<UserDto> deleteUser(@RequestParam("email") String email) {
        return ResponseEntity.ok()
                .body(userService.getUserByEmail(email));
    }
}
