package com.javacodingskills.spring.batch.demo12.writer;

import com.javacodingskills.spring.batch.demo12.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {


    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;

    public void send(Employee employee) {
        kafkaTemplate.send("EMPLOYEE", employee);
    }
}