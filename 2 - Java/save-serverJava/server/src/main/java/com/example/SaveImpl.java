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

    // Método para cadastrar usuario
    public boolean cadastrar(String email, String nome) throws RemoteException {

        String sql = "INSERT into Usuario(email,nome) VALUES (?,?)";

        try {

            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, email);
            statement.setString(2, nome);
            statement.executeUpdate();

            System.out.println("Usuario Cadastrado com Sucesso!!!");
            System.out.println("Nome: " + nome + " | com email: " + email);

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

            Connection connection = Conexao.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);

            ResultSet result = statement.executeQuery();

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

            Connection connection = Conexao.getConnection();

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

            Connection connection = Conexao.getConnection();

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

            return filmes;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;

        }
    }

    // Método para retornar todos os filmes já salvos no Save
    public List<FilmeUsuario> getFilme() throws RemoteException {

        String sql = "SELECT * FROM filmeusuario";

        try {

            Connection connection = Conexao.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

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

            System.out.println("[USER] Usuário solicitou coleção de filmes Save");

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

            Connection connection = Conexao.getConnection();

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
            return usuarios;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;

        }
    }

    public boolean excluirUsuario(String email) throws RemoteException {

        String sql = "DELETE FROM usuario WHERE email=?";

        try {

            Connection connection = Conexao.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            if(email.equals("root@admin.com")) {
                System.out.println("[ADMIN] Tentou excluir o usuario ADMIN ");
                return false;

            } else {

                int rowsDeleted = statement.executeUpdate();

                excluirFilme(email);
                System.out.println("[ADMIN] Usuário " + email + " excluido com sucesso! ");
                return rowsDeleted < 0;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

            return false;
        }

    }

    public boolean excluirFilme(String email) throws RemoteException {

        String sql = "DELETE FROM filmeusuario WHERE emailUsuario=?";

        try {

            Connection connection = Conexao.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            int rowsDeleted = statement.executeUpdate();

            System.out.println("[ADMIN] Filmes do usuario " + email + " excluidos com sucesso! ");
            
            return rowsDeleted < 0;

        } catch (SQLException e) {

            System.out.println(e.getMessage());            
            return false;
        }

    }

    public boolean adicionarFilme(FilmeUsuario filme, String email) throws RemoteException {

        String sql = "INSERT into filmeusuario(emailUsuario,nomeFilme, anoFilme, posterFilme, notaFilme) VALUES (?,?,?,?,?)";

        try {

            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, email);
            statement.setString(2, filme.getNomeFilme());
            statement.setInt(3, Integer.valueOf(filme.getAnoFilme()));
            statement.setString(4, filme.getPosterFilme());
            statement.setInt(5, Integer.valueOf(filme.getNotaFilme()));
            statement.executeUpdate();

            System.out.println("[USER] Filme Save");
            System.out.println("Usuario: " + email + " | Adicionou o filme " + filme.getNomeFilme() + " em seu Save!");

            return true;

        } catch (SQLException e) {
            
            System.out.println(e.getMessage());

            
            return false;
        }
    }
}
