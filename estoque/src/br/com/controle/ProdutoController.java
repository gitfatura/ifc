package br.com.controle;

import br.com.service.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/novo-produto","/salva-produto","/update-produto","/remove-produto","/get-produto","/get-produtos",
			  "/entrada-produto","/saida-produto","/getId-produto","/entradaById-produto","/saidaById-produto","/manutencao-produtos",
	  "/produto-relatorio","/entradas-produtos","/saida-de-produtos","/produtos-deletado",
  "/produto-deletado-relatorio","/relatorio-entrada-produto"})


public class ProdutoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private ProdutoService produtoService = new ProdutoService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		executa(request, response);
	}

	private void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 
		String path = request.getContextPath();
		String uri = request.getRequestURI();
		
		//Novo Produto
		if (uri.equalsIgnoreCase(path + "/novo-produto")) {
			request.getRequestDispatcher("/novo-produto.jsp").forward(request, response);
		}
		
		//Salva o produto
		if (uri.equalsIgnoreCase(path + "/salva-produto")) {
			produtoService.adiciona(request, response);
			response.sendRedirect(path+"/novo-produto");
			
		}
		
		//Lista todos os produtos
		if (uri.equalsIgnoreCase(path + "/get-produtos")) {
			produtoService.getAll(request, response);
			request.getRequestDispatcher("/lista-produtos.jsp").forward(request, response);
		}
		
		if (uri.equalsIgnoreCase(path + "/manutencao-produtos")) {
			produtoService.getAll(request, response);
			request.getRequestDispatcher("/manutencao-produtos.jsp").forward(request, response);
		}
		
		//Atualiza os produtos
		if (uri.equalsIgnoreCase(path + "/update-produto")) {
			produtoService.update(request, response);
			response.sendRedirect(path+"/manutencao-produtos");
		}
		
		//Remove os produtos
		if (uri.equalsIgnoreCase(path + "/remove-produto")) {
			produtoService.remove(request, response);
			response.sendRedirect(path+"/manutencao-produtos");
		}
		
		//Lista de produtos por nome
		if (uri.equalsIgnoreCase(path + "/get-produto")) {
			produtoService.getProduto(request, response);
			request.getRequestDispatcher("/get-produtos.jsp").forward(request, response);
			
		}
		
		//Entrada de produto no estoque
		if (uri.equalsIgnoreCase(path + "/entrada-produto")) {
			produtoService.entradaDeProduto(request, response);
			response.sendRedirect(path+"/manutencao-produtos");
		}
		
		if (uri.equalsIgnoreCase(path + "/entradaById-produto")) {
			produtoService.getProdutoById(request, response);
			request.getRequestDispatcher("/entrada-produto.jsp").forward(request, response);
		}
		
		//Saida de produto no estoque
		if (uri.equalsIgnoreCase(path + "/saida-produto")) {
			produtoService.saidaDeProduto(request, response);
			request.getRequestDispatcher("/saida-produto.jsp").forward(request, response);
		}
		if (uri.equalsIgnoreCase(path + "/saidaById-produto")) {
			produtoService.getProdutoById(request, response);
			request.getRequestDispatcher("/saida-produto.jsp").forward(request, response);
			
		}
		
		if (uri.equalsIgnoreCase(path + "/getId-produto")) {
			produtoService.getProdutoById(request, response);
			request.getRequestDispatcher("/update-produto.jsp").forward(request, response);
			
		}if (uri.equalsIgnoreCase(path + "/entradas-produtos")) {
			produtoService.entradasDeProdutos(request, response);
			request.getRequestDispatcher("/entradas-produtos.jsp").forward(request, response);
			
		}if (uri.equalsIgnoreCase(path + "/saida-de-produtos")) {
			produtoService.saidaDeProdutos(request, response);
			request.getRequestDispatcher("/saida-de-produtos.jsp").forward(request, response);
		}
		if (uri.equalsIgnoreCase(path + "/produtos-deletado")) {
			produtoService.produtoDeletados(request, response);
			request.getRequestDispatcher("/produtos-deletados.jsp").forward(request, response);
		}
		
		
		if (uri.equalsIgnoreCase(path+"/produto-relatorio")) {
			request.getRequestDispatcher("/relatorio-produto.jsp").forward(request, response);
		}
		if (uri.equalsIgnoreCase(path+"/produto-deletado-relatorio")) {
			request.getRequestDispatcher("/relatorio-produto-deletado.jsp").forward(request, response);
		
		}if (uri.equalsIgnoreCase(path+"/relatorio-entrada-produto")) {
			request.getRequestDispatcher("/relatorio-entrada-produto.jsp").forward(request, response);
		}
		

	}

}
