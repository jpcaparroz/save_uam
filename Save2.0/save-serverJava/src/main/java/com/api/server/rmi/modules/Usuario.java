package com.api.server.rmi.modules;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
    private String email;
    private String nome;
}
