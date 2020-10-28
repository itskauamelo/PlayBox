<%--
    Document   : index
    Created on : 31/10/2019, 11:49:05
    Author     : Kaua.Morateli
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Usuario"%>

<html>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Playbox - Dashboard</title>

        <!-- Fonte Custom-->
        <link href="/PlayBox/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Nivel página plugin css-->
        <link href="/PlayBox/admin/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Style Custom p/ template-->
        <link href="/PlayBox/admin/css/sb-admin.css" rel="stylesheet">

        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

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

            <jsp:include page="/admin/navbar.jsp"/>

            <jsp:include page="/admin/sidebar.jsp" />

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active">Início</li>
                    </ol>

                    <style type="text/css">
                        .canvasMaior { 
                            width: 800px;
                            heigth: 400px;
                            float:left;
                            position: relative;
                        }
                        .canvas { 
                            width: 400px;
                            heigth: 400px;
                            float:left;
                        }
                    </style>

                        <div class="canvasMaior">
                            <canvas id="myChartPacotes"></canvas>
                        </div>
                        <div class="canvasMaior">
                            <canvas id="myChartProdutos"></canvas>
                        </div>
                        <br><br>
                        <div class="canvasMaior">
                            <canvas id="myChartGames"></canvas>
                        </div>
                        <div class="canvasMaior">
                            <canvas id="myChartCamisetas"></canvas>
                        </div>

                    <script>
                        var ctx = document.getElementById('myChartPacotes').getContext('2d');
                        var nomes = [];
                        var qtd = [];


                        <c:forEach items="${todosPacotes}" var="p">
                        nomes.push('${p.nome}');
                        qtd.push(${p.quantidade});

                        var chart = new Chart(ctx, {

                            type: 'horizontalBar',
                            data: {
                                labels: nomes,
                                datasets: [{
                                        label: 'Pacotes',
                                        backgroundColor: 'rgb(25, 140, 255)',
                                        borderColor: 'rgb(000, 000, 000)',
                                        data: qtd
                                    }]
                            },
                            options: {
                                events: ['click'],
                                scales: {
                                    xAxes: [{
                                            ticks: {
                                                beginAtZero: true
                                            }
                                        }]
                                }
                            }
                        });
                        </c:forEach>
                    </script>

                    <script>
                        var ctx = document.getElementById('myChartProdutos').getContext('2d');
                        var nomes = [];
                        var qtd = [];


                        <c:forEach items="${todosProdutos}" var="p">
                        nomes.push('${p.nome}');
                        qtd.push(${p.quantidade});

                        var chart = new Chart(ctx, {

                            type: 'horizontalBar',
                            data: {
                                labels: nomes,
                                datasets: [{
                                        label: 'Brindes',
                                        backgroundColor: 'rgb(003, 187, 133)',
                                        borderColor: 'rgb(000, 000, 000)',
                                        data: qtd
                                    }]
                            },
                            options: {
                                responsive: true,
                                events: ['click'],
                                cutoutPercentage: 50,
                                legend: {
                                    //position: 'bottom'
                                },
                                layout: {

                                    padding: {
                                        left: 25,
                                        right: 0,
                                        top: 0,
                                        bottom: 0
                                    }
                                },
                                scales: {
                                    xAxes: [{
                                            ticks: {
                                                beginAtZero: true
                                            }
                                        }]
                                }
                            }
                        });
                        </c:forEach>
                    </script>

                    <script>
                        var ctx = document.getElementById('myChartGames').getContext('2d');
                        var nomes = [];
                        var qtd = [];


                        <c:forEach items="${todosGames}" var="g">
                        nomes.push('${g.nome}');
                        qtd.push(${g.quantidade});

                        var chart = new Chart(ctx, {

                            type: 'bar',
                            data: {
                                labels: nomes,
                                datasets: [{
                                        label: 'Jogos',
                                        backgroundColor: 'rgb(200, 130, 200)',
                                        borderColor: 'rgb(000, 000, 10)',
                                        data: qtd
                                    }]
                            },
                            options: {
                                events: ['click'],
                                cutoutPercentage: 50,
                                legend: {
                                    //position: 'bottom'
                                },
                                /*layout: {
                                 
                                 padding: {
                                 left: 25,
                                 right: 0,
                                 top: 0,
                                 bottom: 0
                                 }
                                 },*/
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
                    </script>

                    <script>
                        var ctx = document.getElementById('myChartCamisetas').getContext('2d');
                        var nomes = [];
                        var qtd = [];


                        <c:forEach items="${todasCamisetas}" var="c">
                        nomes.push('${c.nome}');
                        qtd.push(${c.quantidade});

                        var chart = new Chart(ctx, {

                            type: 'bar',
                            data: {
                                labels: nomes,
                                datasets: [{
                                        label: 'Camisetas',
                                        backgroundColor: 'rgb(255, 102, 051)',
                                        borderColor: 'rgb(000, 000, 000)',
                                        data: qtd
                                    }]
                            },
                            options: {
                                responsive: true,
                                events: ['click'],
                                cutoutPercentage: 50,
                                legend: {
                                    //position: 'bottom'
                                },
                                layout: {

                                    padding: {
                                        left: 50,
                                        right: 0,
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
                    </script> 

                    <!-- DataTables Example -->
                    <!--<div class="card mb-3">
                      <div class="card-header">
                        <i class="fas fa-table"></i>
                        Data Table Example</div>
                      <div class="card-body">
                        <div class="table-responsive">
                          <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            
                            <tfoot>
                              <tr>
                                <th>Name</th>
                                <th>Position</th>
                                <th>Office</th>
                                <th>Age</th>
                                <th>Start date</th>
                                <th>Salary</th>
                              </tr>
                            </tfoot>
            
                          </table>
                        </div>
                      </div>
                    
                      <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                    </div>        </div>
            
            
                  </div>
                    <!-- /.container-fluid -->
                    <jsp:include page="/admin/footer.jsp" />
                </div>
                <!-- /.content-wrapper -->

            </div>
            <!-- /#wrapper -->

            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>

            <jsp:include page="/admin/logoutModal.jsp" />

            <!-- Bootstrap core JavaScript-->
            <script src="/PlayBox/vendor/jquery/jquery.min.js"></script>
            <script src="/PlayBox/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="/PlayBox/vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Page level plugin JavaScript-->
            <script src="/PlayBox/vendor/chart.js/Chart.min.js"></script>
            <script src="/PlayBox/vendor/datatables/jquery.dataTables.js"></script>
            <script src="/PlayBox/vendor/datatables/dataTables.bootstrap4.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="/PlayBox/js/sb-admin.min.js"></script>

            <!-- Demo scripts for this page-->
            <script src="/PlayBox/js/demo/datatables-demo.js"></script>
            <script src="/PlayBox/js/demo/chart-area-demo.js"></script>
            <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js'></script>
            <!--<script src="/PlayBox/admin/js/pizza.js"></script>-->

    </body>

</html>
