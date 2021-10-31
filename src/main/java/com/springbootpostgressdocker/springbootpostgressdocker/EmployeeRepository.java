package com.springbootpostgressdocker.springbootpostgressdocker;

import model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
