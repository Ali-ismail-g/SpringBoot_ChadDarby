package com.luv2code.restAPI.rest;

import com.luv2code.restAPI.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;
    @PostConstruct  //in this method the bean is fully initialized and you can use the dependencies.,this is the contract that guarantees that this method will be invoked only once in the bean lifecycle.
    private void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Rosie","Dan"));
        students.add(new Student("Levi","Dan"));
        students.add(new Student("Olivia","Dan"));
        students.add(new Student("Jackson","Dan"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
    @GetMapping("/students/{studentID}")
    public Student getStudentById(@PathVariable int studentID){
        if((studentID>students.size())||studentID<0){
            throw new StudentNotFoundException("StudentID is not found .. "+studentID);
        }
        return students.get(studentID);
    }



}
