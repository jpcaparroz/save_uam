package com.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Save extends Remote {

    public boolean cadastrar(String email, String nome) throws RemoteException;
    
    public String login(String login) throws RemoteException;
    
}
