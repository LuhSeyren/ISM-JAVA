<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
<%@ page import = "ISM.Apolice" %>
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

    <title>IMS - Alterar Status</title>
  </head>
  <body>
   
   <% Apolice apolice = (Apolice) request.getAttribute("apolice"); %>
 
  <form action="ControleAlterarStatusServlet" method="post">
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="/ISM/home.jsp">Insurance Manager Software</a>
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="ControleVenderApoliceServlet?op=venda">Venda</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="ControleAlterarStatusServlet?op=status">Alteração</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ControleGerarRelatorioServlet?op=relatorio">Relatório</a>
          </li>
        </ul>
      </div>
    </nav>

     <main role="main" class="container">
      <div class="jumbotron">
        <h1>Informações da Apólice</h1>
       

        <div class="col-md-8 order-md-1">
          <form class="needs-validation" novalidate>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName">Número da Apólice</label>
                <h3 for="SeguroNumero"> <%= apolice.getNumero() %> </h3>
              </div>
              <div class="col-md-6 mb-3">
                <label for="lastName">Cliente</label>
                <% if (apolice.getCliente() != null) { %>
               <h3> <%=apolice.getCliente().getNome() %></h3>
               <% } else { %>
               <h3>-</h3>
               <% } %>
              </div>
            </div>

            <div class="mb-3">
              <label for="username">Vigência</label>
              <h3> <%=apolice.getVigencia() %></h3> 
            </div>

            <div class="row"">

              <div class="col-md-6 mb-3">
                <label for="Status">Status Atual</label>
                <h3 > <%=apolice.getStatus()%> </h3>
              </div>

              <div class="col-md-6 mb-3">
              <p>Novo Status</p>
             <select name="status" id="StatusSelect" class="form-control">
                <option selected value="Ativo">Ativo</option>
                <option value="Inativo">Inativo</option>
                <option value="Vencido">Vencido</option>
                <option value="Cancelado">Cancelado</option>
              </select>
              </div>

            </div>
            <input class="btn btn-primary" type="submit" value="Salvar Status &raquo">
          </form>
      </div>
    </main>
    </form>




    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>

</html>