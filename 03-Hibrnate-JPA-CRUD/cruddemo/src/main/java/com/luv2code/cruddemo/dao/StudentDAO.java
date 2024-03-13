package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student myStudent);
    public Student findById(Integer id);
    public List<Student> findAll();
    public List<Student> findStudentsByLastName(String lastName);
    public void updateStudent(Student myStudent);
    public void deleteStudent(Integer id);
    public int deleteAllStudents();
}
