package com.api.server.rmi;

import com.api.server.modules.user.UserDto;
import com.api.server.modules.user.UserService;
import com.api.server.rmi.modules.Usuario;
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

    public Usuario getUsuario(String login) throws RemoteException {
        return mapToUsuario(userService.getUserByEmail(login));
    }

    private Usuario mapToUsuario(UserDto userDto) {
        return Usuario.builder()
                .email(userDto.getEmail())
                .nome(userDto.getName())
                .build();
    }

}
