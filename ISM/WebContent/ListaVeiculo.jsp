<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "ISM.Veiculo" %>
<% ArrayList<Veiculo> listaVeiculo = (ArrayList<Veiculo>) request.getAttribute("lista"); %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Veículos Cadastrados</title>
</head>
<body>

	<h2>Lista de Veículos Cadastrados</h2>

	<table>
  <tr>
    <th>Renavam</th>
    <th>Placa</th>
    <th>Modelo</th>
    <th>Ano</th>
    <th>Cor</th>
  </tr>
  <%
  	int i = 0;
  	while (i < listaVeiculo.size()) {
  		i = i + 1;
  		out.println("Olá");
  	}
  %>
  <tr>
    <td><%=listaVeiculo.get(0).getRenavam()%></td>
    <td><%=listaVeiculo.get(0).getPlaca()%></td>
    <td><%=listaVeiculo.get(0).getModelo()%></td>
    <td><%=listaVeiculo.get(0).getAno()%></td>
    <td><%=listaVeiculo.get(0).getCor()%></td>
  </tr>
 </table>
	

</body>
</html>