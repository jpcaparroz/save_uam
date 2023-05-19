package com.api.server.rmi;

import com.api.server.modules.user.UserService;
import org.springframework.stereotype.Component;

import java.rmi.RemoteException;

@Component
public class SaveImpl implements SaveService  {

    final
    UserService userService;

    public SaveImpl(UserService userService) {
        this.userService = userService;
    }

    public boolean login(String login) throws RemoteException {
        String userEmail = userService.getUserByEmail(login)
                .getEmail();

        return !userEmail.isEmpty();
    }

}
