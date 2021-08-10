package com.example.demo.stundent;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args ->{
           Student deneme= new Student("denme", "denme@gmail.com",LocalDate.of(2000, Month.APRIL, 23));
           Student kerem= new Student("kerem", "kerem@gmail.com",LocalDate.of(2004, Month.JANUARY, 11));
           Student deneme2= new Student("deneme2", "deneme2@gmail.com",LocalDate.of(2002, Month.MAY, 17));

           repository.saveAll(
               List.of(deneme,kerem,deneme2));
        };
    }
}
