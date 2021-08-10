package com.example.demo.stundent;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.PUT;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class StudentService {
    private final StudentRepository studentRepository;
    
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();	
	}

    public void registerStudent(Student student) {
       Optional<Student> studentByOptional = studentRepository.findByEmail(student.getEmail());
       if(studentByOptional.isPresent()) {
           throw new IllegalArgumentException("Student already exists");
       }
        studentRepository.save(student);
    }

    public void deleteStudent(long studentId) {
      boolean exists=  studentRepository.existsById(studentId);
      if(!exists) {
          throw new IllegalArgumentException("Student "+studentId+" does not exist");
      }
      studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentID, String name, String email) {
        Student student = studentRepository.findById(studentID).orElseThrow(()->new IllegalArgumentException("Student "+studentID+" does not exist"));

        student.setName(name);
        student.setEmail(email);
        System.out.println("Yeni öğrenci: "+student.getName());
        studentRepository.save(student);
    }

}
