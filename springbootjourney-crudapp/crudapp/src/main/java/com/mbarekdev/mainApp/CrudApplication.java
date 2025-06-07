package com.mbarekdev.mainApp;

import com.mbarekdev.crudapp.dao.StudentDAO;
import com.mbarekdev.crudapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.mbarekdev")
@EntityScan(basePackages = "com.mbarekdev.crudapp.entity")
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            System.out.println(" Hello Mbarek from CrudApplication ");
            findAllStudents(studentDAO);
            //createMultipleStudents(studentDAO);
            //studentDAO.findAll().forEach(System.out::println);
            //queryForStudents(studentDAO);
            //queryForStudentsByLastName(studentDAO);
            //updateStudent(studentDAO , 2);
            //deleteStudent(studentDAO, 2);
            //deleteAllStudent(studentDAO);
        };
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findByLastName("MBarekDevLab");

        // display list of students with lastname MBarekDevLab
        for (Student s : theStudents) {
            System.out.println(s);
        }
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
//        String[][] studentData = {
//                {"Mbarek", " MBarekDevLab", "mbarek@DevCode.com"},
//                {"Bonita", " applebum", "applebum@DevCode.com"},
//                {"Marry", "bumApple", "applebum@DevCode.com"}
//        };
        List<Student> studentList = List.of(
                new Student("Mbarek", " MBarekDevLab", "mbarek@DevCode.com"),
                new Student("Bonita", " applebum", "applebum@DevCode.com"),
                new Student("Marry", "bumApple", "applebum@DevCode.com")
        );
        for (Student student : studentList) {
            // save the student object
            System.out.println(" Saving the student object ..." + student);
            studentDAO.save(student);
        }
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

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();
        //desplay list of Students
        for (Student tempStd : theStudents) {
            System.out.println(tempStd);
        }
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        int numOfRowsAreDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numOfRowsAreDeleted);
    }


}
