package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public List<Employee> findAllEmployees();
    public Employee findById(int theId);
    public Employee save(Employee theEmployee);
    public void deleteEmployee(int theId);
}
