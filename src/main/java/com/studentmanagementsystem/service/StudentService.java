package com.studentmanagementsystem.service;

import com.studentmanagementsystem.dto.StudentDto;
import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService
{
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public void createStudent(StudentDto studentDto)
    {
        Student student = convertToStudent(studentDto);
        studentRepository.save(student);
    }

    public List<StudentDto> getAllStudents()
    {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students)
        {
            studentDtos.add(convertToStudentDto(student));
        }
        return studentDtos;
    }

    public StudentDto getStudentById(int id)
    {
        Student student = studentRepository.findById(id);
        return convertToStudentDto(student);
    }

    public List<StudentDto> getStudentsByFirstName(String firstName)
    {
        List<Student> students = studentRepository.findByFirstName(firstName);
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students)
        {
            studentDtos.add(convertToStudentDto(student));
        }
        return studentDtos;
    }

    public void updateStudentEmailById(int id, String email)
    {
        Student student = studentRepository.findById(id);
        StudentDto studentDto = convertToStudentDto(student);
        studentDto.setEmailAddress(email);
        student = convertToStudent(studentDto);
        //student.setEmailAddress(email);
        studentRepository.updateStudentEmail(student);
    }

    public void deleteStudentById(int id)
    {
        studentRepository.deleteStudentById(id);
    }

    private Student convertToStudent(StudentDto studentDto)
    {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmailAddress(studentDto.getEmailAddress());
        student.setAge(studentDto.getAge());
        return student;
    }

    private StudentDto convertToStudentDto(@Valid Student student)
    {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(student.getStudentId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmailAddress(student.getEmailAddress());
        studentDto.setAge(student.getAge());
        return studentDto;
    }
}
