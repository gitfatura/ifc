package br.com.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dao.ProdutoDao;
import br.com.entity.Produto;

public class ProdutoService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void adiciona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ProdutoDao dao = new ProdutoDao();
			Produto produto = new Produto();
			
			String descricao = request.getParameter("descricao");
			String quantidade = request.getParameter("quantidade");
			String valor = request.getParameter("valor").replace(",", ".");
			String data = request.getParameter("data");
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data);
			
			produto.setDescricao(descricao);
			produto.setQuantidade(Long.parseLong(quantidade));
			produto.setValor(Double.parseDouble(valor));
			produto.setData(date);
		 
				dao.adiciona(produto);
	 
			
			
		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());
		}
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Produto produto = new Produto();
			String descricao = request.getParameter("descricao");
			String quantidade = request.getParameter("quantidade");
			String valor = request.getParameter("valor").replace(",", ".");
			String data = request.getParameter("data");
			String id = request.getParameter("id");
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data);
			 
			produto.setId(Long.parseLong(id));
			produto.setDescricao(descricao);
			produto.setQuantidade(Long.parseLong(quantidade));
			produto.setValor(Double.parseDouble(valor));
			produto.setData(date);
			
			new ProdutoDao().update(produto);
			
		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());
		}
	}

	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Produto produto = new Produto();
			produto.setId(Long.parseLong(id));
			new ProdutoDao().remove(produto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void getProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String descricao = request.getParameter("descricao");
			List<Produto> produtos = new ProdutoDao().getProduto(descricao);
			request.setAttribute("produtos", produtos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Produto> produtos = new ProdutoDao().getAll();
			request.setAttribute("produtos", produtos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void entradasDeProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Produto> produtos = new ProdutoDao().entradasDeProdutos();
			request.setAttribute("produtos", produtos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void saidaDeProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Produto> produtos = new ProdutoDao().saidaDeProdutos();
			request.setAttribute("produtos", produtos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void produtoDeletados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Produto> produtos = new ProdutoDao().produtosDeletado();
			request.setAttribute("produtos", produtos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void entradaDeProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String quantidade = request.getParameter("quantidade");
			Produto produto = new Produto();
			produto.setId(Long.parseLong(id));
			produto.setQuantidade(Long.parseLong(quantidade));
			new ProdutoDao().entradaDeProduto(produto);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void saidaDeProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String quantidade = request.getParameter("quantidade");
			Produto produto = new Produto();
			ProdutoDao dao = new ProdutoDao();
			produto.setId(Long.parseLong(id));
			produto.setQuantidade(Long.parseLong(quantidade));
			Produto produ = dao.getQuantidades(produto);
			if (produ.getQuantidade()<produto.getQuantidade()) {
				HttpSession session = request.getSession();
				session.setAttribute("quanti", "Quantidade Invalida.");
				return;
			}else{
				dao.saidaDeProduto(produto);	
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void getProdutoById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Produto produto = new ProdutoDao().getId(Integer.parseInt(id));
			request.setAttribute("produto", produto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
