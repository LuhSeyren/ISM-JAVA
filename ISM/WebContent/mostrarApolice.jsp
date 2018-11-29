<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
<%@ page import = "ISM.Apolice" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Apolice</title>
</head>
<body>
	
	<% Apolice apolice = (Apolice) request.getAttribute("apolice"); %>
	
	<h4> Tipo Apolice: compreensivo</h4>
	<h4> Tipo Franquia: <%= apolice.getTipo() %></h4>
	<h4> Modalidade de Valor: <%= apolice.getModalidadeDeValor() %></h4>
	<h4> Valor dos Acessorios: <%= apolice.getValorAcessorios() %></h4>
	<h4> Vigencia: <%= apolice.getVigencia() %></h4>
	<h4> Franquia Casco: <%= apolice.getFranquiaCasco() %></h4>
	<h4> Franquia Acessorios: <%= apolice.getFranquiaAcessorios() %></h4>
	<h4> Premio Líquido: <%= apolice.getPremioLiquido() %></h4>
	<h4> Premio Total: <%= apolice.getPremio() %></h4>
	<h4>Valor Veiculo: <%= apolice.getValorVeiculo() %></h4>
	
	<form action="ApoliceServlet">
		<input type="hidden" name="op"   value="confirma" />
	<input type="submit" value="confirma">
	</form>
	<form action="ApoliceServlet">
		<input type="hidden" name="op"   value="rejeita" />
	<input type="submit" value="Não confirma">
	</form>
	
	
</body>
</html>