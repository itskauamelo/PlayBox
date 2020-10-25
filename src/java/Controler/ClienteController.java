/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Controler;

import DAO.ClienteDAO;
import Model.Cartao;
import Model.Cliente;
import Model.Endereco;
import Model.Pesquisa;
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "ClienteControle", urlPatterns = {
    "/cadastrarCliente",
    "/listarCliente",
    "/excluirCliente",
    "/removerAss",
    "/iniciarEdicaoCliente",
    "/iniciarAlteracaoSenha",
    "/editarCliente",
    "/ativarCadastro",
    "/cadastrarPreferencia",
    "/cadastrarPesquisaCancelamento",
    "/cadastrarCartao",
    "/pagamento",
    "/cadastrarEndereco",
    "/listarMeusEndCart",
    "/cadastrarFk",
    "/relatorioPreferencia",
    "/minhaConta",
    "/bemvindo",
    "/inicio",
    "/formPesquisaCancelamento",
    "/alterarSenha"
})

public class ClienteController extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/excluirCliente")) {
                desativar(request, response);
            } else if (uri.equals(request.getContextPath() + "/removerAss")) {
                removerAssinatura(request, response);
            } else if (uri.equals(request.getContextPath() + "/listarCliente")) {
                listarTodos(request, response);
            } else if (uri.equals(request.getContextPath() + "/pagamento")) {
                listarMeusEnderecosCartoes(request, response);
            } else if (uri.equals(request.getContextPath() + "/listarMeusEndCart")) {
                listarMeusEndCart(request, response);
            } else if (uri.equals(request.getContextPath() + "/iniciarEdicaoCliente")) {
                iniciarEdicao(request, response);
            } else if (uri.equals(request.getContextPath() + "/iniciarAlteracaoSenha")) {
                iniciarAlteracaoSenha(request,response);
            } else if (uri.equals(request.getContextPath() + "/relatorioPreferencia")) {
                relatorioPreferencia(request, response);
            } else if (uri.equals(request.getContextPath() + "/minhaConta")) {
                minhaConta(request, response);
            } else if (uri.equals(request.getContextPath() + "/bemvindo")) {
                bemvindo(request, response);
            } else if (uri.equals(request.getContextPath() + "/inicio")) {
                inicio(request, response);
            } else if (uri.equals(request.getContextPath() + "/formPesquisaCancelamento")) {
                formPesquisaCancelamento(request, response);
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
            } else if (uri.equals(request.getContextPath() + "/cadastrarEndereco")) {
                cadastrarEndereco(request, response);
            }  else if (uri.equals(request.getContextPath() + "/alterarSenha")) {
                confirmarEdicaoSenha(request, response);
            } else if (uri.equals(request.getContextPath() + "/ativarCadastro")) {
                ativarCadastro(request, response);
            } else if (uri.equals(request.getContextPath() + "/cadastrarPreferencia" )) {
                cadastrarPreferencia(request, response);
            } else if (uri.equals(request.getContextPath() + "/cadastrarPesquisaCancelamento")) {
                cadastrarPesquisaCancelamento(request, response);
            } else if (uri.equals(request.getContextPath() + "/editarCliente")) {
                confirmarEdicao(request, response);
            }
            else {
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
        
        ClienteDAO dao = new ClienteDAO();
        dao.cadastrar(cliente);

       response.sendRedirect("cadastrado.jsp");
        
    }
    
    private void cadastrarPreferencia(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        
        Preferencia preferencia = new Preferencia();
        
        preferencia.setPreferencia1(request.getParameter("check"));
        preferencia.setPreferencia2(request.getParameter("check2"));
        preferencia.setPreferencia3(request.getParameter("check3"));
        preferencia.setHorasjogo(request.getParameter("rbhr"));
        preferencia.setJogoonline(request.getParameter("rbonline"));
        
        ClienteDAO dao = new ClienteDAO();
        dao.cadastrarpreferencia(preferencia);
        
        response.sendRedirect(request.getContextPath());
   
    }
    
    private void cadastrarPesquisaCancelamento(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        
        Pesquisa pesquisa = new Pesquisa();
        
        pesquisa.setAvaliacao1(request.getParameter("rate1"));
        pesquisa.setAvaliacao2(request.getParameter("rate2"));
        pesquisa.setAvaliacao3(request.getParameter("rate3"));
        pesquisa.setAvaliacao4(request.getParameter("rate4"));
        pesquisa.setAvaliacao5(request.getParameter("rate5"));
        
        ClienteDAO dao = new ClienteDAO();
        dao.cadastrarPesquisa(pesquisa);
        
        response.sendRedirect(request.getContextPath());
   
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
        request.getRequestDispatcher("edCliente.jsp").forward(request, response);
    }
    
    private void iniciarAlteracaoSenha(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cliente.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(cliente);

        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("alterarSenha.jsp").forward(request, response);
    }

    private void confirmarEdicaoSenha(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cliente.setId(Integer.valueOf(request.getParameter("id")));
        cliente.setSenha(request.getParameter("pw"));
       
        dao.EditarSenha(cliente);
        response.sendRedirect("minhaConta");
        
    }

    private void desativar(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cliente.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(cliente);
        dao.Desativar(cliente);
        
        response.sendRedirect(request.getContextPath());
        
    }
    
    private void removerAssinatura(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
        ClienteDAO dao = new ClienteDAO();
        
        HttpSession sessaoCliente = request.getSession();
        Cliente clienteAutenticado = (Cliente) sessaoCliente.getAttribute("clienteAutenticado");
        
        dao.removerAssinatura(clienteAutenticado);
        
        response.sendRedirect("formPesquisaCancelamento");
    }

    private void cadastrarCartao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {

        HttpSession sessaoCliente = request.getSession();
        Cliente clienteAutenticado = (Cliente) sessaoCliente.getAttribute("clienteAutenticado");
        
        Cartao cartao = new Cartao();
      
        cartao.setBandeira(request.getParameter("txtBandeira"));
        cartao.setNumero(request.getParameter("txtNumeroCartao"));
        cartao.setNomecartao(request.getParameter("txtNomeCartao"));
        cartao.setValidade(request.getParameter("txtValidadeCartao"));
        cartao.setCodigo(Integer.valueOf(request.getParameter("txtCodigoCartao")));        

        ClienteDAO dao = new ClienteDAO();   
        dao.adicionarCartao(cartao, clienteAutenticado);

        response.sendRedirect("listarMeusEndCart");

    }
    
    private void cadastrarEndereco(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {

        HttpSession sessaoCliente = request.getSession();
        Cliente clienteAutenticado = (Cliente) sessaoCliente.getAttribute("clienteAutenticado");
        
        Endereco endereco = new Endereco();

        endereco.setCep(Integer.valueOf(request.getParameter("txtCep")));
        endereco.setRua(request.getParameter("txtRua"));
        endereco.setNumero(Integer.valueOf(request.getParameter("txtNumero")));
        endereco.setComplemento(request.getParameter("txtComplemento"));
        endereco.setBairro(request.getParameter("txtBairro"));
        endereco.setCidade(request.getParameter("txtCidade"));
        endereco.setUf(request.getParameter("txtUf"));       

        ClienteDAO dao = new ClienteDAO();
        dao.adicionarEndereco(endereco, clienteAutenticado);
        
        response.sendRedirect("listarMeusEndCart");
        
    }
    
    private void listarTodos(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        ClienteDAO dao = new ClienteDAO();

        List<Cliente> todosCliente = dao.consultarTodos();
        request.setAttribute("todosCliente", todosCliente);

        request.getRequestDispatcher("admin/index.jsp").forward(request, response);
    }
    
    private void minhaConta(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {

        request.getRequestDispatcher("manutencaoCliente.jsp").forward(request, response);
    }
    
    
        private void confirmarEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cliente.setId(Integer.valueOf(request.getParameter("id")));
        cliente.setCpf(request.getParameter("cpf"));
        cliente.setNomecompleto(request.getParameter("nome"));
        cliente.setGenero(request.getParameter("genero"));
        cliente.setDatanascimento(Date.valueOf(request.getParameter("datanascimento")));
        cliente.setEmail(request.getParameter("email"));
        cliente.setCelular(request.getParameter("celular"));

        dao.Editar(cliente);
        
        response.sendRedirect("minhaConta");
        
    }
    
    private void listarMeusEnderecosCartoes(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        ClienteDAO dao = new ClienteDAO();

        HttpSession sessaoCliente = request.getSession();
        Cliente clienteAutenticado = (Cliente) sessaoCliente.getAttribute("clienteAutenticado");
        
        List<Endereco> MeusEnderecos = dao.consultarMeusEnderecos(clienteAutenticado);
        List<Cartao> MeusCartoes = dao.consultarMeusCartoes(clienteAutenticado);
        
        request.setAttribute("meusEnderecos", MeusEnderecos);
        request.setAttribute("meusCartoes", MeusCartoes);
        
        request.getRequestDispatcher("metodoPagamento.jsp").forward(request, response);
    }
    
    private void listarMeusEndCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        ClienteDAO dao = new ClienteDAO();

        HttpSession sessaoCliente = request.getSession();
        Cliente clienteAutenticado = (Cliente) sessaoCliente.getAttribute("clienteAutenticado");
        
      //List<Compra> minhasCompras = dao.consultarMinhasCompras(clienteAutenticado);
        List<Endereco> MeusEnderecos = dao.consultarMeusEnderecos(clienteAutenticado);
        List<Cartao> MeusCartoes = dao.consultarMeusCartoes(clienteAutenticado);
        
        request.setAttribute("meusEnderecos", MeusEnderecos);
        request.setAttribute("meusCartoes", MeusCartoes);
        
        request.getRequestDispatcher("dadosPessoais.jsp").forward(request, response);
    }
    
    
    private void relatorioPreferencia(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        ClienteDAO dao = new ClienteDAO();

        List<Preferencia> todasPreferencias = dao.consultarTodasPreferencias();
        request.setAttribute("todasPreferencias", todasPreferencias);
        request.getRequestDispatcher("admin/relatorioPreferencia.jsp").forward(request, response);
    }
    
    private void bemvindo(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        request.getRequestDispatcher("indexLogado.jsp").forward(request, response);
    }
    
    private void inicio(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    private void formPesquisaCancelamento(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        request.getRequestDispatcher("FormCancelamento.jsp").forward(request, response);
    }
}
