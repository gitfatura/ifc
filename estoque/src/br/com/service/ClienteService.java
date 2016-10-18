package br.com.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.dao.ClienteDao;
import br.com.entity.Cliente;

public class ClienteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void adiciona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String sexo = request.getParameter("sexo");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String data = request.getParameter("data");
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setRg(rg);
		cliente.setSexo(sexo);
		cliente.setTelefone(telefone);
		cliente.setEmail(email);
		cliente.setEndereco(endereco);
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data);
		cliente.setData(date);
		new ClienteDao().adiciona(cliente);
		
		} catch (Exception e) {
			 System.out.println(e.getMessage());
		}
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String sexo = request.getParameter("sexo");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String data = request.getParameter("data");
		
		Cliente cliente = new Cliente();
		cliente.setId(Long.parseLong(id));
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setRg(rg);
		cliente.setSexo(sexo);
		cliente.setTelefone(telefone);
		cliente.setEmail(email);
		cliente.setEndereco(endereco);
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data);
		cliente.setData(date);
		new ClienteDao().update(cliente);
		
		} catch (Exception e) {
			 System.out.println(e.getMessage());
		}
	}
	
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Cliente> clientes = new ClienteDao().getAll();
			request.setAttribute("clientes", clientes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String id = request.getParameter("id");
			Cliente cliente = new Cliente();
			cliente.setId(Long.parseLong(id));
			new ClienteDao().remove(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void getClientePorID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Cliente cliente = new ClienteDao().getCliente(Integer.parseInt(id));
			request.setAttribute("cliente", cliente);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	
}










