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

    @GetMapping
    ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok()
                .body(userService.getAllUsers());
    }

    @GetMapping("/{email}")
    ResponseEntity<UserDto> getUserByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok()
                .body(userService.getUserByEmail(email));
    }

    @GetMapping("/{email}/movies")
    ResponseEntity<Set<MoviesDto>> getMoviesFromUser(@PathVariable("email") String email) {
        return ResponseEntity.ok()
                .body(userService.getMovies(email));
    }

    @PutMapping("/{email}")
    ResponseEntity<UserDto> updateUser(@PathVariable("email") String email) {
        return ResponseEntity.ok()
                .body(userService.getUserByEmail(email));
    }

    @DeleteMapping("/{email}")
    ResponseEntity<UserDto> deleteUser(@PathVariable("email") String email) {
        return ResponseEntity.ok()
                .body(userService.getUserByEmail(email));
    }
}
