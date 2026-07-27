import java.util.HashSet;
import java.util.Set;

public class StudentSetManager {

    public static void main(String[] args) {
        // Create a HashSet to store unique student IDs as specified
        Set<String> studentIds = new HashSet<>();

        // Prompt the user to enter the number of student IDs they want to register
        IO.print("Enter the number of student IDs to register: ");
        int totalToRegister = Integer.parseInt(IO.readln());

        // 6. Validate the entered number: must be strictly greater than zero
        if (totalToRegister <= 0) {
            IO.println("Invalid number of students.");
            return;
        }

        // 7. Use a for loop to read each student ID from the user
        for (int i = 1; i <= totalToRegister; i++) {
            IO.print("Enter student ID #" + i + ": ");
            String currentId = IO.readln().trim();

            // Check if the ID already exists in the Set before adding
            if (studentIds.contains(currentId)) {
                IO.println("Duplicate ID detected. ID was not added.");
            } else {
                studentIds.add(currentId);
            }
        }

        // 8. Classify the registration using an if-else if-else statement based on unique count
        int uniqueCount = studentIds.size();
        String classification;

        if (uniqueCount < 5) {
            classification = "Small Registration";
        } else if (uniqueCount <= 10) {
            classification = "Medium Registration";
        } else {
            classification = "Large Registration";
        }

        // 9. Display the compiled final results and metrics report
        IO.println("\n=== Registration Summary Report ===");
        IO.println("Total IDs entered           : " + totalToRegister);
        IO.println("Total unique student IDs   : " + uniqueCount);
        IO.println("All unique student IDs     : " + studentIds.toString());
        IO.println("Registration classification: " + classification);
    }
}
