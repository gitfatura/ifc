package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.entity.Login;

public class LoginDao {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexao;
	


	public Login logar(Login login)throws Exception{
		String sql ="select * from login where usuario =? and senha =?";
		Login login2 =null;
		try {
			conexao = Conexao.getConnection();
			ps = conexao.prepareStatement(sql);
			ps.setString(1, login.getUsuario());
			ps.setString(2, login.getSenha());
			rs = ps.executeQuery();
			while (rs.next()){
				login2 = new Login();
				login2.setUsuario(rs.getString("usuario"));
				login2.setSenha(rs.getString("senha"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return login2;
	}

	
	
	
	
}
