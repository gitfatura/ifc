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
	<jsp:include page="home.jsp" />
	<form action="update-cliente" method="post">
		<div class="div-externa-update-cliente">
			<p class="p-update-cliente">Atualização de Clientes</p>
			<div class="div-interna-update-cliente">


				<table>
					<tr>
						<td>Codigo</td>
						<td><input type="text" class="input-update-cliente" name="id" readonly="readonly" value="${cliente.id}" style="width: 300px"></td>
					</tr>
					<tr>
						<td>Nome</td>
						<td><input type="text" class="input-update-cliente"	name="nome" autocomplete="on" value="${cliente.nome}" required="required" style="width: 300px"></td>
					</tr>

					<tr>
						<td>Cpf</td>
						<td><input type="text" class="input-update-cliente" name="cpf" autocomplete="on" value="${cliente.cpf}" required="required" style="width: 134px"> 
						RG <input type="text" class="input-update-cliente" name="rg" value="${cliente.rg}" style="width: 140px"></td>
					</tr>

					<tr>
						<td>Telefone</td>
						<td><input type="text" class="input-update-cliente" name="telefone" autocomplete="on" value="${cliente.telefone}" required="required" style="width: 130px"> 
						Sexo<select id="sexo" name="sexo" class="input-update-cliente" style="width: 135px">
								<option value="${cliente.sexo}">${cliente.sexo}</option>
								<option value="Masculino">Masculino</option>
								<option value="Feminino">Feminino</option>
								<option value="Indeciso">Indeciso</option>
						</select></td>
					</tr>

					<tr>
						<td>Email</td>
						<td><input type="text" class="input-update-cliente" name="email" autocomplete="on" value="${cliente.email}" required="required" style="width: 300px"></td>
					</tr>

					<tr>
						<td>Endereço</td>
						<td><input type="text" class="input-update-cliente" name="endereco" autocomplete="on" value="${cliente.endereco}" required="required" style="width: 300px"></td>
					</tr>
					<tr>
						<td>Data</td>
						<td><input type="date" class="input-update-cliente" name="data" value="${cliente.data}" required="required" style="width: 300px"></td>
					</tr>

				</table>

			</div>
			<input type="submit" class="btn-updatecliente" value="Gravar">

		</div>
	</form>
</body>
</html>