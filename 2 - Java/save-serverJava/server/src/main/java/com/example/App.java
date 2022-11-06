package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

    String bd = "jdbc:sqlite:C:/Users/Joao/Desktop/Save/save-api/save-bd.db";

    // Insere Usuario no Banco de Dados
    public void inserirUsuario(String email, String nome) {

        String sql = "INSERT INTO Usuario(email,nome) VALUES (?,?)";

        try {

            Connection connection = DriverManager.getConnection(bd);
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, email);
            statement.setString(2, nome);
            statement.executeUpdate();

            System.out.println("Usuario: " + nome + " | com email: " + email);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    // Retorna todos usuarios
    public void usuarios() {

        String sql = "SELECT * FROM Usuario";

        try {
            Connection con = DriverManager.getConnection(bd);
            ;
            java.sql.Statement stat = con.createStatement();

            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {

                System.out.println(rs.getString("email") + "\t" +
                        rs.getString("nome"));

            }

        } catch (SQLException e) {
        }
    }

    public void filmesUsuario() {

        String sql = "SELECT * FROM Usuario";

        try {
            Connection con = DriverManager.getConnection(bd);
            ;
            java.sql.Statement stat = con.createStatement();

            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {

                System.out.println(rs.getString("email") + "\t" +
                        rs.getString("nome"));

            }

        } catch (SQLException e) {
        }
    }


    public static void main(String[] args) throws Exception {
        App app = new App();

        app.inserirUsuario("test@gmail.com", "Pedro");

        app.usuarios();

    }
}
