<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="javax.servlet.ServletResponse"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="_css/site.css">
<title></title>
</head>
<body>
 

<%
Connection connection = null;
try {

	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estoque", "root", "sysdba");
	
	File reporFile = new File(application.getRealPath("cliente.jasper"));
	
	Map<String, Object> parameter = new HashMap<String, Object>();
	
	byte[] bytes = JasperRunManager.runReportToPdf(reporFile.getPath(), parameter,connection);
	
	response.setContentType("application/pdf");
	response.setContentLength(bytes.length);
	
	ServletOutputStream outputStream = response.getOutputStream();
	
	outputStream.write(bytes,0,bytes.length);
	
	outputStream.flush();
	outputStream.close();
	
	
	
} catch (Exception e) {
	out.print(e.getMessage());
}finally{
	connection.close();
}


%>
 
</body>
</html>