package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.entity.Cliente;

public class ClienteDao {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexao;
	
	
	public void adiciona(Cliente cliente) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "INSERT INTO cliente(nome,"
					+ " cpf,"
					+ " rg,"
					+ " sexo,"
					+ " telefone,"
					+ " email,"
					+ " endereco,"
					+ " data)"
					+ "VALUES(?, ?, ?, ?,?,?,?,?)";
			ps = conexao.prepareStatement(sql);
			ps.setString(1,cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getRg());
			ps.setString(4, cliente.getSexo());
			ps.setString(5, cliente.getTelefone());
			ps.setString(6, cliente.getEmail());
			ps.setString(7, cliente.getEndereco());
			ps.setDate(8, new java.sql.Date(cliente.getData().getTime()));
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Erro ao salvar o Cliente : " + e.getMessage()+"\n"+"Causa do erro :"+e.getCause());
		} finally {
			 conexao.close();
		}
	}
	
	public void update(Cliente cliente) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "UPDATE  cliente SET" 
					+ " nome=?,"
					+ " cpf=?,"
					+ " rg=?,"
					+ " sexo=?,"
					+ " telefone=?,"
					+ " email=?,"
					+ " endereco=?,"
					+ " data =?"
					+ " WHERE id =?";
			ps = conexao.prepareStatement(sql);
			ps.setString(1,cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getRg());
			ps.setString(4, cliente.getSexo());
			ps.setString(5, cliente.getTelefone());
			ps.setString(6, cliente.getEmail());
			ps.setString(7, cliente.getEndereco());
			ps.setDate(8, new java.sql.Date(cliente.getData().getTime()));
			ps.setLong(9, cliente.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro não foi possivel atualizar o cliente : " + e.getMessage());
		}finally{
			conexao.close();
		}
	}
	
	
	public void remove(Cliente cliente) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "DELETE FROM cliente WHERE id=?";
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, cliente.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro ao deletar o cliente: "+ "\n"+ e.getMessage() + "\n");
		} finally {
			conexao.close();
		}
	}
	 
	
	public List<Cliente> getAll() throws Exception {
		List<Cliente> clientes = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "SELECT * FROM cliente";
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				 Cliente cliente = new Cliente();
				 cliente.setId(rs.getLong("id"));
				 cliente.setNome(rs.getString("nome"));
				 cliente.setCpf(rs.getString("cpf"));
				 cliente.setRg(rs.getString("rg"));
				 cliente.setSexo(rs.getString("sexo"));
				 cliente.setTelefone(rs.getString("telefone"));
				 cliente.setEmail(rs.getString("email"));
				 cliente.setEndereco(rs.getString("endereco"));
				 cliente.setData(rs.getDate("data"));
				 clientes.add(cliente);
			}
		} catch (Exception e) {
			System.out.println("Erro ao pesquisa lista cliente : "+ "\n"+ e.getMessage() + "\n");
		} finally {
			conexao.close();
		}
		return clientes;
	}
	
	public Cliente getCliente(int  id) throws Exception {
		Cliente cliente = null;
		try {
			conexao = Conexao.getConnection();
			String sql = "SELECT * FROM cliente WHERE id=?";
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				 cliente = new Cliente();
				 cliente.setId(rs.getLong("id"));
				 cliente.setNome(rs.getString("nome"));
				 cliente.setCpf(rs.getString("cpf"));
				 cliente.setRg(rs.getString("rg"));
				 cliente.setSexo(rs.getString("sexo"));
				 cliente.setTelefone(rs.getString("telefone"));
				 cliente.setEmail(rs.getString("email"));
				 cliente.setEndereco(rs.getString("endereco"));
				 cliente.setData(rs.getDate("data"));
			}
		} catch (Exception e) {
			System.out.println("Erro ao pesquisa  cliente : "+ "\n"+ e.getMessage() + "\n");
		} finally {
			conexao.close();
		}
		return cliente;
	}
	
}
