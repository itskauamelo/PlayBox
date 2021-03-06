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

        <title>PlayBox - Relatorio de Preferência</title>

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
                    <!-- Breadcrumbs-->
                    <h1 style>Relatório de Preferência</h1><br>
                    
                    <button onclick="esconder()" class="btn btn-success btn-xs">Tabela de Prefrencias</button>
                    
                    <div style="display: none; width: 50%" id="myDIV">
                        <table id="tabela" class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Pref. 1</th>
                                    <th scope="col">Pref. 2</th>
                                    <th scope="col">Pref. 3</th>
                                </tr>
                            </thead>

                            <c:forEach items="${todasPreferencias}" var="p">
                                <tr>
                                    <td>${p.preferencia1}</td>
                                    <td>${p.preferencia2}</td>          
                                    <td>${p.preferencia3}</td>
                                </tr>
                            </c:forEach>

                        </table>
                    <style type="text/css">
                        .canvasMaior { 
                            width: 750px;
                            heigth: 350px;
                            float:left;
                            position: relative;
                        }
                        .canvas { 
                            width: 550px;
                            heigth: 550px;
                            float:left;
                        }
                    </style>
                        
                    </div>

                                        <div class="canvas">
                        <h3>                      Horas de Jogo</h3><br>
                        <canvas id="myChartHorasJogo"></canvas><br>
                        <h3>                      Jogo Online</h3><br>
                        <canvas id="myChartJogoOnline"></canvas><br>
                    </div>
                    

                    



<!--
                    <script>
                        var ctx = document.getElementById('myChart').getContext('2d');
                        //var nomes = [];
                        var qtd = [];
                        <c:forEach items="${todasPreferencias}" var="p">

                        //nomes.push('${p.jogoonline}');
                        qtd.push('${p.preferencia1}');

                        var chart = new Chart(ctx, {

                            type: 'bar',
                            data: {

                                labels: ['Aventura', 'Luta', 'RPG', 'Terror', 'Corrida', 'Ação', 'Esporte', 'Simulação', 'Estratégia'],
                                datasets: [{
                                        label: 'Camisetas',
                                        backgroundColor: 'rgb(000, 150, 200)',
                                        borderColor: 'rgb(000, 000, 10)',
                                        data: qtd
                                    }]
                            },
                            options: {
                                tooltips: {enabled: false},
                                hover: {mode: null},

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
                    </script>-->





                                        
                    <script>
                        var ctx3 = document.getElementById('myChartJogoOnline').getContext('2d');
                        var z = [];
                        var w = [];
                                                 
                        <c:forEach items="${jogoOnline}" var="j">
                        z.push('${j.jogoonline}');
                        w.push(${j.quantidade});
                        
                        var chart = new Chart(ctx3, {

                            type: 'pie',
                            data: {
                                labels: z,
                                datasets: [{
                                        backgroundColor: ["#0ecfc2", "#9b411c"],
                                       
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
                    
                    <script>
                        var ctx3 = document.getElementById('myChartHorasJogo').getContext('2d');
                        var x = [];
                        var y = [];
                                                 
                        <c:forEach items="${horasJogo}" var="t">
                        x.push('${t.horasjogo}');
                        y.push(${t.quantidade});
                        
                        var chart = new Chart(ctx3, {

                            type: 'pie',
                            data: {
                                labels: ['1 a 2 hrs', '3 a 4 hrs', '5 a 7 hrs', 'Mais'],
                                datasets: [{
                                        backgroundColor: ["#016155", "#0ecfc2", "#d18053", "#9b411c"],
                                       
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
                    

                    <br><br><br><br><br>
                    <!-- Area Chart Example-->
                    <!-- /.container-fluid -->
                </div>
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

