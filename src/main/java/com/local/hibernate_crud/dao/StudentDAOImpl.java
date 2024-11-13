package com.local.hibernate_crud.dao;

import com.local.hibernate_crud.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        List<Student> studentList = theQuery.getResultList();
        return studentList;
    }

    @Override
    public Student findStudentByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:lastName", Student.class);
        theQuery.setParameter("lastName", lastName);
        Student student = theQuery.getSingleResult();
        return student;
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student student = findById(id);
        System.out.println(student.toString());
        if (student != null) {
            entityManager.remove(student);
        } else {
            System.out.println("there is no student in id : " + id);
        }
    }

    @Override
    @Transactional
    public void deleteAllStudents() {
        int rows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        System.out.println("Count of deleted rows : " + rows);
    }
}
