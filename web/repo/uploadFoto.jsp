<%-- 
    Document   : uploadFoto
    Created on : 25/02/2020, 23:36:15
    Author     : Kaua.Morateli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
	String root=getServletContext().getRealPath("imagensPB");
	MultipartRequest mr = new MultipartRequest(request, root);
        %>
    </body>
</html>
