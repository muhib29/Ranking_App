package com.example.demo.repository;

import com.example.demo.model.Student;
import com.example.demo.service.StudentList;  // ✅ Corrected import

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepository {

    public List<Student> getAllStudents() {
        StudentList studentList = new StudentList();  // ✅ Correct class name
        return studentList.getAllStudents();
    }
}
