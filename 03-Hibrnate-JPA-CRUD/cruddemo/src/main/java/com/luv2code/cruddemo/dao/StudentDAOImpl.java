package com.luv2code.cruddemo.dao;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    //define entity manager field
    private EntityManager entityManager;
    //use constructor inject and @autowired to inject entity manager
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    //implement save method
    @Override
    @Transactional
    public void save(Student myStudent){
        entityManager.persist(myStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //Create the query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName desc",Student.class);//name of JPA entity ,the class name not the one from database
        //return the query

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findStudentsByLastName(String lastName) {
        //Create the query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:Data",Student.class);//:Data is placeholder for data need to be filled with lastName set as parameter
        //set the parameter
        theQuery.setParameter("Data",lastName);
        //return the result from the query
        return theQuery.getResultList();
    }

    @Override
    @Transactional // must be added since we are performing an update query and adding data
    public void updateStudent(Student myStudent) {
        entityManager.merge(myStudent);
    }

    @Override
    @Transactional // must be added since we are performing a delete query and removing data
    public void deleteStudent(Integer id) {
        Student myDeletedStudent = entityManager.find(Student.class,id);
        entityManager.remove(myDeletedStudent);
    }

    @Override
    @Transactional // must be added since we are performing a delete query and removing data
    public int deleteAllStudents() {
        int deletedRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return deletedRows;
    }
}
