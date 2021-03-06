<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Model.Cliente"%>
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
                <a class="navbar-brand" href="index.jsp" title="PlayBoX">
                    <i class="fa fa-gamepad" aria-hidden="true"></i><span class="main-color">P</span>laybo<span class="main-color">X</span>
                </a><!-- Logo final -->
            </div>
            <!-- Menu principal -->
            <div class="collapse navbar-collapse" id="main-menu">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="index.jsp">
                            <span class="main-link">Inicio</span>
                            <span class="additional-info-link bracket">
                                inicio da jornada
                            </span>
                        </a>
                    </li>
                    <li>
                        <a href="index.jsp#about">
                            <span class="main-link">Serviço</span>
                            <span class="additional-info-link bracket">
                                como funciona
                            </span>
                        </a>
                    </li>
                    <li>
                        <a href="index.jsp#plano">
                            <span class="main-link">Planos </span>
                            <span class="additional-info-link bracket">
                                nossos planos
                            </span>
                        </a>
                    </li>
                    <li>
                        <a href="index.jsp#mandamensagem">
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
                <h2 class="digit-header">Inscreva-se</h2>
                <h3 class="signature-header"><small>Entre<strong> Gamers</strong></small></h3>
            </div>
            <div class="single-page-header-bg"></div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-cadastro col-md-8">
                    <form onsubmit='return confirmacao()' action="cadastrarCliente" method="POST"> 
                    <h2 class="post-item-header"><a title="Inscrição">Inscrição</a></h2>
                    <br>
                    <label>CPF</label>
                    <input type="text" id="txtCpf" name="txtCpf" maxlength="14" OnKeyPress="formatar('###.###.###-##', this)" class="form-control"><br>
                    <label>Nome Completo</label>
                    <input type="text" id="txtNomecompleto" name="txtNomecompleto" class="form-control"><br>
                    <label>Data de Nascimento</label>
                    <input type="date" id="txtData" name="txtData" class="form-control"><br>
                    <label>Genero</label>
                    <select id="optGenero" name="optGenero" class="form-control" style="color: black;">
                        <option>Selecione genero</option>                  
                        <option value="F">Feminino</option>
                        <option value="M">Masculino</option>
                        <option value="O">Outros</option>
                    </select><br>
                    <label>Email</label>
                    <input type="email" id="txtEmail" name="txtEmail" class="form-control"><br>
                    <label>Senha</label>
                    <input type="password" id="txtSenha" name="txtSenha" class="form-control"><br>
                    <label>Confirmar senha</label>
                    <input type="password" class="form-control"><br>
                    <label>Celular</label>
                    <input type="text" id="txtCelular" name="txtCelular" maxlength="13" OnKeyPress="formatar('##-#####-####', this)" class="form-control"><br>
                            <div class="centrocadastro">
        <button class="btn btn-primary" title="Criar Conta" id="btngavar" type="submit" name="gravar" value="Gravar"><i class="fa fa-plus" aria-hidden="true"></i> Criar Conta</a>     
        </div>
                    </form>
                    
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
    
                               <script>
                        function confirmacao() {
                            alert("Cadastro efetuado!Te enviamos um e-mail para ativar seu cadastro");
                        }
                    </script>

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