package com.studentmanagementsystem.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "courses")
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;
/*
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();
*/


    public Course(){}

    public Course(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public int getCourse_id()
    {
        return course_id;
    }
    public void setCourse_id(int course_id)
    {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
/*


    public List<Student> getStudents()
    {
        return students;
    }
    public void setStudents(List<Student> students)
    {
        this.students = students;
    }
*/
}
