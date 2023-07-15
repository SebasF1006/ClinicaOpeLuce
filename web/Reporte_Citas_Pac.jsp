<%-- 
    Document   : pdf
    Created on : 23/01/2016, 03:31:22 PM
    Author     : Ingeniero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>

<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>

<%@page import="javax.servlet.ServletResponse"%>
<%@include file="Conexion.jsp" %>
<%@include file="pacienteSel.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REPORTE DE CITAS POR PACIENTE</title>
    </head>
    <body>

        <%            
            Integer valor = Integer.parseInt(request.getParameter("PDF_Param2"));
            String arch_jasper = "Reporte_Citas_Por_Paciente.jasper";
            File reportfile = new File(application.getRealPath(arch_jasper));

            Map<String, Object> parameter = new HashMap<String, Object>();
            
            parameter.put("id_cita",new Integer(valor));
            
            byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parameter, con);

            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputstream = response.getOutputStream();
            outputstream.write(bytes, 0, bytes.length);

            outputstream.flush();
            outputstream.close();
        %>

    </body>
</html>
