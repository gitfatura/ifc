<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" type="text/css" href="css/site.css">
<script type="text/javascript" src="js/controle.js"></script>
<title></title>
</head>
<body>
	 <jsp:include page="home.jsp"/>
	 
	 <form action="update-produto" name="dados" method="post">
	 
			
			<div class="div-externa-update-produto">
	<p class="p-update-produto">Atualização do Produto</p>
  <div class="div-interna-update-produto">

     
	 <table>
	 <tr>
			<td>ID</td>
			<td><input type="text" class="input-update-produto" readonly="readonly" name="id" value="${produto.id}" style="width:325px"></td>
		</tr>	 
		 
 
		<tr>
			<td>Descrição</td>
			<td><input type="text" class="input-update-produto" name="descricao" value="${produto.descricao}" required="required" style="width:325px"></td>		
		</tr>
		 

		<tr>
			<td>Quantidade</td>
			<td>
			<input type="number" class="input-update-produto" name="quantidade" value="${produto.quantidade}" required="required" style="width:147px">
				Preço<input type="text" class="input-update-produto" name="valor" value="${produto.valor}" required="required" style="width:140px">
			</td>
		</tr>
		
		<tr>
			<td>Data</td>
			<td>
			<input type="date" class="input-update-produto" name="data"  value="${produto.data}" required="required" style="width:147px">			
			</td>
		</tr>
 		 
	 </table>
     
  </div>
    <input type="submit" class="btn-update-produto" value="Gravar">
 
</div>
	</form>
</body>
</html>