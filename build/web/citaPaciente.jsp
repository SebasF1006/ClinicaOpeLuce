<%@page import="util.DeString"%>

<%           
    Integer id = DeString.aInteger(request.getParameter("id"));
    response.sendRedirect("Cita?accion=SEL&id="+id);%>