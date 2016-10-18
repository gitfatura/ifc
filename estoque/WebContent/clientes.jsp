<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/file2.css">
<title>Lista de Clientes</title>
</head>
<body>
<jsp:include page="home.jsp"/> 
<div class="div-lista">
<section>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Entre com a decrição...">

<div  class="tbl-header">


	<table>
	<thead>
			<tr>
				<th>Nome</th>
				<th>Cpf</th>
				<th>Sexo</th>
				<th>Telefone</th>
				<th>Email</th>
				<th>Endereço</th>
				<th style="width: 78px;">Data</th>
				<th style="width: 50px;">Opção</th>
			</tr>
		</thead>
</table>
</div>
<div  class="tbl-content">

<table id="myTable">

		<tbody>
			 <c:forEach var="cliente" items="${clientes}">
			<tr>
				<td><a href="<c:url value="/id-update-cliente?id=${cliente.id}"/>">${cliente.nome}</a></td>
				<td>${cliente.cpf}</td>
				<td style="width: 78px;">${cliente.sexo}</td>
				<td>${cliente.telefone}</td>
				<td>${cliente.email}</td>
				<td>${cliente.endereco}</td>
				<td style="width: 78px;"><fmt:formatDate value="${cliente.data}"/></td>
				<td style="width: 50px;"><a href="<c:url value="/remove-cliente?id=${cliente.id}"/>" onclick="return confirm('Deseja realmente excluir o Cliente:  ${cliente.nome}')">Excluir</a></td>
			 
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</section>
</div>
<script type="text/javascript">

$(window).on("load resize ", function() {
	  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
	  $('.tbl-header').css({'padding-right':scrollWidth});
	}).resize();
</script>
<script>
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
</script>
</body>
</html> 
  