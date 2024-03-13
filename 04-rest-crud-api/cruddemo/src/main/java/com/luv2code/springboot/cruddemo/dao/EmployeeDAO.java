package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAllEmployees();
    public Employee findById(int theId);
    public Employee save(Employee theEmployee);
    public void deleteEmployee(int theId);
}
