package br.com.dao;

import java.util.List;

import br.com.entity.Produto;

public class Teste {

	public static void main(String[] args) throws Exception{

		List<Produto> produtos = new ProdutoDao().getAll();
		for (Produto produto : produtos) {
			System.out.println(produto.getQuantidade());
			System.out.println(produto.getTotal());
		}
		
		
	}

}
