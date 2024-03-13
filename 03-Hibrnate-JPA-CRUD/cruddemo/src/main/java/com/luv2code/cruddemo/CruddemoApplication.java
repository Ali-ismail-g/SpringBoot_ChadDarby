package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean //commandLineRunner from spring boot framework and it will be executed after the spring beans have been loaded
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> { //java lambda expression give an implementation for commandLineRunner interface
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryAllStudents(studentDAO);
			//queryStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudentById(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Now performing deleting all students from database....");
		int numOfRemovedRows = studentDAO.deleteAllStudents();
		System.out.println("now all students have been deleted successfully....and all counted removed data is: "+ numOfRemovedRows);
	}

	private void deleteStudentById(StudentDAO studentDAO) {
		int studentID = 6;
		System.out.println("data of student number: "+studentID+" will be deleted!!");
		studentDAO.deleteStudent(studentID);
		System.out.println("Student has successfully deleted ,you can check database now..");
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentID = 6;
		//get student by using studentID
		Student myStudent = studentDAO.findById(studentID);
		//update firstName of specific student
		myStudent.setFirstName("Aubry");
		studentDAO.updateStudent(myStudent);
		//get data of updated my student
		System.out.println("the updated info of my student is: "+ myStudent);
	}

	private void queryStudentsByLastName(StudentDAO studentDAO) {
		//get all students
		List<Student> allStudents = studentDAO.findStudentsByLastName("Dan");
		//display all students with the same sent lastName
		for(Student myStudents : allStudents){
			System.out.println(myStudents);
		}
	}

	private void queryAllStudents(StudentDAO studentDAO) {
		//get all students
		List<Student> allStudents = studentDAO.findAll();
		//display all students in the console
		for(Student myStudents : allStudents){
			System.out.println(myStudents);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating the student obj....");
		Student tempStudent = new Student("Axil","Mike","axil2016@gmail.com");
		//save the student object
		System.out.println("saving student to DB...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		int studentID = tempStudent.getId();
		//retrieve student based on id: primary key
		System.out.println("student ID id:  "+studentID);
		Student myStudent = studentDAO.findById(studentID);
		//display student
		System.out.println("student info is:  "+myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create 3 student objects
		System.out.println("Creating the 4 student objects ....");
		Student tempStudent1 = new Student("Rosie","Dan","rosie2020@gmail.com");
		Student tempStudent2 = new Student("Levi","Dan","levi2015@gmail.com");
		Student tempStudent3 = new Student("Olivia","Dan","olivia2015@gmail.com");
		Student tempStudent4 = new Student("Jackson","Dan","jackson2015@gmail.com");
		//save the 3 student objects
		System.out.println("Saving the 4 student objects....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student obj
		System.out.println("Creating the student obj....");
		Student tempStudent = new Student("Ali","ismail","aliesmaiil94@gmail.com");
		//save the student obj
		System.out.println("Saving the student obj....");
		studentDAO.save(tempStudent);
		//get id of the student obj
		System.out.println("getID of student obj after saving student,Generated studentID:  "+ tempStudent.getId());
	}
}
