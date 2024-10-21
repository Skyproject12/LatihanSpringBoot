package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			// deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Deleting student id: "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		
		// retrive student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student mystudent = studentDAO.findById(studentId);

		// change first name to "Scooby"
		System.out.println("Updating student ...");
		mystudent.setFirstName("Scooby");

		// update the student
		studentDAO.udpate(mystudent);
		
		// display the update student
		System.out.println("Updated student: "+ mystudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list students
		List<Student> theStudents = studentDAO.findByLastName("Public");

		// display list of students
		for(Student theStudent : theStudents) {
			System.out.println("Students " +theStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		
		// get a list of students
		List<Student> tempStudents = studentDAO.findAll();
		
		// display list of students
		for(Student tempStudent: tempStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create  a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}







