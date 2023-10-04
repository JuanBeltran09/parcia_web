
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Actividades</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../Styles/activityAdd.css">
</head>

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
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h1 class="card-title">Agregar Actividad</h1>
                    <form>
                        <div class="form-group">
                            <label for="nombre">Nombre de la Actividad:</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" required>
                        </div>
                        <div class="form-group">
                            <label for="tipo">Tipo de Actividad:</label>
                            <input type="text" class="form-control" id="tipo" name="tipo" required>
                        </div>
                        <div class="form-group">
                            <label for="fechaInicio">Fecha de Inicio:</label>
                            <input type="date" class="form-control" id="fechaInicio" name="fechaInicio" required>
                        </div>
                        <div class="form-group">
                            <label for="ponderado">Ponderado:</label>
                            <input type="number" class="form-control" id="ponderado" name="ponderado" required>
                        </div>
                        <button type="submit" class="btn btn-primary" id="AddActivityBtn">Agregar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
