package com.demo.crud.dao;

import com.demo.crud.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findBylastName(String lastname);

    void update(Student theStudent);

    void delete(int id);
    int deleteAll();


}
