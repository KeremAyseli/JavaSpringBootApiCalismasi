package com.example.demo.stundent;

import java.util.List;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    
   private final  StudentService studentService;
   @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudent();
    }

    @PostMapping()
    public void registerStudent(@RequestBody Student student){
        studentService.registerStudent(student);    
    }
    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable("studentId") long studentId) {
        studentService.deleteStudent(studentId);
    }

    @Transactional
    @PutMapping(value = "/u/{studentID}")
    public void updateStudent(@PathVariable("studentID") Long studentID, 
    @RequestParam(required = false) String name, 
   @RequestParam(required = false) String Email) {
        System.out.println("Yeni öğrenci ismi: "+name);
        studentService.updateStudent(studentID, name, Email);
    }


}
