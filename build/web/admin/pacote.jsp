<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.util.List"%>
<%@page import="Model.Game"%>
<%@page import="Model.Camiseta"%>
<%@page import="Model.Produto"%>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>PlayBox Admin - Pacotes</title>

        <!-- Custom fonts for this template-->
        <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="../vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="../css/sb-admin.css" rel="stylesheet">

        <!-- Bootstrap core JavaScript-->
        <script src="../vendor/jquery/jquery.min.js"></script>
        <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="../vendor/datatables/jquery.dataTables.js"></script>
        <script src="../vendor/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="../js/sb-admin.min.js"></script>


        <!-- Demo scripts for this page-->
        <script src="../js/demo/datatables-demo.js"></script>

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

            <jsp:include page="/admin/navbar.jsp" />

            <jsp:include page="/admin/sidebar.jsp" />
            
        </nav>

        <div id="wrapper">

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active">Tables</li>
                    </ol>

                    <%
                        List<Game> games = (List<Game>) request.getAttribute("games");
                    %>

                    <%
                        List<Camiseta> camisetas = (List<Camiseta>) request.getAttribute("camisetas");
                    %>

                    <%
                        List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
                    %>
                    <div class="card-body">
                        <form onsubmit="return valida()" action="../cadastrarPacote" method="POST">
                            <label for="txtNome">Nome do Pacote</label>
                            <input type="text" id="txtNome" name="txtNome" class="form-control" style="display:inline-block" required>

                            <label for="txtAssinatura">Assinatura</label>
                            <select onchange="exibir_ocultar(this)" id="txtAssinatura" name="txtAssinatura" class="form-control" required>
                                <option value="" disabled selected>Selecione o nome do pacote</option>
                                <option value="Bronze">Bronze</option>
                                <option value="Prata">Prata</option>
                                <option value="Ouro">Ouro</option>
                            </select>
                            <label for="optJogo">Jogo</label>
                            <select name="optJogo" id="optJogo" class="custom-select custom-select-sm form-control form-control-sm" required>
                                <option value="" disabled selected>Selecione um jogo...</option>
                                <%
                                    for (Game game : games) {
                                %>

                                <option value="<%=game.getNome()%>">  <%= game.getNome()%> </option>

                                <% } %> 
                            </select>

                            <label for="optCamiseta">Camiseta</label>
                            <select name="optCamiseta" id="optCamiseta" class="custom-select custom-select-sm form-control form-control-sm" required>
                                <option value="" disabled selected>Selecione uma camiseta...</option>
                                <%
                                    for (Camiseta camiseta : camisetas) {
                                %>

                                <option value="<%=camiseta.getNome()%>">  <%= camiseta.getNome()%> </option>

                                <% } %> 
                            </select>
                            <div id="optBrinde1" name="optBrinde1" style="display:none;"> 
                                <label for="optBrinde1">Brinde 1</label>
                                <select name="optBrinde1" id="optBrinde1" class="custom-select custom-select-sm form-control form-control-sm" required>
                                    <option value="" disabled selected>Selecione um brinde...</option>
                                    <%
                                        for (Produto produto : produtos) {
                                    %>

                                    <option value="<%=produto.getNome()%>">  <%= produto.getNome()%> </option>

                                    <% } %> 
                                </select>
                            </div>
                            <div id="optBrinde2" name="optBrinde2" style="display:none;"> 
                                <label for="optBrinde2">Brinde 2</label>
                                <select name="optBrinde2" id="optBrinde2" class="custom-select custom-select-sm form-control form-control-sm">
                                    <option value="" disabled selected>Selecione um brinde...</option>
                                    <%
                                        for (Produto produto : produtos) {
                                    %>

                                    <option value="<%=produto.getNome()%>">  <%= produto.getNome()%> </option>

                                    <% } %> 
                                </select>
                            </div>
                            <div id="optBrinde3" name="optBrinde3" style="display:none;"> 
                                <label for="optBrinde3">Brinde 3</label>
                                <select name="optBrinde3" id="optBrinde3" class="custom-select custom-select-sm form-control form-control-sm">
                                    <option value="" disabled selected>Selecione um brinde...</option>
                                    <%
                                        for (Produto produto : produtos) {
                                    %>

                                    <option value="<%=produto.getNome()%>">  <%= produto.getNome()%> </option>

                                    <% } %> 
                                </select>
                            </div>
                            <div id="optBrinde4" name="optBrinde4" style="display:none;"> 
                                <label for="optBrinde4">Brinde 4</label>
                                <select name="optBrinde4" id="optBrinde4" class="custom-select custom-select-sm form-control form-control-sm">
                                    <option value="" disabled selected>Selecione um brinde...</option>
                                    <%
                                        for (Produto produto : produtos) {
                                    %>

                                    <option value="<%=produto.getNome()%>">  <%= produto.getNome()%> </option>

                                    <% } %> 
                                </select>
                            </div>
                            <div id="optBrinde5" name="optBrinde5" style="display:none;"txt> 
                                <label for="optBrinde5">Brinde 5</label>
                                <select name="optBrinde5" id="optBrinde5" class="custom-select custom-select-sm form-control form-control-sm">
                                    <option value="" disabled selected>Selecione um brinde...</option>
                                    <%
                                        for (Produto produto : produtos) {
                                    %>

                                    <option value="<%=produto.getNome()%>">  <%= produto.getNome()%> </option>

                                    <% }%> 
                                </select>
                            </div>
                            <label for="optSituacao">Situação</label>
                            <select name="optSituacao" id="optSituacao" class="custom-select custom-select-sm form-control form-control-sm" required>
                                <option value="" disabled selected>Selecione uma situação...</option>
                                <option value="ATIVO">ATIVO</option>
                                <option value="INATIVO">INATIVO</option>
                            </select>
                            <label for="txtQuantidade">Quantidade</label>
                            <input type="number" min="0" step="1" id="txtQuantidade" name="txtQuantidade" class="form-control" style="display:inline-block" required>
                            <label for="txtPreco">Preço</label>
                            <input type="number" min="0" step="1" id="txtPreco" name="txtPreco" class="dinheiro form-control" style="display:inline-block" required>
                            <br>
                            <br>
                            <button class="btn btn-primary btn-medio" id="btngravar" type="submit" name="gravar" value="Gravar">Cadastrar</button>
                            <br>
                            <br>
                        </form>
                    </div>
                    <script>
                        $('#txtAssinatura').on('change', function () {

                            if (this.value == "Bronze") {
                                $('#optBrinde1').show();
                                $('#optBrinde2').hide();
                                $('#optBrinde3').hide();
                                $('#optBrinde4').hide();
                                $('#optBrinde5').hide();
                            } else
                            if (this.value == "Prata") {
                                $('#optBrinde1').show();
                                $('#optBrinde2').show();
                                $('#optBrinde3').show();
                                $('#optBrinde4').hide();
                                $('#optBrinde5').hide();
                            } else {
                                $('#optBrinde1').show();
                                $('#optBrinde2').show();
                                $('#optBrinde3').show();
                                $('#optBrinde4').show();
                                $('#optBrinde5').show();
                            }
                        });

                        function valida() {
                            var resultado = confirm("Deseja cadastrar um novo pacote?");
                            if (resultado == true) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    </script>
                </div>
                <!-- /.content-wrapper -->

            </div>
            <jsp:include page="/admin/footer.jsp"/>
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
        </div>
    </body>

</html>
