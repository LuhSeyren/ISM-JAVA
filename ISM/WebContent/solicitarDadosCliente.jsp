<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitar Cliente</title>
</head>
<body>


<form action="ClienteServlet" method="post">

CPF: <input type="text" name="cpf"><br>
Nome: <input type="text" name="nome"><br>
Sexo: <input type="text" name="sexo"><br>
Perfil de Uso: <input type="text" name="perfilDeUso"><br>

<input type="submit" value="adicionar Cliente">
</form>


</body>
</html>