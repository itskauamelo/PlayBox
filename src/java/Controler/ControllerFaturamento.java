 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import DAO.CompraDAO;
import Model.Compra;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renato Alberti
 */
@WebServlet(name = "ControllerFaturamento", urlPatterns = {
    "/listarFaturamento"
})
public class ControllerFaturamento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/listarFaturamento")) {
                listarComprasFinalizadas(request, response);
            }  
        }          
            catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("Erro.jsp");
        }
    }
    private void listarComprasFinalizadas(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        CompraDAO dao = new CompraDAO();

        List<Compra> todasComprasFinalizadas = dao.consultarComprasFinalizadas();
        request.setAttribute("todasComprasFinalizadas", todasComprasFinalizadas);
        
        request.getRequestDispatcher("admin/relatorioFaturamento.jsp").forward(request, response);

    }
   

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String uri = request.getRequestURI();

            if (uri.equals(request.getContextPath() + "/????")) {
                ????(request, response);
            } else if (uri.equals(request.getContextPath() + "/????")) {
                ????(request, response);
            } else {
                response.sendRedirect("404.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("../Erro.jsp");
        }
    } */  
}
