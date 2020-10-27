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
                    <h2 class="digit-header">Formulário de Cancelamento :(</h2>
                    <h3 class="signature-header"><small>Ao Preencher nosso formulário você<strong> Gamer</strong> nós ajuda a sempre melhorar nossos produtos</small></h3>
                </div>
                <div class="single-page-header-bg"></div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-cadastro col-md-8">
                        <form onsubmit='return confirmacao()' action="cadastrarPesquisaCancelamento" method="POST">                
                            <p class="section-description text-center lead">Antes de finalizarmos a sua assinatura gostaríamos de saber o seu <span class="highlight">sentimento</span>.
                                de prazer ou decepção com os nossos produtos para que assim nós da <span class="highlight"><span class="main-color">P</span>laybo<span class="main-color">X</span><span class="highlight"></span></span>possamos sempre melhorar o nosso <strong> desempenho </strong>! <br>(Lembrando que o preenchimento abaixo nao é obrigatório e voce pode pular essa etapa clicando em PULAR)</p>
                            <br>
                            <label>1- Qual a probabilidade de você indicar nossos serviços para um amigo(a)?</label><br>

                            <div class="rate">
                                <input type="radio" id="star15" name="rate1" value="5" />
                                <label for="star15" title="text">5 stars</label>
                                <input type="radio" id="star14" name="rate1" value="4" />
                                <label for="star14" title="text">4 stars</label>
                                <input type="radio" id="star13" name="rate1" value="3" />
                                <label for="star13" title="text">3 stars</label>
                                <input type="radio" id="star12" name="rate1" value="2" />
                                <label for="star12" title="text">2 stars</label>
                                <input type="radio" id="star11" name="rate1" value="1" />
                                <label for="star11" title="text">1 star</label>
                            </div>
                            <br><br><br>
                            <label>2- Como você avalia a qualidade do atendimento ao cliente realizado pela gente?</label><br>
                            <div class="rate">
                                <input type="radio" id="star25" name="rate2" value="5" />
                                <label for="star25" title="text">5 stars</label>
                                <input type="radio" id="star24" name="rate2" value="4" />
                                <label for="star24" title="text">4 stars</label>
                                <input type="radio" id="star23" name="rate2" value="3" />
                                <label for="star23" title="text">3 stars</label>
                                <input type="radio" id="star22" name="rate2" value="2" />
                                <label for="star22" title="text">2 stars</label>
                                <input type="radio" id="star21" name="rate2" value="1" />
                                <label for="star21" title="text">1 star</label>
                            </div><br>
                            <br><br>
                            <label>3- Qual seu grau de satisfação com os produtos recebidos?</label><br>
                            <div class="rate">
                                <input type="radio" id="star35" name="rate3" value="5" />
                                <label for="star35" title="text">5 stars</label>
                                <input type="radio" id="star34" name="rate3" value="4" />
                                <label for="star34" title="text">4 stars</label>
                                <input type="radio" id="star33" name="rate3" value="3" />
                                <label for="star33" title="text">3 stars</label>
                                <input type="radio" id="star32" name="rate3" value="2" />
                                <label for="star32" title="text">2 stars</label>
                                <input type="radio" id="star31" name="rate3" value="1" />
                                <label for="star31" title="text">1 star</label>
                            </div>          <br><br>
                            <br>
                            <label>4- Referente a entrega (prazo, embalagem) qual nota voce daria?</label><br>
                            <div class="rate">
                                <input type="radio" id="star45" name="rate4" value="5" />
                                <label for="star45" title="text">5 stars</label>
                                <input type="radio" id="star44" name="rate4" value="4" />
                                <label for="star44" title="text">4 stars</label>
                                <input type="radio" id="star43" name="rate4" value="3" />
                                <label for="star43" title="text">3 stars</label>
                                <input type="radio" id="star42" name="rate4" value="2" />
                                <label for="star42" title="text">2 stars</label>
                                <input type="radio" id="star41" name="rate4" value="1" />
                                <label for="star41" title="text">1 star</label>
                            </div>           
                            <br><br><br>
                            <label>5- Como você classifica sua relação conosco durante nosso periodo juntos?</label><br>
                            <div class="rate">
                                <input type="radio" id="star55" name="rate5" value="5" />
                                <label for="star55" title="text">5 stars</label>
                                <input type="radio" id="star54" name="rate5" value="4" />
                                <label for="star54" title="text">4 stars</label>
                                <input type="radio" id="star53" name="rate5" value="3" />
                                <label for="star53" title="text">3 stars</label>
                                <input type="radio" id="star52" name="rate5" value="2" />
                                <label for="star52" title="text">2 stars</label>
                                <input type="radio" id="star51" name="rate5" value="1" />
                                <label for="star51" title="text">1 star</label>
                            </div>           
                            <br>

                            <br>         
                            </div>
                            </div>
                            </div>
                            <div class="centrocadastro">
                                <button class="btn btn-primary" title="Enviar pesquisa" id="btngavar" type="submit" name="gravar" value="Gravar"><i class="fa fa-plus" aria-hidden="true"></i> Enviar pesquisa</a></button> <br> <br> 
                                </form><a class="btn btn-primary" href="inicio"><i class="fa fa-close" aria-hidden="true"></i> Pular</a></button>
                            </div>
                    </div>
                    <script>
                        function confirmacao() {
                            alert("Obrigado pelo envio da pesquisa");
                        }
                    </script>

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
                        $('input.jogo').on('change', function (evt) {
                            if ($(this).siblings(':checked').length >= limit) {
                                this.checked = false;
                            }
                        });
                    </script>


                    </body>
                    </html>