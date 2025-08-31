package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class StudentService {

    // Get single student by seat number
    public Student getStudentBySeatNo(String seatNo) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ClassPathResource("results.csv").getInputStream()))) {

            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                if (firstLine) { 
                    firstLine = false; 
                    continue; // skip header
                }

                String[] fields = line.split(",");
                if (fields.length < 5) continue; // make sure rank column exists

                String currentSeatNo = fields[1].trim();
                String name = fields[2].trim();
                double marks = 0.0;
                try { marks = Double.parseDouble(fields[3].trim()); } catch (Exception ignored) {}
                String rank = fields[4].trim(); // ✅ read rank directly from CSV

                if (currentSeatNo.equalsIgnoreCase(seatNo)) {
                    return new Student(currentSeatNo, name, marks, rank);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // student not found
    }
}
