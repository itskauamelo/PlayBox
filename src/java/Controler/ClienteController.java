/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Controler;

import DAO.ClienteDAO;
import Model.Cartao;
import Model.Cliente;
import Model.Preferencia;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteControle", urlPatterns = {
    "/cadastrarCliente",
    "/listarCliente",
    "/excluirCliente",
    "/iniciarEdicaoCliente",
    "/editarCliente",
    "/ativarCadastro",
    "/cadastrarPreferencia",
    "/cadastrarCartao",
    "/pagamento"
})

public class ClienteController extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/excluirCliente")) {
                excluir(request, response);
            } else if (uri.equals(request.getContextPath() + "/listarCliente")) {
                listarTodos(request, response);
            } else if (uri.equals(request.getContextPath() + "/pagamento")) {
                listarTodosCartoes(request, response);
            } else if (uri.equals(request.getContextPath() + "/iniciarEdicaoCliente")) {
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

            if (uri.equals(request.getContextPath() + "/cadastrarCliente")) {
                cadastrar(request, response);
            } else if (uri.equals(request.getContextPath() + "/cadastrarCartao")) {
                cadastrarCartao(request, response);
            } else if (uri.equals(request.getContextPath() + "/editarSenhaCliente")) {
                confirmarEdicaoSenha(request, response);
            } else if (uri.equals(request.getContextPath() + "/ativarCadastro")) {
                ativarCadastro(request, response);
            } else if (uri.equals(request.getContextPath() + "/cadastrarPreferencia" )) {
                cadastrarPreferencia(request, response);
            } else {
                response.sendRedirect("404.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("../Erro.jsp");
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(request.getParameter("txtCpf"));
        cliente.setNomecompleto(request.getParameter("txtNomecompleto"));
        cliente.setDatanascimento(Date.valueOf(request.getParameter("txtData")));
        cliente.setGenero(request.getParameter("optGenero"));
        cliente.setEmail(request.getParameter("txtEmail"));
        cliente.setSenha(request.getParameter("txtSenha"));
        cliente.setCelular(request.getParameter("txtCelular"));
        cliente.setEndidentific(request.getParameter("txtIdEnd"));
        cliente.setNomedestinatario(request.getParameter("txtNomedestinatario"));
        cliente.setCep(request.getParameter("txtCep"));
        cliente.setEndereco(request.getParameter("txtEndereco"));
        cliente.setNumero(request.getParameter("txtNumero"));
        cliente.setComplemento(request.getParameter("txtComplemento"));
        cliente.setReferencia(request.getParameter("txtReferencia"));
        cliente.setBairro(request.getParameter("txtBairro"));
        cliente.setCidade(request.getParameter("txtCidade"));
        cliente.setEstado(request.getParameter("optEstado"));
        

        ClienteDAO dao = new ClienteDAO();
        dao.cadastrar(cliente);

       response.sendRedirect("cadastrado.jsp");
        
    }
    
    private void cadastrarPreferencia(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        
        Preferencia preferencia = new Preferencia();
        
        preferencia.setPreferencia1(request.getParameter("check"));
        preferencia.setPreferencia2(request.getParameter("check"));
        preferencia.setPreferencia3(request.getParameter("check"));
        preferencia.setHorasjogo(request.getParameter("rbhr"));
        preferencia.setJogoonline(request.getParameter("rbonline"));
        
        ClienteDAO dao = new ClienteDAO();
        dao.cadastrarpreferencia(preferencia);
        
        response.sendRedirect("indexLogado.jsp");
   
    }
    
    private void ativarCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        
        Cliente cliente = new Cliente();
        cliente.setCpf(request.getParameter("txtCpf"));
        
        ClienteDAO dao = new ClienteDAO();
        dao.ativarCadastro(cliente);

        request.setAttribute("msg", "Cadastro ativado, redirecionando para página principal para que realize o login!");
        response.sendRedirect("preferenciaCliente.jsp");
        
    }

    private void iniciarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cliente.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(cliente);

        request.setAttribute("cliente", cliente);
         request.getRequestDispatcher("admin/EdUser.jsp").forward(request, response);
    }

    private void confirmarEdicaoSenha(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cliente.setId(Integer.valueOf(request.getParameter("id")));
        cliente.setSenha(request.getParameter("txtSenha"));
       
        dao.EditarSenha(cliente);
        
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cliente.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(cliente);
        dao.Desativar(cliente);
        
    }

    private void cadastrarCartao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {

        Cartao cartao = new Cartao();

        cartao.setBandeira(request.getParameter("txtBandeira"));
        cartao.setNumero(request.getParameter("txtNumeroCartao"));
        cartao.setNomecartao(request.getParameter("txtNomeCartao"));
        cartao.setValidade(request.getParameter("txtValidadeCartao"));
        cartao.setCodigo(Integer.valueOf(request.getParameter("txtCodigoCartao")));
        cartao.setCliente(request.getParameter("txtIdCliente"));

        ClienteDAO dao = new ClienteDAO();
        dao.adicionarCartao(cartao);

        response.sendRedirect("pagamento");
/*
        request.setAttribute("msg", "Cadastro ativado, redirecionando para página principal para que realize o login!");
        
*/
        
    }
    
    private void listarTodos(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        ClienteDAO dao = new ClienteDAO();

        List<Cliente> todosCliente = dao.consultarTodos();
        request.setAttribute("todosCliente", todosCliente);

        request.getRequestDispatcher("admin/index.jsp").forward(request, response);
    }
    
    private void listarTodosCartoes(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        ClienteDAO dao = new ClienteDAO();

        List<Cartao> todosCartoes = dao.consultarTodosCartoes();
        request.setAttribute("todosCartoes", todosCartoes);

        request.getRequestDispatcher("metodoPagamento.jsp").forward(request, response);
    }
    
}
