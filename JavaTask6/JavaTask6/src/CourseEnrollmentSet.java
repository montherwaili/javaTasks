import java.util.HashSet;
import java.util.Set;

public class CourseEnrollmentSet {

    public static void main(String[] args) {
        // 4. Create a HashSet to store unique course names
        Set<String> courses = new HashSet<>();

        // 5. Prompt the user to enter the number of courses
        IO.print("Enter the number of courses: ");
        int totalCoursesEntered = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalCoursesEntered <= 0) {
            IO.println("Invalid number of courses.");
            return;
        }

        // 7. Use a for loop to read each course name from the user
        for (int i = 1; i <= totalCoursesEntered; i++) {
            IO.print("Enter course name #" + i + ": ");
            String courseName = IO.readln().trim();

            // Check if the course already exists to prevent duplicate entries
            if (courses.contains(courseName)) {
                IO.println("Course already exists. Duplicate entries are not allowed.");
            } else {
                courses.add(courseName);
            }
        }

        // 8. Prompt the user to enter the name of a course to remove
        IO.print("\nEnter a course name to remove: ");
        String courseToRemove = IO.readln().trim();

        // 9 & 10. Use the remove() method to delete the course from the HashSet
        String removalResult;
        if (courses.remove(courseToRemove)) {
            removalResult = "Course removed successfully.";
        } else {
            removalResult = "Course not found.";
        }

        // 11. Classify the enrollment based on the number of remaining unique courses
        int uniqueRemainingCount = courses.size();
        String catalogClassification;

        if (uniqueRemainingCount < 4) {
            catalogClassification = "Small Course Catalog";
        } else if (uniqueRemainingCount <= 8) {
            catalogClassification = "Medium Course Catalog";
        } else {
            catalogClassification = "Large Course Catalog";
        }

        // 12. Display all the calculated metrics and the summary report
        IO.println("\n=== Course Enrollment Summary Report ===");
        IO.println("Total courses entered         : " + totalCoursesEntered);
        IO.println("Total unique courses remaining: " + uniqueRemainingCount);
        IO.println("All remaining course names    : " + courses.toString());
        IO.println("Removal result                : " + removalResult);
        IO.println("Course catalog classification : " + catalogClassification);
    }
}
