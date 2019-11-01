package com.javacodingskills.spring.batch.demo11;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
@ComponentScan(basePackages = {"com.javacodingskills.spring.batch.demo11"})
public class SpringBatchDemo11Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchDemo11Application.class, args);
	}

}
