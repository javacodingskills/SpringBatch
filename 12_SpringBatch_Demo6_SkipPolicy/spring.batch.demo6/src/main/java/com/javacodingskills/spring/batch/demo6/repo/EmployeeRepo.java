package com.javacodingskills.spring.batch.demo6.repo;

import com.javacodingskills.spring.batch.demo6.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {
}
