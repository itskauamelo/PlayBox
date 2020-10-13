<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Model.Cliente"%>
<%@page import="Model.Assinatura"%>
<!DOCTYPE html>
<html class="no-js">

<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="description" content="PlayboX - A box Gamer dos Gamers">
    <meta name="keywords" content="template, theme, html, css, bootstrap, game, event, culture, music, personal, cv">
    <meta name="author" content="Kauã Morateli, Renato Alberti, Rodrigo Kenji">

    <title>PlayboX - A box Gamer dos Gamers</title>

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
            <%
    Cliente cliente = (Cliente)session.getAttribute("clienteAutenticado");
    
    if (cliente != null){
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
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- Logo -->
                <a class="navbar-brand" href="index.html" title="PlayBoX">
                    <i class="fa fa-gamepad" aria-hidden="true"></i><span class="main-color">P</span>laybo<span class="main-color">X</span>
                </a><!-- Logo end -->
            </div>
            <!-- Main menu -->
            <div class="collapse navbar-collapse" id="main-menu">
                <ul class="nav navbar-nav">
                    <li class="active">
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
                        <a href="branco.jsp">
                            <span class="main-link">Loja</span>
                            <span class="additional-info-link bracket">
                                alguns produtos
                            </span>
                        </a>
                    </li>
                </ul>
            </div><!-- Main menu end -->
        </div>
    </div><!-- Navbar end -->

    <!-- Section home -->
    <div class="section-home" id="home">
        <div class="overlay"></div>
        <!-- Particles -->
        <canvas class="particles" id="particles"></canvas>
        <div class="container">
            <div class="section-home-content">
                <div class="section-icon"><span><i class="fas fa-box-open" style="color:black;" aria-hidden="true"></i></span></div>
                <div class="clearfix"></div>
                <h2 class="digit-header">A caixa <br>GAMER para GAMERS</h2>
                <h3 class="signature-header"></h3>
                <h1 class="system-header">{O clube de assinatura gamer}</h1>
                <p class="section-description">A <span class="highlight"><span class="main-color">P</span>laybo<span class="main-color">X</span></span> é um clube de assinatura <span class="highlight">Gamer.</span> Ao assinar você garante todos os meses na sua casa <span class="highlight">produtos exclusivos e licenciados</span> dos principais universos da cultura gamer desenvolvidos por uma curadoria interna da nossa propria equipe, de gamers para gamers. </p>

                <a href="#" class="btn-border btn-primary" title="Play" data-toggle="modal" data-target="#order-modal">
                    <span class="btn btn-primary btn-lg"><i class="fa fa-play" aria-hidden="true"></i> Play</span>
                </a>
            </div>
        </div>
        <div class="home-bg"></div>
    </div>

    <!-- Section about -->
    <div class="standard-section section-about" id="about">
        <div class="container">
            <div class="text-center">
                <h3 class="standard-subheader bracket" data-100p-top="transform[swing]:translateX(-25px);opacity[swing]:0" data-75p-top="transform[swing]:translateX(0);opacity[swing]:1">como funciona?</h3>
                <h2 class="standard-header" data-100p-top="transform[swing]:translateX(25px);opacity[swing]:0" data-75p-top="transform[swing]:translateX(0);opacity[swing]:1">Serviço</h2>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div class="feature-box text-center">
                        <span class="icon-circle-outer" data-toggle="tooltip" data-placement="top" data-100p-top="transform[swing]:scale(0.5);opacity[swing]:0" data-75p-top="transform[swing]:scale(1);opacity[swing]:1">
                            <span class="icon-circle-inner">
                                <span class="fa fa-hand-o-up"></span>
                            </span>
                        </span>
                        <h3 class="feature-header bracket">Escolha do plano</h3>
                        <p>Selecione o plano que mais combina com você, configure sua caixa (ou até mesmo adicione produtos a mais, avulsos à caixa) e conclua a assinatura. Ah! A renovação é automática ;)</p>
                        <p class="lines-header no-margin" data-100p-top="transform[swing]:scale(0.5);opacity[swing]:0" data-75p-top="transform[swing]:scale(1);opacity[swing]:1">Diversos planos que combinam com seu <strong>gosto</strong>!</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="feature-box text-center">
                        <span class="icon-circle-outer" data-toggle="tooltip" data-placement="top" data-100p-top="transform[swing]:scale(0.5);opacity[swing]:0" data-75p-top="transform[swing]:scale(1);opacity[swing]:1">
                            <span class="icon-circle-inner">
                                <span class="fa fa-space-shuttle"></span>
                            </span>
                        </span>
                        <h3 class="feature-header bracket">Entrega</h3>
                        <p>Acompanhe o progresso da entrega no site da transportadora responsável. Os envios sempre iniciam a partir do dia 15 de cada mês.</p><br>
                        <p class="lines-header no-margin" data-100p-top="transform[swing]:scale(0.5);opacity[swing]:0" data-75p-top="transform[swing]:scale(1);opacity[swing]:1">Entrega na velocidade da <strong>luz</strong>!</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="feature-box text-center">
                        <span class="icon-circle-outer" data-toggle="tooltip" data-placement="top" data-100p-top="transform[swing]:scale(0.5);opacity[swing]:0" data-75p-top="transform[swing]:scale(1);opacity[swing]:1">
                            <span class="icon-circle-inner">
                                <span class="fa fa-smile-o"></span>
                            </span>
                        </span>
                        <h3 class="feature-header bracket">Divirta-se</h3>
                        <p>A sua caixa chegou? Descubra tudo o que veio nela e compartilhe nas suas redes com a #CaixaPlayboX!</p><br><br>
                        <p class="lines-header no-margin" data-100p-top="transform[swing]:scale(0.5);opacity[swing]:0" data-75p-top="transform[swing]:scale(1);opacity[swing]:1">Joguinhos <strong>novos</strong>!</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <!-- Section pricing -->
    <div class="standard-section section-pricing" id="plano">
        <div class="container">
            <div class="text-center">
                <h3 class="standard-subheader bracket" data-100p-top="transform[swing]:translateX(-25px);opacity[swing]:0" data-75p-top="transform[swing]:translateX(0);opacity[swing]:1">nossos planos</h3>
                <h2 class="standard-header" data-100p-top="transform[swing]:translateX(25px);opacity[swing]:0" data-75p-top="transform[swing]:translateX(0);opacity[swing]:1">Planos</h2>
            </div>
            <div class="text-center" data-100p-top="transform[swing]:translateX(-25px);opacity[swing]:0" data-75p-top="transform[swing]:translateX(0);opacity[swing]:1">
                <div class="section-icon"><span><i class="fa fa-money" aria-hidden="true"></i></span></div>
            </div>
            <p class="section-description text-center lead">Separamos em modalidades que cabem em vários bolsos e gostos. Escolha a sua.</p>
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
                                Você deseja:
                                    <div class="modal-footer">
                                        <a href="assinar?id=1" type="submit" class="btn btn-primary"><i class="fa fa-play-circle" aria-hidden="true"></i> Assinar caixa</a> ou <a href="adicionarCarrinho?id=13" type="submit" class="btn btn-primary"><i class="fa fa-cart-arrow-down" aria-hidden="true"></i> Comprar Avulso</a>
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
                                Você deseja:
                                    <div class="modal-footer">
                                        <a href="assinar?id=2" type="submit" class="btn btn-primary"><i class="fa fa-play-circle" aria-hidden="true"></i> Assinar caixa</a> ou <a href="adicionarCarrinho?id=8" type="submit" class="btn btn-primary"><i class="fa fa-cart-arrow-down" aria-hidden="true"></i> Comprar Avulso</a>
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
                                Você deseja:
                                    <div class="modal-footer">
                                        <a href="assinar?id=3" type="submit" class="btn btn-primary"><i class="fa fa-play-circle" aria-hidden="true"></i> Assinar caixa</a> ou <a href="adicionarCarrinho?id=11" type="submit" class="btn btn-primary"><i class="fa fa-cart-arrow-down" aria-hidden="true"></i> Comprar Avulso</a>
                                    </div>
                            </label>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Section send us message (contact form) -->
    <div class="standard-section section-promo section-send-us-message" id="mandamensagem">
        <div class="triangle triangle-up" data-100p-top="top[swing]:-54px" data-75p-top="top[swing]:-24px">
            <i class="fa fa-plus" aria-hidden="true"></i>
        </div>
        <div class="triangle triangle-down" data-100p-top="bottom[swing]:-70px" data-75p-top="bottom[swing]:-40px">
            <i class="fa fa-plus" aria-hidden="true"></i>
        </div>
        <div class="overlay"></div>
        <div class="container">
            <div class="text-center">
                <h3 class="standard-subheader bracket" data-100p-top="transform[swing]:translateX(-25px);opacity[swing]:0" data-75p-top="transform[swing]:translateX(0);opacity[swing]:1">fale a gente</h3>
                <h2 class="standard-header" data-100p-top="transform[swing]:translateX(25px);opacity[swing]:0" data-75p-top="transform[swing]:translateX(0);opacity[swing]:1">Ainda tem dúvidas?</h2>
            </div>
            <div class="text-center" data-100p-top="transform[swing]:translateX(-50px);opacity[swing]:0" data-75p-top="transform[swing]:translateX(0);opacity[swing]:1">
                <div class="section-icon"><span><i class="fa fa-envelope"></i></span></div>
            </div>
            <p class="section-description text-center lead">Não hesite em <span class="highlight">nos contatar</span>. Se você tem alguma pergunta referente aos serviços da <span class="highlight"><span class="main-color">P</span>laybo<span class="main-color">X</span></span> ou outro <span class="highlight">serviço</span> você pode utilizar o <span class="highlight">formulário abaixo</span></p>
            <form class="form-container form" method="POST" action="#">
                <div class="overlay"></div>
                <div class="form-content">
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div data-100p-top="transform[swing]:translateX(-25px);opacity[swing]:0" data-75p-top="transform[swing]:translateX(0);opacity[swing]:1">
                                <div class="form-group has-feedback">
                                    <input type="text" class="form-control" placeholder="Seu nome">
                                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                </div>
                                <div class="form-group has-feedback">
                                    <input type="email" class="form-control" placeholder="Seu e-mail">
                                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                                </div>
                                <div class="form-group has-feedback">
                                    <input type="text" class="form-control" placeholder="Seu celular">
                                    <span class="glyphicon glyphicon-phone form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div data-100p-top="transform[swing]:translateX(25px);opacity[swing]:0" data-75p-top="transform[swing]:translateX(0);opacity[swing]:1">
                                <div class="form-group">
                                    <textarea class="form-control" rows="3" cols="40" placeholder="Sua mensagem"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3 col-md-offset-9">
                            <div data-100p-top="transform[swing]:translateX(25px);opacity[swing]:0" data-75p-top="transform[swing]:translateX(0);opacity[swing]:1">
                                <button type="submit" class="btn btn-primary btn-block">Enviar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

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