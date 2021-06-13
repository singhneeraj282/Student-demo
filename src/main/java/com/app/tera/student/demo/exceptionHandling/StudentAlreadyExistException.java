package com.app.tera.student.demo.exceptionHandling;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class StudentAlreadyExistException extends RuntimeException{

    public StudentAlreadyExistException(String exception) {
        super(exception);
    }
}
