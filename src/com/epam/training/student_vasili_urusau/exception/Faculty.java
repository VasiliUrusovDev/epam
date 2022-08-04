package com.epam.training.student_vasili_urusau.exception;

import java.util.List;

public class Faculty {
    private String name;
    private List<Group> groupList;
    private List<Subject> subjectList;

    public String getName() {
        return name;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public static class BuilderFaculty {
        private Faculty faculty;

        public BuilderFaculty() {
            this.faculty = new Faculty();
        }

        public BuilderFaculty withName(String name) {
            faculty.name = name;
            return this;
        }

        public BuilderFaculty withGroupList(List<Group> groupList) {
            faculty.groupList = groupList;
            return this;
        }

        public BuilderFaculty withSubjectList(List<Subject> subjectList) {
            faculty.subjectList = subjectList;
            return this;
        }

        public Faculty build() {
            if (faculty.name == null || faculty.name.trim().isEmpty()) {
                throw new IllegalArgumentException("Faculty name can't empty");
            }
            if (faculty.groupList.isEmpty()) {
                throw new IllegalArgumentException("Faculty should have any one group");
            }
            if (faculty.subjectList.isEmpty()) {
                throw new IllegalArgumentException("Faculty should have any one subject");
            }
            return faculty;
        }
    }
}
