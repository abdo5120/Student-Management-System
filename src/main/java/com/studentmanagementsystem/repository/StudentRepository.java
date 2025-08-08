package com.studentmanagementsystem.repository;

import com.studentmanagementsystem.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentRepository
{
    private final EntityManager entityManager;

    @Autowired
    public StudentRepository(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(Student student)
    {
        entityManager.persist(student);
    }

    public Student findById(int id)
    {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findAll()
    {
        TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
        return query.getResultList();
    }

    public List<Student> findByFirstName(String firstName)
    {
        TypedQuery<Student> query = entityManager.createQuery("from Student where firstName = :firstName", Student.class);
        query.setParameter("firstName", firstName);
        return query.getResultList();
    }

    @Transactional
    public void updateStudentEmail(Student student)
    {
        entityManager.merge(student);
    }

    @Transactional
    public void deleteStudentById(int id)
    {
        entityManager.remove(findById(id));
    }

}
