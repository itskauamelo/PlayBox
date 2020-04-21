/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import DAO.CompraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alunocmc
 */
@WebServlet(name = "ControllerCompra", urlPatterns = {"/finalizarCompra", "/minhasCompras"})
public class ControllerCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
        String uri = request.getRequestURI();

        if (uri.equals(request.getContextPath() + "/minhasCompras")) {
            minhasCompras(request, response);
        } else {
                response.sendRedirect("404.jsp");
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

            if (uri.equals(request.getContextPath() + "/finalizarCompra")) {
                 finalizarCompra(request, response);            
            } else {
                response.sendRedirect("404.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("../Erro.jsp");
        }
    }
    
    private void finalizarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException {

        //Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
        Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
    
        Compra compra = new Compra();
        //compra.setCliente(cliente);
        compra.setCarrinho(carrinho);
        compra.setTotal((int) carrinho.calcularTotal());

        CompraDAO dao = new CompraDAO();
        
        dao.cadastrar(compra);
        
        request.getSession().removeAttribute("carrinho");
        
        request.setAttribute("msgSucesso", "Sua compra foi finalizada com sucesso!");
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
