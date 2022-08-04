package com.epam.training.student_vasili_urusau.exception;

import java.util.List;

public class Group {
    private String number;
    private List<Student> students;


    public Integer averageMarkForSubject(Subject subject) {
        Integer averageMark = 0;
        Integer count = 0;
        for (Student student : students) {
            if (student.getMarks().containsKey(subject)) {
                count++;
                averageMark += student.getMarks().get(subject);
            }
        }

        students.stream()
                .filter(s -> s.getMarks().containsKey(subject))
                .mapToInt(s -> s.getMarks().get(subject))
                .average()
                .getAsDouble();

        return averageMark/count;

    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getNumber() {
        return number;
    }


    public static class BuilderGroup {
        private Group group;

        public BuilderGroup() {
            group = new Group();
        }

        public BuilderGroup withNumber(String number) {
            group.number = number;
            return this;
        }

        public BuilderGroup withStudents(List<Student> students) {
            group.students = students;
            return this;
        }

        public Group build() {
            if (group.students.isEmpty() || group.students == null) {
                throw new IllegalArgumentException("Group should have students");
            }
            return group;
        }
    }

}
