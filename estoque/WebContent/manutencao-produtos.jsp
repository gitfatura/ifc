<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/file3.css">
<title>Lista de Produto</title>
</head>
<body>
<jsp:include page="home.jsp"/>


<div class="div-lista">
<section>

<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Entre com a decrição..">

<div  class="tbl-header">


	<table>
	<thead>
			<tr>
				<th style="width: 50px;">ID</th>
				<th style="width: 180px;">Nome</th>
				<th>Quantidade</th>
				<th>Preço</th>
				<th>Total</th>
				<th>Data</th>				
				<th>Entrada</th>
				<th>Saida</th>
				<th>Excluir</th>
			</tr>
		</thead>
</table>
</div>
<div  class="tbl-content">

<table id="myTable">

		<tbody>
			<c:forEach var="produto" items="${produtos}">
			<tr class="header">
				<td style="width: 50px;">${produto.id}</td>
				<td style="width: 180px"><a href="<c:url value="/getId-produto?id=${produto.id}"/>">${produto.descricao}</a></td>
				<td>${produto.quantidade}</td>
				<td><fmt:formatNumber value="${produto.valor}" minFractionDigits="2" type="currency"/></td>
				<td><fmt:formatNumber value="${produto.total}" minFractionDigits="2" type="currency"/></td>
				<td><fmt:formatDate value="${produto.data}"/></td>
				<td><a href="<c:url value="/entradaById-produto?id=${produto.id}"/>">+ Quantidade</a></td>
				
				<td><a href="<c:url value="/saidaById-produto?id=${produto.id}"/>">- Saida</a></td>
				
				<td><a href="<c:url value="/remove-produto?id=${produto.id}"/>" onclick="return confirm('Deseja realmente excluir o Cliente:  ${produto.descricao}')">Excluir</a></td>
			
			</tr>
			</c:forEach>
	
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