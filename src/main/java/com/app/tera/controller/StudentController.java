package com.app.tera.controller;

import com.app.tera.entity.Student;
import com.app.tera.exceptionHandling.StudentAlreadyExistException;
import com.app.tera.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("student/v1/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/registerStudent")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student){
        if(studentService.getStudent(student.getId()).isPresent())
            throw new StudentAlreadyExistException();
        return new ResponseEntity<>(studentService.registerStudent(student), HttpStatus.OK);
    }
}
