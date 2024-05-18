package com.demo.crud;

import com.demo.crud.dao.StudentDAO;
import com.demo.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

     return runner -> {

	//createStudent(studentDAO);

    createMultipleStudents(studentDAO);

    //readStudent(studentDAO);
//	 queryForStudents(studentDAO);

//		 getStudentsByLastName(studentDAO);

//updateStudent(studentDAO );

//		 deleteStudent(studentDAO);

//		 deletAllStudents(studentDAO);

	 };
    }

	private void deletAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students........");

		int rows = studentDAO.deleteAll();

		System.out.println("Deleted All students");

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student........");
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		Student student = studentDAO.findById(1);

		System.out.println("Updating the student.........");

		student.setFirstName("Cristiano");
		studentDAO.update(student);

		System.out.println("updated student: "+ student);


	}

	private void getStudentsByLastName(StudentDAO studentDAO) {
		System.out.println("Getting students By lastName..................");
		List<Student> students = studentDAO.findBylastName("Ronaldo");

		for(Student s:students){
			System.out.println(s);
		}



	}

	private void queryForStudents(StudentDAO studentDAO) {

		System.out.println("Getting students..................");
		List<Student> students = studentDAO.findAll();

		for (Student s:students){
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student object .........");
		Student tempStudent = new Student("ahmed","mohamed","ahmed@gmail.com");

		System.out.println("Saving student object in DB.........");
		studentDAO.save(tempStudent);
		System.out.println("Saved student. Generated id: "+tempStudent.getId());

		System.out.println("Getting the student by given id");
		Student myStudent= studentDAO.findById(tempStudent.getId());

		System.out.println("Got the student by given id: "+myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple students
		System.out.println("Creating new student object .........");
		Student tempStudent1 = new Student("Cristiano","Ronaldo","cr7@gmail.com");
		Student tempStudent2 = new Student("leo","messi","leo@gmail.com");
		Student tempStudent3 = new Student("jude","bileingham","jb5@gmail.com");


		//save the students objects
		System.out.println("Saving students objects in DB.........");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);





	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object .........");
		Student tempStudent = new Student("ahmed","mohamed","ahmed@gmail.com");


		//save the student
		System.out.println("Saving student object in DB.........");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());

	}

}
