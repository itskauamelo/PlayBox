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
import Util.Email;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletContext;
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
    "/minhaConta",
    "/bemvindo",
    "/inicio",
    "/formPesquisaCancelamento",
    "/alterarSenha"
})

public class ClienteController extends HttpServlet {
    
        private String host;
	private String port;
	private String user;
	private String pass;
        
	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}
    
    
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
            response.sendRedirect("Erro.jsp");
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException {
        Cliente cliente = new Cliente();
        cliente.setCpf(request.getParameter("txtCpf"));
        cliente.setNomecompleto(request.getParameter("txtNomecompleto"));
        cliente.setDatanascimento(Date.valueOf(request.getParameter("txtData")));
        cliente.setGenero(request.getParameter("optGenero"));
        cliente.setEmail(request.getParameter("txtEmail"));
        cliente.setSenha(request.getParameter("txtSenha"));
        cliente.setCelular(request.getParameter("txtCelular"));

		
		String recipient = request.getParameter("txtEmail");
		String subject = "SEJA BEM-VINDO " +  request.getParameter("txtNomecompleto");
		String content = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
"<head>\n" +
"<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
"<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
"<meta content=\"width=device-width\" name=\"viewport\"/>\n" +
"<!--[if !mso]><!-->\n" +
"<meta content=\"IE=edge\" http-equiv=\"X-UA-Compatible\"/>\n" +
"<!--<![endif]-->\n" +
"<title></title>\n" +
"<!--[if !mso]><!-->\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Alegreya\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Bitter\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Cabin\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Cormorant+Garamond\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Oswald\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<!--<![endif]-->\n" +
"<style type=\"text/css\">\n" +
"		body {\n" +
"			margin: 0;\n" +
"			padding: 0;\n" +
"		}\n" +
"\n" +
"		table,\n" +
"		td,\n" +
"		tr {\n" +
"			vertical-align: top;\n" +
"			border-collapse: collapse;\n" +
"		}\n" +
"\n" +
"		* {\n" +
"			line-height: inherit;\n" +
"		}\n" +
"\n" +
"		a[x-apple-data-detectors=true] {\n" +
"			color: inherit !important;\n" +
"			text-decoration: none !important;\n" +
"		}\n" +
"	</style>\n" +
"<style id=\"media-query\" type=\"text/css\">\n" +
"		@media (max-width: 660px) {\n" +
"\n" +
"			.block-grid,\n" +
"			.col {\n" +
"				min-width: 320px !important;\n" +
"				max-width: 100% !important;\n" +
"				display: block !important;\n" +
"			}\n" +
"\n" +
"			.block-grid {\n" +
"				width: 100% !important;\n" +
"			}\n" +
"\n" +
"			.col {\n" +
"				width: 100% !important;\n" +
"			}\n" +
"\n" +
"			.col_cont {\n" +
"				margin: 0 auto;\n" +
"			}\n" +
"\n" +
"			img.fullwidth,\n" +
"			img.fullwidthOnMobile {\n" +
"				max-width: 100% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col {\n" +
"				min-width: 0 !important;\n" +
"				display: table-cell !important;\n" +
"			}\n" +
"\n" +
"			.no-stack.two-up .col {\n" +
"				width: 50% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num2 {\n" +
"				width: 16.6% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num3 {\n" +
"				width: 25% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num4 {\n" +
"				width: 33% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num5 {\n" +
"				width: 41.6% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num6 {\n" +
"				width: 50% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num7 {\n" +
"				width: 58.3% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num8 {\n" +
"				width: 66.6% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num9 {\n" +
"				width: 75% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num10 {\n" +
"				width: 83.3% !important;\n" +
"			}\n" +
"\n" +
"			.video-block {\n" +
"				max-width: none !important;\n" +
"			}\n" +
"\n" +
"			.mobile_hide {\n" +
"				min-height: 0px;\n" +
"				max-height: 0px;\n" +
"				max-width: 0px;\n" +
"				display: none;\n" +
"				overflow: hidden;\n" +
"				font-size: 0px;\n" +
"			}\n" +
"\n" +
"			.desktop_hide {\n" +
"				display: block !important;\n" +
"				max-height: none !important;\n" +
"			}\n" +
"		}\n" +
"	</style>\n" +
"</head>\n" +
"<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #1a1d1f;\">\n" +
"<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
"<table bgcolor=\"#1a1d1f\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #1a1d1f; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" +
"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#1a1d1f\"><![endif]-->\n" +
"<div style=\"background-color:transparent;\">\n" +
"<div class=\"block-grid\" style=\"min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: transparent;\">\n" +
"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;background-image:url('https://i.ibb.co/426g65X/BF-hero-bg.png');background-position:center top;background-repeat:repeat\">\n" +
"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:640px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
"<!--[if (mso)|(IE)]><td align=\"center\" width=\"640\" style=\"background-color:transparent;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
"<div class=\"col num12\" style=\"min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;\">\n" +
"<div class=\"col_cont\" style=\"width:100% !important;\">\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
"<!--<![endif]-->\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"50\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 1px solid transparent; height: 50px; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td height=\"50\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<div align=\"center\" class=\"img-container center fixedwidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img align=\"center\" alt=\"Black Friday Sale Banner\" border=\"0\" class=\"center fixedwidth\" src=\"https://i.ibb.co/kQMDspZ/Playbox-Logo.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 639px; display: block;\" title=\"Black Friday Sale Banner\" width=\"639\"/>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"</div>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"50\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 1px solid transparent; height: 50px; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td height=\"50\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 20px; padding-left: 20px; padding-top: 0px; padding-bottom: 0px; font-family: Arial, sans-serif\"><![endif]-->\n" +
"<div style=\"color:#393d47;font-family:'Oswald', Arial, 'Helvetica Neue', Helvetica, sans-serif;line-height:1.2;padding-top:0px;padding-right:20px;padding-bottom:0px;padding-left:20px;\">\n" +
"<div style=\"line-height: 1.2; font-size: 12px; font-family: 'Oswald', Arial, 'Helvetica Neue', Helvetica, sans-serif; color: #393d47; mso-line-height-alt: 14px;\">\n" +
"<p style=\"font-size: 46px; line-height: 1.2; word-break: break-word; text-align: center; font-family: Oswald, Arial, 'Helvetica Neue', Helvetica, sans-serif; mso-line-height-alt: 55px; margin: 0;\"><span style=\"color: #ffffff; font-size: 46px;\"><strong>SEJA BEM-VINDO A <span style=\"color: #ffff00;\">P</span>LAYBO<span style=\"color: #ffff00;\">X</span></strong></span></p>\n" +
"</div>\n" +
"</div>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Verdana, sans-serif\"><![endif]-->\n" +
"<div style=\"color:#393d47;font-family:Lucida Sans Unicode, Lucida Grande, Lucida Sans, Geneva, Verdana, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
"<div style=\"line-height: 1.2; font-size: 12px; color: #393d47; font-family: Lucida Sans Unicode, Lucida Grande, Lucida Sans, Geneva, Verdana, sans-serif; mso-line-height-alt: 14px;\">\n" +
"<p style=\"font-size: 16px; line-height: 1.2; word-break: break-word; text-align: center; mso-line-height-alt: 19px; margin: 0;\"><span style=\"color: #ffffff; font-size: 16px;\">O melhor serviço de assinatura mensal de caixas GAMER</span></p>\n" +
"</div>\n" +
"</div>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"42\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 1px solid transparent; height: 42px; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td height=\"42\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 20px; padding-left: 20px; padding-top: 0px; padding-bottom: 0px; font-family: Arial, sans-serif\"><![endif]-->\n" +
"<div style=\"color:#393d47;font-family:'Oswald', Arial, 'Helvetica Neue', Helvetica, sans-serif;line-height:1.2;padding-top:0px;padding-right:20px;padding-bottom:0px;padding-left:20px;\">\n" +
"<div style=\"line-height: 1.2; font-size: 12px; font-family: 'Oswald', Arial, 'Helvetica Neue', Helvetica, sans-serif; color: #393d47; mso-line-height-alt: 14px;\">\n" +
"<p style=\"font-size: 46px; line-height: 1.2; word-break: break-word; text-align: center; font-family: Oswald, Arial, 'Helvetica Neue', Helvetica, sans-serif; mso-line-height-alt: 55px; margin: 0;\"><span style=\"color: #ffffff; font-size: 46px;\"><strong>CLIQUE ABAIXO PARA ATIVAR SEU CADASTRO</strong></span></p>\n" +
"</div>\n" +
"</div>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"42\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 1px solid transparent; height: 42px; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td height=\"42\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<div align=\"center\" class=\"img-container center fixedwidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><a href=\"http://localhost:8080/PlayBox/cadastrado.jsp\" style=\"outline:none\" tabindex=\"-1\" target=\"_blank\"> <img align=\"center\" alt=\"Boxing Class Placeholder\" border=\"0\" class=\"center fixedwidth\" src=\"https://i.ibb.co/zXjWpgY/Play.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 160px; display: block;\" title=\"Boxing Class Placeholder\" width=\"160\"/></a>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"</div>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"42\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 1px solid transparent; height: 42px; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td height=\"42\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"</div>\n" +
"<!--<![endif]-->\n" +
"</div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"<div style=\"background-color:transparent;\">\n" +
"<div class=\"block-grid\" style=\"min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: transparent;\">\n" +
"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;background-image:url('https://i.ibb.co/PjTKbHN/BF-sections-bg-3.png');background-position:center top;background-repeat:no-repeat\">\n" +
"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:640px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
"<!--[if (mso)|(IE)]><td align=\"center\" width=\"640\" style=\"background-color:transparent;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
"<div class=\"col num12\" style=\"min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;\">\n" +
"<div class=\"col_cont\" style=\"width:100% !important;\">\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
"<!--<![endif]-->\n" +
"<div align=\"center\" class=\"img-container center autowidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img align=\"center\" alt=\"Boxing Class Placeholder\" border=\"0\" class=\"center autowidth\" src=\"https://wallpaperaccess.com/full/774615.jpg\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 640px; display: block;\" title=\"Boxing Class Placeholder\" width=\"640\"/>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"</div>\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"</div>\n" +
"<!--<![endif]-->\n" +
"</div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"<div style=\"background-color:transparent;\">\n" +
"<div class=\"block-grid three-up\" style=\"min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: transparent;\">\n" +
"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;background-image:url('https://i.ibb.co/mhJm9nw/4d8592b8-7815-4a7b-a574-ab425fd8b326.png');background-position:center top;background-repeat:repeat\">\n" +
"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:640px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
"<!--[if (mso)|(IE)]><td align=\"center\" width=\"213\" style=\"background-color:transparent;width:213px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
"<div class=\"col num4\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 212px; width: 213px;\">\n" +
"<div class=\"col_cont\" style=\"width:100% !important;\">\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
"<!--<![endif]-->\n" +
"<div align=\"center\" class=\"img-container center fixedwidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><a href=\"http://localhost:8080/PlayBox\" style=\"outline:none\" tabindex=\"-1\" target=\"_blank\"> <img align=\"center\" alt=\"Your Logo\" border=\"0\" class=\"center fixedwidth\" src=\"https://pngimg.com/uploads/pacman/pacman_PNG79.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 96px; display: block;\" title=\"Your Logo\" width=\"96\"/></a>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"</div>\n" +
"<table cellpadding=\"0\" cellspacing=\"0\" class=\"social_icons\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td style=\"word-break: break-word; vertical-align: top; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" +
"<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"social_table\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;\" valign=\"top\">\n" +
"<tbody>\n" +
"<tr align=\"center\" style=\"vertical-align: top; display: inline-block; text-align: center;\" valign=\"top\">\n" +
"<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;\" valign=\"top\"><a href=\"http://localhost:8080/PlayBox\" target=\"_blank\"><img alt=\"Facebook\" height=\"32\" src=\"https://i.ibb.co/Cw6qYFQ/facebook2x.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;\" title=\"facebook\" width=\"32\"/></a></td>\n" +
"<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;\" valign=\"top\"><a href=\"http://localhost:8080/PlayBox\" target=\"_blank\"><img alt=\"Twitter\" height=\"32\" src=\"https://i.ibb.co/RQRPDHr/twitter2x.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;\" title=\"twitter\" width=\"32\"/></a></td>\n" +
"<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;\" valign=\"top\"><a href=\"http://localhost:8080/PlayBox\" target=\"_blank\"><img alt=\"Linkedin\" height=\"32\" src=\"https://i.ibb.co/XJ8vfWL/linkedin2x.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;\" title=\"linkedin\" width=\"32\"/></a></td>\n" +
"<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;\" valign=\"top\"><a href=\"http://localhost:8080/PlayBox\" target=\"_blank\"><img alt=\"Instagram\" height=\"32\" src=\"https://i.ibb.co/1Z72d9p/instagram2x.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;\" title=\"instagram\" width=\"32\"/></a></td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"</div>\n" +
"<!--<![endif]-->\n" +
"</div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
"<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"160\" style=\"background-color:transparent;width:160px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
"<div class=\"col num3\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 159px; width: 160px;\">\n" +
"<div class=\"col_cont\" style=\"width:100% !important;\">\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
"<!--<![endif]-->\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Verdana, sans-serif\"><![endif]-->\n" +
"<div style=\"color:#393d47;font-family:Lucida Sans Unicode, Lucida Grande, Lucida Sans, Geneva, Verdana, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
"<div style=\"line-height: 1.2; font-size: 12px; color: #393d47; font-family: Lucida Sans Unicode, Lucida Grande, Lucida Sans, Geneva, Verdana, sans-serif; mso-line-height-alt: 14px;\">\n" +
"<p style=\"font-size: 13px; line-height: 1.2; word-break: break-word; text-align: left; mso-line-height-alt: 16px; mso-ansi-font-size: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 13px; mso-ansi-font-size: 14px;\"><strong><span style=\"\"><a href=\"http://localhost:8080/PlayBox/#home\" rel=\"noopener\" style=\"text-decoration: none; color: #ffffff;\" target=\"_blank\">{ inicio da jornada }</a></span></strong></span></p>\n" +
"</div>\n" +
"</div>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Verdana, sans-serif\"><![endif]-->\n" +
"<div style=\"color:#393d47;font-family:Lucida Sans Unicode, Lucida Grande, Lucida Sans, Geneva, Verdana, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
"<div style=\"line-height: 1.2; font-size: 12px; color: #393d47; font-family: Lucida Sans Unicode, Lucida Grande, Lucida Sans, Geneva, Verdana, sans-serif; mso-line-height-alt: 14px;\">\n" +
"<p style=\"font-size: 13px; line-height: 1.2; word-break: break-word; text-align: left; mso-line-height-alt: 16px; mso-ansi-font-size: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 13px; mso-ansi-font-size: 14px;\"><strong><span style=\"\"><a href=\"http://localhost:8080/PlayBox/#about\" rel=\"noopener\" style=\"text-decoration: none; color: #ffffff;\" target=\"_blank\">{ serviço }</a></span></strong></span></p>\n" +
"</div>\n" +
"</div>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Verdana, sans-serif\"><![endif]-->\n" +
"<div style=\"color:#393d47;font-family:Lucida Sans Unicode, Lucida Grande, Lucida Sans, Geneva, Verdana, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
"<div style=\"line-height: 1.2; font-size: 12px; color: #393d47; font-family: Lucida Sans Unicode, Lucida Grande, Lucida Sans, Geneva, Verdana, sans-serif; mso-line-height-alt: 14px;\">\n" +
"<p style=\"font-size: 13px; line-height: 1.2; word-break: break-word; text-align: left; mso-line-height-alt: 16px; mso-ansi-font-size: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 13px; mso-ansi-font-size: 14px;\"><strong><span style=\"\"><a href=\"http://localhost:8080/PlayBox/#plano\" rel=\"noopener\" style=\"text-decoration: none; color: #ffffff;\" target=\"_blank\">{ planos }</a></span></strong></span></p>\n" +
"</div>\n" +
"</div>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Verdana, sans-serif\"><![endif]-->\n" +
"<div style=\"color:#393d47;font-family:Lucida Sans Unicode, Lucida Grande, Lucida Sans, Geneva, Verdana, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
"<div style=\"line-height: 1.2; font-size: 12px; color: #393d47; font-family: Lucida Sans Unicode, Lucida Grande, Lucida Sans, Geneva, Verdana, sans-serif; mso-line-height-alt: 14px;\">\n" +
"<p style=\"font-size: 13px; line-height: 1.2; word-break: break-word; text-align: left; mso-line-height-alt: 16px; mso-ansi-font-size: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 13px; mso-ansi-font-size: 14px;\"><strong><span style=\"\"><a href=\"http://localhost:8080/PlayBox/#mandamensagem\" rel=\"noopener\" style=\"text-decoration: none; color: #ffffff;\" target=\"_blank\">{ contato }</a></span></strong></span></p>\n" +
"</div>\n" +
"</div>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"</div>\n" +
"<!--<![endif]-->\n" +
"</div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
"<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"266\" style=\"background-color:transparent;width:266px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
"<div class=\"col num5\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 265px; width: 266px;\">\n" +
"<div class=\"col_cont\" style=\"width:100% !important;\">\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
"<!--<![endif]-->\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Verdana, sans-serif\"><![endif]-->\n" +
"<div style=\"color:#393d47;font-family:Lucida Sans Unicode, Lucida Grande, Lucida Sans, Geneva, Verdana, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
"<div style=\"line-height: 1.2; font-size: 12px; color: #393d47; font-family: Lucida Sans Unicode, Lucida Grande, Lucida Sans, Geneva, Verdana, sans-serif; mso-line-height-alt: 14px;\">\n" +
"<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; text-align: left; mso-line-height-alt: 17px; margin: 0;\"><span style=\"color: #ffffff;\"><strong><span style=\"font-size: 16px;\">2020 - UMC</span></strong></span></p>\n" +
"</div>\n" +
"</div>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Verdana, sans-serif\"><![endif]-->\n" +
"<div style=\"color:#393d47;font-family:Lucida Sans Unicode, Lucida Grande, Lucida Sans, Geneva, Verdana, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
"<div style=\"line-height: 1.2; font-size: 12px; color: #393d47; font-family: Lucida Sans Unicode, Lucida Grande, Lucida Sans, Geneva, Verdana, sans-serif; mso-line-height-alt: 14px;\">\n" +
"<p style=\"font-size: 12px; line-height: 1.2; word-break: break-word; text-align: left; mso-line-height-alt: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 12px;\">Kauã Morateli</span></p>\n" +
"<p style=\"font-size: 12px; line-height: 1.2; word-break: break-word; text-align: left; mso-line-height-alt: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 12px;\">Renato Alberti</span></p>\n" +
"<p style=\"font-size: 12px; line-height: 1.2; word-break: break-word; text-align: left; mso-line-height-alt: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 12px;\">Rodrigo Kenji</span></p>\n" +
"</div>\n" +
"</div>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"70\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 1px solid transparent; height: 70px; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td height=\"70\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"</div>\n" +
"<!--<![endif]-->\n" +
"</div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"<div style=\"background-color:transparent;\">\n" +
"<div class=\"block-grid\" style=\"min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: transparent;\">\n" +
"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:640px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
"<!--[if (mso)|(IE)]><td align=\"center\" width=\"640\" style=\"background-color:transparent;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
"<div class=\"col num12\" style=\"min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;\">\n" +
"<div class=\"col_cont\" style=\"width:100% !important;\">\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
"<!--<![endif]-->\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"50\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 1px solid transparent; height: 50px; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td height=\"50\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"</div>\n" +
"<!--<![endif]-->\n" +
"</div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<!--[if (IE)]></div><![endif]-->\n" +
"</body>\n" +
"</html>";

		try {
			Email.sendEmail(host, port, user, pass, recipient, subject,
					content);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
                
        ClienteDAO dao = new ClienteDAO();
        dao.cadastrar(cliente);

       response.sendRedirect("inicio");
        
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
        HttpSession sessaoCliente = request.getSession();
        Cliente clienteAutenticado = (Cliente) sessaoCliente.getAttribute("clienteAutenticado");

        ClienteDAO dao = new ClienteDAO();
        dao.consultarporId(cliente, clienteAutenticado);

        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("edCliente.jsp").forward(request, response);
    }
    
    private void iniciarAlteracaoSenha(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Cliente cliente = new Cliente();
        HttpSession sessaoCliente = request.getSession();
        Cliente clienteAutenticado = (Cliente) sessaoCliente.getAttribute("clienteAutenticado");

        ClienteDAO dao = new ClienteDAO();
        dao.consultarporId(cliente, clienteAutenticado);

        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("alterarSenha.jsp").forward(request, response);
    }

    private void confirmarEdicaoSenha(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Cliente cliente = new Cliente();

        HttpSession sessaoCliente = request.getSession();
        Cliente clienteAutenticado = (Cliente) sessaoCliente.getAttribute("clienteAutenticado");

        cliente.setSenha(request.getParameter("pw"));

        ClienteDAO dao = new ClienteDAO();
        dao.EditarSenha(cliente, clienteAutenticado);

        response.sendRedirect("minhaConta");
    }

    private void desativar(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Cliente cliente = new Cliente();
        HttpSession sessaoCliente = request.getSession();
        Cliente clienteAutenticado = (Cliente) sessaoCliente.getAttribute("clienteAutenticado");

        ClienteDAO dao = new ClienteDAO();
        dao.consultarporId(cliente,clienteAutenticado);
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
        
        cliente.setId(Integer.valueOf(request.getParameter("id")));
        cliente.setCpf(request.getParameter("cpf"));
        cliente.setNomecompleto(request.getParameter("nome"));
        cliente.setGenero(request.getParameter("genero"));
        cliente.setDatanascimento(Date.valueOf(request.getParameter("datanascimento")));
        cliente.setEmail(request.getParameter("email"));
        cliente.setCelular(request.getParameter("celular"));

        ClienteDAO dao = new ClienteDAO();
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
