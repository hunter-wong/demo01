package com.ujiuye.test;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

public class DemoQuartz {

    public static void main2(String[] args) throws SchedulerException, InterruptedException {
        //job
        JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1","group1").build();
        //时间规则表  10秒 10次
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).withRepeatCount(10);
        //创建触发器
       SimpleTrigger trigger= TriggerBuilder.newTrigger().withIdentity("trigger1","group1").withSchedule(simpleScheduleBuilder).startNow().build();
       //调度器
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        scheduler.scheduleJob(job,trigger);
        scheduler.start();

        Thread.sleep(120*1000);

    }

    public static void main(String[] args) {
        //1.job
        JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();
        //时间builder
        CronScheduleBuilder cronScheduleBuilder= CronScheduleBuilder.cronSchedule("2,26,59 1,36,42 5,9,10,22 * * ? ");

        //trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger2","group1").withSchedule(cronScheduleBuilder).build();
        //工厂中获取调度器
        try {
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();

            Thread.sleep(120*100);

        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
