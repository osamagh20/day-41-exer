package com.example.day39exer.Service;

import com.example.day39exer.ApiResponse.ApiException;
import com.example.day39exer.DTO.StudentDTO;
import com.example.day39exer.Model.Course;
import com.example.day39exer.Model.Student;
import com.example.day39exer.Model.Teacher;
import com.example.day39exer.Repository.CourseRepository;
import com.example.day39exer.Repository.StudentRepository;
import com.example.day39exer.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentService studentService;
    private final StudentRepository studentRepository;

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course){
        Course oldCourse = courseRepository.findCourseById(id);
        if(oldCourse==null){
            throw new ApiException("course not found");
        }
        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiException("course not found");
        }
        courseRepository.delete(course);
    }

    public void linkCourse(Integer teacher_id, Integer course_id){
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);

        if(course==null || teacher==null){
            throw new ApiException("course or teacher not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public Teacher getTeacherDetails(Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
        if(course==null){
            throw new ApiException("course not found");
        }
        return course.getTeacher();
    }



}
