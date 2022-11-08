package com.example;

import com.example.models.*;
import java.util.List;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Save extends Remote {

    public boolean cadastrar(String email, String nome) throws RemoteException;

    public boolean login(String login) throws RemoteException;

    public Usuario getUsuario(String login) throws RemoteException;
    
    public List<FilmeUsuario> getFilmeUsuario(String email) throws RemoteException;
    
    public List<Usuario> getUsuarios () throws RemoteException;
    
    public boolean excluirUsuario(String email) throws RemoteException;
    
}
