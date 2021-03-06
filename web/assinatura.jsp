<%-- 
    Document   : teste
    Created on : 08/10/2020, 22:31:12
    Author     : renat
--%>
<%@page import="Model.Assinatura"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Model.Cliente"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html class="no-js">

    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="description" content="PlayboX - A box Gamer dos Gamers">
        <meta name="keywords" content="template, theme, html, css, bootstrap, game, event, culture, music, personal, cv">
        <meta name="author" content="Kauã Morateli, Renato Alberti, Rodrigo Kenji">

        <title>PlayboX - A loja Gamer dos Gamers</title>

        <!-- Fontes -->
        <link href="https://fonts.googleapis.com/css?family=Press+Start+2P%7CLato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
        <!-- Lightbox styles -->
        <link href="assets/lightbox2-master/dist/css/lightbox.min.css" rel="stylesheet">

        <!-- Carregar styles -->
        <link href="assets/loaders.css-master/loaders.min.css" media="screen" rel="stylesheet" type="text/css">

        <!-- styles -->
        <link href="css/yellow.css" media="screen" rel="stylesheet" type="text/css" title="yellow">
        <link href="css/pink.min.css" media="screen" rel="alternate stylesheet" type="text/css" title="pink">
        <link href="css/orange.min.css" media="screen" rel="alternate stylesheet" type="text/css" title="orange">
        <link href="css/red.min.css" media="screen" rel="alternate stylesheet" type="text/css" title="red">
        <link href="css/green.min.css" media="screen" rel="alternate stylesheet" type="text/css" title="green">
        <link href="css/blue.min.css" media="screen" rel="alternate stylesheet" type="text/css" title="blue">

        <!-- Modernizr -->
        <script type="text/javascript" src="js/modernizr-custom.min.js"></script>

        <!-- Favicon -->
        <link rel="icon" href="img/favicon.png" type="image/png">

    </head>
    <%
        Cliente cliente = (Cliente) session.getAttribute("clienteAutenticado");

        if (cliente != null) {
    %>
    <body>

        <!-- Preloader -->
        <div class="loader-overlay">
            <div class="loader">
                <div class="loader-inner pacman">
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                </div>
                <h3 class="loader-text">Carregando</h3>
            </div>
        </div>

        <!-- trocar cor vai aqui dps -->

        <!-- Navbar -->
        <div class="navbar navbar-inverse">
            <div class="triangle">
                <i class="fa fa-angle-double-down" aria-hidden="true"></i>
            </div>
            <!-- Topbar inicio -->
            <div class="header-top clearfix">
                <div class="container">
                    <ul class="list-inline social-links">
                        <li>
                            <a href="#" title="Twitter"><i class="fa fa-twitter"></i></a>
                        </li><li class="hidden-xs">
                            <a href="#" title="Skype"><i class="fa fa-skype"></i></a>
                        </li><li class="hidden-xxs">
                            <a href="#" title="LinkedIn"><i class="fa fa-linkedin"></i></a>
                        </li><li class="hidden-xxs">
                            <a href="#" title="Google +"><i class="fa fa-google-plus"></i></a>
                        </li><li>
                            <a href="#" title="Youtube"><i class="fa fa-youtube-play"></i></a>
                        </li><li>
                            <a href="#" title="Facebook"><i class="fa fa-facebook"></i></a>
                        </li>
                    </ul>
                    <div class="header-top-dropdown">
                        <div class="btn-group dropdown">
                            <button type="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown">
                                <span class="text"><i class="fa fa-user"></i> Bem-vindo, <%= cliente.getNomecompleto()%> </span>
                            </button>
                            <%}%>
                            <button type="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown">
                                <span class="text"><i class="fa fa-shopping-cart"></i> Carrinho</span>
                            </button>
                            <ul class="dropdown-menu dropdown-menu-right">
                                <li>
                                    <form class="search-box" action="#">
                                        <div class="form-group has-feedback no-margin">
                                            <br>
                                            <br>
                                            <br>
                                            <br>
                                            <br>
                                            <br>
                                            <br>
                                            <br>
                                            <br>
                                            <a href="#" class="btn btn-primary btn-block" title="Ver todos" data-toggle="modal" data-target="#order-modal"><i class="fa fa-shopping-basket" aria-hidden="true"></i> Ver todos</a>
                                        </div>
                                    </form>
                                </li>
                            </ul>
                        </div>                                             
                    </div>
                </div>
            </div><!-- Topbar final -->
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#main-menu">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Logo inicio -->
                    <a class="navbar-brand" href="index.html" title="PlayBoX">
                        <i class="fa fa-gamepad" aria-hidden="true"></i><span class="main-color">P</span>laybo<span class="main-color">X</span>
                    </a><!-- Logo final -->
                </div>
                <!-- Menu principal -->
                <c:forEach items="${carrinho.assinaturaNoCarrinho}" var="assinatura" varStatus="status" >
                    <div class="collapse navbar-collapse" id="main-menu">                  
                        <ul class="nav navbar-nav">                       
                            <li>
                                <a href="removerDoCarrinhoAssinatura?id=${assinatura.id}">
                                    <span class="main-link">Inicio</span>
                                    <span class="additional-info-link bracket">
                                        inicio da jornada
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="removerDoCarrinhoAssinatura?id=${assinatura.id}">
                                    <span class="main-link">Serviço</span>
                                    <span class="additional-info-link bracket">
                                        como funciona
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="removerDoCarrinhoAssinatura?id=${assinatura.id}">
                                    <span class="main-link">Planos </span>
                                    <span class="additional-info-link bracket">
                                        nossos planos
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="removerDoCarrinhoAssinatura?id=${assinatura.id}">
                                    <span class="main-link">Contato </span>
                                    <span class="additional-info-link bracket">
                                        fale com a gente
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="main-link">Loja</span>
                                    <span class="additional-info-link bracket">
                                        alguns produtos
                                    </span>
                                </a>
                            </li>                                  
                        </ul>             
                    </div>
                </c:forEach>
                <!-- Final menu -->
            </div>
        </div>
        <!-- Final Navbar -->

        <div class="single-page-section single-page-blog">

            <div class="container">
                <div class="row">
                    <div class="col-cadastro col-md-8"> <br>
                        <h1>Assinatura </h1>
                        <table class="table table-striped" style>

                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Img</th>
                                    <th>Item</th>
                                    <th>Preço</th>                                       
                                </tr>
                            </thead>

                            <tbody>
                                <c:set var="totalAss" value="0"></c:set>
                                <c:forEach items="${carrinho.assinaturaNoCarrinho}" var="assinatura" varStatus="status" >

                                    <c:choose>
                                        <c:when test="${assinatura.nome == 'BRONZE'}">

                                            <c:set var = "img" scope = "session" value = "${'bronze.png'}"/>

                                        </c:when>

                                        <c:when test="${assinatura.nome == 'PRATA'}">

                                            <c:set var = "img" scope = "session" value = "${'prata.png'}"/>

                                        </c:when>

                                        <c:when test="${assinatura.nome == 'OURO'}">

                                            <c:set var = "img" scope = "session" value = "${'ouro.png'}"/>

                                        </c:when>

                                    </c:choose>

                                    <tr>
                                        <td>${status.count}</td>
                                        <td><img src="img/${img}" width="40"></td>
                                        <td>${assinatura.nome}</td>

                                        <td>
                                            <c:set var="total" value="${totalAss + assinatura.preco}"></c:set>
                                            <fmt:formatNumber type="currency" currencySymbol="R$" value="${assinatura.preco}"></fmt:formatNumber>
                                            </td>
                                        </tr>

                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <th colspan="3">Total</th>
                                            <th><fmt:formatNumber type="currency" currencySymbol="R$" value="${total}"></fmt:formatNumber></th>
                                        </tr>
                                    </tfoot>
                                </table>
                                Frete: Gratis <br> <br>
                            </div>
                            <div class="col-cadastro col-md-8">
                                <form method="POST">
                                    <a href="finalizarAssinatura" style="background-color: greenyellow" type="submit" class="btn btn-primary btn-block">Assinar</a>  
                                </form><br>
                                <a href="removerDoCarrinhoAssinatura?id=${assinatura.id}" type="button" class="btn btn-primary btn-block">Voltar</a>      
                        </c:forEach>                     
                    </div>
                </div>
            </div>
        </div>


        <br><br><br>

        <!-- Footer -->
        <footer class="footer footer-gray text-center" id="follow-us">
            <div class="container">
                <ul class="list-inline">
                    <li>
                        <a href="#" title="Facebook"><i class="fa fa-facebook"></i></a>
                    </li>
                    <li>
                        <a href="#" title="Twitter"><i class="fa fa-twitter"></i></a>
                    </li>
                    <li>
                        <a href="#" title="Dribble"><i class="fa fa-dribbble"></i></a>
                    </li>
                    <li>
                        <a href="#" title="LinkedIn"><i class="fa fa-linkedin"></i></a>
                    </li>
                    <li>
                        <a href="#" title="RSS"><i class="fa fa-rss"></i></a>
                    </li>
                </ul>
                <p> &copy; 2020 <a href="http://www.umc.br/home">UMC</a></p>
            </div>
        </footer>

        <!-- Subir toda página -->
        <div id="toTop" class="to-top">
            <a href="#" class="To the top">
                <i class="fa fa-angle-up"></i>
            </a>
        </div>

        <!-- jQuery -->
        <script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>

        <!-- Bootstrap -->
        <script type="text/javascript" src="assets/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>

        <!-- Custom JS -->
        <script type="text/javascript" src="js/custom.min.js"></script>

        <script>
            function formatar(mascara, documento) {
                var i = documento.value.length;
                var saida = mascara.substring(0, 1);
                var texto = mascara.substring(i)

                if (texto.substring(0, 1) != saida) {
                    documento.value += texto.substring(0, 1);
                }

            }
        </script>

    </body>
</html>
