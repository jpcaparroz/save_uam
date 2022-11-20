package com.example;

import com.example.models.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);

            Save stub = (Save) registry.lookup("Save");
            
            List<FilmeUsuario> lista = new ArrayList<>();
            
            lista = stub.getFilme();

            System.out.println(lista.size());

            
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        
    }

}