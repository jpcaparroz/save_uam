package com.api.server.rmi.modules;

import java.io.Serializable;

public class FilmeUsuario implements Serializable{
    
    private int id;
    private String emailUsuario;
    private String nomeFilme;
    private int anoFilme;
    private String posterFilme;
    private int notaFilme;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getEmailUsuario() {
        return emailUsuario;
    }
    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
    public String getNomeFilme() {
        return nomeFilme;
    }
    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }
    public int getAnoFilme() {
        return anoFilme;
    }
    public void setAnoFilme(int anoFilme) {
        this.anoFilme = anoFilme;
    }
    public String getPosterFilme() {
        return posterFilme;
    }
    public void setPosterFilme(String posterFilme) {
        this.posterFilme = posterFilme;
    }
    public int getNotaFilme() {
        return notaFilme;
    }
    public void setNotaFilme(int notaFilme) {
        this.notaFilme = notaFilme;
    }
  
}
