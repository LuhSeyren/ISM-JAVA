<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
<%@ page import = "ISM.Apolice" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.text.DateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="starter-template.css" rel="stylesheet">

    <title>IMS - Gerar Ap�lice</title>
  </head>
  <body>
<% Apolice apolice = (Apolice) request.getAttribute("apolice"); %>

 <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="/ISM/home.jsp">Insurance Manager Software</a>
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="ControleVenderApoliceServlet?op=venda">Venda</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ControleAlterarStatusServlet?op=status">Altera��o</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ControleGerarRelatorioServlet?op=relatorio">Relat�rio</a>
          </li>
        </ul>
      </div>
    </nav>

     <main role="main" class="container">
      <div class="jumbotron">
        <h1>Informa��es da Ap�lice</h1>


        <div class="col-md-8 order-md-1">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="tipoapolice">Tipo de Ap�lice</label>
                <h3 for="TipoApolice"> Compreensivo </h3>
              </div>
              <div class="col-md-6 mb-3">
                <label for="FranquiaTipo">Tipo da Franquia</label>
                <% if (apolice.getTipo()==1) {%>
                <h3>Obrigat�ria</h3>
                <% } else if (apolice.getTipo()==2) {%>
                <h3>Majorada</h3>
                <% } else { %>
                <h3>Reduzida</h3>
                <% } %>
              </div>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="ModalidadeValor">Modalidade de Valor</label>
                <% if (apolice.getModalidadeDeValor()==0) {%>
                <h3>Determinado</h3>
                <% } else { %>
                <h3>Referenciado</h3>
                <% } %>
              </div>
              <div class="col-md-6 mb-3">
                <label for="VigenciaApolice">Vig�ncia</label>
                <% DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                   String data_vigencia = df.format(apolice.getVigencia());
                 %>
                <h3> <%= data_vigencia %> </h3>
              </div>
            </div>


            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="ValorAcessorio">Valor dos Acess�rios</label>
                <% String valorAcessorios = Integer.toString(apolice.getValorAcessorios());
                   String valorAcessoriosFormat = "";
                   while (valorAcessorios.length() > 3) {
                   		int length = valorAcessorios.length(); 
                   		String valor = valorAcessorios.substring(length - 3, length);
                   		valorAcessoriosFormat = valorAcessoriosFormat + "." + valor;
                   		valorAcessorios = valorAcessorios.substring (0, length - 3);
                   } %>
                <h3> <%= "R$ " + valorAcessorios + valorAcessoriosFormat + ",00" %> </h3>
              </div>
              <div class="col-md-6 mb-3">
                <label for="ValorVeiculo">Valor do Ve�culo</label>
                <% String valorVeiculo = Integer.toString(apolice.getValorVeiculo());
                   String valorVeiculoFormat = "";
                   while (valorVeiculo.length() > 3) {
                   		int length = valorVeiculo.length(); 
                   		String valor = valorVeiculo.substring(length - 3, length);
                   		valorVeiculoFormat = valorVeiculoFormat + "." + valor;
                   		valorVeiculo = valorVeiculo.substring (0, length - 3);
                   } %>
                <h3> <%= "R$ " + valorVeiculo + valorVeiculoFormat + ",00" %> </h3>
              </div>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="FranquiaCasco">Franquia de Casco</label>
                 <% String franquiaCasco = Integer.toString(apolice.getFranquiaCasco());
                   String franquiaCascoFormat = "";
                   while (franquiaCasco.length() > 3) {
                   		int length = franquiaCasco.length(); 
                   		String valor = franquiaCasco.substring(length - 3, length);
                   		franquiaCascoFormat = franquiaCascoFormat + "." + valor;
                   		franquiaCasco = franquiaCasco.substring (0, length - 3);
                   } %>
                <h3> <%= "R$ " + franquiaCasco + franquiaCascoFormat + ",00" %> </h3>
              </div>
              <div class="col-md-6 mb-3">
                <label for="FranquiaAcessorio">Franquia de Acess�rios</label>
                <% String franquiaAcessorios = Integer.toString(apolice.getFranquiaAcessorios());
                   String franquiaAcessoriosFormat = "";
                   while (franquiaAcessorios.length() > 3) {
                   		int length = franquiaAcessorios.length(); 
                   		String valor = franquiaAcessorios.substring(length - 3, length);
                   		franquiaAcessoriosFormat = franquiaAcessoriosFormat + "." + valor;
                   		franquiaAcessorios = franquiaAcessorios.substring (0, length - 3);
                   } %>
                <h3> <%= "R$ " + franquiaAcessorios + franquiaAcessoriosFormat + ",00" %> </h3>
              </div>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="PremioTotal">Pr�mio L�quido</label>
                <% String premioLiquido = Integer.toString(apolice.getPremioLiquido());
                   String premioLiquidoFormat = "";
                   while (premioLiquido.length() > 3) {
                   		int length = premioLiquido.length(); 
                   		String valor = premioLiquido.substring(length - 3, length);
                   		premioLiquidoFormat = premioLiquidoFormat + "." + valor;
                   		premioLiquido = premioLiquido.substring (0, length - 3);
                   } %>
                <h3> <%= "R$ " + premioLiquido + premioLiquidoFormat + ",00" %> </h3>
              </div>
              <div class="col-md-6 mb-3">
                <label for="PremioTotal">Pr�mio Total</label>
                <% String premio = Integer.toString(apolice.getPremio());
                   String premioFormat = "";
                   while (premio.length() > 3) {
                   		int length = premio.length(); 
                   		String valor = premio.substring(length - 3, length);
                   		premioFormat = premioFormat + "." + valor;
                   		premio = premio.substring (0, length - 3);
                   } %>
                <h3> <%= "R$ " + premio + premioFormat + ",00" %> </h3>
              </div>
            </div>
            
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="PremioTotal">Corretor Respons�vel</label>
                <h3>Lucas Eug�nio</h3>
              </div>
              <div class="col-md-6 mb-3">
              <p>Informa��es Da Corretora</p>
              <% if (apolice.getInformacoesDaCorretora() != null) { %>
              	<h3> <%= apolice.getInformacoesDaCorretora() %></h3>
              <% } else { %>
              	<h3> - </h3>
              <% } %>
              </div>
            </div>

			<div class="row">
            	<div class="col-md-6 mb-3">
                <label for="Confirma��o">Deseja Confirmar a Opera��o?</label>
              </div>
            </div>
			<div class="row">
              <div class="col-md-6 mb-3">
               <form action="ApoliceServlet">
               <input type="hidden" name="op"   value="confirma" />
               <input class="btn-block btn-primary" type="submit" value="Confirmar"></input>
               </form>
              </div>
              <div class="col-md-6 mb-3">
               <form action="ApoliceServlet">
			   <input type="hidden" name="op"   value="rejeita" />
		       <input class="btn-block btn-secondary" type="submit" value="Recusar"></input>
			   </form>
              </div>
            </div>
            
      </div>
    </main>





    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>

</html>