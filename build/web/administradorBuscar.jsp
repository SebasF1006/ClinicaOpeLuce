<%@page import="util.DeString"%>
<%
    Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
    String nro_doc = request.getParameter("nro_doc");
    response.sendRedirect("Administrador?accion=SEL2&idadmin="+idadmin+"&nro_doc="+nro_doc);%>