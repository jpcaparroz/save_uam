package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static Connection con = null;

	static {
		String bd = "jdbc:sqlite:C:/Users/Joao/Desktop/Save/1 - HTML/save-api/save-bd.db";
		try {
			con = (Connection) DriverManager.getConnection(bd);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}
}
