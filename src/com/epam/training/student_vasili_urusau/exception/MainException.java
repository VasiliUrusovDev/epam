package com.epam.training.student_vasili_urusau.exception;

import java.util.*;

public class MainException {
    public static void main(String[] args) {

        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(new Subject("algebra"));
        subjectList.add(new Subject("astronomy"));
        subjectList.add(new Subject("computer science"));
        subjectList.add(new Subject("french"));
        subjectList.add(new Subject("german"));
        subjectList.add(new Subject("history"));

        List<Subject> subjectListForHistory = new ArrayList<>();
        subjectListForHistory.add(subjectList.get(0));
        subjectListForHistory.add(subjectList.get(3));
        subjectListForHistory.add(subjectList.get(4));
        subjectListForHistory.add(subjectList.get(5));

        List<Subject> subjectListForAstronomy = new ArrayList<>();
        subjectListForAstronomy.add(subjectList.get(0));
        subjectListForAstronomy.add(subjectList.get(1));
        subjectListForAstronomy.add(subjectList.get(2));
        subjectListForAstronomy.add(subjectList.get(3));

        String lastname[] = {"Churchill", "Brunel", "Nelson", "Diana", "Newton", "Cromwell", "Lennon", "Darwin", "Shakespeare"};

        List<Student> students = new ArrayList<>();
        students.add(new Student("Churchill", new HashMap<>()));
        students.add(new Student("Brunel", new HashMap<>()));
        students.add(new Student("Nelson", new HashMap<>()));

        students.add(new Student("Diana", new HashMap<>()));
        students.add(new Student("Newton", new HashMap<>()));
        students.add(new Student("Cromwell", new HashMap<>()));

        students.add(new Student("Lennon",new HashMap<>()));
        students.add(new Student("Darwin", new HashMap<>()));
        students.add(new Student("Shakespeare",new HashMap<>()));

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < subjectListForAstronomy.size(); j++) {
                students.get(i).addSubjectEndEstimate(subjectListForAstronomy.get(j),(int) (Math.random() * 10) );
            }
        }

        for (int i = 6; i < students.size() ; i++) {
            for (int j = 0; j < subjectListForHistory.size(); j++) {
                students.get(i).addSubjectEndEstimate(subjectListForHistory.get(j),(int) (Math.random() * 10));
            }
        }

        Group group112 = new Group.BuilderGroup()
                .withNumber("112")
                .withStudents(students.subList(0,3))
                .build();

        Group group113 = new Group.BuilderGroup()
                .withNumber("113")
                .withStudents(students.subList(3,6))
                .build();

        Group group011 = new Group.BuilderGroup()
                .withNumber("011")
                .withStudents(students.subList(6, students.size()))
                .build();

        List<Group> groupListForHistory = new ArrayList<>();
        groupListForHistory.add(group011);

        List<Group> groupListForAstronomy = new ArrayList<>();
        groupListForAstronomy.add(group112);
        groupListForAstronomy.add(group113);

        Faculty historyFaculty = new Faculty.BuilderFaculty()
                .withName("History")
                .withSubjectList(subjectListForHistory)
                .withGroupList(groupListForHistory)
                .build();

        Faculty astronomyFaculty = new Faculty.BuilderFaculty()
                .withName("Astronomy")
                .withSubjectList(subjectListForAstronomy)
                .withGroupList(groupListForAstronomy)
                .build();

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(astronomyFaculty);
        facultyList.add(historyFaculty);

        University university = new University.BuilderUniversity()
                .withName("Pythagoras")
                .withSubjectList(subjectList)
                .withFacultyList(facultyList)
                .build();

        university.averageMarkByStudent("Nelson");
        university.averageMarkForSubjectInAllUniversityStream(subjectList.get(4));
        university.averageMarkForSubjectInFacultyInGroupStream(subjectListForAstronomy.get(3), "Astronomy", "112");

    }
}

