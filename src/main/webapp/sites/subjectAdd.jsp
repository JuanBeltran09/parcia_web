<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Agenda</title>
  <link rel="icon" type="image/x-icon" href="../img/mainLogo.png">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">


  <link rel="stylesheet" type="text/css" href="../Styles/subjectAdd.css">
</head>

<body>


<header>

  <nav class="navbar bg-body-tertiary" id="navarid">
    <div class="container-fluid">
      <a class="navbar-brand" href="../index.jsp" id="navarText">
        <img src="../img/mainLogo.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
        Notas
      </a>
    </div>
  </nav>
</header>

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="card">
        <div class="card-body">
          <h2 class="card-title">Formulario de Asignatura</h2>
          <form>
            <div class="mb-3">
              <label for="idSubject" class="form-label">Id</label>
              <input type="text" class="form-control" id="idSubject" name="idSubject" placeholder="Ingresa el código de la asignatura" required>
            </div>
            <div class="mb-3">
              <label for="name" class="form-label">Nombre de la Asignatura</label>
              <input type="text" class="form-control" id="name" name="name" placeholder="Ingresa el nombre de la asignatura" required>
            </div>
            <button type="submit" class="btn btn-primary" id="btnSend">Enviar</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

<div id="container">


</div>

<script src="../script/scripts.js"></script>
</body>
</html>