package com.example;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);

            Save stub = (Save) registry.lookup("Save");
            
            System.out.println(stub.login("joao@testando.java"));
            
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        
    }

}