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
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Kaua.Morateli
 */



public class RenovacaoJob {
    
    public static void main(String[] args) {
        SchedulerFactory shedFact = new StdSchedulerFactory();
        try {
            Scheduler scheduler = shedFact.getScheduler();
            scheduler.start();
            
            JobDetail jobRenovacao = JobBuilder.newJob(ValidadorRenovacao.class)
                            .withIdentity("validadorRenovacao", "grupo02")
                            .build();
            
            Trigger triggerRenovacao = TriggerBuilder.newTrigger()
                              .withIdentity("validadorTRIGGERRenovacao", "grupo02")
                              .withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 15 1/1 ? *"))
                              .build();
            
            
            scheduler.scheduleJob(jobRenovacao, triggerRenovacao);
            
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        
    }
}

/*
public class JobQuartz implements Job {

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
    try {
        System.out.println("Validando dados para execução da rotina");
        dao.cancelarPedido();
        System.out.println("Rotina executada");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(JobQuartz.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(JobQuartz.class.getName()).log(Level.SEVERE, null, ex);
    }
        }
    }*/
    
