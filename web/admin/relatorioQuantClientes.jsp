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

        <title>PlayBox - Relatório de Clientes</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

        <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>

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
                    <h1>Relatório de Clientes</h1><br>
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
                    <br>
                    <table id="tabela" class="tabela" border="1">
                        <thead>
                            <tr>
                            <th class="cabecalho">Quantidade</th>
                            <th class="cabecalho">Mes</th>
                            <th class="cabecalho">Ano</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${quantClientesMes}" var="q">
                            <tr>
                                <td class="conteudo" align="center">${q.quantidade}</td>
                                <td class="conteudo" align="center">${q.mes}</td>
                                <td class="conteudo" align="center">${q.ano}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    
                     
                    <script>
                        //-----------------Combo de Filtros---------------------
                        //Se não for nem 1 nem 2 esconde as duas
                        $("#filtrodata").hide();
                        $("#filtronome").hide();

                        $(document).ready(function () {
                            var valor = $(this).val().toUpperCase();
                            //Chama o evento após selecionar um valor
                            $('#selectfilter').on('change', function () {
                                //Verifica se o valor é igual a 1 e mostra
                                if (this.value == '1')
                                {
                                    $("#filtrodata").show();
                                    $('#limparfiltro').show();
                                    $("#filtronome").hide();

                                    $("#tabela tbody tr").show();
                                    $(nth).each(function () {
                                        if ($(this).text().toUpperCase().indexOf(valor) < 0) {
                                            $(this).parent().hide();
                                        }
                                    });

                                }

                                else if (this.value == '2')
                                {
                                    $("#filtronome").show();
                                    $('#limparfiltro').show();
                                    $("#filtrodata").hide();

                                    $("#tabela tbody tr").show();
                                    $(nth).each(function () {
                                        if ($(this).text().toUpperCase().indexOf(valor) < 0) {
                                            $(this).parent().hide();
                                        }
                                    });
                                } else if (this.value == '0')
                                {
                                    $("#filtrodata").hide();
                                    $("#filtronome").hide();

                                    $("#tabela tbody tr").show();
                                    $(nth).each(function () {
                                        if ($(this).text().toUpperCase().indexOf(valor) < 0) {
                                            $(this).parent().hide();
                                        }
                                    });

                                    alert("Favor selecione um filtro");
                                }
                            });
                        });
                        //-----------------Filtro Por Nome----------------------
                        $(function () {
                                $("#txtnome").keyup(function () {        
                                        //var index = $(this).parent().index();
                                i = 4;
                                        var nth = "#tabela td:nth-child(" + i + ")";
                                        var valor = $(this).val().toUpperCase();
                                        $("#tabela tbody tr").show();
                                        $(nth).each(function () {
                                                if ($(this).text().toUpperCase().indexOf(valor) < 0) {
                                                        $(this).parent().hide();
                                                }
                                        });
                                });
 
                                //$("#tabela input").blur(function () {
                            //        $(this).val("");
                                //});
                        });
                        //-----------------Filtro Por Data----------------------
                        function filterRows() {
                            var from = $('#datefilterfrom').val();
                            var to = $('#datefilterto').val();

                            if (!from && !to) { 
                                return;
                            }

                            from = from || '1970-01-01'; 
                            to = to || '2999-12-31';

                            var dateFrom = moment(from);
                            var dateTo = moment(to);

                            $('#tabela tbody tr').each(function (i, tr) {
                                var val = $(tr).find("td:nth-child(1)").text();
                                var dateVal = moment(val, "DD/MM/YYYY");
                                var visible = (dateVal.isBetween(dateFrom, dateTo, null, [])) ? "" : "none"; 
                                $(tr).css('display', visible);
                            });
                        }

                        $('#datefilterfrom').on("change", filterRows);
                        $('#datefilterto').on("change", filterRows);
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


