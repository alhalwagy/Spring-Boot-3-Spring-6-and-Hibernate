package com.rest.demo.rest;

import com.rest.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

private List<Student> theStudents;

@PostConstruct
public void loadData(){
    Student s1 = new Student("ahmed","mohamed1");
    Student s2 = new Student("ahmed","mohamed2");
    Student s3 = new Student("ahmed","mohamed3");
    Student s4 = new Student("ahmed","mohamed4");
    theStudents = new ArrayList<>();
    theStudents.add(s1);
    theStudents.add(s2);
    theStudents.add(s3);
    theStudents.add(s4);

}


    @GetMapping("/students")
    public List<Student> getAllStudents(){

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

    if(studentId>= theStudents.size() || (studentId<0)){
        throw new StudentNotFoundException("Student id not found..."+studentId);
    }

    return theStudents.get(studentId);

    }




}
