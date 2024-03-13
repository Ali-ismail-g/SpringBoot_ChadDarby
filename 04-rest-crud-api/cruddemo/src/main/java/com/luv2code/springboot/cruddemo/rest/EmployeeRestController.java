package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    //quick and dirty: use constructor injection to inject employee service
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAllEmployees();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee findEmployeeById(@PathVariable int employeeId){
        Employee myEmployee = employeeService.findById(employeeId);
        if(myEmployee == null){
            throw new RuntimeException("Employee with "+employeeId+" is not found!!");
        }
        return myEmployee;
    }
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0); //incase theEmployee has an id need to be set to 0 r it's gonna be an update
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee); //we use the same method in service as it has merge used for both insert new data and update a current one
        return dbEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee deletedEmployee = employeeService.findById(employeeId);
        if(deletedEmployee == null){
            throw new RuntimeException("id "+employeeId+" is not found to be deleted!!");
        }
        employeeService.deleteEmployee(employeeId);
        return "employee with id - "+employeeId+" has been removed successfully!!";
    }
}
