<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>solicitarPeriodo</title>
</head>
<body>
<h1>Coloque o periodo desejado</h1>

<form action="ControleGerarRelatorioServlet" method="post">
  <div>
    <label for="say">data inicial</label>
   <input name="data_inicial" type="date">
  </div>
  <div>
    <label for="say">data final</label>
   <input name="data_final" type="date">
  </div>
  <div>
    <input class="btn btn-info" type="submit" value="Enviar &raquo">
  </div>
</form>

</body>
</html>