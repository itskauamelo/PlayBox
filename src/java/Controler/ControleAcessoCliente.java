package Controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Cliente;
import DAO.ClienteDAO;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Kauã Morateli
 */

@WebServlet(name = "ControleAcessoCliente", urlPatterns = {"/ControleAcessoCliente"})
public class ControleAcessoCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String acao = request.getParameter("acao");
            if (acao.equals("Entrar")) {
                Cliente cliente = new Cliente();
                cliente.setEmail(request.getParameter("txtEmail"));
                cliente.setSenha(request.getParameter("txtSenha"));
                
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente clienteAutenticado = clienteDAO.autenticaCliente(cliente);

                //Verifica se o usuario existe no banco
                if (clienteAutenticado != null) {

                    //Cria uma sessao para o usuario
                    HttpSession sessaoCliente = request.getSession();
                    sessaoCliente.setAttribute("clienteAutenticado", clienteAutenticado);
                    
                    //Redireciona para a pagina princiapal
                    response.sendRedirect("bemvindo");
                    
                } 
                else {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }
            } else if (acao.equals("Sair")) {
                HttpSession sessaoCliente = request.getSession();
                sessaoCliente.removeAttribute("clienteAutenticado");
                response.sendRedirect("inicio");
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
