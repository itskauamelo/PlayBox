<%-- 
    Document   : login
    Created on : 20/10/2019, 21:55:57
    Author     : Kauã Morateli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login - PlayBox</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.png">
	<!-- Metas especifico p/ mobile -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- Fonte -->
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,300,400,600,700" rel="stylesheet">
	<!-- Fonte Icone -->
	<link rel="stylesheet" href="fonts/ionicons/css/ionicons.css">
	<!-- Fonte Texto -->
	<link rel="stylesheet" href="fonts/font.css">
	<!-- CSS Bootstrap -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<!-- Normal CSS -->
	<link rel="stylesheet" href="css/style.css">
	<!-- Midia CSS (responsivo) -->
	<link rel="stylesheet" href="css/media.css">
    </head>
    <body>
        	<main class="cd-main">
		<section class="cd-section index visible ">
			<div class="cd-content style1">
				<div class="login-box d-md-flex align-items-center">
					<h1 class="title">Olá</h1>
					<h3 class="subtitle">Tenha uma ótima jornada pela frente!</h3>
					<div class="login-form-box">
						<div class="login-form-slider">
							<!-- slide inicio login -->
							<div class="login-slide slide login-style1">
								<form action="ControleAcesso" method="POST">
									<div class="form-group">
										<label class="label">Login</label>
										<input type="text" name="txtLogin" class="form-control">
									</div>
									<div class="form-group">
										<label class="label">Senha</label>
										<input type="password" name="txtPw" class="form-control">
									</div>
									<div class="form-group">
										<div class="custom-control custom-checkbox">
											<input type="checkbox" class="custom-control-input" id="customCheck1">
											<label class="custom-control-label" for="customCheck1">Lembrar-me</label>
										</div>
									</div>
									<div class="form-group">
										<input type="submit" class="submit" value="Entrar" id="btnEntrar" name="acao">
									</div>
								</form>
								<div class="sign-up-txt">
									Não possui conta? <a href="javascript:;" class="sign-up-click">Inscrever-se</a>
								</div>
								<div class="forgot-txt">
									<a href="javascript:;" class="forgot-password-click">Esqueci minha senha</a>
								</div>
								<div class="login-with">
									<h3>Logar com rede social</h3>
									<ul class="social-login-btn">
										<li class="facebook-btn"><a href="#"><i class="ion-social-facebook"></i></a></li>
										<li class="twitter-btn"><a href="#"><i class="ion-social-twitter"></i></a></li>
										<li class="google-btn"><a href="#"><img src="images/google.svg"></a></li>
									</ul>
								</div>
							</div>
							<!-- final slide login -->
							<!-- inicio slide inscreva-se   -->
							<div class="signup-slide slide login-style1">
								<div class="d-flex height-100-percentage">
									<div class="align-self-center width-100-percentage">
										<form>
											<div class="form-group">
												<label class="label">Nome</label>
												<input type="text" class="form-control">
											</div>
											<div class="form-group">
												<label class="label">E-mail</label>
												<input type="email" class="form-control">
											</div>
											<div class="form-group">
												<label class="label">Senha</label>
												<input type="password" class="form-control">
											</div>
											<div class="form-group">
												<label class="label">Confirmar Senha</label>
												<input type="password" class="form-control">
											</div>
											<div class="form-group padding-top-15px">
												<input type="submit" class="submit" value="Enviar">
											</div>
										</form>
										<div class="sign-up-txt">
											Já possui uma conta? <a href="javascript:;" class="login-click">login</a>
										</div>
									</div>
								</div>
							</div>
							<!-- signup slide end -->
							<!-- inicio slide esqueci senha -->
							<div class="forgot-password-slide slide login-style1">
								<div class="d-flex height-100-percentage">
									<div class="align-self-center width-100-percentage">
										<form>
											<div class="form-group">
												<label class="label">Entre com seu e-mail para alterar sua senha</label>
												<input type="email" class="form-control">
											</div>
											<div class="form-group">
												<input type="submit" class="submit" value="Submit">
											</div>
										</form>
										<div class="sign-up-txt">
											Você se lembra da senha? <a href="javascript:;" class="login-click">login</a>
										</div>
									</div>
								</div>
							</div>
							<!-- begin slide esqueci senha -->
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
	<div id="cd-loading-bar" data-scale="1"></div>
	<!-- Arquivos JS -->
	<script src="js/modernizr.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/popper.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script src="js/velocity.min.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
    </body>
</html>

