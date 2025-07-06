package com.mbarekDev.cruddemo.dao;

import com.mbarekDev.cruddemo.entity.Course;
import com.mbarekDev.cruddemo.entity.Instructor;
import com.mbarekDev.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    // define field for entity manager
    @PersistenceContext
    private final EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        // retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        // get the courses
        List<Course> courses = tempInstructor.getCourses();
        // break association of all courses for the instructor

        for (Course tempCourse : courses) {
            tempCourse.setInstructor(null);
        }

        // delete the instructor
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        // retrieve instructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        // remove the associated object reference
        // break bidirectional link
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        // delete the instructor detail
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        // create a query {JPQL is not SQL}
        TypedQuery<Course> query = entityManager.createQuery(" from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        // execute query and return actual result
        List<Course> courses = query.getResultList();
        return courses;
    }

   /* @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        // create a query
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " +
                        " JOIN FETCH i.courses " +
                        " WHERE i.id = :data ", Instructor.class
        );
        // execute query
        Instructor instructor = query.getSingleResult();
        return instructor;
    }*/

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " +
                        "JOIN FETCH i.courses " +
                        " JOIN FETCH i.instructorDetail " +
                        "WHERE i.id = :data", Instructor.class
        );
        query.setParameter("data", theId);

        return query.getSingleResult();
    }

    // everytime we modify the db, we should use Transactional
    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteCoursById(int theId) {
        // retriev the course
        Course temCourse = entityManager.find(Course.class, theId);

        // delete the course
        entityManager.remove(temCourse);

    }

    // if modifier the db we should use @Transactional
    @Transactional
    @Override
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

}