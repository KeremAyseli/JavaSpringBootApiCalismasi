package com.example.demo.stundent;

import java.util.List;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    


    @GetMapping
	public List<Student> getStudents() {
        return List.of(new Student(1L,"denme", "denme@gmail.com",LocalDate.of(2000, Month.APRIL, 23),21));	
	}


}
