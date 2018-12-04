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

    <title>IMS - Gerar Apólice</title>
  </head>
  <body>

	<form action="ApoliceServlet" method="post">

 <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#">Insurance Manager Software</a>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Venda </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Alteração <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Relatório</a>
          </li>
        </ul>
      </div>
    </nav>


     <main role="main" class="container">
      <div class="jumbotron">
        <h1>Gerar Apólice de Seguro</h1>
        <div class="input-group mb-3">
          <select class="form-control" name="tipoApolice">
            <option value="" selected disabled> Tipo de Apólice </option>
            <option value="Compreensivo"> Compreensivo </option>
          </select>
          <select class="form-control" name="tipoFranquia">
            <option value="" selected disabled> Tipo de Franquia </option>
            <option value="Obrigatória"> Obrigatória </option>
            <option value="Majorada"> Majorada </option>
            <option value="Reduzida"> Reduzida </option>
          </select>
        </div>
        <div class="input-group mb-3">
          <select class="form-control" name="modalidadeValor">
            <option value="" selected disabled> Modalidade de Valor </option>
            <option value="Determinado"> Determinado </option>
            <option value="Referênciado"> Referênciado </option>
          </select>
          <input type="text" class="form-control" name="valorAcessorios" placeholder="Valor dos Acessórios (Somente Números Inteiros)">
          <div class="input-group-append">
          </div>
        </div>
        <div class="input-group mb-3">
          <select class="form-control" name="vigencia">
            <option value="" selected disabled> Vigência da Apólice </option>
            <option value="1 Ano"> 1 Ano </option>
            <option value="2 Anos"> 2 Anos </option>
          </select>
        </div>
        <input class="btn btn-lg btn-info" type="submit" value="Enviar &raquo"></input>
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