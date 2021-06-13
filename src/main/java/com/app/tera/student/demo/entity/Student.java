package com.app.tera.student.demo.entity;

import com.app.tera.student.demo.enums.Section;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "STUDENT")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name= "roll_number")
    @NotNull(message = "Roll number should not be empty")
    private Long rollNumber;

    @Column(name = "first_name")
    @NotNull(message = "First name should not be empty")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "email")
    @NotNull(message = "Email should not be empty")
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "section")
    private Section section;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile_number", length = 10)
    @NotNull(message = "Please enter your mobile number")
    private Long mobileNumber;


}
