package com.example.day39exer.DTO;

import com.example.day39exer.Model.Student;
import com.example.day39exer.Model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor

public class CourseDTO {
    @NotEmpty(message = "Please Enter the name of course")
    private String name;


}
