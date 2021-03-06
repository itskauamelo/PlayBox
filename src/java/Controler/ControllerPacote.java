package Controler;

import DAO.CamisetaDAO;
import DAO.GameDAO;
import DAO.PacoteDAO;
import DAO.ProdutoDAO;
import Model.Camiseta;
import Model.Game;
import Model.Pacote;
import Model.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
/*
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         
        String uri = request.getRequestURI();
        
            if(uri.contains("/form")){
                GameDAO gameDAO = new GameDAO();

                List<Game> games = gameDAO.listarOpt();
      
                request.setAttribute("games", games);
      
                RequestDispatcher rd = request.getRequestDispatcher("../pacote.jsp");
                rd.forward(request, response);
                
            } else if (uri.contains("/edit/")){
                GameDAO gameDAO = new GameDAO();
                CamisetaDAO camisetaDAO = new CamisetaDAO();
                ProdutoDAO produtoDAO = new ProdutoDAO();
                List<Game> games = gameDAO.listarOpt();
                List<Camiseta> camisetas = camisetaDAO.listarOpt();
                List<Produto> produtos = produtoDAO.listarOpt();
                
                request.setAttribute("games", games);
                request.setAttribute("camisetas", camisetas);
                request.setAttribute("produtos", produtos);
                RequestDispatcher rd = request.getRequestDispatcher("admin/EdPacote.jsp");
                rd.forward(request, response);
            }
    }*/

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
            } else if (uri.contains("edit")){
                listarComboEd(request, response);
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
            response.sendRedirect("Erro.jsp");
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
        Pacote pacote = new Pacote();
        pacote.setNome(request.getParameter("txtNome"));
        pacote.setAssinatura(request.getParameter("txtAssinatura"));
        pacote.setJogo(request.getParameter("optJogo"));
        pacote.setCamiseta(request.getParameter("optCamiseta"));
        pacote.setBrinde1(request.getParameter("optBrinde1"));
        pacote.setBrinde2(request.getParameter("optBrinde2"));
        pacote.setBrinde3(request.getParameter("optBrinde3"));
        pacote.setBrinde4(request.getParameter("optBrinde4"));
        pacote.setBrinde5(request.getParameter("optBrinde5"));
        pacote.setSituacao(request.getParameter("optSituacao"));
        pacote.setPreco(Double.parseDouble(request.getParameter("txtPreco")));
        pacote.setQuantidade(Integer.valueOf(request.getParameter("txtQuantidade")));
        
        PacoteDAO dao = new PacoteDAO();
        dao.cadastrar(pacote);
        dao.subtrairQuantidade(pacote);
        
        response.sendRedirect("listarPacotes");

    }

    private void iniciarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Pacote pacote = new Pacote();
        GameDAO gameDAO = new GameDAO();
        CamisetaDAO camisetaDAO = new CamisetaDAO();
        PacoteDAO pacoteDAO = new PacoteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
  
        pacote.setId(Integer.valueOf(request.getParameter("id")));

        pacoteDAO.consultarporId(pacote);

        
        List<Game> games = gameDAO.listarOpt();
        List<Camiseta> camisetas = camisetaDAO.listarOpt();
        List<Produto> produtos = produtoDAO.listarOpt();
        
        request.setAttribute("games", games);
        request.setAttribute("camisetas", camisetas);
        request.setAttribute("produtos", produtos);
        request.setAttribute("pacote", pacote);
        RequestDispatcher rd = request.getRequestDispatcher("admin/EdPacote.jsp");
        rd.forward(request, response);
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
        
        private void listarComboEd(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {

        GameDAO gameDAO = new GameDAO();
        CamisetaDAO camisetaDAO = new CamisetaDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Game> games = gameDAO.listarOpt();
        List<Camiseta> camisetas = camisetaDAO.listarOpt();
        List<Produto> produtos = produtoDAO.listarOpt();

        request.setAttribute("games", games);
        request.setAttribute("camisetas", camisetas);
        request.setAttribute("produtos", produtos);
        RequestDispatcher rd = request.getRequestDispatcher("/admin/EdPacote.jsp");
        rd.forward(request, response);
    }

        //revisar metodo abaixo (alterar nome campo p/ atender quantidade)
        private void confirmarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Pacote pacote = new Pacote();
        PacoteDAO dao = new PacoteDAO();
        pacote.setId(Integer.valueOf(request.getParameter("id")));
        pacote.setNome(request.getParameter("nome"));
        pacote.setJogo(request.getParameter("jogo"));
        pacote.setCamiseta(request.getParameter("camiseta"));
        pacote.setBrinde1(request.getParameter("brinde1"));
        pacote.setBrinde2(request.getParameter("brinde2"));
        pacote.setBrinde3(request.getParameter("brinde3"));
        pacote.setBrinde4(request.getParameter("brinde4"));
        pacote.setBrinde5(request.getParameter("brinde5"));
        pacote.setSituacao(request.getParameter("situacao"));
        pacote.setQuantidade(Integer.valueOf(request.getParameter("txtQuantidade")));

        dao.Editar(pacote);
        response.sendRedirect("listarPacotes");
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Pacote pacote = new Pacote();
        PacoteDAO dao = new PacoteDAO();
        pacote.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(pacote);
        dao.Excluir(pacote);
        
        response.sendRedirect("listarPacotes");
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

