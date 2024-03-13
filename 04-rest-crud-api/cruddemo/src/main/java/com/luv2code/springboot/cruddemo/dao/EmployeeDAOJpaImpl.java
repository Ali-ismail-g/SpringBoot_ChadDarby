package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployees() {
        //create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        //return employees
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee myEmployee = entityManager.find(Employee.class,theId);
        return myEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee newEmployee = entityManager.merge(theEmployee); //if id == 0 save/insert else update
        return newEmployee;
    }

    @Override
    public void deleteEmployee(int theId) {
        Employee myEmployee = entityManager.find(Employee.class,theId);
        entityManager.remove(myEmployee);
    }
}
