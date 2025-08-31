package com.example.demo.repository;

import java.io.*;
import java.util.ArrayList;

public class File_Dealing {

    public ArrayList<String> fileReader() {
        ArrayList<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(
                new FileReader("src/main/resources/Result-_2nd-Semester_-Section-A-Checked-by-BETA-Group.txt")
            );

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
}
