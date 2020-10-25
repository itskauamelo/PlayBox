<%-- 
    Document   : listarPedidos
    Created on : 27/04/2020, 15:03:45
    Author     : Renato Alberti
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Cliente"%>
<!DOCTYPE html>
<html class="no-js">

    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="description" content="PlayboX - A box Gamer dos Gamers">
        <meta name="keywords" content="template, theme, html, css, bootstrap, game, event, culture, music, personal, cv">
        <meta name="author" content="Kauã Morateli, Renato Alberti, Rodrigo Kenji">

        <title>PlayboX - Minha Conta</title>

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
                                <span class="text"><i class="fa fa-user"></i> Bem-vindo, <%= cliente.getNomecompleto()%>  </span>
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
                    </a><!-- Logo final -->
                </div>
                <!-- Menu -->
                <!-- Menu final -->
            </div>
        </div><!-- Navbar final -->

        <div class="single-page-section single-page-blog">

            <!-- Header Página -->
            <div class="single-page-header single-page-blog-header">
                <div class="overlay"></div>
            </div>

            <div class="container">
                <div class="recol">
                    <ul class="side-menu">
                        <center><br>
                            <a class="link-menu">Pedidos</a><br>
                            <center>__</center><br>
                            <a href="listarAssinatura">Minha Assinatura</a><br>
                            <center>__</center><br>
                            <a class="link-menu">Minha Conta</a><br>
                            <center>__</center><br>
                            <a class="link-menu">Atendimento</a><br>
                            <center>__</center><br>
                            <a class="link-menu">Sair</a><br><br>
                        </center>
                    </ul>
                </div>

                <div class="row">
                    <div class="col-cadastro" style="margin-top: -300px;">
                        <BR>
                        •<a href="iniciarEdicaoCliente?id=<%=cliente.getId()%>"> EDITAR DADOS PESSOAIS</a><BR><BR>
                        •<a href="/listarEnderecosAlteracao"> EDITAR ENDEREÇOS</a><BR><BR>
                        •<a href="/listarCartoesAlteracao"> EDITAR CARTÕES DE CRÉDITO</a><BR><BR>
                        •<a href="iniciarAlteracaoSenha?id=<%=cliente.getId()%>"> ALTERAR MINHA SENHA</a><BR><BR>
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
