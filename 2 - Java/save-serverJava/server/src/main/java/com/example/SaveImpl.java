package com.example;

import java.rmi.RemoteException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.models.FilmeUsuario;
import com.example.models.Usuario;

public class SaveImpl implements Save {

    String bd = "jdbc:sqlite:D:/Eu/Pessoal/Faculdade/save_uam/1 - HTML/save-api/save-bd.db";

    // Método para cadastrar usuario
    public boolean cadastrar(String email, String nome) throws RemoteException {

        String sql = "INSERT into Usuario(email,nome) VALUES (?,?)";

        try {

            Connection connection = DriverManager.getConnection(bd);
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, email);
            statement.setString(2, nome);
            statement.executeUpdate();

            System.out.println("Usuario Cadastrado com Sucesso!!!");
            System.out.println("Nome: " + nome + " | com email: " + email);

            connection.close();
            return true;

        } catch (SQLException e) {
            
            System.out.println(e.getMessage());

            
            return false;
        }

    }

    // Método para realizar login
    public boolean login(String login) throws RemoteException {

        String sql = "SELECT * FROM Usuario WHERE email=?";

        try {

            Connection connection = DriverManager.getConnection(bd);

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);

            ResultSet result = statement.executeQuery();

            connection.close();
            return result.next() == true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());

            System.out.println("Usuário " + login + " não encontrado tentou se conectar");
            
            return false;
        }

    }

    // Método para retornar usuario
    public Usuario getUsuario(String login) throws RemoteException {

        String sql = "SELECT * FROM Usuario WHERE email=?";

        try {

            Connection connection = DriverManager.getConnection(bd);

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);

            ResultSet result = statement.executeQuery();

            Usuario user = new Usuario();

            result.next();

            user.setEmail(result.getString(1));
            user.setNome(result.getString(2));

            if (user.getNome() == null) {

                System.out.println("Algum usuário tentou se conectar...");

            } else if (user.getEmail().equals("root@admin.com")) {

                System.out.println("Administrador acaba de se conectar ao Save!");

            } else {
                System.out.println("Usuario " + user.getNome() + " acabou de se conectar!");
            }

            return user;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;

        }

    }

    // Método para retornar filmes do usuario
    public List<FilmeUsuario> getFilmeUsuario(String email) throws RemoteException {

        String sql = "SELECT * FROM filmeusuario WHERE emailUsuario=?";

        try {

            Connection connection = DriverManager.getConnection(bd);

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet result = statement.executeQuery();

            List<FilmeUsuario> filmes = new ArrayList<>();

            while (result.next()) {
                FilmeUsuario filmeUsuario = new FilmeUsuario();

                filmeUsuario.setEmailUsuario(result.getString(1));
                filmeUsuario.setNomeFilme(result.getString(2));
                filmeUsuario.setAnoFilme(result.getInt(3));
                filmeUsuario.setPosterFilme(result.getString(4));
                filmeUsuario.setNotaFilme(result.getInt(5));

                filmes.add(filmeUsuario);
            }

            System.out.println("[USER] email: " + email + " acessou sua coleção de filmes");

            connection.close();
            return filmes;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;

        }
    }

    // Método para retornar todos usuarios
    public List<Usuario> getUsuarios() throws RemoteException {

        String sql = "SELECT * FROM usuario";

        try {

            Connection connection = DriverManager.getConnection(bd);

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            List<Usuario> usuarios = new ArrayList<>();

            while (result.next()) {
                Usuario usuario = new Usuario();

                usuario.setEmail(result.getString(1));
                usuario.setNome(result.getString(2));

                usuarios.add(usuario);
            }

            System.out.println("[ADMIN] Admin acessou a tabela dos Usuarios");
            connection.close();
            return usuarios;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;

        }
    }
}
