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
          <form action="../cadastrarPacote" method="POST">
              <label for="txtNome">Nome do Pacote</label>
              <select onchange="exibir_ocultar(this)" id="txtNome" name="txtNome" class="form-control" required="required">
                  <option selected="true" disabled="disabled" >Selecione o nome do pacote</option>
                  <option value="Bronze">Bronze</option>
                  <option value="Prata">Prata</option>
                  <option value="Ouro">Ouro</option>
              </select>
              <label for="optJogo">Jogo</label>
              <select name="optJogo" id="optJogo" class="custom-select custom-select-sm form-control form-control-sm">
                <%
                for (Game game : games) {
                %>

                <option value="<%=game.getId()%>">  <%= game.getNome() %> </option>

                <% } %> 
              </select>

              <label for="optCamiseta">Camiseta</label>
              <select name="optCamiseta" id="optCamiseta" class="custom-select custom-select-sm form-control form-control-sm">
                <%
                for (Camiseta camiseta : camisetas) {
                %>

                <option value="<%=camiseta.getId()%>">  <%= camiseta.getNome() %> </option>

                <% } %> 
              </select>
              <div id="optBrinde1" name="optBrinde1" style="display:none;"> 
              <label for="optBrinde1">Brinde 1</label>
              <select name="optBrinde1" id="optBrinde1" class="custom-select custom-select-sm form-control form-control-sm">
                <%
                for (Produto produto : produtos) {
                %>

                <option value="<%=produto.getId()%>">  <%= produto.getNome() %> </option>

                <% } %> 
              </select>
              </div>
              <div id="optBrinde2" name="optBrinde2" style="display:none;"> 
              <label for="optBrinde2">Brinde 2</label>
              <select name="optBrinde2" id="optBrinde2" class="custom-select custom-select-sm form-control form-control-sm">
                <%
                for (Produto produto : produtos) {
                %>

                <option value="<%=produto.getId()%>">  <%= produto.getNome() %> </option>

                <% } %> 
              </select>
              </div>
              <div id="optBrinde3" name="optBrinde3" style="display:none;"> 
              <label for="optBrinde3">Brinde 3</label>
              <select name="optBrinde3" id="optBrinde3" class="custom-select custom-select-sm form-control form-control-sm">
                <%
                for (Produto produto : produtos) {
                %>

                <option value="<%=produto.getId()%>">  <%= produto.getNome() %> </option>

                <% } %> 
              </select>
              </div>
              <div id="optBrinde4" name="optBrinde4" style="display:none;"> 
              <label for="optBrinde4">Brinde 4</label>
              <select name="optBrinde4" id="optBrinde4" class="custom-select custom-select-sm form-control form-control-sm">
                <%
                for (Produto produto : produtos) {
                %>

                <option value="<%=produto.getId()%>">  <%= produto.getNome() %> </option>

                <% } %> 
              </select>
              </div>
              <div id="optBrinde5" name="optBrinde5" style="display:none;"txt> 
              <label for="optBrinde5">Brinde 5</label>
              <select name="optBrinde5" id="optBrinde5" class="custom-select custom-select-sm form-control form-control-sm">
                <%
                for (Produto produto : produtos) {
                %>

                <option value="<%=produto.getId()%>">  <%= produto.getNome() %> </option>

                <% } %> 
              </select>
              </div> 
              
              <script>
                  $('#txtNome').on('change', function() {

                  if(this.value == "Bronze") {
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
              </script>
              
              
          </form>
          </div>
  
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

</body>

</html>
