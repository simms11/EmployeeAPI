package com.springbootpostgressdocker.springbootpostgressdocker.controller;

import com.springbootpostgressdocker.springbootpostgressdocker.EmployeeRepository;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") Integer id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new   ResourceNotFoundException("Employee ID: "+ id +" cannot be found"));
        employeeRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findEmployeeId(@PathVariable(value = "id") Integer id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
             new   ResourceNotFoundException("Employee ID: "+ id +" cannot be found"));
        return ResponseEntity.ok().body(employee);
    }
}
