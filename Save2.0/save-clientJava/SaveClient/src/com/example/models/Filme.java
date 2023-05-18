package com.example.models;

import java.io.Serializable;

public class Filme implements Serializable{
    
    private String nomeFilme;
    private int anoFilme;
    private String posterFilme;
    private int notaFilme;

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
