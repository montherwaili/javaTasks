package src;

import java.util.LinkedList;
import java.util.Queue;

public class PrintQueueManager {

    public static void main(String[] args) {
        // 4. Create a Queue using LinkedList to store print job names (FIFO principle)
        Queue<String> printQueue = new LinkedList<>();

        // 5. Prompt the user to enter the initial number of print jobs
        IO.print("Enter the number of initial print jobs: ");
        int totalJobs = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalJobs <= 0) {
            IO.println("Invalid number of print jobs.");
            return;
        }

        // 7. Use a for loop to read each print job name and add it using offer()
        for (int i = 1; i <= totalJobs; i++) {
            IO.print("Enter print job name #" + i + ": ");
            String jobName = IO.readln().trim();
            printQueue.offer(jobName);
        }

        // 8. Display the menu system using a do-while loop
        int choice;
        do {
            IO.println("\n=== Print Queue Management Menu ===");
            IO.println("1. Add Print Job");
            IO.println("2. Process Next Print Job");
            IO.println("3. View Next Print Job");
            IO.println("4. Search Print Job");
            IO.println("5. Remove Print Job");
            IO.println("6. Display All Print Jobs");
            IO.println("7. Display Queue Statistics");
            IO.println("8. Exit");
            IO.print("Choose an option: ");

            choice = Integer.parseInt(IO.readln().trim());

            // 10. Use a switch-case statement to process user selection
            switch (choice) {
                case 1 -> {
                    // Add Print Job Option using offer()
                    IO.print("Enter new print job name: ");
                    String newJob = IO.readln().trim();
                    printQueue.offer(newJob);
                    IO.println("Print job added successfully.");
                }
                case 2 -> {
                    // Process Next Print Job Option using poll()
                    if (printQueue.isEmpty()) {
                        IO.println("No print jobs in the queue.");
                    } else {
                        String processedJob = printQueue.poll();
                        IO.println("Processed Print Job: " + processedJob);
                    }
                }
                case 3 -> {
                    // View Next Print Job Option using peek()
                    if (printQueue.isEmpty()) {
                        IO.println("No print jobs in the queue.");
                    } else {
                        IO.println("Next print job in line: " + printQueue.peek());
                    }
                }
                case 4 -> {
                    // Search Print Job Option using contains()
                    IO.print("Enter print job name to search: ");
                    String searchJob = IO.readln().trim();
                    if (printQueue.contains(searchJob)) {
                        IO.println("Print job '" + searchJob + "' exists in the queue.");
                    } else {
                        IO.println("Print job '" + searchJob + "' not found in the queue.");
                    }
                }
                case 5 -> {
                    // Remove Specific Print Job Option using remove(Object)
                    IO.print("Enter print job name to remove: ");
                    String removeJob = IO.readln().trim();
                    if (printQueue.remove(removeJob)) {
                        IO.println("Print job '" + removeJob + "' removed successfully.");
                    } else {
                        IO.println("Print job not found.");
                    }
                }
                case 6 -> {
                    // Display All Print Jobs Option using a for-each loop
                    if (printQueue.isEmpty()) {
                        IO.println("No print jobs in the queue.");
                    } else {
                        IO.println("\n--- Current Pending Print Jobs (Front to Back) ---");
                        for (String job : printQueue) {
                            IO.println("- " + job);
                        }
                    }
                }
                case 7 -> {
                    // Display Queue Statistics Option using size() and isEmpty()
                    IO.println("\n--- Print Queue Statistics Report ---");
                    IO.println("Total number of print jobs: " + printQueue.size());

                    if (printQueue.isEmpty()) {
                        IO.println("Next print job            : None (Queue is empty)");
                    } else {
                        IO.println("Next print job            : " + printQueue.peek());
                    }
                    IO.println("Is queue empty?           : " + printQueue.isEmpty());
                }
                case 8 -> IO.println("Exiting Print Queue Management System. Goodbye!");
                default -> IO.println("Invalid choice. Please enter a valid number from 1 to 8.");
            }
        } while (choice != 8);
    }
}
