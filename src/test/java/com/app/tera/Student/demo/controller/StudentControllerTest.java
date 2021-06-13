package com.app.tera.Student.demo.controller;

import com.app.tera.student.demo.controller.StudentController;
import com.app.tera.student.demo.entity.Student;
import com.app.tera.student.demo.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @InjectMocks
    StudentController studentController;

    @InjectMocks
    ObjectMapper objectMapper;

    @Mock
    StudentService studentService;

    private MockMvc mockMvc;
    private Student student;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        this.objectMapper = new ObjectMapper();
        this.student = getStudent();
    }

    @Test
    public void testStudent() throws Exception {
        when(studentService.registerStudent(any())).thenReturn(getStudent());
        mockMvc.perform(post("/student")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(getStudent())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email", is("abc@gmail.com")))
                .andExpect(jsonPath("$.firstName", is("abc")))
                .andExpect(jsonPath("$.rollNumber", is(1234)));
    }

    private static Student getStudent() {
        return Student.builder().id(1l)
                .firstName("abc").lastName("xyz")
                .rollNumber(1234l).address("abc organizaiton")
                //.dateOfBirth(LocalDate.of(1994, 02, 28))
                .email("abc@gmail.com")
                .mobileNumber(7571929008l)
                .fatherName("xyz father")
                .build();
    }
}
