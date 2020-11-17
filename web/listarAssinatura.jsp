<%-- 
    Document   : listarPedidos
    Created on : 27/04/2020, 15:03:45
    Author     : Renato Alberti
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Cliente"%>
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
    <body data-spy="scroll" data-offset="122" data-target="#main-menu" data-skrollr="true">


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

        <!-- Color switcher -->

        <!-- Navbar -->
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="triangle">
                <i class="fa fa-angle-double-down" aria-hidden="true"></i>
            </div>


            <!-- Topbar -->
            <div class="header-top clearfix">
                <div class="container">
                    <ul class="list-inline social-links">
                        <li>
                            <a href="#" title="Twitter"><i class="fa fa-twitter"></i></a>
                        </li><li>
                            <a href="#" title="Youtube"><i class="fa fa-youtube-play"></i></a>
                        </li><li>
                            <a href="#" title="Facebook"><i class="fa fa-facebook"></i></a>
                    </ul>
                    <div class="header-top-dropdown">
                        <div class="btn-group dropdown">
                            <ul class="dropdown-menu dropdown-menu-right">
                                <li>
                                    <form class="search-box" action="#">
                                        <div class="form-group has-feedback no-margin">
                                            <input type="text" class="form-control" placeholder="Procurar">
                                            <i class="fa fa-search form-control-feedback"></i>
                                        </div>
                                    </form>
                                </li>
                            </ul>
                        </div>
                        <div class="btn-group dropdown">

                            <button type="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown">
                                <span class="text"><i class="fa fa-user"></i> Bem-vindo, <%= cliente.getNomecompleto()%> </span>
                            </button>
                            <%}%>

                            <ul class="dropdown-menu dropdown-menu-right">
                                <li>


                                    <div class="text-center">
                                        <div class="form-group has-feedback">
                                            - <a href="minhaConta"> Minha conta </a> -
                                        </div>
                                        <div class="form-group has-feedback">
                                            - <a href="listarCompras"> Pedidos </a> -
                                        </div>
                                        <div class="form-group has-feedback">
                                            - <a href="listarMeusEndCart"> Dados Pessoais </a> -
                                        </div>
                                        <div class="form-group has-feedback">
                                            - <a href="#" data-toggle="modal" data-target="#modal-logout"> Sair </a> -
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Topbar final -->
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
                <div class="collapse navbar-collapse" id="main-menu">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="bemvindo#home">
                                <span class="main-link">Inicio</span>
                                <span class="additional-info-link bracket">
                                    inicio da jornada
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="bemvindo#about">
                                <span class="main-link">Serviço</span>
                                <span class="additional-info-link bracket">
                                    como funciona
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="bemvindo#plano">
                                <span class="main-link">Planos </span>
                                <span class="additional-info-link bracket">
                                    nossos planos
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="bemvindo#mandamensagem">
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
                                    EM BREVE
                                </span>
                            </a>
                        </li>
                    </ul>
                </div>
                <!-- Final menu -->
            </div>
        </div>
        <!-- Final Navbar -->

        <div class="single-page-section single-page-blog">

            <!-- Header Página -->
            <div class="single-page-header single-page-blog-header">
                <div class="overlay"></div>
                <div class="container">
                    <h2 class="digit-header">Assinatura</h2>
                    <h3 class="signature-header"><small>Acompanha aqui sua<strong> Assinatura ativa</strong></small></h3>
                </div>
                <div class="single-page-header-bg"></div>
            </div>

            <div class="container">
                <jsp:include page="/elementos/menuCliente.jsp"/>
                <div class="row">
                    <div class="col-cadastro" style="margin-top: -300px;">

                        <table id="tabela" border="2px" style="border-color: gold">
                            <tr>                
                            </tr>

                            <center> <ul> <h3 style="color: gold">ASSINATURA</h3> </ul> </center>
                            <h2>Essa é sua assinatura ativa</h2>
                            <c:forEach items="${minhaAssinatura}" var="com">
                                <c:choose>

                                    <c:when test="${com.id == '1'}">

                                        <c:set var = "statusNome" scope = "session" value = "${'OURO'}"/>
                                        <c:set var = "img" scope = "session" value = "${'ouro.png'}"/>

                                    </c:when>

                                    <c:when test="${com.id == '2'}">

                                        <c:set var = "statusNome" scope = "session" value = "${'PRATA'}"/>
                                        <c:set var = "img" scope = "session" value = "${'prata.png'}"/>

                                    </c:when>

                                    <c:when test="${com.id == '3'}">

                                        <c:set var = "statusNome" scope = "session" value = "${'BRONZE'}"/>
                                        <c:set var = "img" scope = "session" value = "${'bronze.png'}"/>

                                    </c:when>

                                    <c:otherwise>

                                        <c:set var = "statusNome" scope = "session" value = "${'Você não possui nenhuma assinatura :( <br> Você pode adquirir uma <a> clicando aqui </a> '}"/>
                                        <c:set var = "img" scope = "session" value = "${'x.png'}"/>

                                    </c:otherwise>
                                </c:choose>


                                <tr style="position:center;">
                                    <td class="conteudo" style="width: 30px"><img src="img/${img}" style="width:40px;"</td>
                                    <td class="conteudo">${statusNome}<a style="font-weight: bold"></td></a>
                                <a><td class="conteudo">
                                        <div class="botaocancelar" style="display:block">
                                            <a href="#" data-toggle="modal" data-target="#modal-trocar" class="btn btn-primary btn-block"><i class="fa fa-close"></i>Trocar</a>
                                            <a href="#" data-toggle="modal" data-target="#modal-cancelar" class="btn btn-primary btn-block"><i class="fa fa-close"></i>Cancelar</a>                         
                                        </div>


                                        <div class="modal fade" id="modal-cancelar" tabindex="-1" role="dialog" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        <h3 class="modal-title">Cancelar Assinatura</h3>
                                                    </div>
                                                    <form method="post" action="#">
                                                        <div class="modal-body">
                                                            <div class="checkbox">
                                                                <label>
                                                                    Tem certeza que deseja cancelar sua assinatura? :(
                                                                </label>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <a href="removerAss?id=${com.id}" class="btn btn-primary"><i class="fa fa-sign-out" aria-hidden="true"></i> Sim</a><button type="button" class="btn btn-primary" data-dismiss="modal">Não</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="modal fade" id="modal-trocar" tabindex="-1" role="dialog" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        <h3 class="modal-title">Trocar Assinatura</h3>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div data-100p-top="transform[swing]:translateX(-25px);opacity[swing]:0" data-75p-top="transform[swing]:translateX(0);opacity[swing]:1">
                                                                <div class="price-item price-basic">
                                                                    <div class="price-header">
                                                                        <h3>R$ <strong>50</strong> / mes</h3>
                                                                    </div>
                                                                    <div class="price-description">Bronze</div>
                                                                    <div class="price-image">
                                                                        <div class="overlay"></div>
                                                                        <h4 class="price-title">
                                                                            <span class="overlay-header"><span class="main-color">P</span>laybo<span class="main-color">X</span></span>
                                                                        </h4>
                                                                    </div>
                                                                    <ul class="price-list list-unstyled">
                                                                        <li> 1 (um) jogo</li>
                                                                        <li> 1 (uma) camiseta</li>
                                                                        <li> 1 (um) brinde</li>
                                                                    </ul>
                                                                    <div class="price-button">
                                                                        <a href="#" class="btn btn-primary btn-block" data-toggle="modal" data-target="#modal-bronze" title="Quero esse"><i class="fa fa-shopping-basket" aria-hidden="true"></i> Quero esse</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div data-100p-top="transform[swing]:translateY(-25px);opacity[swing]:0" data-75p-top="transform[swing]:translateY(0);opacity[swing]:1">
                                                                <div class="price-item price-gold">
                                                                    <div class="price-header">
                                                                        <h3>R$ <strong>60</strong> / mes</h3>
                                                                    </div>
                                                                    <div class="price-description">Prata</div>
                                                                    <div class="price-image">
                                                                        <div class="overlay"></div>
                                                                        <h4 class="price-title">
                                                                            <span class="overlay-header"><span class="main-color">P</span>laybo<span class="main-color">X</span></span>
                                                                            <br>
                                                                            <span class="overlay-header">+</span>
                                                                            <br>
                                                                            <span class="overlay-header">DLC</span>
                                                                        </h4>
                                                                    </div>
                                                                    <ul class="price-list list-unstyled">
                                                                        <li> 1 (um) jogo</li>
                                                                        <li> 1 (uma) camiseta</li>
                                                                        <li> 3 (três) brindes</li>
                                                                    </ul>
                                                                    <div class="price-button">
                                                                        <a href="#" class="btn btn-primary btn-block" data-toggle="modal" data-target="#modal-prata" title="Quero esse"><i class="fa fa-shopping-basket" aria-hidden="true"></i> Quero esse</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div data-100p-top="transform[swing]:translateX(25px);opacity[swing]:0" data-75p-top="transform[swing]:translateX(0);opacity[swing]:1">
                                                                <div class="price-item price-platinium">
                                                                    <div class="price-feature">
                                                                        <i class="fa fa-star" aria-hidden="true"></i>
                                                                    </div>
                                                                    <div class="price-header">
                                                                        <h3>R$ <strong>70</strong> / mes</h3>
                                                                    </div>
                                                                    <div class="price-description">Ouro</div>
                                                                    <div class="price-image">
                                                                        <div class="overlay"></div>
                                                                        <h4 class="price-title">
                                                                            <span class="overlay-header"><span class="main-color">P</span>laybo<span class="main-color">X</span></span>
                                                                            <br>
                                                                            <span class="overlay-header">+</span>
                                                                            <br>
                                                                            <span class="overlay-header">DLC PLUS</span>
                                                                        </h4>
                                                                    </div>
                                                                    <ul class="price-list list-unstyled">
                                                                        <li> 1 (um) jogo</li>
                                                                        <li> 1 (uma) camiseta</li>
                                                                        <li> 5 (cinco) brindes</li>
                                                                    </ul>
                                                                    <div class="price-button">
                                                                        <a href="#" class="btn btn-primary btn-block" data-toggle="modal" data-target="#modal-ouro" title="Quero esse"><i class="fa fa-shopping-basket" aria-hidden="true"></i> Quero esse</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </c:forEach>  

                                    <div class="modal fade" id="modal-bronze" tabindex="-1" role="dialog" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h3 class="modal-title">Escolha entre as opções abaixo</h3>
                                                </div>
                                                <form method="post" action="#">
                                                    <div class="modal-body">
                                                        <div class="checkbox">
                                                            <label>
                                                                Você deseja Trocar Assinatura para:
                                                                <h2>Pacote Bronze</h2>
                                                                <div class="modal-footer">
                                                                    <a href="assinar?id=3" type="submit" class="btn btn-primary"><i class="fa fa-play-circle" aria-hidden="true"></i> Trocar</a>
                                                                </div>
                                                            </label>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal fade" id="modal-prata" tabindex="-1" role="dialog" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h3 class="modal-title">Escolha entre as opções abaixo</h3>
                                                </div>
                                                <form method="post" action="#">
                                                    <div class="modal-body">
                                                        <div class="checkbox">
                                                            <label>
                                                                Você deseja Trocar Assinatura para:
                                                                <h2>Pacote Prata</h2>
                                                                <div class="modal-footer">
                                                                    <a href="assinar?id=2" type="submit" class="btn btn-primary"><i class="fa fa-play-circle" aria-hidden="true"></i> Trocar</a> 
                                                                </div>
                                                            </label>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal fade" id="modal-ouro" tabindex="-1" role="dialog" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h3 class="modal-title">Escolha entre as opções abaixo</h3>
                                                </div>
                                                <form method="post" action="#">
                                                    <div class="modal-body">
                                                        <div class="checkbox">
                                                            <label>
                                                                Você deseja Trocar Assinatura para:
                                                                <h2>Pacote Ouro</h2>
                                                                <div class="modal-footer">
                                                                    <a href="assinar?id=1" type="submit" class="btn btn-primary"><i class="fa fa-play-circle" aria-hidden="true"></i> Trocar</a> 
                                                                </div>
                                                            </label>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </td></a>
                            </tr>
                        </table>

                    </div>
                    <div class="col-cadastro col-md-8">
                        <div class="standard-box">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>

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
