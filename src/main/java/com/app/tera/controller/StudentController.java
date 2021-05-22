package com.app.tera.controller;

import com.app.tera.entity.Student;
import com.app.tera.exceptionHandling.StudentAlreadyExistException;
import com.app.tera.exceptionHandling.StudentNotFoundException;
import com.app.tera.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController("/student/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudent() {
        return new ResponseEntity<>(studentService.getAlStudent(), HttpStatus.OK);
    }

    @GetMapping("/student/{rollNumber}")
    public ResponseEntity<Student> getStudentByRollNumber(@PathVariable Long rollNumber) {
        Optional<Student> student = studentService.getStudent(rollNumber);
        if (student.isPresent())
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        throw new StudentNotFoundException();
    }

    @PostMapping("/student")
    public ResponseEntity<Student> registerStudent(@Valid @RequestBody Student student) {
        if (studentService.getStudent(student.getRollNumber()).isPresent())
            throw new StudentAlreadyExistException("Invalid employee ID : " + student.getId());
        return new ResponseEntity<>(studentService.registerStudent(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/student/{rollNumber}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long rollNumber){
        Optional<Student> student = studentService.getStudent(rollNumber);
        if (studentService.getStudent(rollNumber).isPresent())
            return new ResponseEntity<>(studentService.deleteStudentByRollNumber(rollNumber).get(), HttpStatus.NO_CONTENT);
        throw new StudentNotFoundException();
    }

}
