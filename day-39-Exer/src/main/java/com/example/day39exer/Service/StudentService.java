package com.example.day39exer.Service;

import com.example.day39exer.ApiResponse.ApiException;
import com.example.day39exer.DTO.CourseDTO;
import com.example.day39exer.DTO.StudentDTO;
import com.example.day39exer.Model.Course;
import com.example.day39exer.Model.Student;
import com.example.day39exer.Repository.CourseRepository;
import com.example.day39exer.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }


    public List<StudentDTO> findAllDTO() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for(Student student : students){
            StudentDTO studentDTO = new StudentDTO(student.getName(),student.getMajor());
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }


    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id,Student student){
        Student upStudent = studentRepository.findStudentById(id);
        if(upStudent == null){
            throw new ApiException("id not found");
        }
        upStudent.setName(student.getName());
        upStudent.setMajor(student.getMajor());
        upStudent.setAge(student.getAge());
        studentRepository.save(upStudent);
    }

    public void deleteStudent(Integer id){
        Student student = studentRepository.findStudentById(id);
        if(student == null){
            throw new ApiException("id not found");
        }
        studentRepository.delete(student);
    }

    public void changeMajor(Integer id,String major){
        Student student = studentRepository.findStudentById(id);
        if(student == null){
            throw new ApiException("id not found");
        }
        student.setMajor(major);
        student.setCourseSet(null);
        studentRepository.save(student);

    }

    public void enrollCourse(Integer student_id,Integer course_id){
        Student student = studentRepository.findStudentById(student_id);
        if(student == null){
            throw new ApiException("student not found");
        }
        Course course = courseRepository.findCourseById(course_id);
        if(course == null){
            throw new ApiException("course not found");
        }
        student.getCourseSet().add(course);
        studentRepository.save(student);

    }

    public List<StudentDTO> getStudentByCourseId(Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
        List<StudentDTO> studentDTOList = new ArrayList<>();

        if(course==null){
            throw new ApiException("course not found");
        }

        System.out.println("hello-1");

        System.out.println(course.getStudents().size());


        for(Student student : course.getStudents()){
                System.out.println("hello");
                StudentDTO studentDTO = new StudentDTO(student.getName(),student.getMajor());
                studentDTOList.add(studentDTO);
        }
        System.out.println("hello-2");
        return studentDTOList;
    }


}
