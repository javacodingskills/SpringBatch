package com.javacodingskills.spring.batch.demo5.writer;

import com.javacodingskills.spring.batch.demo5.dto.EmployeeDTO;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class EmailSenderWriter implements ItemWriter<EmployeeDTO> {
    @Override
    public void write(List<? extends EmployeeDTO> list) throws Exception {
        System.out.println("Email send successfully to all the employees.");
    }
}
