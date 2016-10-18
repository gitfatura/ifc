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
	<form action="entrada-produto" name="dados" method="post">

		<div class="div-externa-entrada-produto">
			<p class="p-entrada-cliente">Entrada de Produto</p>
  		  <div class="div-interna-entrada-produto">

			<label>Descrição</label><br/>
	    	<input type="text" required="required" class="input-entrada-produto" readonly="readonly" style="width: 300px" value="${produto.descricao}"><br/><br/> 
			
			<label>Quantidade</label><br/>
			<input type="text" name="quantidade" class="input-entrada-produto" required="required"><br/><br/> 
		
			<label>Codigo</label><br/>	
			<input type="text" readonly="readonly" class="input-entrada-produto" required="required" style="width: 150px"  name="id" value="${produto.id}"><br/><br/> 
	    
		</div>
		
			<input type="submit" class="btn-entrada-produto"  value="Atualizar">
			<input type="button" class="btn-entrada-produto" value="Voltar" onclick="location.href='<c:url value="./manutencao-produtos"/>'"> 
	  </div>	  
</form>
<!-- 	
<form action="remove-produto">
	 <input type="hidden" name="id" value="${produto.id}">
	<input type="button" class="btn-entrada-produto" value="Remover" onclick="return confirm('Atenção deseja realmente Excluir produto: ${produto.descricao}') ">
</form>
-->
</body>
</html>












