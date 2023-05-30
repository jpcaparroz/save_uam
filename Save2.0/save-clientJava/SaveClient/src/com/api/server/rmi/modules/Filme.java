package com.api.server.rmi.modules;

import java.io.Serializable;

public class Filme implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String nomeFilme;
    private int anoFilme;
    private String posterFilme;

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
}
