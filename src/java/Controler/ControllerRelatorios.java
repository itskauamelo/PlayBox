package Controler;

import DAO.ClienteDAO;
import DAO.CompraDAO;
import DAO.RelatorioDAO;
import Model.Cliente;
import Model.Compra;
import Model.ItensRelatorio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "RelatorioControle", urlPatterns = {
    "/relatorioItens",
    "/listarFaturamento",
    "/relatorioClientes"
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
} 

