package com.javacodingskills.spring.batch.demo7;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableBatchProcessing
@ComponentScan(basePackages = {"com.javacodingskills.spring.batch.demo7"})
public class SpringBatchDemo7Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchDemo7Application.class, args);
	}

}
