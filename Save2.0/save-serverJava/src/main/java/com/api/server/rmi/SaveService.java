package com.api.server.rmi;


import com.api.server.rmi.modules.Usuario;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SaveService extends Remote {
    boolean login(String login) throws RemoteException;
    Usuario getUsuario(String login) throws RemoteException;
}
