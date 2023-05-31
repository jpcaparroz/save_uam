package com.api.server.rmi.modules;

import java.io.Serializable;

public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String email;
    private String nome;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}
