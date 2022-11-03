package com.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.example.models.Usuario;

public interface Save extends Remote {

    public boolean cadastrar(String email, String nome) throws RemoteException;

    public boolean login(String login) throws RemoteException;

    public Usuario nomeUsuario(String login) throws RemoteException;
    
}
