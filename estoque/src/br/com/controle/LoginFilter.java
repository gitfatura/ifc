package br.com.controle;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns={"/*"})
public class LoginFilter implements Filter {

	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		 
		 if (!isUsuarioLogado(session) && !isUsuarioAutenticado(request)) {
				HttpServletResponse response = (HttpServletResponse) resp;
				response.sendRedirect(request.getContextPath()+"/login");
			}else{
				chain.doFilter(req, resp);
			}
	}	
		
	public boolean isUsuarioLogado(HttpSession session){
		return session !=null && session.getAttribute("usuario_logado") !=null;
	}
	
	
	public boolean isUsuarioAutenticado(HttpServletRequest request){
		 String uri = request.getRequestURI();
		 return uri.equals(request.getContextPath()+"/login") || uri.equals(request.getContextPath()+"/autentica");
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	

}









