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

<form action="salva-cliente"  method="post">

<div class="div-externa-novo-cliente">
	<p class="p-novo-cliente">Cadastro de Clientes</p>
	
  <div class="div-interna-novo-cliente">
	
     
	 <table>	 
		<tr>
			<td>Nome</td>
			<td><input type="text" class="input-novo-cliente" name="nome" autocomplete="on" required="required" style="width:300px"></td>
		</tr>	
 
		<tr>
			<td>Cpf</td>
			<td>
			<input type="text" class="input-novo-cliente"name="cpf" autocomplete="on" required="required" style="width:134px"> 
			RG  <input type="text" class="input-novo-cliente" name="rg" required="required" style="width:140px">		
			</td>		
		</tr>

		<tr>
			<td>Telefone</td>
			<td>
			<input type="text" class="input-novo-cliente" name="telefone" autocomplete="on" required="required" style="width:130px">
		
			Sexo<select id="sexo" name="sexo" class="input-novo-cliente" required="required" style="width:136px">
					<option value="Masculino">Masculino</option>
					<option value="Feminino">Feminino</option>
					<option value="Indeciso">Indeciso</option>
				</select>		
			</td>
		</tr>

		<tr>
		<td>Email</td>
		<td><input type="email"  class="input-novo-cliente" name="email" autocomplete="on" required="required" style="width:300px"></td>
	 </tr>	
     
		<tr>
			<td>Endereço</td>
			<td><input type="text" class="input-novo-cliente" name="endereco" autocomplete="on" required="required" style="width:300px"></td>
		</tr>
		<tr>
			<td>Data</td>
			<td><input type="date" class="input-novo-cliente"  name="data"  autocomplete="on" required="required" style="width:300px"></td>
		</tr>	
			
	 </table>
     
  </div>
    <input type="submit" class="btn-novo-cliente" value="Gravar">
    <input type="reset" class="btn-novo-cliente" value="Cancelar">

</div>
  </form>
</body>
</html>