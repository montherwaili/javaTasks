package services;

import entities.Student;
import interfaces.Manageable;
import interfaces.Searchable;
import utils.HelperUtils;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements Manageable<Student>, Searchable<Student> {
    private List<Student> students = new ArrayList<>();

    // OVERLOADING: three ways to add a student
    public Student addStudent(String firstName, String lastName, String phone) {
        String id = HelperUtils.generateId("STU");
        Student s = new Student(id, firstName, lastName, "", "", phone, "", "",
                "Grade 1", "2026-01-01", 0);
        students.add(s);
        return s;
    }

    public Student addStudent(String firstName, String lastName, String phone, String gradeLevel) {
        String id = HelperUtils.generateId("STU");
        Student s = new Student(id, firstName, lastName, "", "", phone, "", "",
                gradeLevel, "2026-01-01", 0);
        students.add(s);
        return s;
    }
