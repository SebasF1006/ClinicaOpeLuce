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
<%@include file="citaPacienteSel.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRODUCTOS</title>
    </head>
    <body>

        <%            
            String arch_jasper = request.getParameter("jasper");

            File reportfile = new File(application.getRealPath(arch_jasper));

            Map<String, Object> parameter = new HashMap<String, Object>();

            if (arch_jasper.equals("Reportes/Reporte_Citas_Mes_1.jasper")) {
                //Integer mes = Integer.parseInt(request.getParameter("mes"));
                //Integer año = Integer.parseInt(request.getParameter("año"));
                String valor = request.getParameter("PDF_Param");
                
                Integer año = Integer.parseInt(valor.substring(0, 4));
                Integer mes = Integer.parseInt(valor.substring(5, 7));
                
                parameter.put("id_cita", new Integer(mes));
                parameter.put("fecha2", new Integer(año));
            } else {
                Integer valor = Integer.parseInt(request.getParameter("PDF_Param"));
                parameter.put("id_cita", new Integer(valor));
            }

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
