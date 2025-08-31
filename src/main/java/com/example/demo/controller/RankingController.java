package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RankingController {

    private final StudentService studentService;

    public RankingController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String showRanking(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "index"; // <-- points to src/main/resources/templates/index.html
    }

    @PostMapping("/search")
    public String searchStudent(@RequestParam String seatNo, Model model) {
        Student student = studentService.getStudentBySeatNo(seatNo);
        model.addAttribute("student", student);
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }
}
