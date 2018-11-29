<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>solicitarValorVeiculo</title>
</head>
<body>

<form action="ApoliceServlet">
		Valor Veiculo: <input type="text" name="valor"><br>
		<input type="hidden" name="op"   value="veiculo" />
	<input type="submit" value="proximo">
	</form>

</body>
</html>