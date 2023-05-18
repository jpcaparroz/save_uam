package com.api.server.rmi;

import com.api.server.modules.movies.MoviesService;
import com.api.server.modules.user.UserService;

public class SaveImpl implements SaveService{

    final
    UserService userService;

    final
    MoviesService moviesService;

    public SaveImpl(UserService userService, MoviesService moviesService) {
        this.userService = userService;
        this.moviesService = moviesService;
    }

    public boolean login(String login) {
        String userEmail = userService.getUserByEmail(login)
                .getEmail();

        return !userEmail.isEmpty();
    }

}
