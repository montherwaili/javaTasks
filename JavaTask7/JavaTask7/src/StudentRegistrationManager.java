package src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StudentRegistrationManager {

    public static void main(String[] args) {
        // 4. Create the dual-structure tracking pipelines
        Queue<String> waitingQueue = new LinkedList<>();
        Stack<String> registeredStack = new Stack<>();

        // 5. Prompt the user to enter the number of initial students
        IO.print("Enter the number of initial students waiting for registration: ");
        int totalStudents = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalStudents <= 0) {
            IO.println("Invalid number of students.");
            return;
        }

        // 7. Use a for loop to read each student name and add it using add()
        for (int i = 1; i <= totalStudents; i++) {
            IO.print("Enter student name #" + i + ": ");
            String name = IO.readln().trim();
            waitingQueue.add(name);
        }

        // 8. Display the menu system using a do-while loop
        int choice;
        do {
            IO.println("\n=== Student Registration System Menu ===");
            IO.println("1. Add Student to Queue");
            IO.println("2. Process Student Registration");
            IO.println("3. View Next Student");
            IO.println("4. Undo Last Registration");
            IO.println("5. Search Student");
            IO.println("6. Display Waiting Students");
            IO.println("7. Display Registered Students");
            IO.println("8. Display Statistics");
            IO.println("9. Exit");
            IO.print("Choose an option: ");

            choice = Integer.parseInt(IO.readln().trim());

            // 10. Use a switch-case statement to process the user selection
            switch (choice) {
                case 1 -> {
                    // Add Student to Queue Option
                    IO.print("Enter student name to add to the queue: ");
                    String newStudent = IO.readln().trim();
                    waitingQueue.add(newStudent);
                    IO.println("Student added to registration queue successfully.");
                }
                case 2 -> {
                    // Process Student Registration Option (FIFO to LIFO migration)
                    if (waitingQueue.isEmpty()) {
                        IO.println("No students waiting for registration.");
                    } else {
                        String student = waitingQueue.remove();
                        registeredStack.push(student);
                        IO.println("Student registration completed.");
                    }
                }
                case 3 -> {
                    // View Next Student Option using element()
                    if (waitingQueue.isEmpty()) {
                        IO.println("No students in the queue.");
                    } else {
                        IO.println("Next student waiting: " + waitingQueue.element());
                    }
                }
                case 4 -> {
                    // Undo Last Registration Option using pop()
                    if (registeredStack.isEmpty()) {
                        IO.println("No registrations to undo.");
                    } else {
                        String removedStudent = registeredStack.pop();
                        IO.println("Registration undone for: " + removedStudent);
                    }
                }
                case 5 -> {
                    // Search Student Option in both data structures
                    IO.print("Enter student name to search: ");
                    String searchName = IO.readln().trim();

                    if (waitingQueue.contains(searchName)) {
                        IO.println("Status: Waiting for registration");
                    } else if (registeredStack.contains(searchName)) {
                        IO.println("Status: Already registered");
                    } else {
                        IO.println("Status: Not found");
                    }
                }
                case 6 -> {
                    // Display Waiting Students Option using a for-each loop
                    if (waitingQueue.isEmpty()) {
                        IO.println("No waiting students.");
                    } else {
                        IO.println("\n--- Students Waiting in Queue (Front to Back) ---");
                        for (String student : waitingQueue) {
                            IO.println("- " + student);
                        }
                    }
                }
                case 7 -> {
                    // Display Registered Students Option
                    if (registeredStack.isEmpty()) {
                        IO.println("No registered students.");
                    } else {
                        IO.println("\n--- Completed Registrations Stack (Bottom to Top) ---");
                        for (String student : registeredStack) {
                            IO.println("- " + student);
                        }
                    }
                }
                case 8 -> {
                    // Display Comprehensive Statistics Report for both collections
                    IO.println("\n--- Registration System Statistics Report ---");
                    IO.println("Total waiting students     : " + waitingQueue.size());
                    IO.println("Total registered students   : " + registeredStack.size());

                    if (waitingQueue.isEmpty()) {
                        IO.println("Next student waiting       : None (Queue is empty)");
                    } else {
                        IO.println("Next student waiting       : " + waitingQueue.element());
                    }

                    if (registeredStack.isEmpty()) {
                        IO.println("Last registered student    : None (Stack is empty)");
                    } else {
                        IO.println("Last registered student    : " + registeredStack.peek());
                    }

                    IO.println("Is waiting queue empty?    : " + waitingQueue.isEmpty());
                    IO.println("Is registration stack empty: " + registeredStack.isEmpty());
                }
                case 9 -> IO.println("Exiting Student Registration Manager. Goodbye!");
                default -> IO.println("Invalid choice. Please enter a valid number from 1 to 9.");
            }
        } while (choice != 9);
    }
}
