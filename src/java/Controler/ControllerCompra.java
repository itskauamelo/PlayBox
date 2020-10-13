/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import DAO.ClienteDAO;
import DAO.CompraDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Carrinho;
import Model.Cliente;
import Model.Compra;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author alunocmc
 */
@WebServlet(name = "ControllerCompra", urlPatterns = {
    "/finalizarCompra",
    "/finalizarAssinatura",
    "/minhasCompras",
    "/fecharCompra",
    "/compraFinalizada",
    "/listarCompras",
    "/listarComprasADM",
    "/iniciarAltStatus",
    "/alterarStatus",
    "/mostrarPedido",
    "/removerAssinatura",
    "/aprovarPagamento"
})

public class ControllerCompra extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/fecharCompra")) {
                fecharCompra(request, response);
            } else if (uri.equals(request.getContextPath() + "/alterarStatus")) {
                alterarStatus(request, response);
            } else if (uri.equals(request.getContextPath() + "/aprovarPagamento")) {
                aprovarPagamento(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Erro.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/finalizarCompra")) {
                finalizarCompra(request, response);
            } else if (uri.equals(request.getContextPath() + "/finalizarAssinatura")) {
                finalizarAssinatura(request, response);
            } else if (uri.equals(request.getContextPath() + "/compraFinalizada")) {
                listarUltimaCompra(request, response);
            } else if (uri.equals(request.getContextPath() + "/listarCompras")) {
                listarComprasCliente(request, response);
            } else if (uri.equals(request.getContextPath() + "/listarComprasADM")) {
                listarTodasADM(request, response);
            } else if (uri.equals(request.getContextPath() + "/mostrarPedido")) {
                mostrarPedido(request, response);
            } else if (uri.equals(request.getContextPath() + "/iniciarAltStatus")) {
                iniciarAltStatus(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Erro.jsp");
        }
    }

    private void finalizarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException {

        Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");

        Compra compra = new Compra();
        compra.setTotal(carrinho.calcularTotal());
        CompraDAO dao = new CompraDAO();

        dao.cadastrar(compra);
        request.getSession().removeAttribute("carrinho");

        response.sendRedirect("pagamento");

    }
    
    private void finalizarAssinatura(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException {

        Carrinho carrinho = (Carrinho) request.getSession().getAttribute("assinatura");

        Compra compra = new Compra();
        compra.setTotal(carrinho.precoAssinatura());
        
        HttpSession sessaoCliente = request.getSession();
        Cliente clienteAutenticado = (Cliente) sessaoCliente.getAttribute("clienteAutenticado");
        CompraDAO dao = new CompraDAO();

        dao.cadastrarAss(compra);
        dao.assinatura(clienteAutenticado);

        request.getSession().removeAttribute("assinatura");

        response.sendRedirect("pagamento");

    }

    private void iniciarAltStatus(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Compra compra = new Compra();
        CompraDAO dao = new CompraDAO();

        compra.setId(Integer.valueOf(request.getParameter("id")));

        dao.consultarporId(compra);
        request.setAttribute("compra", compra);
        request.getRequestDispatcher("admin/altStatus.jsp").forward(request, response);
    }

    private void alterarStatus(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Compra compra = new Compra();
        CompraDAO dao = new CompraDAO();
        compra.setId(Integer.valueOf(request.getParameter("id")));
        compra.setStatus(Integer.valueOf(request.getParameter("optStatus")));
        /*if (status == null) {
            JOptionPane.showMessageDialog(null,"Selecione uma alteração");
        } else {
            dao.alterarStatus(compra);

            response.sendRedirect("listarComprasADM");
        }*/
        dao.alterarStatus(compra);

        response.sendRedirect("listarComprasADM");
    }

    private void fecharCompra(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException {

        Compra compra = new Compra();
        compra.setCliente(request.getParameter("txtIdCliente"));
        ClienteDAO daocli = new ClienteDAO();
        daocli.cadastrarFk(compra);

        compra.setEnderecoentrega(Integer.valueOf(request.getParameter("chkEndereco")));
        compra.setMetodopagamento(Integer.valueOf(request.getParameter("rbtMetodo")));
        compra.setCartaocredito(Integer.valueOf(request.getParameter("chkCartao")));
        CompraDAO dao = new CompraDAO();
        dao.fecharCompra(compra);

        response.sendRedirect("compraFinalizada");

    }

    private void listarUltimaCompra(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        CompraDAO dao = new CompraDAO();

        List<Compra> ultimaCompra = dao.consultarUltimaCompra();
        request.setAttribute("ultimaCompra", ultimaCompra);

        request.getRequestDispatcher("compraFinalizada.jsp").forward(request, response);
    }

    private void listarTodas(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        CompraDAO dao = new CompraDAO();

        List<Compra> todasCompras = dao.consultarTodas();
        request.setAttribute("todasCompras", todasCompras);

        request.getRequestDispatcher("listarPedidos.jsp").forward(request, response);

    }
    
        private void listarComprasCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        CompraDAO dao = new CompraDAO();

        HttpSession sessaoCliente = request.getSession();
        Cliente clienteAutenticado = (Cliente) sessaoCliente.getAttribute("clienteAutenticado");
             
        List<Compra> minhasCompras = dao.consultarMinhasCompras(clienteAutenticado);
        request.setAttribute("minhasCompras", minhasCompras);

        request.getRequestDispatcher("listarPedidos.jsp").forward(request, response);

    }

    private void listarTodasADM(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        CompraDAO dao = new CompraDAO();

        List<Compra> todasComprasPagamento = dao.consultarTodasAgPagamento();
        request.setAttribute("todasComprasPagamento", todasComprasPagamento);

        request.getRequestDispatcher("admin/listarPedidos.jsp").forward(request, response);

    }

    private void mostrarPedido(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Compra compra = new Compra();
        CompraDAO compraDAO = new CompraDAO();

        compra.setId(Integer.valueOf(request.getParameter("id")));

        compraDAO.consultarporId(compra);

        request.setAttribute("compra", compra);
        RequestDispatcher rd = request.getRequestDispatcher("statusDoPedido.jsp");
        rd.forward(request, response);
    }

    private void aprovarPagamento(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Compra compra = new Compra();
        CompraDAO dao = new CompraDAO();
        compra.setId(Integer.valueOf(request.getParameter("id")));

        dao.statusPago(compra);

        response.sendRedirect("listarComprasADM");
    }
}
