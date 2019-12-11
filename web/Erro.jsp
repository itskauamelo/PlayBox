<%-- 
    Document   : erro
    Created on : 20/10/2019, 20:07:53
    Author     : alunocmc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro | PlayBox</title>
    </head>
    <body>
        <h1>Não foi possivel completar a ação, tente novamente!</h1>
        <%= ((Exception)request.getAttribute("erro")).getMessage() %>
    </body>
</html>
