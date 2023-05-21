package com.api.server.rmi;

import com.api.server.modules.user.UserDto;
import com.api.server.modules.user.UserService;
import com.api.server.rmi.modules.Usuario;
import org.springframework.stereotype.Component;

@Component
public class SaveImpl implements SaveService  {

    final
    UserService userService;

    public SaveImpl(UserService userService) {
        this.userService = userService;
    }



    private Usuario mapToUsuario(UserDto userDto) {
        return Usuario.builder()
                .email(userDto.getEmail())
                .nome(userDto.getName())
                .build();
    }

}
