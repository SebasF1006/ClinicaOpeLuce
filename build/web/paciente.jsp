<%@page import="util.DeString"%>
<%
    Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
    response.sendRedirect("Paciente?accion=SEL&idadmin="+idadmin);%>