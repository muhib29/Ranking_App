
package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.File_Dealing; // ✅ FIXED IMPORT
import java.util.ArrayList;

public class StudentList {

    // Reads file and returns ArrayList<Student>
    public ArrayList<Student> getAllStudents() {

        File_Dealing file = new File_Dealing(); // ✅ Now recognized

        ArrayList<String> lines = file.fileReader();
        ArrayList<Student> students = new ArrayList<>();

        String seatNo, name, rank;
        double marks;

        if (!lines.isEmpty()) {
            lines.remove(0); // skip header row (S.no SeatNo Name Marks Rank)
        }

        for (String line : lines) {
            String[] fields = line.trim().split("\\s+");

            if (fields.length < 4) {
                continue; // skip invalid line if is in file
            }

            seatNo = fields[1];

            // Build full name from tokens between seatNo and marks
            StringBuilder nameBuilder = new StringBuilder();
            for (int i = 2; i <= fields.length - 3; i++) {
                if (i > 2) {
                    nameBuilder.append(" ");
                }
                nameBuilder.append(fields[i]);
            }
            name = nameBuilder.toString();

            marks = Double.parseDouble(fields[fields.length - 2]);

            // Handle missing rank
            if (fields[fields.length - 1].equalsIgnoreCase("None")) {
                rank = "Rank is below 8";
            } else {
                rank = fields[fields.length - 1];
            }

            students.add(new Student(seatNo, name, marks, rank));
        }

        return students;
    }

    // Prints all students
    public void printAllStudents() {
        ArrayList<Student> students = getAllStudents();
        for (Student s : students) {
            System.out.println(s.toString());
        }
        System.out.println("Total students Are: " + students.size());
    }
}
