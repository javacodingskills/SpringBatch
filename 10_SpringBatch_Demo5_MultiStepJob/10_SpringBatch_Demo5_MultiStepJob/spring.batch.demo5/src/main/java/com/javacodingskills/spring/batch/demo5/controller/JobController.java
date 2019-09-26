package com.javacodingskills.spring.batch.demo5.controller;

import com.javacodingskills.spring.batch.demo5.runner.JobRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
url: http://localhost:8080/run/job
 */

@RestController
@RequestMapping("/run")
public class JobController {

    private JobRunner jobRunner;

    @Autowired
    public JobController(JobRunner jobRunner) {
        this.jobRunner = jobRunner;
    }

    @RequestMapping(value = "/job")
    public String runJob() {
        jobRunner.runBatchJob();
        return String.format("Job Demo5 submitted successfully.");
    }
}
