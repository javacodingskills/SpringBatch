package com.javacodingskills.spring.batch.demo11.processor;

import com.javacodingskills.spring.batch.demo11.dto.EmployeeDTO;
import com.javacodingskills.spring.batch.demo11.model.Employee;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EmployeeProcessor implements ItemProcessor<EmployeeDTO, Employee> {

    @Override
    public Employee process(EmployeeDTO employeeDTO) throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId() + new Random().nextInt(10000000));
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setAge(employeeDTO.getAge());
        //System.out.println("inside processor " + employee.toString());
        return employee;
    }
}
