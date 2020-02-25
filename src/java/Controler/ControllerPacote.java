package Controler;

import DAO.CamisetaDAO;
import DAO.GameDAO;
import DAO.PacoteDAO;
import DAO.ProdutoDAO;
import Model.Camiseta;
import Model.Game;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Pacote;
import Model.Produto;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "PacoteControle", urlPatterns = {
    "/cadastrarPacote",
    "/listarPacotes",
    "/excluirPacote",
    "/iniciarEdicaoPacote",
    "/editarPacote",
    "/form/cadastroPacote"
})

public class ControllerPacote extends HttpServlet{
    
    
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         
        String uri = request.getRequestURI();
        
            if(uri.contains("/form")){
                GameDAO gameDAO = new GameDAO();
                List<Game> games = gameDAO.listarOpt();
                
                request.setAttribute("games", games);
                RequestDispatcher rd = request.getRequestDispatcher("teste.jsp");
                rd.forward(request, response);
            }   
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/excluirPacote")) {
                excluir(request, response);
            } else if (uri.equals(request.getContextPath() + "/listarPacotes")) {
                listarTodos(request, response);
            } else if (uri.equals(request.getContextPath() + "/iniciarEdicaoPacote")) {
                iniciarEdicao(request, response);
            } else if (uri.contains("form")) {
                listarCombo(request, response);
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

            if (uri.equals(request.getContextPath() + "/cadastrarPacote")) {
                cadastrar(request, response);
            } else if (uri.equals(request.getContextPath() + "/editarPacote")) {
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
        Pacote pacote = new Pacote();
        pacote.setNome(request.getParameter("txtNome"));
        pacote.setJogo(Integer.valueOf(request.getParameter("txtJogo")));
        pacote.setCamiseta(Integer.valueOf(request.getParameter("txtCamiseta")));
        pacote.setBrinde1(Integer.valueOf(request.getParameter("txtBrinde1")));
        pacote.setBrinde2(Integer.valueOf(request.getParameter("txtBrinde2")));
        pacote.setBrinde3(Integer.valueOf(request.getParameter("txtBrinde3")));
        pacote.setBrinde4(Integer.valueOf(request.getParameter("txtBrinde4")));
        pacote.setBrinde5(Integer.valueOf(request.getParameter("txtBrinde5")));
        pacote.setSituacao(request.getParameter("optSituacao"));
        pacote.setPreco(Double.parseDouble(request.getParameter("txtPreco")));
        

        PacoteDAO dao = new PacoteDAO();
        dao.cadastrar(pacote);
        
        response.sendRedirect("listarPacotes");

    }

    private void iniciarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Pacote pacote = new Pacote();
        PacoteDAO dao = new PacoteDAO();
        pacote.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(pacote);

        request.setAttribute("pacote", pacote);
        request.getRequestDispatcher("admin/EdProd.jsp").forward(request, response);
    }
    
        private void listarCombo(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        
        GameDAO gameDAO = new GameDAO();
        CamisetaDAO camisetaDAO = new CamisetaDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Game> games = gameDAO.listarOpt();
        List<Camiseta> camisetas = camisetaDAO.listarOpt();
        List<Produto> produtos = produtoDAO.listarOpt();
                
        request.setAttribute("games", games);
        request.setAttribute("camisetas", camisetas);
        request.setAttribute("produtos", produtos);
        RequestDispatcher rd = request.getRequestDispatcher("/admin/pacote.jsp");
        rd.forward(request, response);
    }

    private void confirmarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Pacote pacote = new Pacote();
        PacoteDAO dao = new PacoteDAO();
        pacote.setId(Integer.valueOf(request.getParameter("id")));
        pacote.setNome(request.getParameter("nome"));
        pacote.setJogo(Integer.valueOf(request.getParameter("jogo")));
        pacote.setCamiseta(Integer.valueOf(request.getParameter("camiseta")));
        pacote.setBrinde1(Integer.valueOf(request.getParameter("brinde1")));
        pacote.setBrinde2(Integer.valueOf(request.getParameter("brinde2")));
        pacote.setBrinde3(Integer.valueOf(request.getParameter("brinde3")));
        pacote.setBrinde4(Integer.valueOf(request.getParameter("brinde4")));
        pacote.setBrinde5(Integer.valueOf(request.getParameter("brinde5")));
        pacote.setSituacao(request.getParameter("situacao"));
        pacote.setPreco(Double.valueOf(request.getParameter("preco")));

        dao.Editar(pacote);
        response.sendRedirect("listarPacotes");
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Pacote pacote = new Pacote();
        PacoteDAO dao = new PacoteDAO();
        pacote.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(pacote);
        dao.Excluir(pacote);
        
        response.sendRedirect("listarProdutos");
    }

    private void listarTodos(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        PacoteDAO dao = new PacoteDAO();

        List<Pacote> todosPacotes = dao.consultarTodos();
        request.setAttribute("todosPacotes", todosPacotes);
        
        request.getRequestDispatcher("admin/listarPacotes.jsp").forward(request, response);

    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
} 

