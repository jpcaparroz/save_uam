package com.example;

import java.rmi.RemoteException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveImpl implements Save {

    String bd = "jdbc:sqlite:C:/Users/Joao/Desktop/Save/save-api/save-bd.db";

    public boolean cadastrar(String email, String nome) throws RemoteException {

        String sql = "INSERT or IGNORE into Usuario(email,nome) VALUES (?,?)";

        try {

            Connection connection = DriverManager.getConnection(bd);
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, email);
            statement.setString(2, nome);
            statement.executeUpdate();

            System.out.println("Usuario: " + nome + " | com email: " + email);

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());

            return false;
        }

    }

    public String login(String login) throws RemoteException {

        String sql = "SELECT * FROM Usuario WHERE email=?";

        try {

            Connection connection = DriverManager.getConnection(bd);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                
                System.out.println(result.getString(1));
                return result.getString(1);

            }

            return "erro";

        } catch (SQLException e) {
            System.out.println(e.getMessage());

            return "Nao tem! =(";
        }

    }     
    
}
