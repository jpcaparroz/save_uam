package com.api.server.rmi;

import com.api.server.rmi.modules.Filme;
import com.api.server.rmi.modules.FilmeUsuario;
import com.api.server.rmi.modules.Usuario;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SaveService extends Remote {
    boolean cadastrar(String email, String nome) throws RemoteException;

    boolean login(String login) throws RemoteException;

    Usuario getUsuario(String login) throws RemoteException;

    List<FilmeUsuario> getFilmeUsuario(String email) throws RemoteException;

    List<FilmeUsuario> getFilme() throws RemoteException;

    List<Usuario> getUsuarios() throws RemoteException;

    boolean excluirUsuario(String email) throws RemoteException;

    boolean adicionarFilme(FilmeUsuario filme, String email) throws RemoteException;

    List<Filme> getFilme2(String filme) throws RemoteException;

    List<Filme> getMelhoresFilmes() throws RemoteException;
}
