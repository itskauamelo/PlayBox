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

  <title>Playbox - Cadastrar Game</title>

  <!-- Fonte Custom-->
  <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Nivel página plugin css-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Style Custom p/ template-->
  <link href="css/sb-admin.css" rel="stylesheet">

</head>


<body id="page-top">
    
        <%
    Usuario usuario = (Usuario)session.getAttribute("usuarioAutenticado");
    
    if (usuario != null){
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

    <jsp:include page="/admin/navbar.jsp" />
        
    <jsp:include page="/admin/sidebar.jsp" />

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="#">Dashboard</a>
          </li>
          <li class="breadcrumb-item active">Cadastrar Game</li>
        </ol>
        
        <div class="card-body">
        <form action="../cadastrarGame" method="POST">
            <label for="txtNome">Nome</label>
            <input type="text" id="txtNome" name="txtNome" class="form-control" required="required"><br>
            <label for="txtDescricao">Descrição</label>
            <input type="text" id="txtDescricao" name="txtDescricao" class="form-control" required="required"><br>
            <label for="txtPlataforma">Plataforma</label>
            <input type="text" id="txtPlataforma" name="txtPlataforma" class="form-control" required="required"><br>
            <label for="txtImagem">Imagem</label>
            <input accept="image/*" type="file" id="txtImagem" name="txtImagem" class="form-control" required="required"><br>
            <label for="optSituacao">Situação</label>
            <select name="optSituacao" id="optSituacao" class="custom-select custom-select-sm form-control form-control-sm">
                <option value="ATIVO">ATIVO</option>
                <option value="INATIVO">INATIVO</option>
            </select>
            <br><br><label for="txtQuantidade">Quantidade</label>
            <input type="number" id="txtQuantidade" name="txtQuantidade" min="0" class="form-control" required="required"><br>
            <label for="txtPreco">Preco</label>
            <input type="text" id="txtPreco" name="txtPreco" class="dinheiro form-control" style="display:inline-block" />
             <br>
             <br>
             <button class="btn btn-primary btn-medio" id="btngravar" type="submit" name="gravar" value="Gravar">Cadastrar</button>
             <br>
             <br>
        </form>
        </div>

    </div>
    <!-- /.content-wrapper -->

  </div><br><br><br><br><br>
            <jsp:include page="/admin/footer.jsp"/>
  <!-- /#wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
  <br>
  <br>
  <br>
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

</body>

</html>
