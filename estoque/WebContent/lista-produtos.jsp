<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/file.css">

<title></title>
</head>
<body>
<jsp:include page="home.jsp"/>
<div class="div-lista">
	<section>
		<div class="tbl-header">
			<table>
				<thead>
					<tr>
						<th style="width: 10%;">Codigo</th>
						<th style="width: 30%;">Nome</th>
						<th>Quantidade</th>
						<th>Preco</th>
						<th>Total</th>
						<th>Data / Cadastro</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="tbl-content">

			<table>
				<tbody>
					<c:forEach var="produto" items="${produtos}">
						<tr>
							<td style="width: 10%;">${produto.id}</td>
							<td style="width: 30%;">${produto.descricao}</td>
							<td>${produto.quantidade}</td>
							<td><fmt:formatNumber value="${produto.valor}"
									minFractionDigits="2" type="currency" /></td>
							<td><fmt:formatNumber value="${produto.total}"
									minFractionDigits="2" type="currency" /></td>
							<td><fmt:formatDate value="${produto.data}" /></td>
						</tr>
					</c:forEach>

				</tbody>


			</table>
		</div>
	</section>
</div>	
	<script type="text/javascript">
		$(window).on(
				"load resize ",
				function() {
					var scrollWidth = $('.tbl-content').width()
							- $('.tbl-content table').width();
					$('.tbl-header').css({
						'padding-right' : scrollWidth
					});
				}).resize();
	</script>

 
 <!--  
<div class="made-with-love">
  <a target="_blank" href="#">Desenvolvido por Tiago</a>
</div>
 -->
</body>
</html>