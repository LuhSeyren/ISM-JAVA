<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
<%@ page import = "ISM.Apolice" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MostrarStatusApolice</title>
</head>
<body>
<h1>Apolice Encontrada</h1>
<% Apolice apolice = (Apolice) request.getAttribute("apolice"); %>
Numero: <%=apolice.getNumero() %><br>
Status: <%= apolice.getStatus() %>

<form action="ControleAlterarStatusServlet" method="post">
  <div>
    <label>novo status: </label>
   <input name="status" type="text">
  </div>
  <div>
    <input class="btn btn-info" type="submit" value="Enviar &raquo">
  </div>
  </form>


</body>
</html>