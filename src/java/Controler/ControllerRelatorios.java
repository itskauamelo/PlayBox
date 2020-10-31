package Controler;

import DAO.ClienteDAO;
import DAO.CompraDAO;
import DAO.RelatorioDAO;
import Model.Cliente;
import Model.Compra;
import Model.ItensRelatorio;
import Model.Pesquisa;
import Model.Relatorio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "RelatorioControle", urlPatterns = {
    "/relatorioItens",
    "/listarFaturamento",
    "/relatorioClientes",
    "/relatorioPesquisaSatisfacao",
    "/relatorioVendas",
    "/relatorioQuantClientes"
})

public class ControllerRelatorios extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/relatorioItens")) {
                relatorioItens(request, response);
            } else if (uri.equals(request.getContextPath() + "/listarFaturamento")) {
                listarComprasFinalizadas(request, response);
            } else if (uri.equals(request.getContextPath() + "/relatorioClientes")) {
                relatorioClientes(request, response);
            } else if (uri.equals(request.getContextPath() + "/relatorioVendas")) {
                relatorioVendas(request, response);
            } else if (uri.equals(request.getContextPath() + "/relatorioQuantClientes")) {
                relatorioQuantClientes(request, response);
            } else  if (uri.equals(request.getContextPath() + "/relatorioPesquisaSatisfacao")) {
                relatorioPesquisaSatisfacao(request, response);
            }  
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("Erro.jsp");
            }
    }
    

    private void relatorioItens(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        RelatorioDAO dao = new RelatorioDAO();

        List<ItensRelatorio> todosItens = dao.consultarTodos();
        
        request.setAttribute("todosItens", todosItens);
        
        request.getRequestDispatcher("admin/relatorioItensTotais.jsp").forward(request, response);

    }
    
    private void relatorioVendas(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        RelatorioDAO dao = new RelatorioDAO();

        List<Relatorio> periodoVendas2020 = dao.getConsultarPeriodoVenda2020();
        List<Relatorio> periodoVendas2019 = dao.getConsultarPeriodoVenda2019();
        List<Relatorio> vendas2020 = dao.getPedidosStatus();
        List<Relatorio> assCliente = dao.getAssinaturaQuant();
        
        request.setAttribute("periodoVendas2020", periodoVendas2020);
        request.setAttribute("periodoVendas2019", periodoVendas2019);
        request.setAttribute("vendas2020", vendas2020);
        request.setAttribute("assCliente", assCliente);
        request.getRequestDispatcher("admin/relatorioVendas.jsp").forward(request, response);

    }
    
    private void relatorioQuantClientes(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        RelatorioDAO dao = new RelatorioDAO();

        List<Relatorio> quantClientesMes = dao.getQuantClientes();
        
        request.setAttribute("quantClientesMes", quantClientesMes);
        
        request.getRequestDispatcher("admin/relatorioQuantClientes.jsp").forward(request, response);

    }
    
    private void listarComprasFinalizadas(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        CompraDAO dao = new CompraDAO();

        List<Compra> todasComprasFinalizadas = dao.consultarComprasFinalizadas();
        request.setAttribute("todasComprasFinalizadas", todasComprasFinalizadas);
        
        request.getRequestDispatcher("admin/relatorioFaturamento.jsp").forward(request, response);

    }
    
    private void relatorioClientes(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        ClienteDAO dao = new ClienteDAO();

        List<Cliente> todosClientes = dao.consultarClientesCadastrados();
        request.setAttribute("todosClientes", todosClientes);
        
        request.getRequestDispatcher("admin/relatorioClientes.jsp").forward(request, response);
    } 
    
    private void relatorioPesquisaSatisfacao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        ClienteDAO dao = new ClienteDAO();

        List<Pesquisa> todasPesquisas = dao.consultarPesquisasCadastradas();
        request.setAttribute("todasPesquisas", todasPesquisas);
        
        request.getRequestDispatcher("admin/relatorioPesquisa.jsp").forward(request, response);
    }
} 

