package com.app.tera.student.demo.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(StudentNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Student does not exist with given roll number",
                "Provide correct roll number");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentAlreadyExistException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(StudentAlreadyExistException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Student already exist",
                "Should provide with correct id which does not exist");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
