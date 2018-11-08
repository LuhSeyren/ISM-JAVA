<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "ISM.Veiculo" %>
<% Veiculo veiculo = (Veiculo) request.getAttribute("veiculo"); %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Veículos Cadastrados</title>
</head>
<body>

	<h2>Detalhes do Veículo</h2>

	<h4> RENAVAM: <%= veiculo.getRenavam() %></h4>
	<h4> PLACA: <%= veiculo.getPlaca() %></h4>
	<h4> MODELO: <%= veiculo.getModelo() %></h4>
	<h4> ANO: <%= veiculo.getAno() %></h4>
	<h4> COR: <%= veiculo.getCor() %></h4>

</body>
</html>