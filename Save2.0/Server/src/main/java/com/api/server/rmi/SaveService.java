package com.api.server.rmi;


import java.rmi.Remote;

public interface SaveService extends Remote {

    boolean login(String login);

}
