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
                            <span class="text"><i class="fa fa-search"></i> Procurar</span>
                        </button>
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
                    <div class="btn-group dropdown">
                        <button type="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown">
                            <span class="text"><i class="fa fa-user"></i> Login</span>
                        </button>
                        <ul class="dropdown-menu dropdown-menu-right">
                            <li>
                                <form class="login-form" action="#">
                                    <div class="form-group has-feedback">
                                        <input type="text" class="form-control" placeholder="Username">
                                        <i class="fa fa-user form-control-feedback"></i>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="password" class="form-control" placeholder="Password">
                                        <i class="fa fa-lock form-control-feedback"></i>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-block">
                                        <span class="text">Entrar <i class="fa fa-arrow-right"></i></span>
                                    </button>
                                    <h3 class="text-center">ou</h3>
                                    <button type="submit" class="btn btn-primary btn-block">
                                        <span class="text">Inscrever-se <i class="fa fa-arrow-right"></i></span>
                                    </button>
                                    <p class="text-center"><a href="#" title="Reset password">Esqueceu sua senha?</a></p>
                                    <h3 class="text-center">Entrar com rede social</h3>
                                    <ul class="list-inline text-center">
                                        <li>
                                            <a href="#" title="Login with Facebook"><span class="icon-circle-small"><i class="fa fa-facebook"></i></span></a>
                                        </li><li>
                                            <a href="#" title="Login with Twitter"><span class="icon-circle-small"><i class="fa fa-twitter"></i></span></a>
                                        </li><li>
                                            <a href="#" title="Login with Google +"><span class="icon-circle-small"><i class="fa fa-google-plus"></i></span></a>
                                        </li>
                                    </ul>
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
            <div class="collapse navbar-collapse" id="main-menu">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#home">
                            <span class="main-link">Inicio</span>
                            <span class="additional-info-link bracket">
                                inicio da jornada
                            </span>
                        </a>
                    </li>
                    <li>
                        <a href="#about">
                            <span class="main-link">Serviço</span>
                            <span class="additional-info-link bracket">
                                como funciona
                            </span>
                        </a>
                    </li>
                    <li>
                        <a href="#plano">
                            <span class="main-link">Planos </span>
                            <span class="additional-info-link bracket">
                                nossos planos
                            </span>
                        </a>
                    </li>
                    <li>
                        <a href="#mandamensagem">
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
            <!-- Final menu -->
        </div>
    </div>
    <!-- Final Navbar -->

    <div class="single-page-section single-page-blog">

        <!-- Header Página -->
        <div class="single-page-header single-page-blog-header">
            <div class="overlay"></div>
            <div class="container">
                <h2 class="digit-header">Pedidos</h2>
                <h3 class="signature-header"><small>Acompanha aqui seus<strong> Pedidos</strong></small></h3>
            </div>
            <div class="single-page-header-bg"></div>
        </div>
 
        <div class="container">
            <div class="recol">
            <ul class="side-menu">
                <center><br>
                    <a class="link-menu">Pedidos</a><br>
                    <center>_______________</center><br>
                    <a class="link-menu">Dados Pessoais</a><br>
                    <center>_______________</center><br>
                    <a class="link-menu">Atendimento</a><br>
                    <center>_______________</center><br>
                    <a class="link-menu">Sair</a><br><br>
                </center>

            </ul>
            </div>
            
            <div class="row">
                <div class="col-cadastro" style="margin-top: -300px;">

                        <table id="tabela" border="2px" style="border-color: gold">
                        <tr>                
                        </tr>
                        
                        <center> <ul> <h3 style="color: gold">SEUS PEDIDOS</h3> </ul> </center>
                        <c:forEach items="${minhasCompras}" var="com">

                        <c:choose>
                        <c:when test="${com.status == '1'}">

                            <c:set var = "statusNome" scope = "session" value = "${'Aguardando baixa no pagamento'}"/>

                        </c:when>
                        
                        <c:when test="${com.status == '2'}">
                            
                            <c:set var = "statusNome" scope = "session" value = "${'Separando pedido'}"/>
                        
                        </c:when>
                        
                        <c:when test="${com.status == '3'}">
                            
                            <c:set var = "statusNome" scope = "session" value = "${'Pedido despachado p/ transportadora'}"/>
                        
                        </c:when>
                        
                        <c:when test="${com.status == '4'}">
                            
                            <c:set var = "statusNome" scope = "session" value = "${'Pedido em transporte'}"/>
                        
                        </c:when>
                        
                        <c:otherwise>
                            
                            <c:set var = "statusNome" scope = "session" value = "${'Pedido entregue'}"/>
                        
                        </c:otherwise>
                        
                        </c:choose>
                        <tr style="position:center;">
                            <td class="conteudo" style="width: 30px"><img src="img/pack.png" style="width:40px;"</td>
                        <td class="conteudo">#<a href="mostrarPedido?id=${com.id}" style="font-weight: bold">${com.id}</div></td></a>
                            <!--<a><td class="conteudo">Realizado em ${com.data}</td></a>-->
                            <a><td class="conteudo">Realizado em <fmt:formatDate pattern="dd/MM/yyyy" value="${com.data}" /></td></a>
                            <a><td class="conteudo" style="text-align:right;"><h96 style="font-weight: bold">R$ ${com.total}0</h96></td></a>
                            <a><td class="conteudo">${statusNome}</td></a>
                        </tr>
                        </c:forEach>
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
        function formatar(mascara, documento){
          var i = documento.value.length;
          var saida = mascara.substring(0,1);
          var texto = mascara.substring(i)
          
          if (texto.substring(0,1) != saida){
                    documento.value += texto.substring(0,1);
          }
          
        }
    </script>

</body>
</html>
