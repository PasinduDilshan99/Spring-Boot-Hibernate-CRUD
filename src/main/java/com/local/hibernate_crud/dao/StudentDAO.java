package com.local.hibernate_crud.dao;

import com.local.hibernate_crud.model.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    Student findStudentByLastName(String lastName);

    void updateStudent(Student student);

    void deleteStudentById(int id);

    void deleteAllStudents();
}
