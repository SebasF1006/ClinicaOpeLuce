<%@page import="util.DeString"%>
<%
    Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
    String nro_doc_pac = request.getParameter("nro_doc_pac");
    response.sendRedirect("Cita?accion=SEL5&idadmin="+idadmin+"&nro_doc_pac="+nro_doc_pac);%>