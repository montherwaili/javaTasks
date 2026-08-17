package entities;

// Second level of inheritance: Person -> Teacher -> HeadTeacher
public class HeadTeacher extends Teacher {
    private String department;
    private int teachersManaged;

    public HeadTeacher(String id, String firstName, String lastName, String dateOfBirth,
                       String gender, String phoneNumber, String email, String address,
                       String subject, int experienceYears, double salary,
                       String department, int teachersManaged) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address,
                subject, experienceYears, salary);
        this.department = department;
        this.teachersManaged = teachersManaged;
    }

    public String getDepartment() { return department; }
    public int getTeachersManaged() { return teachersManaged; }
    public void setDepartment(String department) { this.department = department; }

    public void addManagedTeacher() {
        teachersManaged = teachersManaged + 1;
    }
