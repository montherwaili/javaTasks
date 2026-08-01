import java.util.ArrayList;
import java.util.List;

public class StudentNameManager {

    public static void main(String[] args) {
        // 5. Prompt the user to enter the initial number of students
        IO.print("Enter the number of initial students: ");
        int totalStudents = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalStudents <= 0) {
            IO.println("Invalid number of students.");
            return;
        }

        // 4. Create a String array to store student names (or dynamic track via List to support adding)
        List<String> studentList = new ArrayList<>();

        // 7. Use a for loop to read each student name initially
        for (int i = 1; i <= totalStudents; i++) {
            IO.print("Enter student name #" + i + ": ");
            String name = IO.readln().trim();
            studentList.add(name);
        }

        // 8. Display the menu system using a do-while loop
        int choice;
        do {
            IO.println("\n=== Student Name Management Menu ===");
            IO.println("1. Add Student Name");
            IO.println("2. Search Student Name");
            IO.println("3. Update Student Name");
            IO.println("4. Display All Student Names");
            IO.println("5. Analyze Names");
            IO.println("6. Compare Two Names");
            IO.println("7. Exit");
            IO.print("Choose an option: ");

            choice = Integer.parseInt(IO.readln().trim());

            // 10. Use a switch case statement to process user menu selection
            switch (choice) {
                case 1 -> {
                    // Add Student Name Option
                    IO.print("Enter new student name to add: ");
                    String newName = IO.readln().trim();
                    boolean exists = false;

                    // Check if the name already exists using equals()
                    for (String name : studentList) {
                        if (name.equals(newName)) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        IO.println("Student name already exists.");
                    } else {
                        studentList.add(newName);
                        IO.println("Student name added successfully.");
                    }
                }
                case 2 -> {
                    // Search Student Name Option
                    IO.print("Enter a student name to search: ");
                    String searchTarget = IO.readln().trim();
                    boolean found = false;

                    // Search using a loop and equals()
                    for (String name : studentList) {
                        if (name.equals(searchTarget)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        IO.println("Student found.");
                    } else {
                        IO.println("Student not found.");
                    }
                }
                case 3 -> {
                    // Update Student Name Option
                    IO.print("Enter the existing student name to update: ");
                    String existingName = IO.readln().trim();
                    int foundIndex = -1;

                    // Search for the existing name in the collection
                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).equals(existingName)) {
                            foundIndex = i;
                            break;
                        }
                    }

                    if (foundIndex != -1) {
                        IO.print("Enter the new student name: ");
                        String updatedName = IO.readln().trim();
                        studentList.set(foundIndex, updatedName);
                        IO.println("Student name updated successfully.");
                    } else {
                        IO.println("Existing student name not found.");
                    }
                }
                case 4 -> {
                    // Display All Student Names Option with numbering formatting
                    if (studentList.isEmpty()) {
                        IO.println("No student records found.");
                    } else {
                        IO.println("\n--- Registered Student Names ---");
                        for (int i = 0; i < studentList.size(); i++) {
                            IO.println((i + 1) + ". " + studentList.get(i));
                        }
                    }
                }
                case 5 -> {
                    // Analyze Names Option using String methods and loops
                    if (studentList.isEmpty()) {
                        IO.println("No names available for analysis.");
                    } else {
                        int count = studentList.size();
                        String longestName = studentList.get(0);
                        String shortestName = studentList.get(0);
                        int totalCharacters = 0;
                        int startsWithACount = 0;
                        int endsWithaCount = 0;

                        for (String name : studentList) {
                            totalCharacters += name.length();

                            // Find the longest student name length tracking
                            if (name.length() > longestName.length()) {
                                longestName = name;
                            }
                            // Find the shortest student name length tracking
                            if (name.length() < shortestName.length()) {
                                shortestName = name;
                            }
                            // Number of names starting with "A" or "a" (using startsWith/toUpperCase/toLowerCase)
                            if (name.startsWith("A") || name.startsWith("a")) {
                                startsWithACount++;
                            }
                            // Number of names ending with "a" or "A" (using endsWith)
                            if (name.endsWith("a") || name.endsWith("A")) {
                                endsWithaCount++;
                            }
                        }
                        double averageLength = (double) totalCharacters / count;

                        IO.println("\n--- Student Name Analysis Statistics ---");
                        IO.println("Total number of students      : " + count);
                        IO.println("Longest student name          : " + longestName);
                        IO.println("Shortest student name         : " + shortestName);
                        IO.println("Total characters in all names : " + totalCharacters);
                        IO.println("Average name length           : " + averageLength);
                        IO.println("Number of names starting with 'A': " + startsWithACount);
                        IO.println("Number of names ending with 'a'  : " + endsWithaCount);
                    }
                }
                case 6 -> {
                    // Compare Two Names Option
                    IO.print("Enter the first student name: ");
                    String name1 = IO.readln().trim();
                    IO.print("Enter the second student name: ");
                    String name2 = IO.readln().trim();

                    // Compare using equals(), equalsIgnoreCase(), and compareTo()
                    boolean isEqual = name1.equals(name2);
                    boolean isEqualIgnore = name1.equalsIgnoreCase(name2);
                    int comparisonResult = name1.compareTo(name2);

                    IO.println("\n--- Comparison Results ---");
                    IO.println("Using equals()           : " + isEqual);
                    IO.println("Using equalsIgnoreCase() : " + isEqualIgnore);
                    IO.println("Using compareTo()        : " + comparisonResult + " (0 means identical, negative means name1 comes first, positive means name2 comes first)");
                }
                case 7 -> IO.println("Exiting the program. Goodbye!");
                default -> IO.println("Invalid choice. Please enter a valid number from 1 to 7.");
            }
        } while (choice != 7);
    }
}
