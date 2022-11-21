package com.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends SaveImpl {
    public static void main(String[] args) {

        try {
            SaveImpl impl = new SaveImpl();

            Save stub = (Save) UnicastRemoteObject.exportObject(impl, 0);

            Registry registry = LocateRegistry.createRegistry(18000);
            registry.rebind("Save", stub);
            System.out.println("[SERVER] Server SAVE online =)");
            
        } catch (Exception e) {
            
            System.out.println( "[ERRO] Falha ao iniciar o Servidor: " + e.getMessage());
            
        }
    }
    
}
