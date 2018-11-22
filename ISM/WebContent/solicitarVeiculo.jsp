<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>solicitar Veiculo</title>
</head>
<body>

<form action="VeiculoServlet" method="post">

Renavam: <input type="text" name="renavam"><br>
Placa: <input type="text" name="placa"><br>
Modelo: <input type="text" name="modelo"><br>
Ano: <input type="text" name="ano"><br>
Cor: <input type="text" name="cor"><br>

<input type="submit" value="adicionar veiculo">
</form>

</body>
</html>