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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="js/cita.js" type="text/javascript"></script>
        <script src="js/pacienteCita.js" type="text/javascript"></script>
        <link rel="icon" href="img/icono.ico"/>
    </head>
    <body>
        <div class="d-flex">
            <div id="sidebar-container" class="bg-primary">
                <div class="logo">
                    <h4 class="text-light font-weight-bold">Opeluce</h4>
                </div>
                <div class="menu">
                    <!--a href="LoginAdministrador.jsp" class="d-block text-light p-3"><i class="icon ion-md-apps mr-2 lead"></i>Tablero</a-->
                    <a type="button" class="d-block text-light p-3" onclick="CitasPaciente();"><i class="icon ion-md-calendar mr-2 lead"></i>Mis Citas</a> 
                    <a type="button" class="d-block text-light p-3" onclick="AgendarCita();"><i class="icon ion-md-mail mr-2 lead"></i>Agendar Cita</a>
                    <a type="button" class="d-block text-light p-3" onclick="ModificarDatosPaciente();"><i class="icon ion-md-save mr-2 lead" ></i>Modificar Datos</a>
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
                                        ${NombrePaciente} ${ApellidosPaciente}
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
                            <div class="pricing-header p-3 pb-md-4 mx-auto text-center ">
                                <h1 class="fs-6 fw-normal font-weight-bold">AGENDAR CITA</h1>
                            </div> 
                            <div class="row cita">
                                <div class="col-lg-6">
                                    <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
                                        <h3 class="fs-6 fw-normal">Ingrese tipo de cita:</h3>
                                    </div>
                                    <form action="Cita" method="post" >
                                        <input type="hidden" name="accion" value="INS"/>
                                        <input type="hidden" name="idpacientes" value="${idpacientes}"/>
                                        <input class="align-items-center" type="hidden" name="id_pr"
                                               value="${paciente.getIdpacientes()}"/>

                                        <select class="form-control" name="tipo_cita">
                                            <option class="form-control"  value="CONSULTA GENERAL">CONSULTA GENERAL</option>
                                            <option class="form-control"  value="CONSULTA PEDRIATICA">CONSULTA PEDRIATICA</option>
                                            <option class="form-control"  value="SUB ESPECIALIDADES">SUB ESPECIALIDADES</option>
                                            <option class="form-control"  value="EXAMEN DE LA VISTA">EXAMEN DE LA VISTA</option>
                                        </select>
                                        <br/>
                                        <input type="hidden" name="id" value="${id}" style="width: 400px"/>
                                        <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
                                            <button class="btn btn-primary" type="submit">Agendar Cita</button>
                                        </div> 
                                    </form> 
                                </div>
                                <div class="col-lg-1">  
                                </div>          
                                <div class="col-lg-4">
                                    <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
                                        <h3 class="fs-6 fw-normal">Tarifas</h3>
                                    </div>
                                    <div class="row row-cols-1 row-cols-md-2 mb-3 text-center">
                                        <div class="col">
                                            <div class="card mb-4 rounded-3 shadow-sm">
                                                <div class="card-header py-3">
                                                    <h4 class="my-0 fw-normal">General</h4>
                                                </div>
                                                <div class="card-body">
                                                    <h1 class="card-title pricing-card-title">S/.90</h1>
                                                    <!--ul class="list-unstyled mt-3 mb-4">
                                                      <li>10 users included</li>
                                                    </ul-->
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="card mb-4 rounded-3 shadow-sm">
                                                <div class="card-header py-3">
                                                    <h4 class="my-0 fw-normal">Pediatrica</h4>
                                                </div>
                                                <div class="card-body">
                                                    <h1 class="card-title pricing-card-title">S/.120</h1>
                                                    <!--ul class="list-unstyled mt-3 mb-4">
                                                      <li>20 users included</li>
                                                    </ul-->
                                                </div>
                                            </div>
                                        </div>
                                    </div> 
                                    
                                    <div class="row row-cols-1 row-cols-md-2 mb-3 text-center">
                                        <div class="col">
                                            <div class="card mb-4 rounded-3 shadow-sm">
                                                <div class="card-header py-3">
                                                    <h4 class="my-0 fw-normal">Subespe- cialidades</h4>
                                                </div>
                                                <div class="card-body">
                                                    <h1 class="card-title pricing-card-title">S/.160</h1>
                                                    <!--ul class="list-unstyled mt-3 mb-4">
                                                      <li>10 users included</li>
                                                    </ul-->
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="card mb-4 rounded-3 shadow-sm">
                                                <div class="card-header py-3">
                                                    <h4 class="my-0 fw-normal">Ex. de Vista</h4>
                                                </div>
                                                <div class="card-body">
                                                    <h1 class="card-title pricing-card-title">S/.140</h1>
                                                    <!--ul class="list-unstyled mt-3 mb-4">
                                                      <li>20 users included</li>
                                                    </ul-->
                                                </div>
                                            </div>
                                        </div>
                                    </div> 

                                    <div class="col-lg-1">  
                                    </div>
                                </div>        
                                <c:if test="${message != null}"> 
                                    <div class="p-3 pb-md-4 mx-auto text-center alert alert-primary w-50" role="alert">
                                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                                        <h3>Se requiere</h3>
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
