<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="com.guadarrama.app.routes.models.*" %>

<%
    //recuperamos la lista de choferes que seteamos en eñ request desde el Servlet
    List<Driver> drivers = (List<Driver>) request.getAttribute("drivers");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"
        integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-inverse">
       <div class="container-fluid">
           <!-- Brand and toggle get grouped for better mobile display -->
           <div class="navbar-header" id="div1">
               <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                   data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                   <span class="sr-only">Toggle navigation</span>
                   <span class="icon-bar"></span>
                   <span class="icon-bar"></span>
                   <span class="icon-bar"></span>
               </button>
               <a class="navbar-brand" href="#" id="enlace1">Rutas App</a>
           </div>

           <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
               <ul class="nav navbar-nav">
                   <li class="dropdown">
                       <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">Choferes<span
                               class="caret"></span></a>
                       <ul class="dropdown-menu">
                           <li><a href="<%=request.getContextPath()%>/choferes/listar">Lista Choferes</a></li>
                           <li><a href="<%=request.getContextPath()%>/choferes/alta">Alta Chofer</a></li>
                       </ul>
                   </li>

                   <li class="dropdown">
                       <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">Camiones<span
                               class="caret"></span></a>
                       <ul class="dropdown-menu">
                           <li><a href="<%=request.getContextPath()%>/trucks/toList">Lista Camiones</a></li>
                           <li><a href="<%=request.getContextPath()%>/trucks/add">Alta Camion</a></li>
                       </ul>
                   </li>

                   <li class="dropdown">
                       <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">Rutas<span
                               class="caret"></span></a>
                       <ul class="dropdown-menu">
                           <li><a href="<%=request.getContextPath()%>/rutas/alta">Alta Ruta</a></li>
                       </ul>
                   </li>
               </ul>
           </div><!-- /.navbar-collapse -->
       </div><!-- /.container-fluid -->
    </nav>
    <div class="container">
        <div class="wrow">
            <div class="col-6">
                <h2>Listado de choferes</h2>
            </div>
            <div class="class-6">
                <a href="<%=request.getContextPath()%>/drivers/add" class="btn btn-success">Alta choferes</a>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-12">
                <div class="table-responsive">
                    <table class="table table-bordered table-stripped" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>ID.CHOFER</th>
                                <th>NOMBRE</th>
                                <th>AP.PATERNO</th>
                                <th>AP.MATERNO</th>
                                <th>LICENCIA</th>
                                <th>Teléfono</th>
                                <th></th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(Driver d : drivers){ %>
                                <tr>
                                    <td><%=d.getId_driver()%></td>
                                    <td><%=d.getName()%></td>
                                    <td><%=d.getSurname()%></td>
                                    <td><%=d.getLastName()%></td>
                                    <td><%=d.getLicence()%></td>
                                    <td><%=d.getPhone()%></td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/drivers/details?id=<%=d.getId_driver()%>" class="btn btn-success">Detalle</a>
                                    </td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/drivers/edit?id=<%=d.getId_driver()%>" class="btn btn-primary">Editar</a>
                                    </td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/drivers/delete?id=<%=d.getId_driver()%>" class="btn btn-danger">Eliminar</a>
                                    </td>
                                </tr>
                                <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>