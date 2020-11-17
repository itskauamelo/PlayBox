<%-- 
    Document   : usuario
    Created on : 07/11/2019, 12:26:05
    Author     : Kaua.Morateli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Usuario"%>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>PlayBox - Usuário</title>

        <!-- Custom fonts for this template-->
        <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="../vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="../css/sb-admin.css" rel="stylesheet">

        <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>

    </head>

    <body id="page-top">

        <%
            Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");

            if (usuario != null) {
        %>

        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

            <a class="navbar-brand mr-1" href="index.jsp">PlayBox</a>

            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

            <!-- Navbar Search -->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <h8>Bem-vindo, <%= usuario.getLogin()%> !</h8>
                        <%}%>
                    <div class="input-group-append">
                    </div>
                </div>
            </form>

            <jsp:include page="/admin/navbar.jsp" />

            <jsp:include page="/admin/sidebar.jsp" />

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="usuario.html">Cadastrar Usuário</a></li>
                        <li class="breadcrumb-item"><a href="listarUsuario">Listar Usuário</a></li>
                    </ol>
                    <div class="card-body">
                        <form onsubmit="return valida()" method="POST" action="../cadastrarUsuario">
                            <div class="form-group">
                                <div class="form-row">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="text" id="nome" name="nome" class="form-control" placeholder="Nome Completo" required="required">
                                    <label for="nome">Nome Completo</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="text" id="login" name="login" class="form-control" placeholder="Login" required="required">
                                    <label for="login">Login</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col-md-6">
                                        <div class="form-label-group">
                                            <input type="password" id="pw" name="pw" class="form-control" placeholder="Senha" required="required">
                                            <label for="pw">Senha</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-label-group">
                                            <input type="password" id="confirmPassword" class="form-control" placeholder="Confirmar senha" required="required">
                                            <label for="confirmPassword">Confirmar senha</label>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <select name="perfil" id="perfil" class="custom-select custom-select-sm form-control form-control-sm" required>
                                        <option value="" disabled selected>Selecione um Perfil...</option>
                                        <option value="ADMINISTRADOR">ADMINISTRADOR</option>
                                        <option value="FUNCIONARIO">FUNCIONARIO</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="form-label-group">
                                    <select name="situacao" id="situacao" class="custom-select custom-select-sm form-control form-control-sm" required>
                                        <option value="" disabled selected>Selecione uma situação...</option>
                                        <option value="ATIVO">ATIVO</option>
                                        <option value="INATIVO">INATIVO</option>
                                    </select>
                                </div>
                            </div>


                            <button class="btn btn-primary btn-block" id="btngavar" type="submit" name="gravar" value="Gravar">Registrar</button>

                        </form>
                        
                        <script>
                            function valida() {
                                var resultado = confirm("Deseja cadastrar novo usuario?");
                                if (resultado == true) {
                                    return true;
                                }else {                                   
                                    return false;
                                }
                            }
                        </script>
                        
                    </div>
                    <!-- Area Chart Example-->
                    <!-- /.container-fluid -->

                    <!-- Sticky Footer -->
                    <footer class="sticky-footer">
                        <div class="container my-auto">
                            <div class="copyright text-center my-auto">
                                <span>Copyright © PlayBox 2019</span>
                            </div>
                        </div>
                    </footer>

                </div>
                <!-- /.content-wrapper -->

            </div>
            <!-- /#wrapper -->

            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>

            <!-- Logout Modal-->
            <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                            <a class="btn btn-primary" href="login.html">Logout</a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Bootstrap core JavaScript-->
            <script src="../vendor/jquery/jquery.min.js"></script>
            <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Page level plugin JavaScript-->
            <script src="../vendor/chart.js/Chart.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="../js/sb-admin.min.js"></script>

            <!-- Demo scripts for this page-->
            <script src="../js/demo/chart-area-demo.js"></script>
            <script src="../js/demo/chart-bar-demo.js"></script>
            <script src="../js/demo/chart-pie-demo.js"></script>

    </body>

</html>
