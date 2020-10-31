<%-- 
    Document   : relatorioQuantClientes
    Created on : 28/10/2020, 21:30:46
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

        <title>PlayBox - Relatório de Vendas</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

        <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
        
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
                    <h1>Relatório de Vendas</h1><br>
                    <!--<label>Período</label><br>-->
                    <!--<form method="POST">
                    <h6>Data Inicial: <input type="date"><p> Data Final:  <input type="date"><br><br></h6>
                        <button class="btn btn-primary btn-medio" type="submit">Emitir</button>
                    </form>-->
                    <!--
                                        <div class="row" >  
                                            <div class="col-md-1">
                                                <select color="green" id="selectfilter" class="custom-select custom-select-sm form-control form-control-sm">
                                                    <option value="" disabled selected>Filtrar Por</option>
                                                    <option value="1">Data</option>
                                                    <option value="2">Nome</option>
                                                </select>
                                            </div>
                    
                                            <div id="filtrodata" class="row">
                                                <div class="col-md-6">
                                                    <h4>De</h4>
                                                    <input type="date" class="form-control" id="datefilterfrom" data-date-split-input="true">
                                                </div>
                                                <div class="col-md-6">
                                                    <h4>Até</h4>
                                                    <input type="date" class="form-control" id="datefilterto" data-date-split-input="true">
                                                </div>
                                            </div>
                    
                                            <div id="filtronome" class="col-md-3">
                                                <h4>Nome</h4>
                                                <input id="txtnome" type="text" class="form-control">
                                            </div>
                    
                                        </div>
                    -->
                    <button onclick="esconder()">Esconder/ Tabela</button>
                    <br>
                    <br>
                    <div id="myDIV">
                        <table id="tabela" class="tabela" border="1" style="float:left">
                        <thead>
                            <tr>
                                <th class="cabecalho">Quantidade</th>
                                <th class="cabecalho">Mes/Ano</th>
                            </tr>
                        </thead>

                    </table>
                    </div>
                    
                    
                    <script>
                          function esconder() {
                          var x = document.getElementById("myDIV");
                          if (x.style.display === "none") {
                            x.style.display = "block";
                          } else {
                            x.style.display = "none";
                          }
                        }
                    </script>

                    <style type="text/css">
                        .canvasMaior { 
                            width: 800px;
                            heigth: 400px;
                            float:left;
                            position: relative;
                        }
                        .canvas { 
                            width: 600px;
                            heigth: 600px;
                            float:left;
                        }
                    </style>

                    <div class="canvasMaior">
                        <canvas id="myChartVendas2020"></canvas>
                        <canvas id="myChartVendas2019"></canvas>
                    </div>
                    <br>
                    <div class="canvas">
                        <h3>                      Qtd Vendas por Status</h3><br>
                        <canvas id="myChartVendasPie"></canvas><br>
                        <h3>                      Qtd Vendas por Assinatura</h3><br>
                        <canvas id="myChartAssinaturaPie"></canvas>
                    </div>

                    <script>
                        var ctx1 = document.getElementById('myChartVendas2020').getContext('2d');
                        var mesano1 = [];
                        var qtd1 = [];


                        <c:forEach items="${periodoVendas2020}" var="v1">
                        mesano1.push('${v1.mesano}');
                        qtd1.push(${v1.quantidade}); 

                        var chart1 = new Chart(ctx1, {

                            type: 'line',
                            data: {
                                labels: mesano1,
                                datasets: [{
                                        label: 'Ano 2020',
                                        borderColor: 'rgb(25, 140, 255)',
                                        data: qtd1
                                    },
                                        ]
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
                        var ctx2 = document.getElementById('myChartVendas2019').getContext('2d');
                        var mesano2 = [];
                        var qtd2 = [];


                        <c:forEach items="${periodoVendas2019}" var="v2">
                        mesano2.push('${v2.mesano}');
                        qtd2.push(${v2.quantidade}); 

                        var chart2 = new Chart(ctx2, {

                            type: 'line',
                            data: {
                                labels: mesano2,
                                datasets: [{
                                        label: 'Ano 2019',
                                        borderColor: 'rgb(255, 103, 135)',
                                        data: qtd2
                                    },
                                        ]
                            },
                            options: {
                                events: ['click'],
                                scales: {
                                    yAxes: [{
                                            ticks: {
                                                beginAtZero: true,
                                                callback: function (value) {
                                                    if (Number.isInteger(value)) {
                                                        return value;
                                                    }
                                                },
                                                stepSize: 1
                                            }
                                        }]
                                }
                            }
                        });
                        </c:forEach>
                    </script>
                    
                                        
                    <script>
                        var ctx3 = document.getElementById('myChartVendasPie').getContext('2d');
                        var x = [];
                        var y = [];
                                                 
                        <c:forEach items="${assCliente}" var="a">
                        x.push('${a.status}');
                        y.push(${a.quantidade});
                        
                        var chart = new Chart(ctx3, {

                            type: 'pie',
                            data: {
                                labels: ['Cancelado', 'Vendido', 'Aguardando Pagamento'],
                                datasets: [{
                                        backgroundColor: ["#686868", "#F36281", "#198CFF"],
                                       
                                        data: y
                                    }]
                            },
                            options: {
                                legend: {
                                    position: 'bottom'
                                },
                                events: ['click'],
                                //events: ['click'],
                                cutoutPercentage: 50,
                                yAxes: [{
                                        ticks: {
                                            beginAtZero: true
                                        }
                                    }]
                            }
                        });
                        </c:forEach>
                            
                    </script>
                    
                    <script>
                        var ctx4 = document.getElementById('myChartAssinaturaPie').getContext('2d');
                        var z = [];
                        var w = [];
                                                 
                        <c:forEach items="${vendas2020}" var="t">
                        z.push('${t.assinatura}');
                        w.push(${t.quantidade});
                        
                        var chart = new Chart(ctx4, {

                            type: 'pie',
                            data: {
                                labels: ['Bronze', 'Prata', 'Ouro'],
                                datasets: [{
                                        backgroundColor: ["#b87333", "#c0c0c0", "#FFD700"],
                                       
                                        data: w
                                    }]
                            },
                            options: {
                                legend: {
                                    position: 'bottom'
                                },
                                events: ['click'],
                                //events: ['click'],
                                cutoutPercentage: 50,
                                yAxes: [{
                                        ticks: {
                                            beginAtZero: true
                                        }
                                    }]
                            }
                        });
                        </c:forEach>
                            
                    </script>
                    
                    <!-- Area Chart Example-->
                    <!-- /.container-fluid -->

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


