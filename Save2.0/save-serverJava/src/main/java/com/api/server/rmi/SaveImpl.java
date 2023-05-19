package com.api.server.rmi;

import com.api.server.modules.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.rmi.RemoteException;

@Component
public class SaveImpl implements SaveService  {

    @Autowired
    UserService userService;

    @Override
    public boolean login(String login) throws RemoteException {
        String userEmail = userService.getUserByEmail(login)
                .getEmail();

        return !userEmail.isEmpty();
    }

}
