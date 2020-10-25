<%-- 
    Document   : index
    Created on : 31/10/2019, 11:49:05
    Author     : Kaua.Morateli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Usuario"%>

<html>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Playbox - Dashboard</title>

        <!-- Fonte Custom-->
        <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Nivel página plugin css-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Style Custom p/ template-->
        <link href="css/sb-admin.css" rel="stylesheet">

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

                    <div class="col-md-5">
                        <canvas id="myChart"></canvas>
                    </div>
                    <div class="col-md-4">
                        <canvas id="pizza" width="1024" height="768"></canvas>
                    </div>
                  
                    <script>
                        
                    var data = [
                    {
                        value: 300,
                        color:"#F7464A",
                        highlight: "#FF5A5E",
                        label: "Red"
                    },
                    {
                        value: 50,
                        color: "#46BFBD",
                        highlight: "#5AD3D1",
                        label: "Green"
                    },
                    {
                        value: 100,
                        color: "#FDB45C",
                        highlight: "#FFC870",
                        label: "Yellow"
                    }
                ];

                var ctx = document.getElementById("pizza").getContext("2d");
                new Chart(ctx).Pie(data);
                //new Chart(ctx).Doughnut(data);
                        
                    </script>
                    

                    <script>
                        var ctx = document.getElementById('myChart').getContext('2d');
                        var chart = new Chart(ctx, {

                            type: 'bar',

                            data: {
                                labels: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro'],
                                datasets: [{
                                        label: 'Pacotes Vendidos',
                                        backgroundColor: 'rgb(000, 200, 200)',
                                        borderColor: 'rgb(000, 000, 10)',
                                        data: [0, 10, 5, 2, 20, 30, 45]
                                    }]
                            },

                            options: {}
                        });
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
            <script src="../vendor/jquery/jquery.min.js"></script>
            <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Page level plugin JavaScript-->
            <script src="../vendor/chart.js/Chart.min.js"></script>
            <script src="../vendor/datatables/jquery.dataTables.js"></script>
            <script src="../vendor/datatables/dataTables.bootstrap4.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="../js/sb-admin.min.js"></script>

            <!-- Demo scripts for this page-->
            <script src="../js/demo/datatables-demo.js"></script>
            <script src="../js/demo/chart-area-demo.js"></script>
            <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js'></script>
            <script src="js/pizza.js"></script>

    </body>

</html>
