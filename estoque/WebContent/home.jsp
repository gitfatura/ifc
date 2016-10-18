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

<ul>
  <li><a class="active" href="home.jsp">Home</a></li>
 
  <li class="dropdown">
    <a href="#" class="dropbtn">Clientes</a>
    <div class="dropdown-content">
      <a href="./novo-cliente">Novo Cliente</a>
      <a href="./all-clientes">Lista de Clientes</a>
      <a href="./relatorio-clientes">Relatorio de Clientes</a>

    </div>
  </li>
  <li class="dropdown">
    <a href="#" class="dropbtn">Produtos</a>
    <div class="dropdown-content">
      <a href="./novo-produto">Novo Produto</a>
      <a href="./get-produtos">Todos Produtos</a>
      <a href="./manutencao-produtos">Manutenção de Produtos</a>
	  <a href="./entradas-produtos">Entradas de Produtos</a>
	  <a href="./saida-de-produtos">Saida de Produtos</a>
	  <a href="./produtos-deletado">Produtos Excluidos</a>
	  <a href="./produto-relatorio">Relatorio de Produtos</a>
	  <a href="./relatorio-entrada-produto">Relatorio de entrada de Produtos</a>
	  <a href="./produto-deletado-relatorio">Relatorio de Produtos Excluido</a>
	  <a href="grafico.jsp">Grafico Produto</a>
	  <li style="float:right"><a class="active" href="./logof">Sair</a></li>
    </div>
  </li>
    
   
</ul>
</body>
</html>