<%@page import="Model.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Model.Cliente"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


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
                <h2 class="digit-header">Politica de Assinatura PlayBox</h2>
                <h3 class="signature-header"><small>Essa é nossa politica de aquisição de assinatura, onde tem o objetivo de informar o cliente sobre a aquisição do serviço de assinatura mensal.</small></h3>
            </div>
            <div class="single-page-header-bg"></div>
        </div>
        <div class="container">
            <h1 style="text-align: center"> POLITICA DE ASSINATURA PLAYBOX </h1>
                                <h3 style="text-align: justify; line-height: 2.1">
                                    •	Os clientes que optam por adquirir a assinatura mensal, serão cobrados mensalmente no 15º dia do mês de acordo com o valor da assinatura escolhida;<br>
                                    •	As caixas começam a ser enviadas no 17º dia do mês e possuem o prazo de entrega de até 7 dias (Envios são feitos via Sedex);<br>
                                    •	Os itens que compõem a caixa são selecionados de acordo com o preenchimento do Formulário de Preferência, onde a equipe de P&D realiza o fechamento do relatório para identificar os maiores indicadores de escolha dos Clientes, a fim de agradar todos os gostos;<br>
                                    •	É possível realizar a compra avulsa das caixas, sem compromisso de realizar a assinatura, assim o cliente tem a liberdade de adquirir somente a caixa que gostar do tema;<br>
                                    •	Para trocar a assinatura, o cliente deve acessar o Portal do Cliente, consultar sua assinatura e troca-la para o serviço de sua escolha (caso possua um pedido em aberto e deseja trocar a assinatura do mesmo, o pedido anterior é automaticamente cancelado, gerando um novo, com nova numeração)<br>
                                    • 	O solicitante poderá encaminhar suas dúvidas, solicitações e reclamações ao Serviço de Atendimento ao Consumidor (SAC) da PLAYBOX cujo horário de funcionamento se dará em dias úteis, das 10h00 às 17h00, pelos seguintes canais de e-mail: playbox.suporte@gmail.com<br>
                                    • 	Capacidade para Aceitar os Termos e Condições: o solicitante afirma ser maior de 18 anos ou ser menor emancipado, ou estar de posse de autorização legal dos pais ou de tutores, e plenamente capaz de consentir com os termos, condições, obrigações, afirmações, representações e garantias descritas neste Termo de Aceite e documentos incorporados.<br>
                                    • 	Disposição Finais Informações cadastrais: o solicitante autoriza a PLAYBOX a divulgar as informações constantes do seu cadastro às autoridades públicas competentes sempre que estas as solicitarem formalmente, nos termos da legislação aplicável.<br>
                                </h3>

            <div class="row">
                
                <div class="col-cadastro col-md-8">

                                 
                    <br>
                   
                    <br>
                 
                    <br>         
                </div>
            </div>
        </div>
        <div class="centrocadastro">    <a class="btn btn-primary" href="inicio"><i class="fa fa-close" aria-hidden="true"></i> Voltar</a></button>
        </div>
    </div>
                <script>
                    function confirmacao() {
                        alert("Confirmação politica SESP");
                    }
                </script>
        
        </div>
    </div>
</form>

    
    <!-- Footer -->
   

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


    <script type="text/javascript">
        $(document).ready(function () {
           $('.jogo').click(function () {
               var text = "";
               $('.jogo:checked').each(function () {
                   text += $(this).val() + ',';
               });
           });
        });

    </script>

    <script>
        var limit = 1;
        $('input.jogo').on('change', function(evt) {
        if($(this).siblings(':checked').length >= limit) {
        this.checked = false;
   }
});
    </script>


</body>
</html>