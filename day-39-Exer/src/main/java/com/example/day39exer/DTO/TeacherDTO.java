package com.example.day39exer.DTO;

import com.example.day39exer.Model.Address;
import com.example.day39exer.Model.Course;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class TeacherDTO {


    private String name;
    @NotNull(message = "Please enter the age")
    @Positive
    private Integer age;
    @NotEmpty(message = "Enter the email")
    @Email
    private String email;
    @NotNull(message = "Please enter the salary")
    @Positive
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courseSet;
}
