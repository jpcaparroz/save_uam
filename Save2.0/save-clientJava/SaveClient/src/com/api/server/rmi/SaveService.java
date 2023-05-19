package com.api.server.rmi;

import com.example.models.*;
import java.util.List;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SaveService extends Remote {

    public boolean cadastrar(String email, String nome) throws RemoteException;

    boolean login(String login) throws RemoteException;

    public Usuario getUsuario(String login) throws RemoteException;
    
    public List<FilmeUsuario> getFilmeUsuario(String email) throws RemoteException;
    
    public List<FilmeUsuario> getFilme() throws RemoteException;
    
    public List<Usuario> getUsuarios () throws RemoteException;
    
    public boolean excluirUsuario(String email) throws RemoteException;
    
    public boolean excluirFilme(String email) throws RemoteException;
    
    public boolean adicionarFilme(FilmeUsuario filme, String email) throws RemoteException;
    
    //Melhorias save 2.0 -> Consumindo direto da API
    public boolean adicionarFilme2(Filme filme, String email) throws RemoteException;
    
    //Melhorias save 2.0 -> Consumindo direto da API
    public List<Filme> getFilme2() throws RemoteException;
    
}
