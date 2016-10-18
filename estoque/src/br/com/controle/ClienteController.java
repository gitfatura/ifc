package br.com.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.service.ClienteService;


@WebServlet({ "/novo-cliente","/salva-cliente", "/update-cliente","/remove-cliente","/all-clientes","/id-cliente",
	"/id-update-cliente","/relatorio-clientes" })

public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ClienteService cliente = new ClienteService();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 executa(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executa(request, response);
	}
	
	
	private void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String uri = request.getRequestURI();
		 String path = request.getContextPath();

		 if (uri.equalsIgnoreCase(path+"/novo-cliente")) {
			request.getRequestDispatcher("/cliente.jsp").forward(request, response);
		}
		 if (uri.equalsIgnoreCase(path+"/salva-cliente")) {
			cliente.adiciona(request, response);
			response.sendRedirect(path+"/novo-cliente");
		}
		 if (uri.equalsIgnoreCase(path+"/id-update-cliente")) {
			 cliente.getClientePorID(request, response);
			 request.getRequestDispatcher("/cliente-update.jsp").forward(request, response);
		}
		 if (uri.equalsIgnoreCase(path+"/remove-cliente")) {
			 cliente.remove(request, response);
			 response.sendRedirect(path+"/all-clientes");
		}
		 if (uri.equalsIgnoreCase(path+"/update-cliente")) {
			 cliente.update(request, response);
			 response.sendRedirect(path+"/all-clientes");
		}
		 if (uri.equalsIgnoreCase(path+"/all-clientes")) {
			 cliente.getAll(request, response);
			request.getRequestDispatcher("/clientes.jsp").forward(request, response);
		}
		 
		 if (uri.equalsIgnoreCase(path+"/relatorio-clientes")) {
			request.getRequestDispatcher("/relatorio-cliente.jsp").forward(request, response);
		}
	}

}






