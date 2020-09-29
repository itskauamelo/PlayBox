/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import DAO.CompraDAO;
import Model.Compra;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

/**
 *
 * @author Kaua.Morateli
 */
public class JobQuartz /*implements Job*/ {
/*
JobDetail jobDetail = JobBuilder.newJob(JobQuartz.class)
				.withIdentity("job", "grupo")
				.build();

SimpleScheduleBuilder simpleScheduler = SimpleScheduleBuilder.simpleSchedule()
                                                              .withIntervalInSeconds(10)
							       .repeatForever();

Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger", "grupo")
				.withSchedule(simpleScheduler)
				.build();


    
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        CompraDAO dao = new CompraDAO();
        Compra compra = new Compra();
        try {
            dao.cancelarPedido(compra);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JobQuartz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JobQuartz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
    
