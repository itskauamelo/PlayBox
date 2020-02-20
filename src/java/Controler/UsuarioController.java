package Controler;

import DAO.UsuarioDAO;
import Model.EnumPerfilAcesso;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Usuario;



@WebServlet(name = "UsuarioControle", urlPatterns = {
    "/cadastrarUsuario",
    "/listarUsuario",
    "/excluirUsuario",
    "/iniciarEdicaoUsuario",
    "/editarUsuario"
})

public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/excluirUsuario")) {
                excluir(request, response);
            } else if (uri.equals(request.getContextPath() + "/listarUsuario")) {
                listarTodos(request, response);
            } else if (uri.equals(request.getContextPath() + "/iniciarEdicaoUsuario")) {
                iniciarEdicao(request, response);
            } else {
                listarTodos(request, response);
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

            if (uri.equals(request.getContextPath() + "/cadastrarUsuario")) {
                cadastrar(request, response);
            } else if (uri.equals(request.getContextPath() + "/editarUsuario")) {
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
        Usuario usuario = new Usuario();
        usuario.setNome(request.getParameter("nome"));
        usuario.setLogin(request.getParameter("login"));
        usuario.setPw(request.getParameter("pw"));
        usuario.setPerfil(EnumPerfilAcesso.valueOf(request.getParameter("perfil")));
        usuario.setSituacao(request.getParameter("situacao"));

        UsuarioDAO dao = new UsuarioDAO();
        dao.cadastrar(usuario);

        response.sendRedirect("listarUsuario");
        
    }

    private void iniciarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        usuario.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(usuario);

        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("admin/EdUser.jsp").forward(request, response);
    }

    private void confirmarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        usuario.setId(Integer.valueOf(request.getParameter("id")));
        usuario.setNome(request.getParameter("nome"));
        usuario.setLogin(request.getParameter("login"));
        usuario.setPw(request.getParameter("pw"));
        usuario.setPerfil(EnumPerfilAcesso.valueOf(request.getParameter("perfil")));
        usuario.setSituacao(request.getParameter("situacao"));

        dao.Editar(usuario);
        response.sendRedirect("listarUsuario");
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        usuario.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(usuario);
        dao.Excluir(usuario);
        
        response.sendRedirect("listarUsuario");
    }

    private void listarTodos(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        UsuarioDAO dao = new UsuarioDAO();

        List<Usuario> todosUsuario = dao.consultarTodos();
        request.setAttribute("todosUsuario", todosUsuario);

        request.getRequestDispatcher("admin/listar.jsp").forward(request, response);
    }

}
