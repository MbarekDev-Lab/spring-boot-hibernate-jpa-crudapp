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
            createInstructor(appDAO);

            //System.out.println("Hello World from CommandLineRunner");
        };
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
}