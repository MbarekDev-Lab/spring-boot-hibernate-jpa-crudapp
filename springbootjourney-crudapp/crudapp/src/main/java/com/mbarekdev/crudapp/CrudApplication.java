package com.mbarekdev.crudapp;

import com.mbarekdev.crudapp.dao.StudentDAO;
import com.mbarekdev.crudapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // System.out.println(" Hello Mbarek from CrudApplication ");
           // createObjStudent(studentDAO);
            findStudentById(studentDAO, 1);
            findAllStudents(studentDAO);
            updateStudent(studentDAO, 1);
            deleteStudent(studentDAO, 1);
        };
    }

    private void createObjStudent(StudentDAO studentDAO) {
        // create student obj
        System.out.println(" create new student object ");
        Student tempStudent = new Student("Mbarek", "MBarekDevLab", "mbarek@DevCode.com");

        // save the student object
        System.out.println(" save the student object ...");
        studentDAO.save(tempStudent);

        // display student object
        System.out.println("display student Generated id;  " + tempStudent.getId());
    }


    private void findStudentById(StudentDAO dao, int id) {
        Student student = dao.findById(id);
        System.out.println("Found Student: " + student);
    }

    private void findAllStudents(StudentDAO dao) {
        dao.findAll().forEach(System.out::println);
    }

    private void updateStudent(StudentDAO dao, int id) {
        Student student = dao.findById(id);
        if (student != null) {
            student.setFirstName("UpdatedName");
            dao.update(student);
            System.out.println("Updated Student: " + student);
        }
    }

    private void deleteStudent(StudentDAO dao, int id) {
        dao.delete(id);
        System.out.println("Deleted student with ID: " + id);
    }
}
