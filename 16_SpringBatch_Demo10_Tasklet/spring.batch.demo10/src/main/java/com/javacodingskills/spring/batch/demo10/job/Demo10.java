package com.javacodingskills.spring.batch.demo10.job;

import com.javacodingskills.spring.batch.demo10.repo.EmployeeRepo;
import com.javacodingskills.spring.batch.demo10.tasklet.DataCleanup;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Demo10 {

    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    private EmployeeRepo employeeRepo;

    @Autowired
    public Demo10(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, EmployeeRepo employeeRepo) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.employeeRepo = employeeRepo;
    }

    @Qualifier(value = "demo10")
    @Bean
    public Job demo10Job() throws Exception {
        return this.jobBuilderFactory.get("demo10")
                .start(step1Demo10())
                .build();
    }

    @Bean
    public Step step1Demo10() throws Exception {

        return stepBuilderFactory.get("step1")
                .tasklet(new DataCleanup(employeeRepo))
                .build();
    }


}
