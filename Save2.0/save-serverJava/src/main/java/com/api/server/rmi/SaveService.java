package com.api.server.rmi;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SaveService extends Remote {
    boolean login(String login) throws RemoteException;
}
