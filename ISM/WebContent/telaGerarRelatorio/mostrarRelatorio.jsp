<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
<%@ page import = "ISM.Apolice" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Relatorio</title>
</head>

<% ArrayList<Apolice> apoliceList = (ArrayList<Apolice>) request.getAttribute("apoliceList"); %>

<body>
<TABLE>

<% for(Iterator iterator = apoliceList.iterator(); iterator.hasNext();) { %>
 	<% Apolice apolice = (Apolice) iterator.next();%>
    <TR>N�mero Apolice: <%= apolice.getNumero() %></TR>
    <TR>Nome: <%= apolice.getValorVeiculo() %></TR>
    
    <br>
    <% } %>
</TABLE>


</body>
</html>