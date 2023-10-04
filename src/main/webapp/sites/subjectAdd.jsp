<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Agenda</title>
  <link rel="icon" type="image/x-icon" href="../img/mainLogo.png">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

  <link rel="stylesheet" type="text/css" href="../Styles/indexStyles.css">
</head>

<body>
<div class="container mt-5">
  <h2>Formulario de Asignatura</h2>
  <form>
    <div class="mb-3">
      <label for="name" class="form-label">Id</label>
      <input type="text" class="form-control" id="idSubject" name="idSubject  " placeholder="Ingresa el codigo de la asignatura" required>
    </div>
    <div class="mb-3">
      <label for="name" class="form-label">Nombre de la Asignatura</label>
      <input type="text" class="form-control" id="name" name="name" placeholder="Ingresa el nombre de la asignatura" required>
    </div>
    <button type="submit" class="btn btn-primary" id="btnSend">Enviar</button>
  </form>

</div>

<div id="container">

  <a href="../index.jsp">Menu</a>
</div>

<script src="../scripts.js"></script>
</body>
</html>