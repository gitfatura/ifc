package br.com.controle;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dao.LoginDao;
import br.com.entity.Login;

@WebServlet(urlPatterns = { "/login", "/autentica", "/logof" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		String uri = request.getRequestURI();
		String path = request.getContextPath();

		if (uri.equalsIgnoreCase(path + "/login")) {
			login(request, response);
		}
		if (uri.equalsIgnoreCase(path+"/autentica")) {
			logar(request, response);
		}
		if (uri.equalsIgnoreCase(path+"/logof")) {
			logof(request, response);
		}

	}

	public void login(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	
	
	public void logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");

		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String senhahex = hexString.toString();
		
		Login login1 = new Login();
		login1.setUsuario(usuario);
		login1.setSenha(senhahex);

	
			Login login = new LoginDao().logar(login1);

			if (login != null) {
				HttpSession session = request.getSession();
				session.setAttribute("usuario_logado", login);
				response.sendRedirect(request.getContextPath()+"/index");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("login_erro", "Usuario ou Senha invalido");
				response.sendRedirect(request.getContextPath() + "/login");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void logof(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/login");
	}

}










