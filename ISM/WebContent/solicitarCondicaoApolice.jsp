<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ApoliceServlet" method="post">

Tipo de Apolice (int): <input type="text" name="tipoApolice"><br>
Tipo de Franquia (int): <input type="text" name=tipoFranquia><br>
Modalidade de Valor (0 - Determinado; 1 - Referenciado ): <input type="text" name="modalidadeValor"><br>
Valor dos Acessorios (int): <input type="text" name="valorAcessorios"><br>
Vigencia yyyy-MM-dd : <input type="text" name="vigencia"><br>

<input type="submit" value="enviar">
</form>

</body>
</html>