package entities;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String gradeLevel;
    private String enrollmentDate;
    private double feeBalance;
    private List<String> subjects;

    public Student(String id, String firstName, String lastName, String dateOfBirth,
                   String gender, String phoneNumber, String email, String address,
                   String gradeLevel, String enrollmentDate, double feeBalance){

            // super tells the parent to build its part first
            super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
            this.gradeLevel = gradeLevel;
            this.enrollmentDate = enrollmentDate;
            setFeeBalance(feeBalance);   // check runs
            this.subjects = new ArrayList<>();
    }

    public String getGradeLevel() { return gradeLevel; }
    public String getEnrollmentDate() { return enrollmentDate; }
    public double getFeeBalance() { return feeBalance; }
    public List<String> getSubjects() { return subjects; }

    public void setGradeLevel(String gradeLevel) { this.gradeLevel = gradeLevel; }
    public void setEnrollmentDate(String enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public void setFeeBalance(double feeBalance) {
}
