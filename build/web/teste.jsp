<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.util.List"%>
<%@page import="Model.Game"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja!</title>
    </head>
    <body>
        
                <%
            List<Game> games = (List<Game>) request.getAttribute("games");
        %>
        
        <h1>Novo</h1>
        <form>
            Nome: <input type="text"><br/>
            Game: <select>
                                
                            <%
                                for (Game game : games) {                                           
                            %>
                            
                            
                            <option value="<%=game.getId()%>">  <%= game.getNome() %> </option>
                            
                            <% } %> 

                       </select>
            
                       Preço: <input type="text"><br/>
                       <input type="submit">         
            
        </form>
    </body>
        
</html>
