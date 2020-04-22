/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import DAO.CompraDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Carrinho;
import Model.Compra;
import Model.Cliente;
import java.sql.SQLException;

/**
 *
 * @author alunocmc
 */
@WebServlet(name = "ControllerCompra", urlPatterns = {"/finalizarCompra", "/minhasCompras"})
public class ControllerCompra extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/finalizarCompra")) {
                 finalizarCompra(request, response);            
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Erro.jsp");
        }
    }
    
    private void finalizarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException {

        Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
        Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
    
        Compra compra = new Compra();
        //compra.setCliente(cliente);
        compra.setTotal(carrinho.calcularTotal());

        CompraDAO dao = new CompraDAO();
        
        dao.cadastrar(compra);
        
        request.getSession().removeAttribute("carrinho");
        
        response.sendRedirect("pagamento");

    }

    private void minhasCompras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cliente usuarioLogado = (Cliente) request.getSession().getAttribute("usuarioLogado");
        List<Compra> comprasUsuario = null;

        if (usuarioLogado != null) {
            CompraDAO dao = new CompraDAO();
            //comprasUsuario = dao.listarComprasUsuario(usuarioLogado);
        }

        request.setAttribute("compras", comprasUsuario);
        request.getRequestDispatcher("minhasCompras.jsp").forward(request, response);
    }

}
