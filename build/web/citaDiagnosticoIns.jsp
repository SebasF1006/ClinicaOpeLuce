<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OPELUCE</title>

        <link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">

        <!-- BOOTSTRAP -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
        <!-- ESTILO PROPIO -->
        <link href="css/estilo_intranet.css" rel="stylesheet" type="text/css"/>
        <script src="js/doctorCita.js" type="text/javascript"></script>
        <link rel="icon" href="img/icono.ico"/>
        <!-- <link href="css/estilo_message.css" rel="stylesheet" type="text/css"/>-->
    </head>
    <body>
        <div class="d-flex">
            <div id="sidebar-container" class="bg-primary">
                <div class="logo">
                    <h4 class="text-light font-weight-bold">Opeluce</h4>
                </div>
                <div class="menu">
                    <!--a href="#" class="d-block text-light p-3"><i class="icon ion-md-apps mr-2 lead"></i>Tablero</a-->
                    <a type="button" class="d-block text-light p-3" onclick="CitasDoctor();"><i class="icon ion-md-calendar mr-2 lead"></i>Mis Citas</a>
                    <a type="button" class="d-block text-light p-3" onclick="ModificarDatosDoctor();"><i class="icon ion-md-save mr-2 lead"></i>Modificar Datos</a>
                    <!--a href="index.html" class="d-block text-light p-3"><i class="icon ion-md-settings mr-2 lead"></i>Cerrar Sesión</a-->
                </div>
            </div>
            <div class="w-100">
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <div class="container">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" 
                                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <!--form class="form-inline my-2 my-lg-0">
                          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form-->
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ml-auto">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" 
                                       data-toggle="dropdown" aria-expanded="false">
                                        ${doctor.getNombres_doctor()} ${doctor.getApellidos_doctor()}
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="index.html">Cerrar Sesión</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <div id="content">
                    <section class="py-3">
                        <div class="container">
                            <h1 class="mt-1"> Ingrese el Diagnostico de la Cita </h1>
                            <form action="Cita" method="post"> 
                                <input type="hidden" name="accion" value="DINS"/>
                                <input type="hidden" name="idcita" value="${idcita}"/>
                                <input type="hidden" name="id_doctor" value="${doctor.iddoctor}"/>
                                <input type="hidden" name="id" value="${doctor.iddoctor}"/>
                                <input class="align-items-center" type="hidden" name="id_pr"
                                                           value="${doctor.iddoctor}"/>
                                <div class="row">
                                    <div class="col-lg-6 mt-4">
                                        Diagnostico :
                                    </div><br>
                                    <input class="form-control" type="text" size="80" name="diagnostico_cita"/>
                                    <br/><br/>
                                    <div class="col-lg-12">
                                        <button class="btn btn-primary" type="submit">Guardar</button>
                                    </div>
                                </div> 
                            </form>
                            <c:if test="${message != null}"> 
                                <div class="p-3 pb-md-4 mx-auto text-center alert alert-primary w-50" role="alert">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                        <h3>Aviso</h3>
                                        ${message}
                                </div>
                                     </c:if>
                        </div>                   
                    </section>
                </div> 
            </div>
        </div>
    </body>
</html>
