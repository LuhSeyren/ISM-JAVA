<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
<%@ page import = "ISM.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cliente</title>
</head>
<h1>Cliente</h1>


<body>

	<% Cliente cliente = (Cliente) request.getAttribute("cliente"); %>
	<h4> CPF: <%= cliente.getCpf() %></h4>
	<h4> NOME: <%= cliente.getNome() %></h4>
	<h4> SEXO: <%= cliente.getSexo() %></h4>
	<h4> PERFIL DE USO: <%= cliente.getPerfilDeUso() %></h4>
</body>
</html>