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
                <a class="nav-link" href="javascript:history.back()">
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
                    <h6 class="dropdown-header">Pedidos:</h6>
                    <a class="dropdown-item" href="/PlayBox/listarComprasADM">Alterar Status</a>
                    <h6 class="dropdown-header">Relatórios:</h6>
                    <a class="dropdown-item" href="/PlayBox/listarFaturamento">Faturamento</a>
                    <a class="dropdown-item" href="/PlayBox/relatorioItens">Itens</a>
                    <a class="dropdown-item" href="/PlayBox/relatorioClientes">Clientes</a>
                    <a class="dropdown-item" href="/PlayBox/relatorioPreferencia">Preferencia de Clientes</a>
                    <a class="dropdown-item" href="/PlayBox/relatorioPesquisaSatisfacao">Pesquisa de Satisfação</a>
                    <a class="dropdown-item" href="/PlayBox/relatorioQuantClientes">Quantidade clientes</a>
                    <a class="dropdown-item" href="/PlayBox/relatorioVendas">Vendas Mensal</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-plus"></i>
                    <span>Cadastros</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                    <a class="dropdown-item" name="btnCadastroUser" href="/PlayBox/admin/usuario.jsp">Usuários</a>
                    <a class="dropdown-item" href="/PlayBox/admin/produto.jsp">Brindes</a>
                    <a class="dropdown-item" href="/PlayBox/admin/camiseta.jsp">Camiseta</a>
                    <a class="dropdown-item" href="/PlayBox/admin/game.jsp">Game</a>
                    <a class="dropdown-item" href="/PlayBox/form/cadastroPacote">Pacotes</a>

                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/PlayBox/listarUsuario">
                    <i class="fas fa-fw fa-user"></i>
                    <span>Usuários</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/PlayBox/listarProdutos">
                    <i class="fas fa-fw fa-bone"></i>
                    <span>Brindes</span></a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/PlayBox/listarCamisetas">
                    <i class="fas fa-fw fa-tshirt"></i>
                    <span>Camisetas</span></a>

            <li class="nav-item">
                <a class="nav-link" href="/PlayBox/listarGames">
                    <i class="fas fa-fw fa-gamepad"></i>
                    <span>Games</span></a>

            <li class="nav-item">
                <a class="nav-link" href="/PlayBox/listarPacotes">
                    <i class="fas fa-fw fa-gift"></i>
                    <span>Pacotes</span></a>
            </li>
        </ul>
</html>
