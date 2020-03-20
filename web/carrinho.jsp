<%-- 
    Document   : carrinho
    Created on : 08/03/2020, 16:54:31
    Author     : Kaua.Morateli
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="Model.Cliente"%>
<%@page import="Model.Carrinho"%>
<%@page import="Model.Pacote"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<!DOCTYPE html>
<html class="no-js">

<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="description" content="PlayboX - A box Gamer dos Gamers">
    <meta name="keywords" content="template, theme, html, css, bootstrap, game, event, culture, music, personal, cv">
    <meta name="author" content="Kauã Morateli, Renato Alberti, Rodrigo Kenji">

    <title>PlayboX - Carrinho de Compras</title>

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Press+Start+2P%7CLato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <!-- Lightbox styles -->
    <link href="assets/lightbox2-master/dist/css/lightbox.min.css" rel="stylesheet">
  

    
    <!-- Loaders styles -->
    <link href="assets/loaders.css-master/loaders.min.css" media="screen" rel="stylesheet" type="text/css">

    <!-- Template styles -->
    <link href="css/yellow.min.css" media="screen" rel="stylesheet" type="text/css" title="yellow">
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
                            <span class="text"><i class="fa fa-user"></i> Bem-vindo,  </span>
                        </button>
                        
                        
                        <ul class="dropdown-menu dropdown-menu-right">
                            <li>

                                
                                <div class="text-center">
                                    <div class="form-group has-feedback">
                                        - <a href="#"> Minha conta </a> -
                                    </div>
                                    <div class="form-group has-feedback">
                                        - <a href="#"> Pedidos </a> -
                                    </div>
                                    <div class="form-group has-feedback">
                                        - <a href="#"> Dados Pessoais </a> -
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
        
        <!-- Topbar end -->
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#main-menu">
                    <span class="sr-only">Navegação</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- Logo -->
                <a class="navbar-brand" href="index.html" title="PlayBoX" style="">
                    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<i class="fa fa-gamepad" aria-hidden="true"></i><span class="main-color">P</span>laybo<span class="main-color">X</span>
                </a><!-- Logo end -->
            </div>
            <!-- Main menu -->
<!-- Main menu end -->
        </div>
    </div><!-- Navbar end -->
    <br><br>
    <br><br>
    <br><br>
    <br><br>

            <div style="margin-left: 100px; margin-right: 100px;">

            <h1><a>Meu Carrinho</a></h1>
            <br>
            <br>
            <table class="table table-striped" style>
                
                <c:if test="${cart.lineItemCount==0}">
                    <tr>
                        <td colspan="4">
                            <font size="2" face="Verdana, Arial, Helvetica, sans-serif"/>
                            - Você ainda não possui produtos no carrinho-
                            <br/>
                        </td>
                    </tr>
                </c:if>
                
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Img</th>
                        <th>Produto</th>
                        <th>Camiseta</th>
                        <th>Preço</th>
                    </tr>
                </thead>

                <tbody>
                   <c:set var="total" value="0"></c:set>
                   <c:forEach items="${carrinho.pacotesNoCarrinho}" var="pacote" varStatus="status" >
                       
                   <tr>
                       <td>${status.count}</td>
                       <td><img src="" width="40"></td>
                       <td>${pacote.nome}</td>
                       <td>
                           <select style="color: black;" id="optTamanho" name="optTamanho">
                               <option disabled="disabled">Escolha um tamanho</option>
                               <option value ="P">P</option>
                               <option value ="M">M</option>
                               <option value ="G">G</option>
                               <option value ="GG">GG</option>
                               <option value ="GGX">GGX</option>
                           </select>
                       </td>

                       <td><c:set var="total" value="${total + pacote.preco}"></c:set>
                       <fmt:formatNumber type="currency" currencySymbol="R$" value="${pacote.preco}"></fmt:formatNumber>
                       </td>
                       <td>
                            <a href="removerDoCarrinho?id=${pacote.id}">
                            <span class="glyphicon glyphicon-remove icone-botao"></span>
                            </a>
                        </td>
                   </tr>
                   </c:forEach>
                </tbody>
                
                <tfoot>
                    <tr>
                        <th colspan="5">Total</th>
                        <th><fmt:formatNumber type="currency" currencySymbol="R$" value=""></fmt:formatNumber></th>
                    </tr>
                </tfoot>
            </table>
            <br><br><br>
            <div class="col-sm-4">
            <a href="." class="btn btn-primary btn-block dropdown-toggle" title="Continuar" data-toggle="dropdown" data-target="#login"><i class="fa fa-shopping-basket" aria-hidden="true"></i> Continuar Comprando</a>
            </div><br><br><br>
            <div class="price-button">
            <a href="metodoPagamento.jsp" class="btn btn-primary btn-block dropdown-toggle" title="Continuar"><i class="fa fa-play" aria-hidden="true"></i> Continuar</a>
            </div>
            <br><br><br>
            ⠀<img src="img/pagamentos.png" alt="Visa | Mastercard | Diners | Amex | Hipercard | Elo | Itaú | Bradesco | Banco do Brasil | HSBC | Boleto" title="Visa | Mastercard | Diners | Amex | Hipercard | Elo | Itaú | Bradesco | Banco do Brasil | HSBC | Boleto">
            </div>
    
    <br><br>
    <br><br>
    <br><br>
    <!-- Footer -->
    <footer class="footer text-center" id="follow-us">
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

    <!-- Scroll to top button -->
    <div id="toTop" class="to-top">
        <a href="#" class="To the top">
            <i class="fa fa-angle-up"></i>
        </a>
    </div>
    
        <div class="modal fade" id="modal-logout" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3 class="modal-title">Sair</h3>
                </div>
                <form method="post" action="#">
                    <div class="modal-body">
                        <div class="checkbox">
                            <label>
                                Tem certeza que deseja Sair? :(
                            </label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <a href="ControleAcessoCliente?acao=Sair" type="submit" class="btn btn-primary"><i class="fa fa-sign-out" aria-hidden="true"></i> Sim</a><button type="button" class="btn btn-primary" data-dismiss="modal">Cancelar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>

    <!-- Bootstrap -->
    <script type="text/javascript" src="assets/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>

    <!-- Lightbox -->
    <script type="text/javascript" src="assets/lightbox2-master/dist/js/lightbox.min.js"></script>

    <!-- morris charts -->
    <script type="text/javascript" src="assets/morris.js-0.5.1/morris.min.js"></script>

    <!-- jQuery parallax -->
    <script type="text/javascript" src="js/jquery.parallax-1.1.3-min.js"></script>

    <!-- jQuery countdown -->
    <script type="text/javascript" src="js/countdown.min.js"></script>

    <!-- skrollr -->
    <script type="text/javascript" src="js/skrollr.min.js"></script>

    <!-- raphael -->
    <script src="js/raphael.min.js"></script>

    <!-- particles -->
    <script src="js/TweenLite.min.js"></script>
    <script src="js/EasePack.min.js"></script>
    <script src="js/rAF.min.js"></script>
    <script src="js/particles.min.js"></script>

    <!-- Custom javascript -->
    <script type="text/javascript" src="js/custom.min.js"></script>

    <!-- Main page javascript -->
    <script type="text/javascript" src="js/main.min.js"></script>

    <!-- Google maps -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDEspZc-GBwxrJtw4vS3GjhAzIv7gHVbXw&callback=initMap"></script>

</body>
</html>
