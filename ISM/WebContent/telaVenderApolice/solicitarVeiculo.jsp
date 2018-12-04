<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <link href="stylesheet.css" rel="stylesheet">

    <title>IMS - Gerar Ap�lice</title>
  </head>
  <body>
	<form action="VeiculoServlet" method="post">

 <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#">Insurance Manager Software</a>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Venda </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Altera��o <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Relat�rio</a>
          </li>
        </ul>
      </div>
    </nav>


     <main role="main" class="container">
      <div class="jumbotron">
        <h1>Gerar Ap�lice de Seguro</h1>
        <div class="input-group mb-3">
          <select class="form-control" name="modelo">
            <option value="" selected disabled> Modelo do Ve�culo </option>
            <option value="WolksVagen GOL"> WolksVagen GOL </option>
            <option value="WolksVagen FOX"> WolksVagen FOX </option>
            <option value="WolksVagen GOLF"> WolksVagen GOLF </option>
            <option value="WolksVagen UP"> WolksVagen UP </option>
            <!-- Mais um milh�o de op��es-->
          </select>
        </div>
        
        <div class="input-group mb-3">
          <input type="text" class="form-control" name="ano" placeholder="Ano do Ve�culo">
          <div class="input-group-append">
          </div>
          <input type="text" class="form-control" name="cor" placeholder="Cor do Ve�culo">
          <div class="input-group-append">
          </div>
        </div>
        
        <div class="input-group mb-3">
          <input type="text" class="form-control" name="placa" placeholder="Placa do Ve�culo (Somente Letras e N�meros)">
          <div class="input-group-append">
          </div>
          <input type="text" class="form-control" name="renavam" placeholder="Renavam (Somente N�meros)">
          <div class="input-group-append">
          </div>
        </div>
        <input class="btn btn-info" type="submit" value="Adicionar Ve�culo &raquo"></input>
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