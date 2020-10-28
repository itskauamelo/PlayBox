package Controler;

import DAO.CamisetaDAO;
import DAO.GameDAO;
import DAO.PacoteDAO;
import DAO.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Usuario;
import DAO.UsuarioDAO;
import Model.Camiseta;
import Model.Game;
import Model.Pacote;
import Model.Produto;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Kauã Morateli
 */

@WebServlet(name = "ControleAcesso", urlPatterns = {"/ControleAcesso"})
public class ControleAcesso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String acao = request.getParameter("acao");
            if (acao.equals("Entrar")) {
                Usuario usuario = new Usuario();
                usuario.setLogin(request.getParameter("txtLogin"));
                usuario.setPw(request.getParameter("txtPw"));
                
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuarioAutenticado = usuarioDAO.autenticaUsuario(usuario);

                //Verifica se o usuario existe no banco
                if (usuarioAutenticado != null) {

                    //Cria uma sessao para o usuario
                    HttpSession sessaoUsuario = request.getSession();
                    sessaoUsuario.setAttribute("usuarioAutenticado", usuarioAutenticado);
                    
                    CamisetaDAO daoCamiseta = new CamisetaDAO();
                    GameDAO daoGame = new GameDAO();                    
                    PacoteDAO daoPacote = new PacoteDAO();                    
                    ProdutoDAO daoProduto = new ProdutoDAO();                    

                    List<Camiseta> todasCamisetas = daoCamiseta.consultarTodos();
                    request.setAttribute("todasCamisetas", todasCamisetas);

                    List<Game> todosGames = daoGame.consultarTodos();
                    request.setAttribute("todosGames", todosGames); 
                    
                    List<Pacote> todosPacotes = daoPacote.consultarTodos();
                    request.setAttribute("todosPacotes", todosPacotes);
                    
                    List<Produto> todosProdutos = daoProduto.consultarTodos();
                    request.setAttribute("todosProdutos", todosProdutos);
                    
                    //Redireciona para a pagina princiapal
                    RequestDispatcher rd = request.getRequestDispatcher("admin/index.jsp");
                    rd.forward(request, response);
                    
                } 
                else {
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }
            } else if (acao.equals("Sair")) {
                HttpSession sessaoUsuario = request.getSession();
                sessaoUsuario.removeAttribute("usuarioAutenticado");
                response.sendRedirect("login.jsp");
            }
        } catch (Exception erro) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            request.setAttribute("erro", erro);
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
