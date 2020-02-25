package Controler;

import DAO.CamisetaDAO;
import Model.Camiseta;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ProdutoControle", urlPatterns = {
    "/cadastrarCamiseta",
    "/listarCamisetas",
    "/desativarCamiseta",
    "/iniciarEdicaoCamiseta",
    "/editarCamiseta"
})

public class ControllerCamiseta extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/desativarCamiseta")) {
                desativar(request, response);
            } else if (uri.equals(request.getContextPath() + "/listarCamisetas")) {
                listarTodos(request, response);
            } else if (uri.equals(request.getContextPath() + "/iniciarEdicaoCamiseta")) {
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

            if (uri.equals(request.getContextPath() + "/cadastrarCamiseta")) {
                cadastrar(request, response);
            } else if (uri.equals(request.getContextPath() + "/editarCamiseta")) {
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
        Camiseta camiseta = new Camiseta();
        camiseta.setNome(request.getParameter("txtNome"));
        camiseta.setDescricao(request.getParameter("txtDescricao"));
        camiseta.setSexo(request.getParameter("txtSexo"));
        camiseta.setTamanho(request.getParameter("txtTamanho"));
        camiseta.setImagem(request.getParameter("txtImagem"));
        camiseta.setSituacao(request.getParameter("optSituacao"));
        camiseta.setQuantidade(Integer.valueOf(request.getParameter("txtQuantidade")));
        camiseta.setPreco(Double.parseDouble(request.getParameter("txtPreco")));
        

        CamisetaDAO dao = new CamisetaDAO();
        dao.cadastrar(camiseta);
        
        //response.sendRedirect("listarProdutos");

        
    }

    private void iniciarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Camiseta camiseta = new Camiseta();
        CamisetaDAO dao = new CamisetaDAO();
        camiseta.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(camiseta);

        request.setAttribute("camiseta", camiseta);
        // request.getRequestDispatcher("admin/EdProd.jsp").forward(request, response);
    }

    private void confirmarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Camiseta camiseta = new Camiseta();
        CamisetaDAO dao = new CamisetaDAO();
        camiseta.setId(Integer.valueOf(request.getParameter("id")));
        camiseta.setNome(request.getParameter("nome"));
        camiseta.setDescricao(request.getParameter("descricao"));
        camiseta.setDescricao(request.getParameter("sexo"));
        camiseta.setDescricao(request.getParameter("tamanho"));
        camiseta.setImagem(request.getParameter("imagem"));
        camiseta.setSituacao(request.getParameter("situacao"));
        camiseta.setQuantidade(Integer.valueOf(request.getParameter("quantidade")));
        camiseta.setPreco(Double.valueOf(request.getParameter("preco")));

        dao.Editar(camiseta);
        //response.sendRedirect("listarProdutos");
    }

    private void desativar(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Camiseta camiseta = new Camiseta();
        CamisetaDAO dao = new CamisetaDAO();
        camiseta.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(camiseta);
        dao.Desativar(camiseta);
        
        //response.sendRedirect("listarProdutos");
    }

    private void listarTodos(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        CamisetaDAO dao = new CamisetaDAO();

        List<Camiseta> todasCamisetas = dao.consultarTodos();
        request.setAttribute("todasCamisetas", todasCamisetas);
        
        //request.getRequestDispatcher("admin/listarProdutos.jsp").forward(request, response);

    }
    
} 

