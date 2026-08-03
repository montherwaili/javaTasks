package src;

import java.util.LinkedList;
import java.util.Queue;

public class TicketQueueManager {

    public static void main(String[] args) {
        // 4. Create a Queue using LinkedList to store customer names (FIFO principle)
        Queue<String> ticketQueue = new LinkedList<>();

        // 5. Prompt the user to enter the initial number of customers
        IO.print("Enter the number of initial customers: ");
        int totalCustomers = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalCustomers <= 0) {
            IO.println("Invalid number of customers.");
            return;
        }

        // 7. Use a for loop to read each customer name and add it safely
        for (int i = 1; i <= totalCustomers; i++) {
            IO.print("Enter customer name #" + i + ": ");
            String name = IO.readln().trim();

            // FIXED: Added strict verification to reject empty or blank names
            if (name.isBlank()) {
                IO.println("Error: Customer name cannot be empty. Please re-enter.");
                i--; // Decrement counter to retry this student registration slot properly
            } else {
                ticketQueue.add(name);
            }
        }

        // 8. Display the menu system using a do-while loop
        int choice;
        do {
            IO.println("\n=== Ticket Booking Queue Management Menu ===");
            IO.println("1. Add Customer");
            IO.println("2. Serve Customer");
            IO.println("3. View Next Customer");
            IO.println("4. Search Customer");
            IO.println("5. Display All Customers");
            IO.println("6. Display Queue Statistics");
            IO.println("7. Exit");
            IO.print("Choose an option: ");

            choice = Integer.parseInt(IO.readln().trim());

            // 10. Use a switch-case statement to process the user selection
            switch (choice) {
                case 1 -> {
                    // Add Customer Option with validation check
                    IO.print("Enter new customer name: ");
                    String newCustomer = IO.readln().trim();

                    // FIXED: Added validation check to reject empty entries from the menu
                    if (newCustomer.isBlank()) {
                        IO.println("Error: Customer name cannot be empty.");
                    } else {
                        ticketQueue.add(newCustomer);
                        IO.println("Customer added successfully.");
                    }
                }
                case 2 -> {
                    // Serve Customer Option using remove()
                    if (ticketQueue.isEmpty()) {
                        IO.println("Queue is empty.");
                    } else {
                        String servedCustomer = ticketQueue.remove();
                        IO.println("Served Customer: " + servedCustomer);
                    }
                }
                case 3 -> {
                    // View Next Customer Option using element()
                    if (ticketQueue.isEmpty()) {
                        IO.println("Queue is empty.");
                    } else {
                        IO.println("Next customer to be served: " + ticketQueue.element());
                    }
                }
                case 4 -> {
                    // Search Customer Option using contains()
                    IO.print("Enter customer name to search: ");
                    String searchName = IO.readln().trim();
                    if (ticketQueue.contains(searchName)) {
                        IO.println("Customer found in queue.");
                    } else {
                        IO.println("Customer not found.");
                    }
                }
                case 5 -> {
                    // Display All Customers Option using a for-each loop
                    if (ticketQueue.isEmpty()) {
                        IO.println("Queue is empty.");
                    } else {
                        IO.println("\n--- Customers Waiting in Queue (Front to Back) ---");
                        for (String customer : ticketQueue) {
                            IO.println("- " + customer);
                        }
                    }
                }
                case 6 -> {
                    // Display Queue Statistics Option using size() and isEmpty()
                    IO.println("\n--- Ticket Queue Statistics Report ---");
                    IO.println("Total number of customers: " + ticketQueue.size());

                    if (ticketQueue.isEmpty()) {
                        IO.println("First customer in queue  : None (Queue is empty)");
                        IO.println("Last customer in queue   : None (Queue is empty)");
                    } else {
                        // Cast to LinkedList to safely extract the last element for FIFO statistics
                        LinkedList<String> listRef = (LinkedList<String>) ticketQueue;
                        IO.println("First customer in queue  : " + ticketQueue.element());
                        IO.println("Last customer in queue   : " + listRef.getLast());
                    }
                    IO.println("Is queue empty?          : " + ticketQueue.isEmpty());
                }
                case 7 -> IO.println("Exiting Ticket Booking Queue System. Goodbye!");
                default -> IO.println("Invalid choice. Please enter a valid number from 1 to 7.");
            }
        } while (choice != 7);
    }
}
