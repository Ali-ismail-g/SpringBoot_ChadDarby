package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members") //path is plural of entity Employee written here but after using @RepositoryRestResource it will replace /employees with /members
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // no need to write any code here
}
