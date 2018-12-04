<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>solicitarNumeroApolice</title>
</head>
<body>
<h1>Insira o numero da Apólice</h1>

<form action="ControleAlterarStatusServlet" method="get">
  <div>
    <label>NumeroApolice</label>
   <input name="numeroApolice" type="text">
   <input name="op" value="numeroApolice" type="hidden">
  </div>
  <div>
    <input class="btn btn-info" type="submit" value="Enviar &raquo">
  </div>
</form>

</body>
</html>