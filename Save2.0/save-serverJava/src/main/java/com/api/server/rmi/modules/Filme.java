package com.api.server.rmi.modules;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Filme implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nomeFilme;
    private int anoFilme;
    private String posterFilme;
}
