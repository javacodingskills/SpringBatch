package com.javacodingskills.spring.batch.demo11.scheduler;

import com.javacodingskills.spring.batch.demo11.runner.JobRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class JobScheduler {

    private JobRunner jobRunner;

    public JobScheduler(JobRunner jobRunner){
        this.jobRunner = jobRunner;
    }

    @Scheduled(cron="0 0/2 * 1/1 * ?")
    public void jobSchduled(){
        System.out.println("Job triggered");
        jobRunner.runBatchJob();
    }


}
