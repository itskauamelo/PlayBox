package Controler;

import DAO.ProdutoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Produto;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ProdutoControle", urlPatterns = {
    "/cadastrarProduto",
    "/listarProdutos",
    "/excluirProduto",
    "/iniciarEdicaoProduto",
    "/editarProduto"
})

public class ControllerProduto extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/excluirProduto")) {
                excluir(request, response);
            } else if (uri.equals(request.getContextPath() + "/listarProdutos")) {
                listarTodos(request, response);
            } else if (uri.equals(request.getContextPath() + "/iniciarEdicaoProduto")) {
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

            if (uri.equals(request.getContextPath() + "/cadastrarProduto")) {
                cadastrar(request, response);
            } else if (uri.equals(request.getContextPath() + "/editarProduto")) {
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
        Produto produto = new Produto();
        produto.setNome(request.getParameter("txtNome"));
        produto.setDescricao(request.getParameter("txtDescricao"));
        produto.setImagem(request.getParameter("txtImagem"));
        produto.setSituacao(request.getParameter("optSituacao"));
        produto.setQuantidade(Integer.valueOf(request.getParameter("txtQuantidade")));
        produto.setPreco(Double.parseDouble(request.getParameter("txtPreco")));
        

        ProdutoDAO dao = new ProdutoDAO();
        dao.cadastrar(produto);
        
        response.sendRedirect("listarProdutos");

        
    }

    private void iniciarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Produto produto = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        produto.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(produto);

        request.setAttribute("produto", produto);
        request.getRequestDispatcher("admin/EdProd.jsp").forward(request, response);
    }

    private void confirmarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Produto produto = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        produto.setId(Integer.valueOf(request.getParameter("id")));
        produto.setNome(request.getParameter("nome"));
        produto.setDescricao(request.getParameter("descricao"));
        produto.setImagem(request.getParameter("imagem"));
        produto.setSituacao(request.getParameter("situacao"));
        produto.setQuantidade(Integer.valueOf(request.getParameter("quantidade")));
        produto.setPreco(Double.valueOf(request.getParameter("preco")));

        dao.Editar(produto);
        response.sendRedirect("listarProdutos");
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Produto produto = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        produto.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(produto);
        dao.Excluir(produto);
        
        response.sendRedirect("listarProdutos");
    }

    private void listarTodos(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        ProdutoDAO dao = new ProdutoDAO();

        List<Produto> todosProdutos = dao.consultarTodos();
        request.setAttribute("todosProdutos", todosProdutos);
        
        request.getRequestDispatcher("admin/listarProdutos.jsp").forward(request, response);

    }
    
} 

