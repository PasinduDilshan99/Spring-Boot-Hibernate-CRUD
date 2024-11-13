package com.local.hibernate_crud;

import com.local.hibernate_crud.dao.StudentDAO;
import com.local.hibernate_crud.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateCrudApplication.class, args);

    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
            createMultipleStudents(studentDAO);
//            findUserById(studentDAO);
//            getAllStudents(studentDAO);
//            getStudentByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudentById(studentDAO);
//            deleteAllStudents(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        Student student = new Student("first name 1", "last name 1", "email@gmail.com");
        studentDAO.save(student);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        Student student1 = new Student("first name 2", "last name 2", "email2@gmail.com");
        Student student2 = new Student("first name 3", "last name 3", "email3@gmail.com");
        Student student3 = new Student("first name 4", "last name 4", "email4@gmail.com");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
    }

    private void findUserById(StudentDAO studentDAO) {
        Student student = studentDAO.findById(1);
        System.out.println(student.toString());
    }

    private void getAllStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        int i = 1;
        for (Student student : students) {
            System.out.println(i + ". " + student.toString());
            i++;
        }
    }

    private void getStudentByLastName(StudentDAO studentDAO) {
        Student student = studentDAO.findStudentByLastName("last name 4");
        System.out.println(student.toString());
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student udpatedStudent = new Student(1, "new student first Name", "new student last Name", "newEmail@gmail.com");
        Student student = studentDAO.findById(udpatedStudent.getId());
        System.out.println(student.toString());
        studentDAO.updateStudent(udpatedStudent);
    }

    private void deleteStudentById(StudentDAO studentDAO) {
        studentDAO.deleteStudentById(1);
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        studentDAO.deleteAllStudents();
    }
}
