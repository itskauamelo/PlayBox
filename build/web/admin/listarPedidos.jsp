<%-- 
    Document   : listar.jsp
    Created on : 29/10/2019, 10:51:03
    Author     : Kaua.Morateli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>PlayBox - Alterar Status Pedido</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

            <a class="navbar-brand mr-1" href="admin/index.html">PlayBox</a>

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

            <jsp:include page="/admin/navbar.jsp" />

            <jsp:include page="/admin/sidebar.jsp" />

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="admin/usuario.html">Cadastrar Usuário</a></li>
                        <li class="breadcrumb-item"><a href="listarUsuario">Listar Usuário</a></li>
                    </ol>

                    <table id="tabela">
                        <tr>
                            <th class="cabecalho">Id</th>
                            <th class="cabecalho">Data</th>
                            <th class="cabecalho">Valor</th>
                            <th class="cabecalho">Status atual</th>
                            <th class="cabecalho">Alterar</th>
                        </tr>

                        <c:forEach items="${todasComprasPagamento}" var="com">

                            <c:choose>
                                <c:when test="${com.status == '1'}">

                                    <c:set var = "statusNome" scope = "session" value = "${'Aguardando baixa no pagamento'}"/>   
                                    <tr style="position:center;">
                                        <td class="conteudo">#<a href="#" style="font-weight: bold">${com.id}</div></a></td>
                                    <a><td class="conteudo">Realizado em <fmt:formatDate pattern="dd/MM/yyyy" value="${com.data}" /></td></a>
                                    <a><td class="conteudo" style="text-align:right;"><h96 style="font-weight: bold">R$ ${com.total}0</h96></td></a>
                                    <a><td class="conteudo">${statusNome}</td></a>
                                    <a>
                                        <td>
                                            <form onsubmit="return valida()" id="formulario" action="aprovarPagamento?id=${com.id}" method="POST">
                                                <button class="btn btn-primary btn-block" style="background-color:green" value="Aprovar" type="submit"/>Aprovar</button>
                                            </form>
                                        </td>
                                    </a>
                                    </tr>                                  
                                </c:when>

                                <c:when test="${com.status == '2'}">

                                    <c:set var = "statusNome" scope = "session" value = "${'Separando pedido'}"/>
                                    <tr style="position:center;">
                                        <td class="conteudo">#<a href="#" style="font-weight: bold">${com.id}</div></a></td>
                                    <a><td class="conteudo">Realizado em <fmt:formatDate pattern="dd/MM/yyyy" value="${com.data}" /></td></a>
                                    <a><td class="conteudo" style="text-align:right;"><h96 style="font-weight: bold">R$ ${com.total}0</h96></td></a>
                                    <a><td class="conteudo">${statusNome}</td></a>
                                    <td class="conteudo"> <a class="btn btn-primary btn-block" id="btngravar" href="iniciarAltStatus?id=${com.id}"> Alterar </a></td>                              
                                    </tr>
                                </c:when>

                                <c:when test="${com.status == '3'}">

                                    <c:set var = "statusNome" scope = "session" value = "${'Pedido despachado p/ transportadora'}"/>
                                    <tr style="position:center;">
                                        <td class="conteudo">#<a href="#" style="font-weight: bold">${com.id}</div></a></td>
                                    <a><td class="conteudo">Realizado em <fmt:formatDate pattern="dd/MM/yyyy" value="${com.data}" /></td></a>
                                    <a><td class="conteudo" style="text-align:right;"><h96 style="font-weight: bold">R$ ${com.total}0</h96></td></a>
                                    <a><td class="conteudo">${statusNome}</td></a>
                                    <td class="conteudo"> <a class="btn btn-primary btn-block" id="btngravar" href="iniciarAltStatus?id=${com.id}"> Alterar </a></td>                              
                                    </tr>
                                </c:when>

                                <c:when test="${com.status == '4'}">

                                    <c:set var = "statusNome" scope = "session" value = "${'Pedido em transporte'}"/>
                                    <tr style="position:center;">
                                        <td class="conteudo">#<a href="#" style="font-weight: bold">${com.id}</div></a></td>
                                    <a><td class="conteudo">Realizado em <fmt:formatDate pattern="dd/MM/yyyy" value="${com.data}" /></td></a>
                                    <a><td class="conteudo" style="text-align:right;"><h96 style="font-weight: bold">R$ ${com.total}0</h96></td></a>
                                    <a><td class="conteudo">${statusNome}</td></a>
                                    <td class="conteudo"> <a class="btn btn-primary btn-block" id="btngravar" href="iniciarAltStatus?id=${com.id}"> Alterar </a></td>                              
                                    </tr>
                                </c:when>

                                <c:otherwise>

                                    <c:set var = "statusNome" scope = "session" value = "${'Pedido entregue'}"/>
                                    <tr style="position:center;">
                                        <td class="conteudo">#<a href="#" style="font-weight: bold">${com.id}</div></a></td>
                                    <a><td class="conteudo">Realizado em <fmt:formatDate pattern="dd/MM/yyyy" value="${com.data}" /></td></a>
                                    <a><td class="conteudo" style="text-align:right;"><h96 style="font-weight: bold">R$ ${com.total}0</h96></td></a>
                                    <a><td class="conteudo">${statusNome}</td></a>   
                                    <td><img src="images/Entregue.png">Finalizado</td>
                                    <img href="images/Entregue.png">
                                    </tr>
                                </c:otherwise>

                            </c:choose>

                        </c:forEach>

                        <script>
                            //----------------Valida Formulario-----------------
                            function valida() {
                                var resultado = confirm("Deseja aprovar o pagamento?");
                                if (resultado == true) {
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        </script>           
                    </table>
                   
                    <!-- Area Chart Example-->
                    <!-- /.container-fluid -->
                    <br><br><br>

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

