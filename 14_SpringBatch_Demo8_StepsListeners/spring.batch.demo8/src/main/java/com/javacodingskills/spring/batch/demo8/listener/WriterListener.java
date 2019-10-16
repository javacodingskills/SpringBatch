package com.javacodingskills.spring.batch.demo8.listener;

import com.javacodingskills.spring.batch.demo8.model.Employee;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

public class WriterListener implements ItemWriteListener<Employee> {
    @Override
    public void beforeWrite(List<? extends Employee> list) {
        System.out.println("before write :");
        list.stream().forEach(System.out::println);
    }

    @Override
    public void afterWrite(List<? extends Employee> list) {
        System.out.println("after write");
    }

    @Override
    public void onWriteError(Exception e, List<? extends Employee> list) {
        System.out.println("on write error : " + e.getMessage());
    }
}
