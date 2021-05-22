package com.app.tera.entity;

import com.app.tera.enums.Section;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "STUDENT")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "First name should not be empty")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "email")
    @NotBlank(message = "Email should not be empty")
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "section")
    private Section section;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile_number", length = 10)
    @NotNull
    @NotBlank(message = "Please enter your mobile number")
    private Long mobileNumber;


}
