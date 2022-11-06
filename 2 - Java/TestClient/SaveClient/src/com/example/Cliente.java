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
            
            List<Usuario> lista1 = new ArrayList<>();
            
            lista = stub.getFilmeUsuario("teste@gmail.com");
            
            lista1 = stub.getUsuarios();
            
            //System.out.println(lista1.get(2).getNome());
            
            //System.out.println(lista.get(0).getNomeFilme());
            
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        
    }

}