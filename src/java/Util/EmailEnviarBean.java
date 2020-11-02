/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Kaua.Morateli
 */
@Stateless
public class EmailEnviarBean {

    public void enviarEmail(String deEmail, String usuario, String pw,
                            String paraEmail, String assunto, String mensagem) {
        
        try {
            Properties prop = System.getProperties();
            prop.put("mail.smtp.host", "SMTP.office365.com");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.put("mail.smtp.socketFactory.port", "587");
            prop.put("mail.smtp.socketFactory.fallback", "false");
            
            Session emailSessao = Session.getDefaultInstance(prop, null);
            emailSessao.setDebug(true);
            
            Message mensagemEmail = new MimeMessage(emailSessao);
            
            mensagemEmail.setFrom(new InternetAddress(deEmail));
            mensagemEmail.setRecipient(Message.RecipientType.TO, new InternetAddress(paraEmail));
            mensagemEmail.setContent(mensagem, "text/html");
            mensagemEmail.setSubject(assunto);
            
            Transport transport = emailSessao.getTransport("smtp");
            transport.connect("SMTP.office365.com", usuario, pw);
            transport.sendMessage(mensagemEmail, mensagemEmail.getAllRecipients());
            
            
        } catch (Exception ex) {
            Logger.getLogger(EmailEnviarBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
