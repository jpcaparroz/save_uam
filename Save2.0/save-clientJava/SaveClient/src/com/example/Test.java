package com.example;

import com.api.server.rmi.SaveService;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Joao Pedro
 */
public class Test {
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        
        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);

            SaveService stub = (SaveService) registry.lookup("Save");
            
            String login = "root@admin.com";
            
            System.out.println(stub.getMelhoresFilmes().get(100).getNomeFilme());

            if (stub.login(login) == true) {
                
                
                
                System.out.println(stub.getUsuario(login).getNome()); 
                
                System.out.println("FOI!!!!!!!");
            } else {
                System.out.println("NAOOOOOOOO");
            }

                
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    
}
