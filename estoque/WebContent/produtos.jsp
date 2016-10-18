<%@page import="net.sf.jasperreports.engine.util.JRLoader"%>
<%@ page contentType="application/pdf"%>

<%@ page trimDirectiveWhitespaces="true"%>
<%@page import="net.sf.jasperreports.engine.xml.JRXmlLoader"%>
<%@page import="net.sf.jasperreports.engine.design.JasperDesign"%>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.DriverManager"%>

<%
	Connection connection = null;
	try {

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estoque", "root", "sysdba");
		
		String jrxmlFile = getServletContext().getRealPath("/jrxml/produto.jrxml");
		
		InputStream input = new FileInputStream(new File(jrxmlFile));
		
		JasperReport jasperReport = JasperCompileManager.compileReport(input);
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,connection);
		
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
		
	} catch (Exception e) {
		System.out.println("Erro ao conectar com a mysql :" + e.getMessage());
	}finally{
		connection.close();
	}
%>














