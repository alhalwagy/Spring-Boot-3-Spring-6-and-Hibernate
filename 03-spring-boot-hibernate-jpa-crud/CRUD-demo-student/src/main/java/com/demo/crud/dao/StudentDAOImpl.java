package com.demo.crud.dao;

import com.demo.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.boot.model.internal.QueryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //Define fields for entity manager

    private EntityManager entityManager;

    //inject Entity manager

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement methods

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {

        //Name of Entity class Not name of table in DB same for lastName
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc",Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findBylastName(String lastname) {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData",Student.class);

        theQuery.setParameter("theData",lastname);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {

        Student student = entityManager.find(Student.class,id);

        entityManager.remove(student);

    }

    @Override
    @Transactional
    public int deleteAll() {

        return entityManager.createQuery("DELETE From Student").executeUpdate();
    }
}
