
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ver Actividades</title>
    <link rel="icon" type="image/x-icon" href="../img/mainLogo.png">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../Styles/activityList.css">
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
                    <h1 class="card-title">Lista de Actividades</h1>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Actividades</th>
                        </tr>
                        </thead>
                        <tbody id="tBody">

                        </tbody>
                    </table>
                    <button class="btn btn-primary float-right" data-toggle="modal" data-target="#agregarActividadModal" id="AddActivityBtn">Agregar Actividad</button>
                    <%
                        String idParameter = request.getParameter("id");

                        if (idParameter != null && !idParameter.isEmpty()) {
                    %>
                    <script>
                        document.getElementById('AddActivityBtn').addEventListener('click',()=>{

                            window.location.href = "../sites/activityAdd.jsp?id="+'<%=idParameter%>'
                        });
                    </script>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../script/scriptActivityList.js"></script>
</body>
</html>
