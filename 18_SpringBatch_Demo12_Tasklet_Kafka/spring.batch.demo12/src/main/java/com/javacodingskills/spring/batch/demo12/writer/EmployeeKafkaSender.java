package com.javacodingskills.spring.batch.demo12.writer;

import com.javacodingskills.spring.batch.demo12.model.Employee;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeKafkaSender implements ItemWriter<Employee> {


    @Autowired
    private Sender sender;

    @Override
    public void write(List<? extends Employee> employees) throws Exception {
        for (Employee employee : employees) {
            sender.send(employee);
        }
        System.out.println("Message sent to kafka");

    }
}
