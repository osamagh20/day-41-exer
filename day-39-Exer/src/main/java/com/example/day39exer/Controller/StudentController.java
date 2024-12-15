package com.example.day39exer.Controller;

import com.example.day39exer.ApiResponse.ApiResponse;
import com.example.day39exer.DTO.StudentDTO;
import com.example.day39exer.Model.Student;
import com.example.day39exer.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudent(){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/get-student-DTO")
    public ResponseEntity getAllStudentsDTO(){
        List<StudentDTO> studentDTOS = studentService.findAllDTO();
        return ResponseEntity.status(200).body(studentDTOS);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("student added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id,@RequestBody @Valid Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body(new ApiResponse("student updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("student deleted successfully"));
    }

    @PutMapping("/change-major/{id}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer id,@PathVariable String major){
        studentService.changeMajor(id, major);
        return ResponseEntity.status(200).body(new ApiResponse("student updated successfully"));
    }

    @PutMapping("/enroll/{student_id}/{course_id}")
    public ResponseEntity enrollCourse(@PathVariable Integer student_id,@PathVariable Integer course_id){
        studentService.enrollCourse(student_id, course_id);
        return ResponseEntity.status(200).body(new ApiResponse("student enroll the course successfully"));
    }

    @GetMapping("/get-by-course-id/{course_id}")
    public ResponseEntity getStudentByCourseId(@PathVariable Integer course_id){
        List<StudentDTO> students = studentService.getStudentByCourseId(course_id);
        return ResponseEntity.status(200).body(students);
    }


}
