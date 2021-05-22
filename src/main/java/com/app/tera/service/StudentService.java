package com.app.tera.service;

import com.app.tera.entity.Student;
import com.app.tera.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student registerStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> getStudent(Long id){
        return studentRepository.findById(id);
    }
}
