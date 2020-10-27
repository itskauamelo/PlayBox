<%-- 
    Document   : listarCamiseta.jsp
    Created on : 26/02/2020, 10:51:03
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

        <title>PlayBox - Listar Camiseta</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

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
                        <li class="breadcrumb-item"><a href="listarCamiseta">Listar Camiseta</a></li>
                    </ol>

                    <table id="tabela">
                        <tr>
                            <th class="cabecalho">Id</th>
                            <th class="cabecalho">Nome</th>
                            <th class="cabecalho">descricao</th>
                            <th class="cabecalho">Sexo</th>
                            <th class="cabecalho">Tamanho</th>
                            <th class="cabecalho">Imagem</th>
                            <th class="cabecalho">Situação</th>
                            <th class="cabecalho">Quantidade</th>
                            <th class="cabecalho">Preço</th>
                            <th class="cabecalho">Editar/Excluir</th>
                        </tr>
                        <c:forEach items="${todasCamisetas}" var="c">
                            <tr>
                                <td class="conteudo" align="center">${c.imagem}</td>
                                <td class="conteudo" align="center">${c.id}</td>
                                <td class="conteudo" align="center">${c.nome}</td>
                                <td class="conteudo" align="center">${c.descricao}</td>
                                <td class="conteudo" align="center">${c.sexo}</td>
                                <td class="conteudo" align="center">${c.tamanho}</td>
                                <td class="conteudo" align="center">${c.situacao}</td>
                                <td class="conteudo" align="center">${c.quantidade}</td>
                                <td class="conteudo" align="center">${c.preco}</td>
                                <td class="conteudo" align="center"><a href="iniciarEdicaoCamiseta?id=${c.id}"><img style="height: 25px; width: 25px;"src="images/5594.png" alt=""  id="iconTable"/></a>        <a onclick="return valida()" href="desativarCamiseta?id=${c.id}"><img style="height: 25px; width: 25px;" src="images/5599.png" alt="" id="iconTable"/></a></td>
                            </tr>
                        </c:forEach>
                    </table>

                    <div class="col-md-5">
                        <canvas id="myChart"></canvas>
                    </div>

                    <script>
                        var ctx = document.getElementById('myChart').getContext('2d');
                        var nomes = [];
                        var qtd = [];
                        <c:forEach items="${todasCamisetas}" var="c">

                        nomes.push('${c.nome}');
                        qtd.push('${c.quantidade}');
                        var chart = new Chart(ctx, {

                            type: 'bar',
                            data: {

                                labels: nomes,
                                datasets: [{
                                        label: 'Camisetas',
                                        backgroundColor: 'rgb(000, 150, 200)',
                                        borderColor: 'rgb(000, 000, 10)',
                                        data: qtd
                                    }]
                            },
                            options: {
                                events: ['click'],
                                tooltips: {enabled: false},
                                hover: {mode: null},
                                
                                legend: {
                                    display: true,
                                    labels: {
                                        fontColor: 'rgb(000, 000, 000)'
                                    }
                                },
                                layout: {
                                    padding: {
                                        left: 50,
                                        right: 50,
                                        top: 0,
                                        bottom: 0
                                    }
                                },
                                scales: {
                                    yAxes: [{
                                            ticks: {
                                                beginAtZero: true
                                            }
                                        }]
                                }
                            }
                        });
                        </c:forEach>


                        console.log(nomes);
                        function valida() {
                            var resultado = confirm("Deseja desativar esta camiseta?");
                            if (resultado == true) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    </script>

                    <footer class="sticky-footer">
                        <div class="container my-auto">
                            <div class="copyright text-center my-auto">
                                <span>Copyright © PlayBox 2020</span>
                            </div>
                        </div>
                    </footer>

                </div>


            </div>

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

