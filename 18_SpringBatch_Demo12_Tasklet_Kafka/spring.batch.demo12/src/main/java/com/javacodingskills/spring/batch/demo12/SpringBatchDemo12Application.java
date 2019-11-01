package com.javacodingskills.spring.batch.demo12;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableBatchProcessing
@EnableKafka
@ComponentScan(basePackages = {"com.javacodingskills.spring.batch.demo12"})
public class SpringBatchDemo12Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchDemo12Application.class, args);
	}

}
