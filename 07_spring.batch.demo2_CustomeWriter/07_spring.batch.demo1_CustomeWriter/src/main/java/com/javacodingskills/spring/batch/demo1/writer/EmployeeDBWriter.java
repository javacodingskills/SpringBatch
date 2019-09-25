package com.javacodingskills.spring.batch.demo1.writer;

import com.javacodingskills.spring.batch.demo1.model.Employee;
import com.javacodingskills.spring.batch.demo1.repo.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDBWriter implements ItemWriter<Employee> {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDBWriter.class);

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeDBWriter(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    @Override
    public void write(List<? extends Employee> employees) throws Exception {
        employeeRepo.saveAll(employees);
        logger.info("{} employees saved in database", employees.size());
    }
}
