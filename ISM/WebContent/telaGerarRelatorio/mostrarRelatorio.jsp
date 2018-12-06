<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
<%@ page import = "ISM.Apolice" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="starter-template.css" rel="stylesheet">

    <title>IMS - Gerar Relatório</title>
  </head>
  <body>
   

   <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="/ISM/home.jsp">Insurance Manager Software</a>
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="ControleVenderApoliceServlet?op=venda">Venda</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ControleAlterarStatusServlet?op=status">Alteração</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="ControleGerarRelatorioServlet?op=relatorio">Relatório</a>
          </li>
        </ul>
      </div>
    </nav>

	<% ArrayList<Apolice> apoliceList = (ArrayList<Apolice>) request.getAttribute("apoliceList"); %>

     <main role="main" class="container">
      <div class="jumbotron">
        <section class="jumbotron text-center">
          <h1>Apólices Encontradas</h1>
        <div class="table-responsive">
            <table class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>Número</th>
                  <th>Nome</th>
                  <th>Status</th>
                  <th>Vigência</th>
                  <th>Tipo Franquia</th>
                </tr>
              </thead>
              <tbody>
                <% for(Iterator iterator = apoliceList.iterator(); iterator.hasNext();) { %>
			 	<% Apolice apolice = (Apolice) iterator.next();%>
			 	<tr>
			    	<td><%= apolice.getNumero() %></td>
			    	<% if (apolice.getCliente() == null) { %>
			    	<td>-</td>
			    	<% } else { %>
			    	<td> <%= apolice.getCliente().getNome() %> </td>
			    	<% } %>
			    	<td><%= apolice.getStatus() %></td>
			    	<td><%= apolice.getVigencia() %></td>
			    	<% if (apolice.getTipo() == 1) { %>
			    	<td> Obrigatória </td>
			    	<% } else if (apolice.getTipo() == 2) { %>
			    	<td> Majorada </td>
			    	<% } else { %>
			    	<td>Reduzida</td>
			    	<% } %>
			    </tr>
   			  <% } %>
              </tbody>
            </table>
          </section>
      </div>
    </main>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
