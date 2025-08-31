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
            int rankCounter = 0;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                if (firstLine) { firstLine = false; continue; } // skip header

                String[] fields = line.split(",");
                if (fields.length < 4) continue;

                String currentSeatNo = fields[1].trim();
                String name = fields[2].trim();
                double marks = 0.0;
                try { marks = Double.parseDouble(fields[3].trim()); } catch (Exception ignored) {}

                if (currentSeatNo.equalsIgnoreCase(seatNo)) {
                    return new Student(currentSeatNo, name, marks, String.valueOf(rankCounter));
                }
                rankCounter++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // student not found
    }
}
