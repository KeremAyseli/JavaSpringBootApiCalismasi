package com.example.demo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import student.Student;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping(path = "/")
	public List<Student> getMessage() {
		return List.of(new Student(1L,"denme", "denme@gmail.com",LocalDate.of(2000, Month.APRIL, 23),21));
	}

}
