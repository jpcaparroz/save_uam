package com.api.server.rmi.modules;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmeUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String emailUsuario;
    private String nomeFilme;
    private int anoFilme;
    private String posterFilme;
    private int notaFilme;
}
