<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<html>
  <head>
  </head>

  <body>

                          <table id="tabela">
                        <tr>
                            <th class="cabecalho">Quantidade</th>
                            <th class="cabecalho">Mes</th>
                            <th class="cabecalho">Ano</th>
                        </tr>
                        <c:forEach items="${periodoVendas}" var="p">
                            <tr>
                                <td class="conteudo" align="center">${p.quantidade}</td>
                                <td class="conteudo" align="center">${p.mes}</td>
                                <td class="conteudo" align="center">${p.ano}</td>
                            </tr>
                        </c:forEach>
                    </table>
      
      
      
      
      
  </body>
</html>