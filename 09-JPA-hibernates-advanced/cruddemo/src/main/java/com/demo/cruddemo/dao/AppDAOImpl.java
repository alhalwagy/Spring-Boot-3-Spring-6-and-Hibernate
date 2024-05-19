package com.demo.cruddemo.dao;

import com.demo.cruddemo.entity.Course;
import com.demo.cruddemo.entity.Instructor;
import com.demo.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AppDAOImpl implements AppDAO{


    private final EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {

        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class,id);

        instructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {

        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class
        );

        query.setParameter("data",id);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i "+"JOIN FETCH i.courses "+"JOIN FETCH i.instructorDetail "+"where i.id = :data",Instructor.class);
        query.setParameter("data",id);


        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void Update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {

        return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {

        Course course = entityManager.find(Course.class,id);

        entityManager.remove(course);

    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {

        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "+"JOIN FETCH c.reviews "+"where c.id = :data", Course.class);

        query.setParameter("data",id);


        return query.getSingleResult();
    }


    @Override
    @Transactional
    public void save(Instructor instructor) {

        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
      }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {

        Instructor instructor  = entityManager.find(Instructor.class,id);

    List<Course> courses = instructor.getCourses();

    for(Course c :courses) {
        c.setInstructor(null);
    }
        entityManager.remove(instructor);

    }


}
