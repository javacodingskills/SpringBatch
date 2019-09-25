package com.javacodingskills.spring.batch.demo1.processor;

import com.javacodingskills.spring.batch.demo1.dto.EmployeeDTO;
import com.javacodingskills.spring.batch.demo1.model.Employee;
import com.javacodingskills.spring.batch.demo1.writer.EmployeeDBWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProcessor implements ItemProcessor<EmployeeDTO, Employee> {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDBWriter.class);

    @Override
    public Employee process(EmployeeDTO employeeDTO) throws Exception {
        logger.info("Inside process method. Employee = {}", employeeDTO.toString());
        if (!isValid(employeeDTO)) {
            return null;
        }
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setAge(employeeDTO.getAge());
        return employee;
    }

    boolean isValid(EmployeeDTO employeeDTO) {
        return (employeeDTO.getFirstName().startsWith("AAA")) ? false : true;
    }
}
