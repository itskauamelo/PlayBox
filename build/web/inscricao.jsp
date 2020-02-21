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
                <h2 class="digit-header">Inscreva-se</h2>
                <h3 class="signature-header"><small>Entre<strong> Gamers</strong></small></h3>
            </div>
            <div class="single-page-header-bg"></div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-cadastro col-md-8">
                    <form action="cadastrarCliente" method="POST"> 
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
                </div>
                <div class="col-cadastro col-md-8">
                    <div class="standard-box">
                        <h3 class="post-item-header">Endereço</h3>
                        <br>
                        <label>Identificação do endereço:</label>
                        <input type="text" id="txtIdEnd" name="txtIdEnd" class="form-control" placeholder="Casa, trabalho, ..."><br>
                        <label>Nome do destinatário</label>
                        <input type="text" id="txtNomedestinatario" name="txtNomedestinatario"class="form-control" ><br>
                        <label>CEP</label>
                        <input type="text" id="txtCep" name="txtCep" maxlength="9" OnKeyPress="formatar('#####-###', this)" class="form-control"><br>
                        <label>Endereço</label>
                        <input type="text" id="txtEndereco" name="txtEndereco" class="form-control"><br>
                        <label>Numero</label>
                        <input type="text" id="txtNumero" name="txtNumero" class="form-control"><br>
                        <label>Complemento</label>
                        <input type="text" id="txtComplemento" name="txtComplemento" class="form-control"><br>
                        <label>Referência</label>
                        <input type="text" id="txtReferencia" name="txtReferencia" class="form-control"><br>
                        <label>Bairro</label>
                        <input type="text" id="txtBairro" name="txtBairro" class="form-control"><br>
                        <label>Cidade</label>
                        <input type="text" id="txtCidade" name="txtCidade" class="form-control"><br>
                        <label>Estado</label>
                        <select id="optEstado" name="optEstado" class="form-control" style="color: black;">
                            <option>Selecione um estado</option>                  
                            <option value="AC">Acre</option>
                            <option value="AL">Alagoas</option>
                            <option value="AP">Amapá</option>
                            <option value="AM">Amazonas</option>
                            <option value="BA">Bahia</option>
                            <option value="CE">Ceará</option>
                            <option value="DF">Distrito Federal</option>
                            <option value="ES">Espírito Santo</option>
                            <option value="GO">Goiás</option>
                            <option value="MA">Maranhão</option>
                            <option value="MT">Mato Grosso</option>
                            <option value="MS">Mato Grosso do Sul</option>
                            <option value="MG">Minas Gerais</option>
                            <option value="PA">Pará</option>
                            <option value="PB">Paraíba</option>
                            <option value="PR">Paraná</option>
                            <option value="PE">Pernambuco</option>
                            <option value="PI">Piauí</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="RN">Rio Grande do Norte</option>
                            <option value="RS">Rio Grande do Sul</option>
                            <option value="RO">Rondônia</option>
                            <option value="RR">Roraima</option>
                            <option value="SC">Santa Catarina</option>
                            <option value="SP">São Paulo</option>
                            <option value="SE">Sergipe</option>
                            <option value="TO">Tocantins</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="centrocadastro">
        <button class="btn btn-primary" title="Criar Conta" id="btngavar" type="submit" name="gravar" value="Gravar"><i class="fa fa-plus" aria-hidden="true"></i> Criar Conta</a>     
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