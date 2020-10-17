/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import DAO.AssinaturaDAO;
import DAO.PacoteDAO;
import Model.Assinatura;
import Model.Carrinho;
import Model.Cliente;
import Model.Pacote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kaua.Morateli
 */
    @WebServlet(name = "ControllerCarrinho", urlPatterns = {"/ControllerCarrinho",
    "/adicionarCarrinho", 
    "/removerCarrinho",
    "/assinar",
    "/assinatura",
    "/removerDoCarrinhoAssinatura",
    "/carrinho"})
    
public class ControllerCarrinho extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = request.getRequestURI();

        if (url.equals(request.getContextPath() + "/adicionarCarrinho")) {
            colocarCarrinho(request, response);
        } else if (url.equals(request.getContextPath() + "/assinar")) {
                assinar(request, response);
        } else if (url.equals(request.getContextPath() + "/removerCarrinho")) {
            removerDoCarrinho(request, response);
        } else if (url.equals(request.getContextPath() + "/carrinho")) {
            consultarCarrinho(request, response);
        } else if (url.equals(request.getContextPath() + "/removerDoCarrinhoAssinatura")) {
            removerDoCarrinhoAssinatura(request, response);
        } else {
            consultarAssinatura(request, response);
        }
    }
    
    private void colocarCarrinho(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id")); 

            PacoteDAO dao = new PacoteDAO();
            Pacote pacoteAdicionar = dao.consultarPorIdCarrinho(id);
            
            Carrinho carrinho = (Carrinho) request.getSession(true).getAttribute("carrinho"); 
            
            if (carrinho == null){ 
                carrinho = new Carrinho();
                request.getSession().setAttribute("carrinho", carrinho);
            }
            carrinho.addPacote(pacoteAdicionar);
            response.sendRedirect("carrinho");
            
        
        } catch (Exception ex) {
            Logger.getLogger(ControllerCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void assinar(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            int id = Integer.parseInt(request.getParameter("id")); 
            
            HttpSession sessaoCliente = request.getSession();
            Cliente clienteAutenticado = (Cliente) sessaoCliente.getAttribute("clienteAutenticado");
            
            
            AssinaturaDAO dao = new AssinaturaDAO();
            Assinatura AssinaturaAdicionar = dao.consultarPorIdCarrinho(id);
            
            dao.inserirAssinatura(id, clienteAutenticado);
           
            Carrinho carrinho = (Carrinho) request.getSession(true).getAttribute("carrinho"); 
            
            if (carrinho == null){ 
                carrinho = new Carrinho();
                request.getSession().setAttribute("carrinho", carrinho);
            }
            carrinho.addAssinatura(AssinaturaAdicionar);
            response.sendRedirect("assinatura");
            
        
        } catch (Exception ex) {
            Logger.getLogger(ControllerCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    private void removerDoCarrinho(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            PacoteDAO dao = new PacoteDAO();
            Pacote pacoteARemover = dao.consultarPorIdCarrinho(id);

            Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
            carrinho.remover(pacoteARemover);
            response.sendRedirect("carrinho");
        
        } catch (Exception ex) {
            try {
                Logger.getLogger(ControllerCarrinho.class.getName()).log(Level.SEVERE, null, ex);
                response.sendError(500, "Não foi possível remover o pacote do carrinho.");
            } catch (IOException ex1) {
                Logger.getLogger(ControllerCarrinho.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void removerDoCarrinhoAssinatura(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            AssinaturaDAO dao = new AssinaturaDAO();
            Assinatura assinaturaARemover = dao.consultarPorIdCarrinho(id);

            Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
            carrinho.removerAssinatura(assinaturaARemover);
            response.sendRedirect("bemvindo");
        
        } catch (Exception ex) {
            try {
                Logger.getLogger(ControllerCarrinho.class.getName()).log(Level.SEVERE, null, ex);
                response.sendError(500, "Não foi possível remover o pacote do carrinho.");
            } catch (IOException ex1) {
                Logger.getLogger(ControllerCarrinho.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void consultarCarrinho(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            request.getRequestDispatcher("carrinho.jsp").forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(ControllerCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void consultarAssinatura(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            request.getRequestDispatcher("assinatura.jsp").forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(ControllerCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
