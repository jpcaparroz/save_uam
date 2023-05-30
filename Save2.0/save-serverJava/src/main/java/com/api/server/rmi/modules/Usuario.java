package com.api.server.rmi.modules;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String email;
    private String nome;
}
