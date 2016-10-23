package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.entity.Produto;

public class ProdutoDao{
	
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexao;
	 
	public void adiciona(Produto produto) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "INSERT INTO produto(descricao,"
					+ " quantidade,"
					+ " valor,"		
					+ " data)"
					+ "VALUES(?, ?, ?, ?)";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, produto.getDescricao());
			ps.setLong(2, produto.getQuantidade());
			ps.setDouble(3, produto.getValor());
			ps.setDate(4, new java.sql.Date(produto.getData().getTime()));
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Erro ao salvar o produto : " + e.getMessage()+"\n"+"Causa do erro :"+e.getCause());
		} finally {
			 conexao.close();
		}
	}
	
	public void update(Produto produto) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "UPDATE  produto SET" 
					+ " descricao=?,"				
					+ " quantidade=?,"
					+ " valor=?,"
					+ " data =?"
					+ " WHERE id =?";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, produto.getDescricao());
			ps.setLong(2, produto.getQuantidade());
			ps.setDouble(3, produto.getValor());
			ps.setDate(4, new java.sql.Date(produto.getData().getTime()));
			ps.setLong(5, produto.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro não foi possivel atualizar o produto : " + e.getMessage());
		}finally{
			conexao.close();
		}
	}
	
	public void entradaDeProduto(Produto produto)throws Exception{
		try{
			conexao = Conexao.getConnection();
			String sql = "UPDATE produto SET quantidade = quantidade + ?  WHERE id = ?";
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, produto.getQuantidade());
			ps.setLong(2, produto.getId());
			ps.executeUpdate();
		}catch(Exception e){			
			System.out.println("Erro não foi possivel dar entrada  do produto : " + e.getMessage());
		}finally{
			conexao.close();
		}
	}
	
	
	public void saidaDeProduto(Produto produto)throws Exception{
		try{
			conexao = Conexao.getConnection();
			String sql = "UPDATE produto SET quantidade = quantidade - ? WHERE id = ?";
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, produto.getQuantidade());
			ps.setLong(2, produto.getId());
			ps.executeUpdate();
			
		}catch(Exception e){
			System.out.println("Erro ao dar baixa do produto:"+ "\n"+ e.getMessage());
		}finally{
			conexao.close();
		}
	}
	
	public void remove(Produto produto) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "DELETE FROM produto WHERE id=?";
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, produto.getId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro ao deletar o produto: "+ "\n"+ e.getMessage() + "\n");
		} finally {
			conexao.close();
		}
	}
	
	
	public Produto getId(int id) throws Exception {
		Produto produto = null;
		try {
			conexao = Conexao.getConnection();
			String sql = "SELECT * FROM produto WHERE id =?";
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getLong("quantidade"));
				produto.setValor(rs.getDouble("valor"));
				produto.setData(rs.getDate("data"));
			}

		} catch (Exception e) {
			System.out.println("Erro ao pesquisa produto, com o codigo o produto: "+ "\n"+ e.getMessage());
		} finally {
			conexao.close();
		}
		return produto;
	}

	
	public List<Produto> getProduto(String item) throws Exception {
		List<Produto> lista = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "SELECT * FROM produto WHERE UPPER(descricao)LIKE UPPER(?)";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, "%" + item + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getLong("quantidade"));
				produto.setValor(rs.getDouble("valor"));
				produto.setValor(rs.getDouble("total"));
				lista.add(produto);
			}
		} catch (Exception e) {
			System.out.println("Erro ao pesquisa lista produto, com descricao do produto: "+ "\n"+ e.getMessage() + "\n");
		} finally {
			conexao.close();
		}
		return lista;
	}
	
	
	public List<Produto> getAll() throws Exception {
		List<Produto> lista = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "select id, sum(quantidade * valor)as total,valor,descricao,quantidade,data from produto group by id order by total";
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getLong("quantidade"));
				produto.setValor(rs.getDouble("valor"));
				produto.setTotal(rs.getDouble("total"));
				produto.setData(rs.getDate("data"));
				lista.add(produto);
			}
		} catch (Exception e) {
			System.out.println("Erro ao pesquisa lista produto, com descricao do produto "+ "\n"+ e.getMessage() + "\n");
		} finally {
			conexao.close();
		}
		return lista;
	}
	
	
	public Produto getQuantidades(Produto produto){
	 
		String sql ="select quantidade from produto where id =?";
		try {
			conexao = Conexao.getConnection();
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, produto.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
			    produto = new Produto();
				produto.setQuantidade(rs.getLong("quantidade"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return produto;
	}
	
	
	public List<Produto> entradasDeProdutos() throws Exception {
		List<Produto> lista = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "select id, sum(quantidade * valor)as total,valor,descricao,quantidade,data from entrada_produto group by id order by id";
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getLong("quantidade"));
				produto.setValor(rs.getDouble("valor"));
				produto.setTotal(rs.getDouble("total"));
				produto.setData(rs.getDate("data"));
				lista.add(produto);
			}
		} catch (Exception e) {
			System.out.println("Erro ao pesquisa lista entrada_produto "+ "\n"+ e.getMessage() + "\n");
		} finally {
			conexao.close();
		}
		return lista;
	}
	
	public List<Produto> saidaDeProdutos() throws Exception {
		List<Produto> lista = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "select id, sum(quantidade * valor)as total,valor,descricao,quantidade,data from saida_produto group by id order by descricao";
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getLong("quantidade"));
				produto.setValor(rs.getDouble("valor"));
				produto.setTotal(rs.getDouble("total"));
				produto.setData(rs.getDate("data"));
				lista.add(produto);
			}
		} catch (Exception e) {
			System.out.println("Erro ao pesquisa lista atualizacao_produto "+ "\n"+ e.getMessage() + "\n");
		} finally {
			conexao.close();
		}
		return lista;
	}
	
	public List<Produto> produtosDeletado() throws Exception {
		List<Produto> lista = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "select id, sum(quantidade * valor)as total,valor,descricao,quantidade,data from produto_deletado group by id order by total";
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getLong("quantidade"));
				produto.setValor(rs.getDouble("valor"));
				produto.setTotal(rs.getDouble("total"));
				produto.setData(rs.getDate("data"));
				lista.add(produto);
			}
		} catch (Exception e) {
			System.out.println("Erro ao pesquisa lista produto deletado "+ "\n"+ e.getMessage() + "\n");
		} finally {
			conexao.close();
		}
		return lista;
	}
	
	
}








