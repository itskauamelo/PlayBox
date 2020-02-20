<%-- 
    Document   : email
    Created on : 19/02/2020, 21:06:22
    Author     : Kaua.Morateli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.mail.*" %>
<%@page import="javax.naming.*" %>
<%@page import="java.io.*" %>
<%@page import="javax.mail.internet.*" %>
<%@page import="javax.activation.*" %>
<%@page import="com.sun.mail.smtp.*" %>
<%@page import="java.util.*" %>


<%
    String user, host, pass;
    host="smtp.gmail.com";
    pass="160695kaua";
    user="playbxgamer@gmail.com";
    String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    String to = "playbxgamer@gmail.com";

%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
