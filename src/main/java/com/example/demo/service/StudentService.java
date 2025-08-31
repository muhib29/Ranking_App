package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    // Read all students and assign rank based on CSV order
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ClassPathResource("results.csv").getInputStream()))) {

            String line;
            boolean firstLine = true; // Skip header

            int rankCounter = 1; // Start rank from 1

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                if (firstLine) { firstLine = false; continue; } // skip CSV header

                String[] fields = line.split(",");
                if (fields.length < 4) continue;

                String seatNo = fields[1].trim();
                String name = fields[2].trim();
                double marks = 0.0;
                try { marks = Double.parseDouble(fields[3].trim()); } catch (Exception e) {}

                String rank = String.valueOf(rankCounter++); // auto increment rank

                students.add(new Student(seatNo, name, marks, rank));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    // Get single student by SeatNo
    public Student getStudentBySeatNo(String seatNo) {
        return getAllStudents().stream()
                .filter(s -> s.getSeatNo().equalsIgnoreCase(seatNo))
                .findFirst()
                .orElse(null);
    }
}
