package com.mbarekDev.cruddemo;

import com.mbarekDev.cruddemo.dao.AppDAO;
import com.mbarekDev.cruddemo.entity.Course;
import com.mbarekDev.cruddemo.entity.Instructor;
import com.mbarekDev.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
            // createInstructor(appDAO);

            // findInstructor(appDAO);

            // deleteInstructor(appDAO);

            //findInstructorDetail(appDAO);

            // deleteInstructorDetail(appDAO);

            //createInstructorWithCourses(appDAO);

            //findInstructorWithCourses(appDAO);

            // findCoursesForInstructor(appDAO);

            //findInstructorWithCoursesJoinFetch(appDAO);

            // updateInstructor(appDAO);

            // updateCourse(appDAO);

            // deleteInstructor(appDAO);

            deleteCourse(appDAO);
        };
    }

    private void deleteCourse(AppDAO appDAO) {

        int theId = 10;
        System.out.println("Deleting Course " + theId);
        appDAO.deleteCoursById(theId);

        System.out.println("Done !");

    }

    private void updateCourse(AppDAO appDAO) {
        int theId = 10;
        // find the course

        System.out.println("Finding course by id :" + theId);
        Course tempCourse = appDAO.findCourseById(theId);

        // update the course
        System.out.println("Updating the course id :  " + theId);
        tempCourse.setTitle("Enjoy the learning to code : ");

        appDAO.update(tempCourse);
        System.out.println("Done !");


    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;

        // find the instructor
        System.out.println("FInding instructor id : " + theId);
        Instructor temInstructor = appDAO.findInstructorById(theId);

        // uptate the instructor
        System.out.println("Updating instuctor id : " + theId);
        temInstructor.setLastName("TESTER");
        appDAO.update(temInstructor);
        System.out.println("Done !");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId = 1;
        // find the instructor
        System.out.println("Finding instrictor id : " + theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor : " + tempInstructor);
        System.out.println("the associated courses : " + tempInstructor.getCourses());
        System.out.println("Done !");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id : " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);

        // find courses for instructor
        System.out.println("Finding courses for istructor id : " + theId);

        List<Course> courseList = appDAO.findCoursesByInstructorId(theId);
        tempInstructor.setCourses(courseList);

        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done ! ");

    }

    private void findInstructorWithCourses(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Finding instructor id : " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses : " + tempInstructor.getCourses());
        System.out.println("Done !");


    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        // create the instructor
        Instructor tempInstructor = new Instructor("Mbarek", "benraiss", "mbarek@benraiss.com");
        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.mbarek.com", "Codding");
        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        Course tempCourse1 = new Course("Air Guitar The ultimate ----");
        Course tempCourse2 = new Course("The Pinball Masterclass");

        // add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        System.out.println("Saving instructor " + tempInstructor);
        System.out.println("The Courses : " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);
        System.out.println("Done ! ");

    }


    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 4;
        System.out.println("Deleting instructor detail id: " + theId);

        appDAO.deleteInstructorDetailById(theId);

        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int theId = 3;
        Optional<InstructorDetail> optionalDetail = Optional.ofNullable(appDAO.findInstructorDetailById(theId));

        if (optionalDetail.isPresent()) {
            InstructorDetail tempInstructorDetail = optionalDetail.get();

            // print the instructor detail
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            // print the associated instructor
            System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
        } else {
            System.out.println("InstructorDetail with ID " + theId + " not found.");
        }

        System.out.println("Done!");
    }

    private void deleteInstructor(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);

        appDAO.deleteInstructorById(theId);

        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {

        int theId = 2;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());

    }

    private void createInstructor(AppDAO appDAO) {

		/*
		// create the instructor	tempInstructor =
				new Instructor("Chad", "Darby", "darby@gg.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.gg.com/youtube",
						"code!!!");
		*/

        // create the instructor
        Instructor tempInstructor =
                new Instructor("Madhu", "Patel", "madhu@gg.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.gg.com/youtube",
                        "Guitar");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        //
        // NOTE: this will ALSO save the details object
        // because of CascadeType.ALL
        //
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }
}