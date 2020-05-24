package Controler;

import DAO.ProdutoDAO;
import DAO.GameDAO;
import DAO.CamisetaDAO;
import DAO.PacoteDAO;
import DAO.RelatorioDAO;
import Model.Produto;
import Model.Game;
import Model.Camiseta;
import Model.ItensRelatorio;
import Model.Pacote;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "RelatorioControle", urlPatterns = {
    "/relatorioItens"
})

public class ControllerRelatorios extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/relatorioItens")) {
                relatorioItens(request, response);
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
    
} 

