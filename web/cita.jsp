<%@page import="util.DeString"%>
<%
    Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
    response.sendRedirect("Cita?accion=SEL2&idadmin="+idadmin);%>