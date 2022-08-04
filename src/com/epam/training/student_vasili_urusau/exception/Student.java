package com.epam.training.student_vasili_urusau.exception;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String lastname;
    private Map<Subject, Integer> marks;

    public Student(String lastname, Map<Subject, Integer> marks) {
//        if (marks.size() == 0) {
//            throw new IllegalArgumentException("Student should has subject");
//        }
        this.lastname = lastname;
        this.marks = marks;
    }

    public void addSubjectEndEstimate(Subject subject, Integer mark) {
        if (mark < 0 || mark > 10) {
            throw new IllegalArgumentException("mark should be from 0 to 10");
        }
        marks.put(subject,mark);
    }

    public void averageMark() {
        Double averageMark = 0.;
        for (Integer mark : marks.values()) {
            averageMark += mark;
        }

        System.out.println(lastname + " average mark = " + averageMark/marks.size());
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Map<Subject, Integer> getMarks() {
        return marks;
    }
}
