package com.api.server.rmi;

import com.api.server.modules.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveImpl implements SaveService{

    @Autowired
    UserService userService;

    public boolean login(String login) {
        String userEmail = userService.getUserByEmail(login)
                .getEmail();

        return !userEmail.isEmpty();
    }

}
