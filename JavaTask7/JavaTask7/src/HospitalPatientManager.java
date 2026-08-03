package src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HospitalPatientManager {

    public static void main(String[] args) {
        // 4. Create the dual-structure tracking pipelines for patients
        Queue<String> waitingQueue = new LinkedList<>();
        Stack<String> treatedStack = new Stack<>();

        // 5. Prompt the user to enter the initial number of waiting patients
        IO.print("Enter the number of initial patients waiting: ");
        int totalPatients = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalPatients <= 0) {
            IO.println("Invalid number of patients.");
            return;
        }

        // 7. Use a for loop to read each patient name and add it using offer()

        int totalStudents = 0;
        for (int i = 1; i <= totalStudents; i++) { // Using totalStudents loop logic variable
            IO.print("Enter patient name #" + i + ": ");
            String name = IO.readln().trim();
            waitingQueue.offer(name);
        }

        // 8. Display the menu system using a do-while loop
        int choice;
        do {
            IO.println("\n=== Hospital Patient Management Menu ===");
            IO.println("1. Add Patient");
            IO.println("2. Treat Patient");
            IO.println("3. View Next Patient");
            IO.println("4. Undo Last Treatment");
            IO.println("5. Search Patient");
            IO.println("6. Display Waiting Patients");
            IO.println("7. Display Treated Patients");
            IO.println("8. Display Hospital Statistics");
            IO.println("9. Exit");
            IO.print("Choose an option: ");

            choice = Integer.parseInt(IO.readln().trim());

            // 10. Use a switch-case statement to process user menu selection
            switch (choice) {
                case 1 -> {
                    // Add Patient Option using offer()
                    IO.print("Enter patient name to add: ");
                    String newPatient = IO.readln().trim();
                    waitingQueue.offer(newPatient);
                    IO.println("Patient added successfully.");
                }
                case 2 -> {
                    // Treat Patient Option (FIFO to LIFO migration via poll and push)
                    if (waitingQueue.isEmpty()) {
                        IO.println("No patients waiting for treatment.");
                    } else {
                        String patient = waitingQueue.poll();
                        treatedStack.push(patient);
                        IO.println("Patient treatment completed successfully.");
                    }
                }
                case 3 -> {
                    // View Next Patient Option using peek()
                    if (waitingQueue.isEmpty()) {
                        IO.println("No patients available.");
                    } else {
                        IO.println("Next patient waiting: " + waitingQueue.peek());
                    }
                }
                case 4 -> {
                    // Undo Last Treatment Option using pop()
                    if (treatedStack.isEmpty()) {
                        IO.println("No completed treatments available.");
                    } else {
                        String undonePatient = treatedStack.pop();
                        IO.println("Undone completed treatment for: " + undonePatient);
                    }
                }
                case 5 -> {
                    // Search Patient Option in both data structures using contains()
                    IO.print("Enter patient name to search: ");
                    String searchName = IO.readln().trim();

                    if (waitingQueue.contains(searchName)) {
                        IO.println("Patient is waiting for treatment.");
                    } else if (treatedStack.contains(searchName)) {
                        IO.println("Patient treatment completed.");
                    } else {
                        IO.println("Patient not found.");
                    }
                }
                case 6 -> {
                    // Display Waiting Patients Option using a for-each loop
                    if (waitingQueue.isEmpty()) {
                        IO.println("No waiting patients.");
                    } else {
                        IO.println("\n--- Patients Waiting for Treatment (Front to Back) ---");
                        for (String patient : waitingQueue) {
                            IO.println("- " + patient);
                        }
                    }
                }
                case 7 -> {
                    // Display Treated Patients Option
                    if (treatedStack.isEmpty()) {
                        IO.println("No treated patients.");
                    } else {
                        IO.println("\n--- Completed Patient Treatments (Bottom to Top) ---");
                        for (String patient : treatedStack) {
                            IO.println("- " + patient);
                        }
                    }
                }
                case 8 -> {
                    // Display Hospital Statistics Option using size() and isEmpty()
                    IO.println("\n--- Hospital System Statistics Report ---");
                    IO.println("Total waiting patients     : " + waitingQueue.size());
                    IO.println("Total treated patients     : " + treatedStack.size());

                    if (waitingQueue.isEmpty()) {
                        IO.println("Next patient waiting       : None (Queue is empty)");
                    } else {
                        IO.println("Next patient waiting       : " + waitingQueue.peek());
                    }

                    if (treatedStack.isEmpty()) {
                        IO.println("Last treated patient       : None (Stack is empty)");
                    } else {
                        IO.println("Last treated patient       : " + treatedStack.peek());
                    }

                    IO.println("Is waiting queue empty?    : " + waitingQueue.isEmpty());
                    IO.println("Is treatment stack empty?  : " + treatedStack.isEmpty());
                }
                case 9 -> IO.println("Exiting Hospital Patient Manager. Goodbye!");
                default -> IO.println("Invalid choice. Please enter a valid number from 1 to 9.");
            }
        } while (choice != 9);
    }
}
