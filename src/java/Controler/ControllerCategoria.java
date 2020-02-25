package Controler;

import DAO.CategoriaDAO;
import Model.Categoria;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "CategoriaControle", urlPatterns = {
    "/cadastrarCategoria",
    "/listarCategorias",
    "/desativarCategoria",
    "/iniciarEdicaoCategoria",
    "/editarCategoria"
})

public class ControllerCategoria extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/desativarCategoria")) {
                excluir(request, response);
            } else if (uri.equals(request.getContextPath() + "/listarCategorias")) {
                listarTodos(request, response);
            } else if (uri.equals(request.getContextPath() + "/iniciarEdicaoCategoria")) {
                iniciarEdicao(request, response);
            } 
            
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("Erro.jsp");
            }
    }
   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/cadastrarCategoria")) {
                cadastrar(request, response);
            } else if (uri.equals(request.getContextPath() + "/editarCategoria")) {
                confirmarEdicao(request, response);
            } else {
                response.sendRedirect("404.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("../Erro.jsp");
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
        Categoria categoria = new Categoria();
        categoria.setCategoria(request.getParameter("txtCategoria"));
        
        CategoriaDAO dao = new CategoriaDAO();
        dao.cadastrar(categoria);
        
        response.sendRedirect("listarPacotes");

        
    }

    private void iniciarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Categoria categoria = new Categoria();
        CategoriaDAO dao = new CategoriaDAO();
        categoria.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(categoria);

        request.setAttribute("categoria", categoria);
        // request.getRequestDispatcher("admin/EdProd.jsp").forward(request, response);
    }

    private void confirmarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Categoria categoria = new Categoria();
        CategoriaDAO dao = new CategoriaDAO();
        categoria.setId(Integer.valueOf(request.getParameter("id")));
        categoria.setCategoria(request.getParameter("categoria"));

        dao.Editar(categoria);
        // response.sendRedirect("listarPacotes");
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Categoria categoria = new Categoria();
        CategoriaDAO dao = new CategoriaDAO();
        categoria.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(categoria);
        dao.Excluir(categoria);
        
        // response.sendRedirect("listarProdutos");
    }

    private void listarTodos(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        CategoriaDAO dao = new CategoriaDAO();

        List<Categoria> todasCategorias = dao.consultarTodos();
        request.setAttribute("todasCategorias", todasCategorias);
        
        // request.getRequestDispatcher("admin/listarPacotes.jsp").forward(request, response);

    }
    
} 

