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

/**
 *
 * @author alunocmc
 */
@WebServlet(name = "ControllerCompra", urlPatterns = {"/finalizarCompra", "/minhasCompras"})
public class ControllerCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();

        if (url.equals(request.getContextPath() + "/finalizarCompra")) {
            finalizarCompra(request, response);
        } else if (url.equals(request.getContextPath() + "/minhasCompras")) {
            minhasCompras(request, response);
        } else {
            response.sendRedirect("erro.jsp");
        }
    }

    private void finalizarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Cliente usuarioLogado = (Cliente) request.getSession().getAttribute("usuarioLogado");
        Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
    
        Compra compra = new Compra();
        compra.setCarrinho(carrinho);
        compra.setData(new Date());
        compra.setCliente(usuarioLogado);
        compra.setTotal(carrinho.calcularTotal());

        CompraDAO dao = new CompraDAO();
        dao.cadastrar(compra);
        
        request.getSession().removeAttribute("carrinho");
        
        request.setAttribute("msgSucesso", "Sua compra foi finalizada com sucesso!");
        minhasCompras(request, response);
    }

    private void minhasCompras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cliente usuarioLogado = (Cliente) request.getSession().getAttribute("usuarioLogado");
        List<Compra> comprasUsuario = null;

        if (usuarioLogado != null) {
            CompraDAO dao = new CompraDAO();
            comprasUsuario = dao.listarComprasUsuario(usuarioLogado);
        }

        request.setAttribute("compras", comprasUsuario);
        request.getRequestDispatcher("minhasCompras.jsp").forward(request, response);
    }

}
