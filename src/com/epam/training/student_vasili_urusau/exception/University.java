package com.epam.training.student_vasili_urusau.exception;

import java.util.ArrayList;
import java.util.List;

public class University {

    private String name;
    private List<Faculty> facultyList;
    private List<Subject> subjectList;

    public void averageMarkForSubjectInFacultyInGroup(String subject, String faculty, String group) {
        Integer averageMark = 0;
        for (Subject sub : subjectList) {
            if (sub.getName().equalsIgnoreCase(subject)) {
                for (Faculty fac : facultyList) {
                    if (fac.getName().equalsIgnoreCase(faculty)) {
                        for (Group gr : fac.getGroupList()) {
                            if (gr.getNumber().equalsIgnoreCase(group)) {
                                for (Student student : gr.getStudents()) {
                                   averageMark += student.getMarks().get(sub);
                                }
                                System.out.println("average mark for subject in faculty in group = " + averageMark/gr.getStudents().size());
                            }
                        }
                    }
                }
            }
        }
    }

    public void averageMarkForSubjectInFacultyInGroupStream(Subject subject, String faculty, String group) {

         List<Group> groups = facultyList.stream()
                 .filter(f -> f.getName().equalsIgnoreCase(faculty))
                 .filter(f -> f.getSubjectList().contains(subject))
                 .map(Faculty::getGroupList)
                 .filter(groupList -> groupList.stream().anyMatch(g -> g.getNumber().equalsIgnoreCase(group)))
                 .collect(ArrayList::new,
                         ArrayList::addAll,
                         ArrayList::addAll);

        List<Student> students = groups.stream()
                .filter(g -> g.getNumber().equalsIgnoreCase(group))
                .collect(ArrayList::new,
                        (l,i) -> l.addAll(i.getStudents()),
                        ArrayList::addAll);

        double average = students.stream()
                .filter(s -> s.getMarks().containsKey(subject))
                .mapToInt(s -> s.getMarks().get(subject))
                .average()
                .orElse(0.);

        System.out.println("this is average mark for subject in faculty in group " + subject + " = " + average);
    }


    public void averageMarkForSubjectInAllUniversityStream(Subject subject) {

        List<Faculty> faculties = facultyList.stream()
              .filter(f -> f.getSubjectList().contains(subject)).toList();

        List<Group> groups = faculties.stream()
              .collect(ArrayList::new,
                      (list, item) -> list.addAll(item.getGroupList()),
                      ArrayList::addAll);

        List<Student> students = groups.stream()
              .collect(ArrayList::new,
                      (l,i) -> l.addAll(i.getStudents()),
                      ArrayList::addAll);

        double average = students.stream()
              .filter(s -> s.getMarks().containsKey(subject))
              .mapToInt(s -> s.getMarks().get(subject))
              .average()
              .orElse(0.);

        System.out.println("this is average mark for subject in all university " + subject + " = " + average);

    }

    public void averageMarkByStudent(String lastname) {

           ArrayList<Group> groups = facultyList.stream()
                    .map(Faculty::getGroupList)
                   .collect(ArrayList::new,
                           ArrayList::addAll,
                           ArrayList::addAll);

           ArrayList<Student> students = groups.stream()
                   .map(Group::getStudents)
                   .collect(ArrayList::new,
                           ArrayList::addAll,
                           ArrayList::addAll);

           students.stream()
                   .filter(s -> s.getLastname().equalsIgnoreCase(lastname))
                   .forEach(Student::averageMark);

    }

    public String getName() {
        return name;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public static class BuilderUniversity {
        private University university;

        public BuilderUniversity() {
            university = new University();
        }

        public BuilderUniversity withName(String name) {
            university.name = name;
            return this;
        }

        public BuilderUniversity withFacultyList(List<Faculty> facultyList) {
            university.facultyList = facultyList;
            return this;
        }

        public BuilderUniversity withSubjectList(List<Subject> subjectList) {
            university.subjectList = subjectList;
            return this;
        }

        public University build() {
            if (university.facultyList.isEmpty() || university.facultyList == null) {
                throw new IllegalArgumentException("University should have faculty");
            }
            return university;
        }
    }


}
