package com.example.day39exer.DTO;

import com.example.day39exer.Model.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class StudentDTO {

    @NotEmpty
    private String name;
    @NotEmpty
    private String major;

}
