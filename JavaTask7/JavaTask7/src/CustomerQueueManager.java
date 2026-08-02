package src;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueueManager {

    public static void main(String[] args) {
        // 4. Create a Queue using LinkedList to store customer names (FIFO principle)
        Queue<String> customerQueue = new LinkedList<>();

        // 5. Prompt the user to enter the initial number of customers
        IO.print("Enter the number of initial customers: ");
        int totalCustomers = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalCustomers <= 0) {
            IO.println("Invalid number of customers.");
            return;
        }

        // 7. Use a for loop to read each customer name and add it to the queue using offer()
        for (int i = 1; i <= totalCustomers; i++) {
            IO.print("Enter customer name #" + i + ": ");
            String name = IO.readln().trim();
            customerQueue.offer(name);
        }

        // 8. Display the menu system using a do-while loop
        int choice;
        do {
            IO.println("\n=== Customer Queue Management Menu ===");
            IO.println("1. Add Customer");
            IO.println("2. Serve Customer");
            IO.println("3. View Next Customer");
            IO.println("4. Search Customer");
            IO.println("5. Display All Customers");
            IO.println("6. Display Queue Statistics");
            IO.println("7. Exit");
            IO.print("Choose an option: ");

            choice = Integer.parseInt(IO.readln().trim());

            // 10. Use a switch-case statement to process user selection
            switch (choice) {
                case 1 -> {
                    // Add Customer Option using offer()
                    IO.print("Enter new customer name: ");
                    String newCustomer = IO.readln().trim();
                    customerQueue.offer(newCustomer);
                    IO.println("Customer added successfully.");
                }
                case 2 -> {
                    // Serve Customer Option using poll()
                    if (customerQueue.isEmpty()) {
                        IO.println("No customers in the queue.");
                    } else {
                        String servedCustomer = customerQueue.poll();
                        IO.println("Served Customer: " + servedCustomer);
                    }
                }
                case 3 -> {
                    // View Next Customer Option using peek()
                    if (customerQueue.isEmpty()) {
                        IO.println("No customers in the queue.");
                    } else {
                        IO.println("Next Customer to be served: " + customerQueue.peek());
                    }
                }
                case 4 -> {
                    // Search Customer Option using contains()
                    IO.print("Enter customer name to search: ");
                    String searchName = IO.readln().trim();
                    if (customerQueue.contains(searchName)) {
                        IO.println("Customer '" + searchName + "' is currently waiting in the queue.");
                    } else {
                        IO.println("Customer '" + searchName + "' not found in the queue.");
                    }
                }
                case 5 -> {
                    // Display All Customers Option using a for-each loop
                    if (customerQueue.isEmpty()) {
                        IO.println("No customers in the queue.");
                    } else {
                        IO.println("\n--- Current Waiting Customers (Front to Back) ---");
                        for (String customer : customerQueue) {
                            IO.println("- " + customer);
                        }
                    }
                }
                case 6 -> {
                    // Display Queue Statistics Option using size() and isEmpty()
                    IO.println("\n--- Queue Statistics Report ---");
                    IO.println("Total number of customers: " + customerQueue.size());

                    if (customerQueue.isEmpty()) {
                        IO.println("First customer           : None (Queue is empty)");
                        IO.println("Last customer            : None (Queue is empty)");
                    } else {
                        // Cast to LinkedList to safely extract the last element for FIFO statistics
                        LinkedList<String> listRef = (LinkedList<String>) customerQueue;
                        IO.println("First customer           : " + customerQueue.peek());
                        IO.println("Last customer            : " + listRef.getLast());
                    }
                    IO.println("Is queue empty?          : " + customerQueue.isEmpty());
                }
                case 7 -> IO.println("Exiting Customer Queue Management System. Goodbye!");
                default -> IO.println("Invalid choice. Please enter a valid number from 1 to 7.");
            }
        } while (choice != 7);
    }
}
