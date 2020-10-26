/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Kaua.Morateli
 */



public class CobrancaJob {
    
    public static void main(String[] args) {
        SchedulerFactory shedFact = new StdSchedulerFactory();
        try {
            Scheduler scheduler = shedFact.getScheduler();
            scheduler.start();
            
            JobDetail job = JobBuilder.newJob(ValidadorCobrancaJob.class)
                            .withIdentity("validadorcobrancaJOB", "grupo01")
                            .build();
            
            Trigger trigger = TriggerBuilder.newTrigger()
                              .withIdentity("validadorcobrancaTRIGGER", "grupo01")
                              .withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 15 * ?"))
                              .build();
            
            scheduler.scheduleJob(job, trigger);
            
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        
    }
}

    
