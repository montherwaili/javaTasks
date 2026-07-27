import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseEnrollmentSystem {

    public static void main(String[] args) {
        // 4. Create a HashSet to store unique student IDs
        Set<Integer> studentIdSet = new HashSet<>();

        // Create a HashMap to associate student IDs with their enrolled courses
        Map<Integer, String> enrollmentMap = new HashMap<>();

        // 5. Prompt the user to enter the number of students
        IO.print("Enter the number of students: ");
        int totalRecordsEntered = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalRecordsEntered <= 0) {
            IO.println("Invalid number of students.");
            return;
        }

        // 7. Use a for loop to read each student ID and course name
        for (int i = 1; i <= totalRecordsEntered; i++) {
            IO.println("\nEntering details for Student #" + i + ":");
            IO.print("Enter Student ID: ");
            int studentId = Integer.parseInt(IO.readln());

            // Check whether the student ID already exists in the HashSet to prevent duplicates
            if (studentIdSet.contains(studentId)) {
                IO.println("Student ID already exists. Record not added.");
                // Decrement the loop counter to allow re-entering this student record properly
                i--;
            } else {
                IO.print("Enter Course Name: ");
                String courseName = IO.readln().trim();

                // Add the validated unique ID and course name to both collections
                studentIdSet.add(studentId);
                enrollmentMap.put(studentId, courseName);
            }
        }

        // 8. Prompt the user to enter a student ID to update
        IO.print("\nEnter a student ID to update their course: ");
        int updateId = Integer.parseInt(IO.readln());

        // 9 & 10. Check if the student ID exists and perform the update via replace()
        if (enrollmentMap.containsKey(updateId)) {
            IO.print("Enter the new course name: ");
            String newCourse = IO.readln().trim();

            // Update the course name safely using the replace() method
            enrollmentMap.replace(updateId, newCourse);
            IO.println("Course updated successfully.");
        } else {
            IO.println("Student ID not found.");
        }

        // 11. Use an if-else if-else statement to classify the enrollment size
        int uniqueCount = enrollmentMap.size();
        String enrollmentClassification;

        if (uniqueCount < 5) {
            enrollmentClassification = "Small Enrollment";
        } else if (uniqueCount <= 15) {
            enrollmentClassification = "Medium Enrollment";
        } else {
            enrollmentClassification = "Large Enrollment";
        }

        // 12. Display all the calculated metrics and the comprehensive final summary report
        IO.println("\n=== Enrollment Summary Report ===");
        IO.println("Total student records entered         : " + totalRecordsEntered);
        IO.println("Total unique students                 : " + uniqueCount);
        IO.println("All student IDs                       : " + studentIdSet.toString());
        IO.println("All student IDs with enrolled courses : " + enrollmentMap.toString());
        IO.println("Enrollment classification             : " + enrollmentClassification);
    }
}
