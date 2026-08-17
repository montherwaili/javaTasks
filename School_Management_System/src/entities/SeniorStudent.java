package entities;

// Second level of inheritance: Person -> Student -> SeniorStudent
public class SeniorStudent extends Student {
    private String major;
    private double gpa;

    public SeniorStudent(String id, String firstName, String lastName, String dateOfBirth,
                         String gender, String phoneNumber, String email, String address,
                         String gradeLevel, String enrollmentDate, double feeBalance,
                         String major, double gpa) {
        // super(...) goes all the way up: SeniorStudent -> Student -> Person
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address,
                gradeLevel, enrollmentDate, feeBalance);
        this.major = major;
        this.gpa = gpa;
    }
