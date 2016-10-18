<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/site.css">

<title></title>
</head>
<body>
<jsp:include page="home.jsp"/>
<form action="saida-produto"  method="post">
<div class="div-externa-saida-produto">
	<p class="p-saida-produto">Baixar Produto do Estoque</p>
  <div class="div-interna-saida-produto">
	
			<label>Descrição</label><br/>
	    	<input type="text" readonly="readonly" class="input-saida-produto" required="required" style="width: 230px" value="${produto.descricao}"><br/><br/> 
			<label>Quantidade</label><br/>
			<input type="text"   name="quantidade" class="input-saida-produto" autocomplete="on" required="required"><br/><br/> 
			<label>Codigo</label><br/>
			<input type="text" readonly="readonly" class="input-saida-produto" required="required" name="id" value="${produto.id}"><br/><br/> 
		
	
	</div>
		<input type="submit" class="btn-saida-produto" value="Baixar">
			
<input type="button" value="Voltar" class="btn-saida-produto" onclick="location.href='<c:url value="./manutencao-produtos"/>'"><br/> 


<label style="color: red; margin-left: 70px;">${quanti}</label>		
	</div>
	</form>
	<%session.removeAttribute("quanti");%>
</body>
</html>