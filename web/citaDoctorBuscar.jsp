<%@page import="util.DeString"%>
<%
    Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
    String nro_doc_doc = request.getParameter("nro_doc_doc");
    response.sendRedirect("Cita?accion=SEL7&idadmin="+idadmin+"&nro_doc_doc="+nro_doc_doc);%>