package com.example.demo.model;

public class Student {
    private String seatNo;
    private String name;
    private double marks;
    private String rank;

    // ✅ Default Constructor (needed by Spring & frameworks)
    public Student() {
    }

    // ✅ Parameterized Constructor
    public Student(String seatNo, String name, double marks, String rank) {
        this.seatNo = seatNo;
        this.name = name;
        this.marks = marks;
        this.rank = rank;
    }

    // ✅ Getters & Setters
    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
