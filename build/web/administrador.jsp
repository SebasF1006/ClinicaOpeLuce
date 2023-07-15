<%@page import="util.DeString"%>
<%
    Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
    response.sendRedirect("Administrador?accion=SEL&idadmin="+idadmin);%>