<%-- 
    Document   : index
    Created on : 23/01/2016, 03:23:38 PM
    Author     : Ingeniero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
        Connection con = null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        //con = (Connection)DriverManager.getConnection("jdbc:mysql://10.100.18.129:3306/bdclinicadopeluce?useSSL=false","root","R5Jctvb4Ue");
        con = (Connection)DriverManager.getConnection("jdbc:mysql://node142097-env-1974150.jelastic.saveincloud.net:12979/bdclinicadopeluce?useSSL=false","root","R5Jctvb4Ue");
        out.print("Conexion en Linea");
        }catch(Exception ex){
        out.print("Error: "+ex.getMessage());
        }
        %>
        
    </body>
</html>
