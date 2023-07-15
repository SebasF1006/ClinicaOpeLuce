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
                    <!--a href="LoginAdministrador.jsp" class="d-block text-light p-3"><i class="icon ion-md-apps mr-2 lead"></i>Tablero</a-->
                    <a href="Administrador?accion=SEL&idadmin=${admin.getIdadministrador()}" class="d-block text-light p-3"><i class="icon ion-md-person mr-2 lead"></i>Administradores</a>
                    <a href="Doctor?accion=SEL&idadmin=${admin.getIdadministrador()}" class="d-block text-light p-3"><i class="icon ion-md-heart mr-2 lead"></i>Doctores</a>
                    <a href="Paciente?accion=SEL&idadmin=${admin.getIdadministrador()}"  class="d-block text-light p-3"><i class="icon ion-md-people mr-2 lead"></i>Pacientes</a>
                    <a href="Cita?accion=SEL2&idadmin=${admin.getIdadministrador()}" class="d-block text-light p-3"><i class="icon ion-md-calendar mr-2 lead"></i>Citas</a>
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
                                        ${NombreAdministrador} ${ApellidosAdministrador}
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
                            <h1 class="mt-1"> Actualizar Datos Doctor </h1>
                            <form action="Doctor" method="post"> 
                                <input type="hidden" name="accion" value="UPD"/>
                                <input type="hidden" name="iddoctor" value="${doctor.iddoctor}"/>
                                <input class="align-items-center" type="hidden" name="idadmin"
                                       value="${admin.getIdadministrador()}"/>
                                <div class="row">
                                    <div class="col-lg-6 mt-4">
                                        Tipo de Documento:
                                        <select class="form-control" name="tipo_doc_doctor">
                                            <option class="form-control"  value="DNI"
                                                    <c:if test="${doctor.tipo_doc_doctor.equals('DNI')}">
                                                        selected
                                                        </c:if>>DNI</option>
                                            <option class="form-control" value="CARNET DE EXTRANJERIA" 
                                                    <c:if test="${doctor.tipo_doc_doctor.equals('CARNET DE EXTRANJERIA')}">
                                                        selected
                                                        </c:if>>CARNET DE EXTRANJERIA</option>
                                            <option class="form-control" value="C.C." 
                                                    <c:if test="${doctor.tipo_doc_doctor.equals('C.C.')}">
                                                        selected
                                                        </c:if>>C.C.</option>
                                        </select>
                                        <br/>
                                        Nro de Documento:
                                        <input class="form-control" type="text" name="nro_doc_doctor" value="${doctor.nro_doc_doctor}"/>
                                        <br/>
                                        Nombre:
                                        <input class="form-control" type="text" name="nombres_doctor" value="${doctor.nombres_doctor}"/>
                                        <br/>
                                        Apellido:
                                        <input class="form-control" type="text" name="apellidos_doctor" value="${doctor.apellidos_doctor}"/>
                                        <br/>
                                        Especialidad:
                                        <select class="form-control" name="especialidad_doctor">
                                            <option class="form-control"  value="CONSULTA GENERAL"
                                                    <c:if test="${doctor.especialidad_doctor.equals('CONSULTA GENERAL')}">
                                                        selected
                                                        </c:if>>CONSULTA GENERAL</option>
                                            <option class="form-control" value="CONSULTA PEDRIATICA" 
                                                    <c:if test="${doctor.especialidad_doctor.equals('CONSULTA PEDRIATICA')}">
                                                        selected
                                                        </c:if>>CONSULTA PEDRIATICA</option>
                                            <option class="form-control" value="SUB ESPECIALIDADES" 
                                                    <c:if test="${doctor.especialidad_doctor.equals('SUB ESPECIALIDADES')}">
                                                        selected
                                                        </c:if>>SUB ESPECIALIDADES</option>
                                            <option class="form-control" value="EXAMEN DE LA VISTA" 
                                                    <c:if test="${doctor.especialidad_doctor.equals('EXAMEN DE LA VISTA')}">
                                                        selected
                                                        </c:if>>EXAMEN DE LA VISTA</option>
                                        </select>
                                        <br/>
                                    </div>
                                    <div class="col-lg-6 mt-4">
                                        Telefono:
                                        <input class="form-control" type="text" name="telefono_doctor" value="${doctor.telefono_doctor}"/>
                                        <br/>
                                        Dirección:
                                        <input class="form-control" type="text" name="direccion_doctor" value="${doctor.direccion_doctor}"/>
                                        <br/>
                                        Fecha de nacimiento:
                                        <input class="form-control" type="date" name="fecha_nacimiento_doctor"  value="${doctor.fecha_nacimiento_doctor}"/>
                                        <br/>
                                        Correo electronico:
                                        <input class="form-control" class="form-control" type="text" name="correo_doctor" value="${doctor.correo_doctor}"/>
                                        <br/>
                                        Contraseña:
                                        <input class="form-control" type="text" name="password_doctor" value="${doctor.password_doctor}"/>
                                        <br/>
                                    </div>
                                    <div class="col-lg-12">
                                        <button class="btn btn-primary" type="submit">Actualizar</button>
                                    </div>
                                </div> 
                            </form>
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
