package com.example;

import com.api.server.rmi.modules.FilmeUsuario;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import com.api.server.rmi.SaveService;

public class Cliente {

    private static final String SERVER_IP = "127.0.0.1";

    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.getRegistry(SERVER_IP, 18000);

            SaveService stub = (SaveService) registry.lookup("Save");
            
            List<FilmeUsuario> lista = new ArrayList<>();
            
            lista = stub.getFilme();

            System.out.println(lista.size());

            
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        
    }

}