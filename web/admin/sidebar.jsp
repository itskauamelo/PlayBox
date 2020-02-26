<%-- 
    Document   : sidebar
    Created on : 06/11/2019, 21:18:21
    Author     : superalunocmc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
          <h6 class="dropdown-header">Relatórios:</h6>
          <a class="dropdown-item" href="#">Faturamento</a>
          <a class="dropdown-item" href="#">Preferencia de Clientes</a>
        </div>
      </li>
            <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-plus"></i>
          <span>Cadastros</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <a class="dropdown-item" name="btnCadastroUser" href="usuario.jsp">Usuários</a>
          <a class="dropdown-item" href="produto.jsp">Brindes</a>
          <a class="dropdown-item" href="camiseta.jsp">Camiseta</a>
          <a class="dropdown-item" href="game.jsp">Game</a>
          <a class="dropdown-item" href="pacote.jsp">Pacotes</a>

        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../listarUsuario">
          <i class="fas fa-fw fa-user"></i>
          <span>Usuários</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../listarProdutos">
          <i class="fas fa-fw fa-gift"></i>
          <span>Brindes</span></a>
      </li>
      
            <li class="nav-item">
        <a class="nav-link" href="">
          <i class="fas fa-fw fa-tshirt"></i>
          <span>Camisetas</span></a>
                
            <li class="nav-item">
        <a class="nav-link" href="produtos.html">
          <i class="fas fa-fw fa-gamepad"></i>
          <span>Games</span></a>
      </li>
    </ul>
</html>
