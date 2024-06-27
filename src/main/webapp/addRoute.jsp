<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="com.guadarrama.app.routes.models.*" %>

<%
    //recuperamos la lista de choferes que seteamos en eñ request desde el Servlet
    List<Driver> drivers = (List<Driver>) request.getAttribute("drivers");
    List<Truck> trucks = (List<Truck>) request.getAttribute("trucks");
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
    <div class="container body-content">

        <script src="//maps.googleapis.com/maps/api/js?key=AIzaSyCWeeateTaYGqsHhNcmoDfT7Us-vLDZVPs&amp;sensor=false&amp;language=en"></script>

        <div class="row">
            <div class="col-md-12">
                <h2>Iniciar Ruta</h2>
            </div>
            <div style="display: block;"><input type="text" name="txtEsOD" id="txtEsOD"></div>
        </div>
        <div class="row">
            izquierda
            <div class="col-md-6">
                <div class="form-group">
                    <label for="">Chofer</label>
                    <select name="driver" id="driver" class="form-control">
                        <option value="">Seleccionar</option>
                        <% for(Driver driver : drivers){ %>
                            <option value="<%=driver.getId_driver()%>"><%=driver.getName()%></option>
                        <% } %>
                    </select>
                </div>

                <div class="form-group">
                   <div class="row">
                        <div class="com-md-9">
                            <label for="">Origen</label>
                            <input type="text" name="origin" id="origin" class="form-control">
                            <input type="hidden" name="idOrigin" id="idOrigin" class="form-control">
                        </div>
                        <div class="com-md-3">
                            <button class="btn btn-primary btn-xs" style="margin-top: 30px;" onclick="getDirection(1)">Obtener Datos</button>
                        </div>
                   </div>
                </div>

                <div class="form-group">
                    <label for="">Fecha Salida</label>
                    <input type="text" name="departureDate" id="departureDate" class="form-control">
                </div>

                <div class="form-group">
                    <label for="">Distancia</label>
                    <input type="text" name="distance" id="distance" class="form-control">
                </div>
            </div>

            derecha
            <div class="col-md-6">
                <div class="form-group">
                    <label for="">Camión</label>
                    <select name="truck" id="truck" class="form-control">
                        <option value="">Seleccionar</option>
                        <% for(Truck truck : trucks){ %>
                            <option value="<%=truck.getId_truck()%>"><%=truck.getLicencePlate()%></option>
                        <% } %>
                    </select>
                </div>

                <div class="form-group">
                   <div class="row">
                        <div class="com-md-9">
                            <label for="">Destino</label>
                            <input type="text" name="destinity" id="destinity" class="form-control">
                            <input type="hidden" name="idDestinity" id="idDestinity" class="form-control">
                        </div>
                        <div class="com-md-3">
                            <button class="btn btn-primary btn-xs" style="margin-top: 30px;" onclick="getDirection(2)">Obtener Datos</button>
                        </div>
                   </div>
                </div>

                <div class="form-group">
                    <label for="">Fecha Llegada</label>
                    <input type="text" name="estimatedArrivalDate" id="estimatedArrivalDate" class="form-control">
                </div>

                <div class="form-group">
                    <label for="">Capacidad de Camión</label>
                    <input type="text" name="capacity" id="capacity" class="form-control">
                </div>
                <div class="form-group">
                    <button>Asignar Ruta</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="row">
                        <div class="col-md-12">
                            <h4>Guardar Direccion</h4>
                        </div>
                    </div>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="">Calle</label>
                                <input type="text" name="Street" id="Street" class="form-control">
                            </div>

                            <div class="form-group">
                                <label for="">Numero</label>
                                <input type="text" name="Number" id="Number" class="form-control">
                            </div>

                            <div class="form-group">
                                <label for="">Colonia</label>
                                <input type="text" name="Neighbor" id="Neighbor" class="form-control">
                            </div>

                            <div class="form-group">
                                <label for="">Ciudad</label>
                                <input type="text" name="City" id="City" class="form-control">
                            </div>

                            <div class="form-group">
                                <label for="">Estado</label>
                                <input type="text" name="State" id="State" class="form-control">
                            </div>

                            <div class="form-group">
                                <label for="">CP</label>
                                <input type="text" name="PC" id="PC" class="form-control">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="row">
                        <div class="col-md-10">
                            <div class="col-md-10 col-md-offset-1">
                                <div class="col-md-4">
                                    <butto class="btn btn-success" onclick="btnSaveAd()">Guardar</butto>
                                </div>
                                <div class="col-md-4 col-md-offset-2">
                                    <button class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        function cleanModal(){
            $('#Street').val('');
            $('#Number').val('');
            $('#Neighbor').val('');
            $('#City').val('');
            $('#State').val('');
            $('#PC').val('');
        }

        function getDirection(fount){
            cleanModal();
            $('#myModal').modal('show');
            var direction = "";
            if (fount == 1){
                direction = $('#origin').val();
            }else{
                direction = $('#destination').val();
            }
            $("#txtEsOD").val(fount);
            if(direction != ""){
                var geocoder = new google.maps.Geocoder();
                geocoder.geocode({'address' : direction}, function(results, status){
                    console.log(results);
                    console.log(status);
                    if(status == google.maps.GeocoderStatus.OK){
                        var numResults = results[0].address_components.length;
                        for(var  index = 0; index < numResults; index++){
                            var numResultsTypes = results[0].address_components[index].types.length;
                            for(var property = 0; property < numResultsTypes; property++){
                                var Type = results[0].address_components[index].types[property];
                                var description = results[0].address_components[index].long_name;
                                switch(Type){
                                    case "route":
                                        $('#Street').val(description);
                                        break;
                                    case "street_number":
                                        $('#Number').val(description);
                                        break;
                                    case "sublocality_level_1":
                                        $('#Neighbor').val(description);
                                        break;
                                    case "locality":
                                        $('#City').val(description);
                                        break;
                                    case "administrative_area_level_1":
                                        $('#State').val(description);
                                        break;
                                    case "postal_code":
                                        $('#PC').val(description);
                                        break;
                                }
                            }
                        }
                    if(results[0].address_components.length > 0){
                        if(fount == 1){
                            $('#origin').val(results[0].formatted_address);
                        }else{
                            $('#destination').val(results[0].formatted_address);
                        }
                    }
                }else{
                    alert("Error al obtener la direccion");

                }
            });
            }else{
                    alert("No se encontró la dirección, proporcione una correcta");
                    $('#myModal').modal('hide');
                }
        }
    </script>
</body>
</html>