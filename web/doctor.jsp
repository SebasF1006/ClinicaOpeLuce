<%@page import="util.DeString"%>
<%
    Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
    response.sendRedirect("Doctor?accion=SEL&idadmin="+idadmin);%>