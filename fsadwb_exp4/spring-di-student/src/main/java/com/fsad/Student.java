package com.fsad;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private int studentId = 102;
    private String name = "Rebekah";
    private String course = "AI";
    private int year = 4;

    public void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Year: " + year);
    }
}