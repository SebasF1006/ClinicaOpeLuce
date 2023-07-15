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
        <link href="css/estilo_singin.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="img/icono.ico"/>
    </head>
    <body>
        <div class="d-flex">
            <div class="w-100">
                <div id="content">
                    <section class="py-3">
                        <div class="container">
                            <div class="pricing-header p-3 pb-md-2 mx-auto text-center ">
                                <img src="img/user3.png" alt="" width="90" height="80">
                                <h1 class="fs-6 fw-normal font-weight-bold">Registrarse</h1>
                            </div> 
                            <form action="Paciente" method="post">
                                <input type="hidden" name="accion" value="INS2"/>
                                <div class="row">
                                    <div class="col-lg-1 mt-4"></div>
                                    <div class="col-lg-5 mt-4">
                                        Tipo de Documento:
                                        <select class="form-control" name="tipo_doc_paciente">
                                            <option class="form-control"  value="DNI"
                                                    <c:if test="${paciente.tipo_doc_paciente.equals('DNI')}">
                                                        selected
                                                        </c:if>>DNI</option>
                                            <option class="form-control" value="CARNET DE EXTRANJERIA" 
                                                    <c:if test="${paciente.tipo_doc_paciente.equals('CARNET DE EXTRANJERIA')}">
                                                        selected
                                                        </c:if>>CARNET DE EXTRANJERIA</option>
                                            <option class="form-control" value="C.C." 
                                                    <c:if test="${paciente.tipo_doc_paciente.equals('C.C.')}">
                                                        selected
                                                        </c:if>>C.C.</option>
                                        </select>
                                        <br/>
                                        Nro de Documento: 
                                        <input class="form-control" type="text" name="nro_doc_paciente" value="${paciente.nro_doc_paciente}"/>
                                        <br/>
                                        Nombres:
                                        <input class="form-control" type="text" name="nombres_paciente" value="${paciente.nombres_paciente}"/>
                                        <br/>
                                        Apellidos:
                                        <input class="form-control" type="text" name="apellidos_paciente" value="${paciente.apellidos_paciente}"/>
                                        <br/>
                                        Telefono:
                                        <input class="form-control" type="text" name="telefono_paciente" value="${paciente.telefono_paciente}"/>
                                        <br/>
                                    </div>
                                    <div class="col-lg-5 mt-4">
                                        Dirección:
                                        <input class="form-control" type="text" name="direccion_paciente" value="${paciente.direccion_paciente}"/>
                                        <br/>
                                        Fecha de nacimiento:
                                        <input class="form-control" type="date" name="fecha_nacimiento_paciente" value="${paciente.fecha_nacimiento_paciente}"/>
                                        <br/>
                                        Correo electronico:
                                        <input class="form-control" type="text" name="correo_paciente" value="${paciente.correo_paciente}"/>
                                        <br/>
                                        Contraseña:
                                        <input class="form-control" type="text" name="password_paciente" value="${paciente.password_paciente}"/>
                                        <br>
                                     
                                    </div>  
                                    <div class="col-lg-1 mt-4"></div>
                                    <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
                                                <button class="btn btn-primary" type="submit" onclick="Login()">Registrarme</button>&nbsp;&nbsp;&nbsp;
                                                &nbsp;&nbsp;&nbsp;<a class="btn btn-primary" type="button" onclick="VolverLogin()">Volver al Login</a>
                                            </div> 
                                    <script>
                                        function Login() {
                                            //alert("fs");
                                            window.location = "login.jsp";
                                        }
                                        
                                        function VolverLogin() {
                                            window.location = "login.jsp";
                                        }
                                    </script>
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
