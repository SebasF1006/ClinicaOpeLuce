<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OPELUCE</title>

        <link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <!-- BOOTSTRAP -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
        <!-- ESTILO PROPIO -->
        <link href="css/estilo_intranet.css" rel="stylesheet" type="text/css"/>
        <script src="js/administrador.js" type="text/javascript"></script>
        <script src="js/INS_UPD.js" type="text/javascript"></script>
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
                            <h1 class="font-weight-bold mb-0">CATALOGO DE ADMINISTRADORES</h1>
                            <a class="btn btn-primary mt-4 mb-4" href="Administrador?accion=GOINS&idadmin=${admin.getIdadministrador()}"> Agregar Nuevo</a>
                            <!--button type="button" class="btn btn-primary" data-toggle="modal" data-target="#AgregarPaciente" data-whatever="@mdo">Agregar Nuevo</button-->

                            <!--div class="row py-3">
                            <form class="form-inline col-lg-6">
                              <input class="form-control mr-sm-2" type="search" placeholder="Nombre" aria-label="Search">
                              <button class="btn btn-warning my-2 my-sm-0" type="submit">Buscar</button>
                            </form>
                            <form class="form-inline col-lg-6">
                              <input class="form-control mr-sm-2" type="search" placeholder="N° doc" aria-label="Search">
                              <button class="btn btn-warning my-2 my-sm-0" type="submit">Buscar</button>
                            </form>
                            </div-->
                            <h4 class="font-weight-bold mb-0">Busqueda de Administrador</h4>
                            <form action="Administrador" method="post" >
                                <input type="hidden" name="accion" value="SEL4"/>
                                <input type="hidden" name="idadmin" value="${admin.getIdadministrador()}"/>
                                <label class="font-weight-bold mb-0" size="10">Digite el Nro de Doc. :</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="text" name ="nro_doc" size="10"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input class="btn btn-primary mt-4 mb-4" type="submit" value="BUSCAR" />
                            </form>
                            <form action="Administrador" method="post" >
                                <input type="hidden" name="accion" value="SEL3"/>
                                <input type="hidden" name="idadmin" value="${admin.getIdadministrador()}"/>
                                <input class="btn btn-primary mt-4 mb-4" type="submit" value="RESTAURAR TABLA" />
                            </form>
                            <c:if test="${message != null}"> 
                                <div class="p-3 pb-md-4 mx-auto text-center alert alert-primary w-50" role="alert">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <h3>Aviso</h3>
                                    ${message}
                                </div>
                            </c:if>
                            <br class="py-3">
                            <table class="table table-bordered">
                                <thead>
                                    <tr class="color-title">
                                        <th class="text-center">ID</th>
                                        <th class="text-center">TIPO DOC.</th>
                                        <th class="text-center">NRO DOC.</th>
                                        <th class="text-center">NOMBRES</th>
                                        <th class="text-center">APELLIDOS</th>
                                        <th class="text-center">TELEFONO</th>
                                        <th class="text-center">DIRECCION</th>
                                        <th class="text-center">EDAD</th>
                                        <th class="text-center">FECHA DE NACIMIENTO</th>
                                        <th>
                                            <a type="button" class="text-light text-center" onclick="administradorUpd2();">
                                                Editar
                                            </a>
                                            <!--button onclick="administradorUpd();" type="button" class="btn btn-primary" data-toggle="modal" data-target="#EditarAdministrador" data-whatever="@mdo">Editar</button-->
                                        </th>
                                        <th>
                                            <a type="button" class="text-light text-center" onclick="administradorDel2();">
                                                Eliminar                         
                                            </a>
                                        </th>
                                <input class="align-items-center" type="hidden" name="idadmin"
                                       value="${admin.getIdadministrador()}"/>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="f" items="${list}">
                                        <tr>
                                            <td class="text-center">${f.idadministrador}</td>
                                            <td class="text-center">${f.tipo_doc_administrador}</td>
                                            <td class="text-center">${f.nro_doc_administrador}</td>
                                            <td class="text-center">${f.nombres_administrador}</td>
                                            <td class="text-center">${f.apellidos_administrador}</td>
                                            <td class="text-center">${f.telefono_administrador}</td>
                                            <td class="text-center">${f.direccion_administrador}</td>
                                            <td class="text-center">${f.edad_administrador}</td>
                                            <td class="text-center">${f.fecha_nacimiento_administrador}</td>
                                            <th class="text-center">
                                                <input class="align-items-center" type="radio" name="id_upd"
                                                       value="${f.idadministrador}"/>
                                            </th>
                                            <th>
                                    <center><input class="align-self-center" type="checkbox" name="id_del" 
                                                   value="${f.idadministrador}"/></center>
                                    </th>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </section>
                </div>
            </div>
        </div>
    </body>
</html>
