package com.example.demo.stundent;

import java.util.List;
import java.time.LocalDate;
import java.time.Month;
public class StudentService {
    public List<Student> getStudent() {
        return List.of(new Student(1L,"denme", "denme@gmail.com",LocalDate.of(2000, Month.APRIL, 23),21));	
	}
}
