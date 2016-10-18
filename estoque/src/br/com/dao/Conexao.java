package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static Connection connection;

	public static Connection getConnection() throws Exception {

		try {

			if (connection ==null || connection.isClosed()) {
				
				Class.forName("com.mysql.jdbc.Driver");//Força o drive do banco de dados
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estoque", "root", "sysdba");//Caminho do bando de dados
			}
			
		} catch (Exception e) {//Captura a exeção
			System.out.println("Erro ao conectar com a mysql :"+e.getMessage());
		}
		return connection;//Retorna a conexao.
	}
}
