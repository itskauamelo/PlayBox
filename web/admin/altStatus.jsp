<%-- 
    Document   : altStatus
    Created on : 10/05/2020, 20:10:53
    Author     : Kaua.Morateli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>PlayBoX - Alterar Status do Pedido</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

            <a class="navbar-brand mr-1" href="index.html">PlayBox</a>

            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

            <!-- Navbar Search -->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button">
                            <i class="fas fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>

            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown no-arrow mx-1">
                    <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-bell fa-fw"></i>
                        <span class="badge badge-danger">9+</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item dropdown no-arrow mx-1">
                    <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-envelope fa-fw"></i>
                        <span class="badge badge-danger">7</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-user-circle fa-fw"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#">Settings</a>
                        <a class="dropdown-item" href="#">Activity Log</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
                    </div>
                </li>
            </ul>

        </nav>

        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="index.html">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Home</span>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Controles</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <h6 class="dropdown-header">Login Screens:</h6>
                        <a class="dropdown-item" href="login.html">Login</a>
                        <a class="dropdown-item" href="register.html">Register</a>
                        <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
                        <div class="dropdown-divider"></div>
                        <h6 class="dropdown-header">Other Pages:</h6>
                        <a class="dropdown-item" href="404.html">404 Page</a>
                        <a class="dropdown-item" href="blank.html">Blank Page</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="usuario.html">
                        <i class="fas fa-fw fa-user"></i>
                        <span>Usuários</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="produtos.html">
                        <i class="fas fa-fw fa-bone"></i>
                        <span>Produtos</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="produtos.html">
                        <i class="fas fa-fw fa-gift"></i>
                        <span>Pacotes</span></a>
                </li>
            </ul>

            <c:choose>
                <c:when test="${compra.status == '1'}">

                    <c:set var = "statusNome" scope = "session" value = "${'Aguardando baixa no pagamento'}"/>

                </c:when>

                <c:when test="${compra.status == '2'}">

                    <c:set var = "statusNome" scope = "session" value = "${'Separando pedido'}"/>
                    <div id="content-wrapper">

                        <div class="container-fluid">

                            <!-- Breadcrumbs-->
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="usuario.html">Cadastrar Produto</a></li>
                                <li class="breadcrumb-item"><a href="listarProdutos">Listar Produto</a></li>
                            </ol>
                            <div class="card-body" >
                                <form method="POST" action="alterarStatus">
                                    <div class="form-group">
                                        <div class="form-row">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <input type="text" id="id" name="id" class="form-control" placeholder="Id" required="required" value="${compra.id}" readonly>
                                            <label for="id">Id</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <br>
                                            <select name="optStatus" id="optStatus">
                                                <option disabled selected>Alterar para:</option>
                                                <option value="3">Pedido despachado p/ transportadora</option>
                                                <option value="4">Pedido em transporte</option>
                                                <option value="5">Pedido entregue</option>
                                            </select>
                                        </div>
                                    </div><br>
                                    <button class="btn btn-primary btn-block" id="btngravar" type="submit" name="confirmar" value="Gravar">Alterar Status</button>
                                </form>
                            </div>
                            <br>
                            <!-- Sticky Footer -->
                            <footer class="sticky-footer">
                                <div class="container my-auto">
                                    <div class="copyright text-center my-auto">
                                        <span>Copyright © PlayBox 2020</span>
                                    </div>
                                </div>
                            </footer>

                        </div>
                        <!-- /.content-wrapper -->
                    </div>
                    <a class="scroll-to-top rounded" href="#page-top">
                        <i class="fas fa-angle-up"></i>
                    </a>
                </c:when>

                <c:when test="${compra.status == '3'}">

                    <c:set var = "statusNome" scope = "session" value = "${'Pedido despachado p/ transportadora'}"/>
                    <div id="content-wrapper">

                        <div class="container-fluid">

                            <!-- Breadcrumbs-->
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="usuario.html">Cadastrar Produto</a></li>
                                <li class="breadcrumb-item"><a href="listarProdutos">Listar Produto</a></li>
                            </ol>
                            <div class="card-body" >
                                <form method="POST" action="alterarStatus">
                                    <div class="form-group">
                                        <div class="form-row">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <input type="text" id="id" name="id" class="form-control" placeholder="Id" required="required" value="${compra.id}" readonly>
                                            <label for="id">Id</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <br>
                                            <select name="optStatus" id="optStatus">
                                                <option disabled selected>Alterar para:</option>
                                                <option value="4">Pedido em transporte</option>
                                                <option value="5">Pedido entregue</option>
                                            </select>
                                        </div>
                                    </div><br>
                                    <button class="btn btn-primary btn-block" id="btngravar" type="submit" name="confirmar" value="Gravar">Alterar Status</button>
                                </form>
                            </div>
                            <br>
                            <!-- Sticky Footer -->
                            <footer class="sticky-footer">
                                <div class="container my-auto">
                                    <div class="copyright text-center my-auto">
                                        <span>Copyright © PlayBox 2020</span>
                                    </div>
                                </div>
                            </footer>

                        </div>
                        <!-- /.content-wrapper -->
                    </div>
                    <a class="scroll-to-top rounded" href="#page-top">
                        <i class="fas fa-angle-up"></i>
                    </a>
                </c:when>

                <c:when test="${compra.status == '4'}">

                    <c:set var = "statusNome" scope = "session" value = "${'Pedido em transporte'}"/>
                    <div id="content-wrapper">

                        <div class="container-fluid">

                            <!-- Breadcrumbs-->
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="usuario.html">Cadastrar Produto</a></li>
                                <li class="breadcrumb-item"><a href="listarProdutos">Listar Produto</a></li>
                            </ol>
                            <div class="card-body" >
                                <form method="POST" action="alterarStatus">
                                    <div class="form-group">
                                        <div class="form-row">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <input type="text" id="id" name="id" class="form-control" placeholder="Id" required="required" value="${compra.id}" readonly>
                                            <label for="id">Id</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <br>
                                            <select name="optStatus" id="optStatus">
                                                <option disabled selected>Alterar para:</option>
                                                <option value="5">Pedido entregue</option>
                                            </select>
                                        </div>
                                    </div><br>
                                    <button class="btn btn-primary btn-block" id="btngravar" type="submit" name="confirmar" value="Gravar">Alterar Status</button>
                                </form>
                            </div>
                            <br>
                            <!-- Sticky Footer -->
                            <footer class="sticky-footer">
                                <div class="container my-auto">
                                    <div class="copyright text-center my-auto">
                                        <span>Copyright © PlayBox 2020</span>
                                    </div>
                                </div>
                            </footer>

                        </div>
                        <!-- /.content-wrapper -->
                    </div>
                    <a class="scroll-to-top rounded" href="#page-top">
                        <i class="fas fa-angle-up"></i>
                    </a>
                </c:when>

                <c:otherwise>

                    <c:set var = "statusNome" scope = "session" value = "${'Pedido entregue'}"/>

                </c:otherwise>

            </c:choose>


            <!-- /#wrapper -->

            <!-- Scroll to Top Button-->


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
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Page level plugin JavaScript-->
            <script src="vendor/chart.js/Chart.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="js/sb-admin.min.js"></script>

            <!-- Demo scripts for this page-->
            <script src="js/demo/chart-area-demo.js"></script>
            <script src="js/demo/chart-bar-demo.js"></script>
            <script src="js/demo/chart-pie-demo.js"></script>

    </body>

</html>