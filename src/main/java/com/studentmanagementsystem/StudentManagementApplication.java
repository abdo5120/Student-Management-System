package com.studentmanagementsystem;

import com.studentmanagementsystem.dto.StudentDto;
import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.service.StudentService;

import jakarta.validation.Valid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class StudentManagementApplication {


	public static void main(String[] args) {
		//SpringApplication.run(StudentManagementApplication.class, args);

		ApplicationContext context = SpringApplication.run(StudentManagementApplication.class, args);
		StudentService studentService = context.getBean(StudentService.class);

		/*
		StudentDto studentDto = new StudentDto("Ali" , "Omer", "ali@gmail.com", 22);
		studentService.createStudent(studentDto);
		studentDto = new StudentDto("Salah" , "Amer", "salah@gmail.com", 28);
		studentService.createStudent(studentDto);
		studentDto = new StudentDto("Maged" , "Amir", "maged@gmail.com", 25);
		studentService.createStudent(studentDto);
		*/
		/*
		List<StudentDto> studentDtoList = studentService.getAllStudents();
		for (StudentDto studentDto : studentDtoList)
		{
			System.out.println(studentDto.toString());
		}
		*/
		/*
		StudentDto studentDto = studentService.getStudentById(5);
		System.out.println(studentDto);
		 */
		/*
		List<StudentDto> studentDtoList = studentService.getStudentsByFirstName("maged");
		for (StudentDto studentDto : studentDtoList)
		{
			System.out.println(studentDto.toString());
		}
		 */

		//studentService.updateStudentEmailById(5,"newMailjj525");
		//studentService.deleteStudentById(7);

	}

}
