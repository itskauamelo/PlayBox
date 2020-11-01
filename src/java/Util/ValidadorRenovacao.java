/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import DAO.CompraDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kaua.Morateli
 */
public class ValidadorRenovacao implements Job {
    
    @Override
    public void execute (JobExecutionContext arg0) throws JobExecutionException {
        
        System.out.println("Job de renovação da assinatura. Iniciado em: "+new Date());
        CompraDAO dao = new CompraDAO();
        try {
            dao.renovarAssinatura();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidadorRenovacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ValidadorRenovacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Job executado em "+new Date());
        
        
        
    }
    
}
