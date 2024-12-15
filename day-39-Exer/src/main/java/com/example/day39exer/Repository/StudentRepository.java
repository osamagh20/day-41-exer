package com.example.day39exer.Repository;

import com.example.day39exer.Model.Course;
import com.example.day39exer.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentById(Integer id);

    @Query("select c from Course c where c.id=?1")
    List<Student> getStudentsByCourseId(Integer courseId);


}
