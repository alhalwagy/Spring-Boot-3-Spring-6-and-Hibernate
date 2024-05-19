package com.demo.cruddemo;

import com.demo.cruddemo.dao.AppDAO;
import com.demo.cruddemo.entity.*;
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

	@Bean
	public CommandLineRunner commandLineRunner (AppDAO appDAO){

		return runner->{
//			createInstructor(appDAO);

//			findInstructorById(appDAO);

//			removeInstructor(appDAO);

//			findInstructorDeltail(appDAO);

//			deleteInstructorDetailById(appDAO);

//createInstructorWithCourses(appDAO);

//			findInstructorWithCourses(appDAO);

//			findCoursesForInstructor(appDAO);

//			findInstructorWithCoursesJoinFetch(appDAO);

//		updateInstructor(appDAO);

//			updateCourse(appDAO);

//			deleteCourseById(appDAO);

//			createCourseAndReviews(appDAO);

//			getCourseWithReviews(appDAO);

//			deleteCourseAndReviewsByCourseId(appDAO);

			createCourseAndStudents(appDAO);


		};

	}

	private void createCourseAndStudents(AppDAO appDAO) {

		Course course = new Course("Javaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa EEEEEEEEE");

		Student student1 = new Student("ahmed","mo","a@m.com");
		Student student2 = new Student("ahhgdj","fdsg","adsg@m.com");
		Student student3 = new Student("ahmkjjjkhed","jhkhjk","oiuuy@m.com");

		course.addStudent(student1);
		course.addStudent(student2);
		course.addStudent(student3);

		System.out.println(course);
		System.out.println(course.getStudents());

		appDAO.save(course);

		System.out.println("Course and student saved");
	}

	private void deleteCourseAndReviewsByCourseId(AppDAO appDAO) {

		int id = 10;

		appDAO.deleteCourse(id);

		System.out.println("done!!!");

	}

	private void getCourseWithReviews(AppDAO appDAO) {

		Course course = appDAO.findCourseAndReviewsByCourseId(10);

		System.out.println(course);
		System.out.println(course.getReviews());

	}

	private void createCourseAndReviews(AppDAO appDAO) {

		Course course = new Course("Java EE");

		course.addReview(new Review("Greeeeeeeeeeeeeeeeeeeeeeeeeeeet"));
		course.addReview(new Review("newwwwwwwwwwwwwwwwwwww"));
		course.addReview(new Review("butyyyyyyyyyyyyyyy"));
		course.addReview(new Review("badddddddddddddddddddddddddd"));

		appDAO.save(course);

		System.out.println("course and reviews saved...");



	}

	private void deleteCourseById(AppDAO appDAO) {

		int id =10;

		System.out.println("Deleting Course id: "+id);


		appDAO.deleteCourse(id);

		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {

		int id =10;
		System.out.println("Finding the course by id:......................"+id);
		Course course = appDAO.findCourseById(id);

		course.setTitle("Javaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa SE");

		appDAO.Update(course);


	}

	private void updateInstructor(AppDAO appDAO) {

		int id =1;
		System.out.println("Finding the instructor by id:......................"+id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Updating Instructor...................."+id);

		instructor.setLastName("tester");

		appDAO.update(instructor);

		System.out.println("Updated!!");

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int id =1;
		System.out.println("Finding Instructor of id 1:..............................");
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println(instructor);
		System.out.println(instructor.getCourses());

		System.out.println("Done!");


	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int id = 1;
		System.out.println("Finding Instructor of id 1:..............................");
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println(instructor);

		System.out.println("Finding Courses of instructor id:..............................");

		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		instructor.setCourses(courses);

		System.out.println("the courses: "+instructor.getCourses());

		System.out.println("Done!");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding Instructor of id 1:..............................");
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println(instructor);
		System.out.println("the courses: "+instructor.getCourses());

		System.out.println("Done!");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("chad","derby","chad@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("luv2.youtube","luv2");

		tempInstructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("springboot");
		Course course2 = new Course("springboot security");

		tempInstructor.add(course1);
		tempInstructor.add(course2);

		appDAO.save(tempInstructor);

		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getCourses());
		System.out.println(tempInstructor.getInstructorDetail());


	}

	private void deleteInstructorDetailById(AppDAO appDAO) {

		int id = 3;
		System.out.println("Deleting Instructor Details and Instructor data....................");
		appDAO.deleteInstructorDetailById(id);
		System.out.println("DONE!!");



	}

	private void findInstructorDeltail(AppDAO appDAO) {

		int id = 2;
		 InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());

	}

	private void removeInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("Deleting Instructor...........");

		appDAO.deleteInstructorById(id);


		System.out.println("deleted instructor");

	}

	private void findInstructorById(AppDAO appDAO) {
		int id =1;
		Instructor instructor = appDAO.findInstructorById(id);


		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail());


	}



	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("ahmed","mohamed","derby@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("levellll youtube","luv");

		tempInstructor.setInstructorDetail(instructorDetail);

		System.out.println(tempInstructor);

		appDAO.save(
				tempInstructor
		);

	}


}
