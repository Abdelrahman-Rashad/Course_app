package com.example.course.model;

public class Course {

    int Id;
    String Name;
    String Description;
    String TeacherName;

    public Course(int id, String name, String description, String teacherName) {
        Id = id;
        Name = name;
        Description = description;
        TeacherName = teacherName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }
}
