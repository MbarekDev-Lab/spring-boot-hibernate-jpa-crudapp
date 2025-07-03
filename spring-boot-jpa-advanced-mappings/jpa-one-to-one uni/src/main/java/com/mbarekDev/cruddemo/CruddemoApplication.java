package com.mbarekDev.cruddemo;

import com.mbarekDev.cruddemo.dao.AppDAO;
import com.mbarekDev.cruddemo.entity.Instructor;
import com.mbarekDev.cruddemo.entity.InstructorDetail;
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
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return args -> {
            //createInstructorr(appDAO);
            //findInstructor(appDAO);
            deleteInstructor(appDAO);


            //System.out.println("Hello World from CommandLineRunner");
        };
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting instructor id : " + theId);
        appDAO.deleteInstructiorById(theId);
        System.out.println("Done!");


    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructoer id :  " + theId);

        Instructor tempInstruictor = appDAO.findInstructorById(theId);

        System.out.println("tempInnstructor : " + tempInstruictor);
        System.out.println("the associated instructor detail only  : " + tempInstruictor.getInstructorDetail());

    }

    private void createInstructor(AppDAO appDAO) {

        // create the instructor
        Instructor tempInstructor = new Instructor("Chad", "Darby", "mbarek@gmail.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.mb.com", "codding");

        // associate the instructor
        // NOTE this will also save the details object
        // because of CascadeTypes.ALL

        System.out.println("Saving instructor : " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done !");


    }

    private void createInstructorr(AppDAO appDAO) {

        // create the instructor
        Instructor tempInstructor = new Instructor(
                "mbarek", "benne", "mbarek@gmail.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "https://www.mbarek.com", "surfing");

        // associate the instructor with instructor detail
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor (this will also save instructor detail because of CascadeType.ALL)
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }
}