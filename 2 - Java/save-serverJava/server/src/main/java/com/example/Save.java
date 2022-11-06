package com.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.example.models.FilmeUsuario;
import com.example.models.Usuario;

public interface Save extends Remote {

    public boolean cadastrar(String email, String nome) throws RemoteException;

    public boolean login(String login) throws RemoteException;

    public Usuario getUsuario(String login) throws RemoteException;

    public List<FilmeUsuario> getFilmeUsuario (String email) throws RemoteException;
 
    public List<Usuario> getUsuarios () throws RemoteException;
}
