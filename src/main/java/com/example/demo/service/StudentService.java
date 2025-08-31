package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private static final String FILE_PATH = "src/main/resources/results.csv";

    // Read all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty())
                    continue;

                lineNumber++;
                if (lineNumber <= 2) {
                    // Skip the first two header lines
                    continue;
                }

                // Split by comma
                String[] fields = line.split(",");
                if (fields.length < 4)
                    continue;

                String seatNo = fields[1].trim();
                String name = fields[2].trim();

                double marks = 0.0;
                try {
                    marks = Double.parseDouble(fields[3].trim());
                } catch (NumberFormatException e) {
                    // skip malformed line
                    continue;
                }

                String rank = (fields.length > 4 && !fields[4].trim().equalsIgnoreCase("None"))
                        ? fields[4].trim()
                        : "Rank below 8";

                students.add(new Student(seatNo, name, marks, rank));
            }

        } catch (IOException e) {
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
