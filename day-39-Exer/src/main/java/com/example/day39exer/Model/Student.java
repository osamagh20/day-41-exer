package com.example.day39exer.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(10) not null")
    private String name;
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String major;

    @ManyToMany
    private Set<Course> courseSet;

    public Student(@NotEmpty String name, @NotEmpty String major) {
        this.name = name;
        this.major = major;
    }
}
