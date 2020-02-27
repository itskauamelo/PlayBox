package Controler;

import DAO.GameDAO;
import Model.Game;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "GameControle", urlPatterns = {
    "/cadastrarGame",
    "/listarGames",
    "/desativarGame",
    "/iniciarEdicaoGame",
    "/editarGame"
})

public class ControllerGame extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/desativarGame")) {
                desativar(request, response);
            } else if (uri.equals(request.getContextPath() + "/listarGames")) {
                listarTodos(request, response);
            } else if (uri.equals(request.getContextPath() + "/iniciarEdicaoGame")) {
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

            if (uri.equals(request.getContextPath() + "/cadastrarGame")) {
                cadastrar(request, response);
            } else if (uri.equals(request.getContextPath() + "/editarGame")) {
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
        Game game = new Game();
        game.setNome(request.getParameter("txtNome"));
        game.setDescricao(request.getParameter("txtDescricao"));
        game.setPlataforma(request.getParameter("txtPlataforma"));
        game.setImagem(request.getParameter("txtImagem"));
        game.setSituacao(request.getParameter("optSituacao"));
        game.setQuantidade(Integer.valueOf(request.getParameter("txtQuantidade")));
        game.setPreco(Double.parseDouble(request.getParameter("txtPreco")));
        

        GameDAO dao = new GameDAO();
        dao.cadastrar(game);
        
        response.sendRedirect("listarGames");

        
    }

    private void iniciarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Game game = new Game();
        GameDAO dao = new GameDAO();
        game.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(game);

        request.setAttribute("game", game);
        request.getRequestDispatcher("admin/EdGame.jsp").forward(request, response);
    }

    private void confirmarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Game game = new Game();
        GameDAO dao = new GameDAO();
        game.setId(Integer.valueOf(request.getParameter("id")));
        game.setNome(request.getParameter("nome"));
        game.setDescricao(request.getParameter("descricao"));
        game.setPlataforma(request.getParameter("plataforma"));
        game.setImagem(request.getParameter("imagem"));
        game.setSituacao(request.getParameter("situacao"));
        game.setQuantidade(Integer.valueOf(request.getParameter("quantidade")));
        game.setPreco(Double.valueOf(request.getParameter("preco")));

        dao.Editar(game);
        response.sendRedirect("listarGames");
    }

    private void desativar(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Game game = new Game();
        GameDAO dao = new GameDAO();
        game.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(game);
        dao.Desativar(game);
        
        response.sendRedirect("listarGames");
    }

    private void listarTodos(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        GameDAO dao = new GameDAO();

        List<Game> todosGames = dao.consultarTodos();
        request.setAttribute("todosGames", todosGames);
        
        request.getRequestDispatcher("admin/listarGames.jsp").forward(request, response);

    }
    
} 

