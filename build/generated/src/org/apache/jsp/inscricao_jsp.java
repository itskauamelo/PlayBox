package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Cliente;

public final class inscricao_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html class=\"no-js\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("    <meta name=\"description\" content=\"PlayboX - A box Gamer dos Gamers\">\r\n");
      out.write("    <meta name=\"keywords\" content=\"template, theme, html, css, bootstrap, game, event, culture, music, personal, cv\">\r\n");
      out.write("    <meta name=\"author\" content=\"Kauã Morateli, Renato Alberti, Rodrigo Kenji\">\r\n");
      out.write("\r\n");
      out.write("    <title>PlayboX - A loja Gamer dos Gamers</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Fonts -->\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Press+Start+2P%7CLato:100,100i,300,300i,400,400i,700,700i,900,900i\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Lightbox styles -->\r\n");
      out.write("    <link href=\"assets/lightbox2-master/dist/css/lightbox.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Loaders styles -->\r\n");
      out.write("    <link href=\"assets/loaders.css-master/loaders.min.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Template styles -->\r\n");
      out.write("    <link href=\"css/yellow.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" title=\"yellow\">\r\n");
      out.write("    <link href=\"css/pink.min.css\" media=\"screen\" rel=\"alternate stylesheet\" type=\"text/css\" title=\"pink\">\r\n");
      out.write("    <link href=\"css/orange.min.css\" media=\"screen\" rel=\"alternate stylesheet\" type=\"text/css\" title=\"orange\">\r\n");
      out.write("    <link href=\"css/red.min.css\" media=\"screen\" rel=\"alternate stylesheet\" type=\"text/css\" title=\"red\">\r\n");
      out.write("    <link href=\"css/green.min.css\" media=\"screen\" rel=\"alternate stylesheet\" type=\"text/css\" title=\"green\">\r\n");
      out.write("    <link href=\"css/blue.min.css\" media=\"screen\" rel=\"alternate stylesheet\" type=\"text/css\" title=\"blue\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Modernizr -->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/modernizr-custom.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Favicon -->\r\n");
      out.write("    <link rel=\"icon\" href=\"img/favicon.png\" type=\"image/png\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <!-- Preloader -->\r\n");
      out.write("    <div class=\"loader-overlay\">\r\n");
      out.write("        <div class=\"loader\">\r\n");
      out.write("            <div class=\"loader-inner pacman\">\r\n");
      out.write("                <div></div>\r\n");
      out.write("                <div></div>\r\n");
      out.write("                <div></div>\r\n");
      out.write("                <div></div>\r\n");
      out.write("                <div></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <h3 class=\"loader-text\">Carregando</h3>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- Color switcher -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Navbar -->\r\n");
      out.write("    <div class=\"navbar navbar-inverse\">\r\n");
      out.write("        <div class=\"triangle\">\r\n");
      out.write("            <i class=\"fa fa-angle-double-down\" aria-hidden=\"true\"></i>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Topbar -->\r\n");
      out.write("        <div class=\"header-top clearfix\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <ul class=\"list-inline social-links\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\" title=\"Twitter\"><i class=\"fa fa-twitter\"></i></a>\r\n");
      out.write("                    </li><li class=\"hidden-xs\">\r\n");
      out.write("                        <a href=\"#\" title=\"Skype\"><i class=\"fa fa-skype\"></i></a>\r\n");
      out.write("                    </li><li class=\"hidden-xxs\">\r\n");
      out.write("                        <a href=\"#\" title=\"LinkedIn\"><i class=\"fa fa-linkedin\"></i></a>\r\n");
      out.write("                    </li><li class=\"hidden-xxs\">\r\n");
      out.write("                        <a href=\"#\" title=\"Google +\"><i class=\"fa fa-google-plus\"></i></a>\r\n");
      out.write("                    </li><li>\r\n");
      out.write("                        <a href=\"#\" title=\"Youtube\"><i class=\"fa fa-youtube-play\"></i></a>\r\n");
      out.write("                    </li><li>\r\n");
      out.write("                        <a href=\"#\" title=\"Facebook\"><i class=\"fa fa-facebook\"></i></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <div class=\"header-top-dropdown\">\r\n");
      out.write("                    <div class=\"btn-group dropdown\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-link dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("                            <span class=\"text\"><i class=\"fa fa-search\"></i> Procurar</span>\r\n");
      out.write("                        </button>\r\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <form class=\"search-box\" action=\"#\">\r\n");
      out.write("                                    <div class=\"form-group has-feedback no-margin\">\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"Procurar\">\r\n");
      out.write("                                        <i class=\"fa fa-search form-control-feedback\"></i>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"btn-group dropdown\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-link dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("                            <span class=\"text\"><i class=\"fa fa-shopping-cart\"></i> Carrinho</span>\r\n");
      out.write("                        </button>\r\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <form class=\"search-box\" action=\"#\">\r\n");
      out.write("                                    <div class=\"form-group has-feedback no-margin\">\r\n");
      out.write("                                        <br>\r\n");
      out.write("                                        <br>\r\n");
      out.write("                                        <br>\r\n");
      out.write("                                        <br>\r\n");
      out.write("                                        <br>\r\n");
      out.write("                                        <br>\r\n");
      out.write("                                        <br>\r\n");
      out.write("                                        <br>\r\n");
      out.write("                                        <br>\r\n");
      out.write("                                        <a href=\"#\" class=\"btn btn-primary btn-block\" title=\"Ver todos\" data-toggle=\"modal\" data-target=\"#order-modal\"><i class=\"fa fa-shopping-basket\" aria-hidden=\"true\"></i> Ver todos</a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"btn-group dropdown\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-link dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("                            <span class=\"text\"><i class=\"fa fa-user\"></i> Login</span>\r\n");
      out.write("                        </button>\r\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <form class=\"login-form\" action=\"#\">\r\n");
      out.write("                                    <div class=\"form-group has-feedback\">\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"Username\">\r\n");
      out.write("                                        <i class=\"fa fa-user form-control-feedback\"></i>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"form-group has-feedback\">\r\n");
      out.write("                                        <input type=\"password\" class=\"form-control\" placeholder=\"Password\">\r\n");
      out.write("                                        <i class=\"fa fa-lock form-control-feedback\"></i>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <button type=\"submit\" class=\"btn btn-primary btn-block\">\r\n");
      out.write("                                        <span class=\"text\">Entrar <i class=\"fa fa-arrow-right\"></i></span>\r\n");
      out.write("                                    </button>\r\n");
      out.write("                                    <h3 class=\"text-center\">ou</h3>\r\n");
      out.write("                                    <button type=\"submit\" class=\"btn btn-primary btn-block\">\r\n");
      out.write("                                        <span class=\"text\">Inscrever-se <i class=\"fa fa-arrow-right\"></i></span>\r\n");
      out.write("                                    </button>\r\n");
      out.write("                                    <p class=\"text-center\"><a href=\"#\" title=\"Reset password\">Esqueceu sua senha?</a></p>\r\n");
      out.write("                                    <h3 class=\"text-center\">Entrar com rede social</h3>\r\n");
      out.write("                                    <ul class=\"list-inline text-center\">\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                            <a href=\"#\" title=\"Login with Facebook\"><span class=\"icon-circle-small\"><i class=\"fa fa-facebook\"></i></span></a>\r\n");
      out.write("                                        </li><li>\r\n");
      out.write("                                            <a href=\"#\" title=\"Login with Twitter\"><span class=\"icon-circle-small\"><i class=\"fa fa-twitter\"></i></span></a>\r\n");
      out.write("                                        </li><li>\r\n");
      out.write("                                            <a href=\"#\" title=\"Login with Google +\"><span class=\"icon-circle-small\"><i class=\"fa fa-google-plus\"></i></span></a>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div><!-- Topbar end -->\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"navbar-header\">\r\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#main-menu\">\r\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                </button>\r\n");
      out.write("                <!-- Logo -->\r\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.html\" title=\"PlayBoX\">\r\n");
      out.write("                    <i class=\"fa fa-gamepad\" aria-hidden=\"true\"></i><span class=\"main-color\">P</span>laybo<span class=\"main-color\">X</span>\r\n");
      out.write("                </a><!-- Logo end -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Main menu -->\r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"main-menu\">\r\n");
      out.write("                <ul class=\"nav navbar-nav\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#home\">\r\n");
      out.write("                            <span class=\"main-link\">Inicio</span>\r\n");
      out.write("                            <span class=\"additional-info-link bracket\">\r\n");
      out.write("                                inicio da jornada\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#about\">\r\n");
      out.write("                            <span class=\"main-link\">Serviço</span>\r\n");
      out.write("                            <span class=\"additional-info-link bracket\">\r\n");
      out.write("                                como funciona\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#plano\">\r\n");
      out.write("                            <span class=\"main-link\">Planos </span>\r\n");
      out.write("                            <span class=\"additional-info-link bracket\">\r\n");
      out.write("                                nossos planos\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#mandamensagem\">\r\n");
      out.write("                            <span class=\"main-link\">Contato </span>\r\n");
      out.write("                            <span class=\"additional-info-link bracket\">\r\n");
      out.write("                                fale com a gente\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <span class=\"main-link\">Loja</span>\r\n");
      out.write("                            <span class=\"additional-info-link bracket\">\r\n");
      out.write("                                alguns produtos\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Final menu -->\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Final Navbar -->\r\n");
      out.write("\r\n");
      out.write("    <div class=\"single-page-section single-page-blog\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Header Página -->\r\n");
      out.write("        <div class=\"single-page-header single-page-blog-header\">\r\n");
      out.write("            <div class=\"overlay\"></div>\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <h2 class=\"digit-header\">Inscreva-se</h2>\r\n");
      out.write("                <h3 class=\"signature-header\"><small>Entre<strong> Gamers</strong></small></h3>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"single-page-header-bg\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-cadastro col-md-8\">\r\n");
      out.write("                    <div>\r\n");
      out.write("                    <form action =\"cadastrarCliente\"> \r\n");
      out.write("                    <!-- Posts list -->\r\n");
      out.write("                    <h2 class=\"post-item-header\"><a title=\"Inscrição\">Inscrição</a></h2>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <label>CPF</label>\r\n");
      out.write("                    <input type=\"text\" id=\"txtCpf\" name=\"txtCpf\" class=\"form-control\"><br>\r\n");
      out.write("                    <label>Nome Completo</label>\r\n");
      out.write("                    <input type=\"text\" id=\"txtNome\" name=\"txtNome\" class=\"form-control\"><br>\r\n");
      out.write("                    <label>Data de Nascimento</label>\r\n");
      out.write("                    <input type=\"text\" id=\"txtData\" name=\"txtData\" class=\"form-control\"><br>\r\n");
      out.write("                    <label>Genero</label>\r\n");
      out.write("                    <input type=\"text\" id=\"txtGenero\" name=\"txtGenero\" class=\"form-control\"><br>\r\n");
      out.write("                    <label>Email</label>\r\n");
      out.write("                    <input type=\"email\" id=\"txtEmail\" name=\"txtEmail\" class=\"form-control\"><br>\r\n");
      out.write("                    <label>Senha</label>\r\n");
      out.write("                    <input type=\"password\" id=\"txtSenha\" name=\"txtSenha\" class=\"form-control\"><br>\r\n");
      out.write("                    <label>Confirmar senha</label>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\"><br>\r\n");
      out.write("                    <label>Celular</label>\r\n");
      out.write("                    <input type=\"text\" id=\"txtCelular\" name=\"txtCelular\" class=\"form-control\"><br>\r\n");
      out.write("\r\n");
      out.write("                    <!-- Pagination -->\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- Archives list -->\r\n");
      out.write("                <div class=\"col-cadastro col-md-8\">\r\n");
      out.write("                    <div class=\"standard-box\">\r\n");
      out.write("                        <h3 class=\"post-item-header\">Endereço</h3>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <label>Identificação do endereço:</label>\r\n");
      out.write("                        <input type=\"text\" id=\"txtIdEnd\" name=\"txtIdEnd\" class=\"form-control\" placeholder=\"Casa, trabalho, ...\"><br>\r\n");
      out.write("                        <label>Nome do destinatário</label>\r\n");
      out.write("                        <input type=\"text\" id=\"txtDestinatario\" name=\"txtDestinatario\"class=\"form-control\" ><br>\r\n");
      out.write("                        <label>CEP</label>\r\n");
      out.write("                        <input type=\"text\" id=\"txtCep\" name=\"txtCep\" class=\"form-control\"><br>\r\n");
      out.write("                        <label>Endereço</label>\r\n");
      out.write("                        <input type=\"text\" id=\"txtEndereco\" name=\"txtEndereco\" class=\"form-control\"><br>\r\n");
      out.write("                        <label>Numero</label>\r\n");
      out.write("                        <input type=\"text\" id=\"txtNumero\" name=\"txtNumero\" class=\"form-control\"><br>\r\n");
      out.write("                        <label>Complemento</label>\r\n");
      out.write("                        <input type=\"text\" id=\"txtComplemento\" name=\"txtComplemento\" class=\"form-control\"><br>\r\n");
      out.write("                        <label>Referência</label>\r\n");
      out.write("                        <input type=\"text\" id=\"txtReferencia\" name=\"txtReferencia\" class=\"form-control\"><br>\r\n");
      out.write("                        <label>Bairro</label>\r\n");
      out.write("                        <input type=\"text\" id=\"txtBairro\" name=\"txtBairro\" class=\"form-control\"><br>\r\n");
      out.write("                        <label>Cidade</label>\r\n");
      out.write("                        <input type=\"text\" id=\"txtCidade\" name=\"txtCidade\" class=\"form-control\"><br>\r\n");
      out.write("                        <label>Estado</label>\r\n");
      out.write("                        <select id=\"optEstado\" name=\"optEstado\" class=\"form-control\" style=\"color: black;\">\r\n");
      out.write("                            <option>Selecione um estado</option>                  \r\n");
      out.write("                            <option value=\"AC\">Acre</option>\r\n");
      out.write("                            <option value=\"AL\">Alagoas</option>\r\n");
      out.write("                            <option value=\"AP\">Amapá</option>\r\n");
      out.write("                            <option value=\"AM\">Amazonas</option>\r\n");
      out.write("                            <option value=\"BA\">Bahia</option>\r\n");
      out.write("                            <option value=\"CE\">Ceará</option>\r\n");
      out.write("                            <option value=\"DF\">Distrito Federal</option>\r\n");
      out.write("                            <option value=\"ES\">Espírito Santo</option>\r\n");
      out.write("                            <option value=\"GO\">Goiás</option>\r\n");
      out.write("                            <option value=\"MA\">Maranhão</option>\r\n");
      out.write("                            <option value=\"MT\">Mato Grosso</option>\r\n");
      out.write("                            <option value=\"MS\">Mato Grosso do Sul</option>\r\n");
      out.write("                            <option value=\"MG\">Minas Gerais</option>\r\n");
      out.write("                            <option value=\"PA\">Pará</option>\r\n");
      out.write("                            <option value=\"PB\">Paraíba</option>\r\n");
      out.write("                            <option value=\"PR\">Paraná</option>\r\n");
      out.write("                            <option value=\"PE\">Pernambuco</option>\r\n");
      out.write("                            <option value=\"PI\">Piauí</option>\r\n");
      out.write("                            <option value=\"RJ\">Rio de Janeiro</option>\r\n");
      out.write("                            <option value=\"RN\">Rio Grande do Norte</option>\r\n");
      out.write("                            <option value=\"RS\">Rio Grande do Sul</option>\r\n");
      out.write("                            <option value=\"RO\">Rondônia</option>\r\n");
      out.write("                            <option value=\"RR\">Roraima</option>\r\n");
      out.write("                            <option value=\"SC\">Santa Catarina</option>\r\n");
      out.write("                            <option value=\"SP\">São Paulo</option>\r\n");
      out.write("                            <option value=\"SE\">Sergipe</option>\r\n");
      out.write("                            <option value=\"TO\">Tocantins</option>\r\n");
      out.write("                        </select>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"centrocadastro\">\r\n");
      out.write("        <a href=\"#\" class=\"btn btn-primary\" title=\"Criar Conta\" data-toggle=\"modal\" data-target=\"#order-modal\" id=\"btngavar\" type=\"submit\" name=\"gravar\" value=\"Gravar\"><i class=\"fa fa-plus\" aria-hidden=\"true\"></i> Criar Conta</a>     \r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <br><br><br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Footer -->\r\n");
      out.write("    <footer class=\"footer footer-gray text-center\" id=\"follow-us\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <ul class=\"list-inline\">\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"#\" title=\"Facebook\"><i class=\"fa fa-facebook\"></i></a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"#\" title=\"Twitter\"><i class=\"fa fa-twitter\"></i></a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"#\" title=\"Dribble\"><i class=\"fa fa-dribbble\"></i></a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"#\" title=\"LinkedIn\"><i class=\"fa fa-linkedin\"></i></a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"#\" title=\"RSS\"><i class=\"fa fa-rss\"></i></a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <p> &copy; 2020 <a href=\"http://www.umc.br/home\">UMC</a></p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("\r\n");
      out.write("    <!-- Scroll to top button -->\r\n");
      out.write("    <div id=\"toTop\" class=\"to-top\">\r\n");
      out.write("        <a href=\"#\" class=\"To the top\">\r\n");
      out.write("            <i class=\"fa fa-angle-up\"></i>\r\n");
      out.write("        </a>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- jQuery -->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-3.1.0.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap -->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"assets/bootstrap-3.3.7/dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom javascript -->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/custom.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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