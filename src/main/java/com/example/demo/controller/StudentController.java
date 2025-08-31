package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET /api/students → List all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // GET /api/students/{seatNo} → Get details by seat number
    @GetMapping("/{seatNo}")
    public Object getStudentBySeatNo(@PathVariable String seatNo) {
        Student student = studentService.getStudentBySeatNo(seatNo);
        if (student != null) {
            return student;
        } else {
            return Map.of("message", "No student found with this Seat No.");
        }
    }

}
