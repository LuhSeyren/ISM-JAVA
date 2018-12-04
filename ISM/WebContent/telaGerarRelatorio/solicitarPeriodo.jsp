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
    <a class="navbar-brand" href="/../../home.html">Insurance Manager Software</a>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="../../1-venderApolice/1A-cliente/cliente.html">Venda </a>
          </li>
          <li class="nav-iteme">
            <a class="nav-link" href="../../2-alterarApolice/1-status/site.html">Alteração <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="../../3-gerarRelatorio/1-periodo/site.html">Relatório</a>
          </li>
        </ul>
      </div>
    </nav>

	 <form action="ControleGerarRelatorioServlet" method="post">
     <main role="main" class="container">
      <div class="jumbotron">
        <h1>Busca de Apolice por Período</h1>

        <div class="input-group mb-3">
          <div class="col">
            <h4>Data Inicial</h4>
            <input name="data_inicial" class="form-control" type="date" value="Data de Início" id="example-date-input">
          </div>
          <div class="col">
            <h4>Data Final</h4>
            <input name="data_final" class="form-control" type="date" value="Data de Fim" id="example-date-input">
          </div>

        </div>
        <input class="btn btn-info" type="submit" value="Buscar Apólices &raquo">
      </div>
    </main>
    </form>





    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
