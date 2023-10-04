
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio</title>
    <link rel="icon" type="image/x-icon" href="img/mainLogo.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="Styles/indexStyles.css">
</head>
<body>

<nav class="navbar bg-body-tertiary" id="navarid">
    <div class="container-fluid">
        <a class="navbar-brand" href="#" id="navarText">
            <img src="img/mainLogo.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
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
                    <h1 class="card-title">Menú de Asignaturas</h1>
                    <ul class="list-group">
                        <li class="list-group-item">
                            <a href="sites/subjectAdd.jsp">Crear Asignaturas</a>
                        </li>
                        <li class="list-group-item">
                            <a href="sites/subjectList.jsp">Ver Asignaturas</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
