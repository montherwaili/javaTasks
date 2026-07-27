import java.util.HashMap;
import java.util.Map;

public class StudentGradesMap {

    public static void main(String[] args) {
        // 4. Create a HashMap to store unique student IDs as keys and their grades as values
        Map<Integer, Double> gradeMap = new HashMap<>();

        // 5. Prompt the user to enter the number of students
        IO.print("Enter the number of students: ");
        int totalRecordsEntered = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalRecordsEntered <= 0) {
            IO.println("Invalid number of students.");
            return;
        }

        // 7. Use a for loop to read each student ID and grade
        for (int i = 1; i <= totalRecordsEntered; i++) {
            IO.println("\nEntering details for Student #" + i + ":");
            IO.print("Enter Student ID: ");
            int studentId = Integer.parseInt(IO.readln());

            // Check if the student ID already exists in the map
            if (gradeMap.containsKey(studentId)) {
                IO.println("Student ID already exists. Record not added.");
                // Decrement the loop counter to allow re-entering a valid student record
                i--;
            } else {
                IO.print("Enter Student Grade: ");
                double grade = Double.parseDouble(IO.readln());
                gradeMap.put(studentId, grade);
            }
        }

        // 8. Prompt the user to enter a student ID whose grade should be updated
        IO.print("\nEnter a student ID to update their grade: ");
        int updateId = Integer.parseInt(IO.readln());

        // 9 & 10. Check if the student ID exists and perform the update via replace()
        if (gradeMap.containsKey(updateId)) {
            IO.print("Enter the new grade: ");
            double newGrade = Double.parseDouble(IO.readln());

            // Update the grade value safely using the replace() method
            gradeMap.replace(updateId, newGrade);
            IO.println("Grade updated successfully.");
        } else {
            IO.println("Student ID not found.");
        }

        // 11. Calculate the total sum of grades to compute the average grade
        double totalSum = 0;
        for (double grade : gradeMap.values()) {
            totalSum += grade;
        }

        // Calculate the accurate decimal average based on total unique map records count
        double averageGrade = totalSum / gradeMap.size();

        // 12. Use an if-else if-else statement to classify the class performance
        String classPerformance;
        if (averageGrade < 60.0) {
            classPerformance = "Needs Improvement";
        } else if (averageGrade <= 84.0) {
            classPerformance = "Good Performance";
        } else {
            classPerformance = "Excellent Performance";
        }

        // 13. Display the compiled final results and metrics report
        IO.println("\n=== Student Grades Summary Report ===");
        IO.println("Total student records         : " + gradeMap.size());
        IO.println("All student IDs and grades    : " + gradeMap.toString());
        IO.println("Average grade                 : " + averageGrade);
        IO.println("Class performance             : " + classPerformance);
    }
}
