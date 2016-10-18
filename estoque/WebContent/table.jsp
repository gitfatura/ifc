<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/file.css">

<title></title>
</head>
<body>
<jsp:include page="home.jsp"/>
	<section> <!--for demo wrap-->
	<h1>Fixed Table header</h1>  
<div  class="tbl-header">
	<table cellpadding="0" cellspacing="0" border="0">
  	<thead>
   			<tr>
      			<th>Codigo</th>
				<th>Nome</th>
				<th>Quantidade</th>
				<th>Valor Custo</th>
				<th>Valor Total</th>
				<th>Data Cadastro</th>
    	   </tr>
  </thead>
</table>
</div>
<div  class="tbl-content">

<table cellpadding="0" cellspacing="0" border="0">
  <tbody>
     <c:forEach var="produto" items="${produtos}">
			<tr>
				<td>${produto.id}</td>
				<td>${produto.descricao}</td>
				<td>${produto.quantidade}</td>
				<td><fmt:formatNumber value="${produto.valor}" minFractionDigits="2" type="currency"/></td>
				<td><fmt:formatNumber value="${produto.total}" minFractionDigits="2" type="currency"/></td>
				<td><fmt:formatDate value="${produto.data}"/></td>
			</tr>
			</c:forEach> 
      
  </tbody>


</table>
</div>
</section>

<script type="text/javascript">

$(window).on("load resize ", function() {
	  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
	  $('.tbl-header').css({'padding-right':scrollWidth});
	}).resize();
</script>
	
<!-- follow me template 
<div class="made-with-love">
  Made with 
  <i>♥</i> by 
  <a target="_blank" href="http://codepen.io/nikhil8krishnan">Nikhil Krishnan</a>
</div>
 -->
</body>
</html>