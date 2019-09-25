package com.javacodingskills.spring.batch.demo4.repo;

import com.javacodingskills.spring.batch.demo4.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {
}
