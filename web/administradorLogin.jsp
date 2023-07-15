<%@page import="dao.impl.DaoAdministradorImpl"%>
<%@page import="dao.DaoAdministrador"%>
<%@page import="entidades.Administrador"%>
<%
    String correo = request.getParameter("correo");
    String pass = request.getParameter("pass");
    DaoAdministrador daoAdministrador = new DaoAdministradorImpl();
    Administrador admin = daoAdministrador.administradorGetLogin(correo,pass);
    response.sendRedirect("Administrador?accion=SEL&idadmin="+admin.getIdadministrador());%>