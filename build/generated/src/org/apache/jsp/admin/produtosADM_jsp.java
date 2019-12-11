package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class produtosADM_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Espécies Administrador</title>\n");
      out.write("        <!--bootstarp-css-->\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <!--/bootstarp-css -->\n");
      out.write("        <!--css-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <!--/css-->\n");
      out.write("        <link href=\"css/personalizado.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <meta name=\"keywords\" content=\"Petcare Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, \n");
      out.write("              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design\" />\n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("        <link href=\"css/hover.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("        <!--fonts-->\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Arimo:400,700' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>\n");
      out.write("        <!--/fonts-->\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/modernizr.custom.js\"></script>\n");
      out.write("        <script src=\"js/responsiveslides.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!--header-->\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div class=\"header-info\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"logo\">\n");
      out.write("                        <a href=\"index.html\"><img src=\"images/logo.png\" alt=\"\" /></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"search-box\">\n");
      out.write("                        <form>\n");
      out.write("                            <input type=\"text\" name=\"s\" class=\"textbox\" placeholder=\"Search\" required=\"\">\n");
      out.write("                            <input type=\"submit\" value=\"\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"clearfix\"> </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"header-bottom\">\n");
      out.write("                <div class=\"menu\">\n");
      out.write("                    <span class=\"menu-info\"> </span>\n");
      out.write("                    <ul class=\"cl-effect-21\">\n");
      out.write("                        <li><a href=\"indexADM.jsp\">INÍCIO</a></li>\n");
      out.write("                        <li><a href=\"about.html\">SOBRE</a></li>\n");
      out.write("                        <li><a href=\"projects.html\">PROJECTS</a></li>\n");
      out.write("                        <li><a href=\"perfil.jsp\">CADASTRO</a></li>\n");
      out.write("                        <li><a href=\"login.jsp\">LOGOUT</a></li>\n");
      out.write("                        <!--<li><a href=\"contact.html\">CONTATO</a></li>-->\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"clearfix\"> </div>\t\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--/header-->\n");
      out.write("        <div class=\"contact_top\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h4>Espécies Ativas no Sistema</h4>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-12 contact-us-info\">\n");
      out.write("                        <form action=\"ControllerProdutos\" method=\"POST\">\n");
      out.write("                            <div class=\"col-md-8 contact-us-info\" align=\"left\">\n");
      out.write("                                NOME <input type=\"text\" name=\"txtNomeProdutos\" placeholder=\"NOME DA ESPÉCIE\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-2 contact-us-info\" align=\"center\">\n");
      out.write("                                <input type=\"submit\" name=\"acao\" value=\"PESQUISAR\" />\n");
      out.write("                            </div>   \n");
      out.write("                            <div class=\"col-md-2 contact-us-info\" align=\"right\">\n");
      out.write("                                <input type=\"submit\" name=\"acao\" value=\"LISTAR\" />\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("\n");
      out.write("                        <table class=\"table table-bordered \">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th bgcolor=\"#28B6DE\">N°</th>\n");
      out.write("                                    <th bgcolor=\"#28B6DE\">Nome</th>\n");
      out.write("                                    <th bgcolor=\"#28B6DE\">Descrição</th>\n");
      out.write("                                    <th bgcolor=\"#28B6DE\">Alterar</th>\n");
      out.write("                                    <th bgcolor=\"#28B6DE\">Deletar</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                          <!--  ");

                            //    ArrayList<Especie> especielist = (ArrayList<Especie>) request.getAttribute("especies");
                            //     int contador = 0;
                            //    if (especielist == null) { 
      out.write("\n");
      out.write("                            //    ");
} else {
      out.write("\n");
      out.write("                            //    ");
 for (Especie e : especielist) {
                           //         contador = contador + 1;
                            
      out.write("-->\n");
      out.write("                           <!-- <tbody>\n");
      out.write("                                <tr> \n");
      out.write("                                    <td scope=\"row\">");
      out.print(e.getCodigo());
      out.write("</td> \n");
      out.write("                                    <td>");
      out.print(e.getNome());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(e.getDescricao());
      out.write("</td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <form action=\"ControllerProdutos\" method=\"post\">  \n");
      out.write("                                            <div class=\"contact-us-info\" id=\"btnListaProdutos\" align=\"center\" >\n");
      out.write("                                                <input type=\"hidden\" name=\"id\" value=\"");
      out.print(e.getCodigo());
      out.write("\">\n");
      out.write("                                                <input type=\"submit\" name=\"acao\" value=\"ALTERAR\" >\n");
      out.write("                                            </div>\n");
      out.write("                                        </form>  \n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <form action=\"ControllerProdutos\" method=\"post\">  \n");
      out.write("                                            <div class=\"contact-us-info\" id=\"btnListaProdutos\" align=\"center\" >\n");
      out.write("                                                <input type=\"hidden\" name=\"id\" value=\"");
      out.print(e.getProdutos());
      out.write("\">\n");
      out.write("                                                <input type=\"submit\" name=\"acao\" value=\"DELETAR\" >\n");
      out.write("                                            </div>\n");
      out.write("                                        </form>\n");
      out.write("                                    </td>\n");
      out.write("                                    ");
}
                                        }
      out.write("\n");
      out.write("                                </tr>\n");
      out.write("                            </tbody> -->\n");
      out.write("                        </table>\n");
      out.write("                    <!-- //   Quantidade de registros encontrados: ");
      out.print( contador);
      out.write(" -->\n");
      out.write("                    </div>\n");
      out.write("                </div> \n");
      out.write("                <div class=\"row\">\n");
      out.write("                    </br>\n");
      out.write("                    </br>\n");
      out.write("                    <div class=\"col-md-12 contact-us-info\" id=\"ProdutosADM\" align=\"center\">\n");
      out.write("                        <div class=\"alert alert-primary\" role=\"alert\" >\n");
      out.write("                            <h3><a href=\"cadastrarEProdutosADM.jsp\" class=\"alert-link\">Deseja cadastrar uma nova espécie?! Clique aqui</a></h3>\n");
      out.write("                        </div>                            \n");
      out.write("                    </div>           \n");
      out.write("                </div>    \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
