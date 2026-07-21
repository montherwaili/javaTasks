import java.util.ArrayList;
import java.util.List;


public class LibraryManagementSystem {

    public static void main(String[] args) {
        // Create lists to store book information independently
        List<String> bookNames = new ArrayList<>();
        List<String> authorNames = new ArrayList<>();
        List<Boolean> isAvailable = new ArrayList<>();

        // Add 10 initial books with their authors and availability status (true = Available, false = Borrowed)
        bookNames.add("Java Programming"); authorNames.add("James Gosling"); isAvailable.add(true);
        bookNames.add("Clean Code"); authorNames.add("Robert Martin"); isAvailable.add(true);
        bookNames.add("The Hobbit"); authorNames.add("J.R.R. Tolkien"); isAvailable.add(false);
        bookNames.add("Effective Java"); authorNames.add("Joshua Bloch"); isAvailable.add(true);
        bookNames.add("Introduction to Algorithms"); authorNames.add("Thomas Cormen"); isAvailable.add(true);
        bookNames.add("Head First Design Patterns"); authorNames.add("Eric Freeman"); isAvailable.add(true);
        bookNames.add("The Pragmatic Programmer"); authorNames.add("Andrew Hunt"); isAvailable.add(false);
        bookNames.add("Cracking the Coding Interview"); authorNames.add("Gayle McDowell"); isAvailable.add(true);
        bookNames.add("Artificial Intelligence"); authorNames.add("Stuart Russell"); isAvailable.add(true);
        bookNames.add("Data Structures and Algorithms"); authorNames.add("Robert Lafore"); isAvailable.add(true);

        // Control variable for the interactive menu loop
        boolean running = true;

        // Loop to keep displaying the menu until the user selects option 6 (Exit)
        while (running) {
            IO.println("\n=== Library Management System Menu ===");
            IO.println("1: Display all books");
            IO.println("2: Search for a book");
            IO.println("3: Borrow a book");
            IO.println("4: Return a book");
            IO.println("5: Display library report");
            IO.println("6: Exit the program");
            IO.print("Choose an option: ");

            // Read user menu selection choice
            String choice = IO.readln();

            // Handle user choices using modern switch case structure
            switch (choice) {
                case "1" -> displayBooks(bookNames, authorNames, isAvailable);
                case "2" -> {
                    IO.print("Enter book name to search: ");
                    String searchName = IO.readln();
                    searchBook(bookNames, searchName);
                }
                case "3" -> {
                    IO.print("Enter book name to borrow: ");
                    String borrowName = IO.readln();
                    borrowBook(bookNames, isAvailable, borrowName);
                }
                case "4" -> {
                    IO.print("Enter book name to return: ");
                    String returnName = IO.readln();
                    returnBook(bookNames, isAvailable, returnName);
                }
                case "5" -> displayReport(bookNames, isAvailable);
                case "6" -> {
                    IO.println("Exiting the program. Thank you for using the library system!");
                    running = false;
                }
                default -> IO.println("Invalid option. Please enter a number from 1 to 6.");
            }
        }
    }

    /**
     * Accepts book lists as parameters and displays all books and their metadata using a loop.
     */
    public static void displayBooks(List<String> names, List<String> authors, List<Boolean> availability) {
        IO.println("\n--- Library Book Catalog ---");
        // Loop through the collections to print structural information of each book
        for (int i = 0; i < names.size(); i++) {
            String status = availability.get(i) ? "Available" : "Unavailable (Borrowed)";
            IO.println("Title: [" + names.get(i) + "] | Author: " + authors.get(i) + " | Status: " + status);
        }
    }

    /**
     * Searches for a specific book name in the list and prints the search results.
     */
    public static void searchBook(List<String> names, String targetName) {
        boolean found = false;
        // Loop to find an exact case-insensitive match for the book name
        for (String name : names) {
            if (name.equalsIgnoreCase(targetName)) {
                found = true;
                break;
            }
        }
        // Display result feedback to the user
        if (found) {
            IO.println("Result: '" + targetName + "' exists in our library collection.");
        } else {
            IO.println("Result: '" + targetName + "' does NOT exist in our library collection.");
        }
    }

    /**
     * Checks availability of a book and modifies its status to unavailable if borrowed successfully.
     */
    public static void borrowBook(List<String> names, List<Boolean> availability, String targetName) {
        int index = -1;
        // Loop to find the index of the requested book title
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(targetName)) {
                index = i;
                break;
            }
        }

        // Conditional checks to determine transaction execution path
        if (index == -1) {
            IO.println("Transaction Failed: Book not found in the catalog.");
        } else if (!availability.get(index)) {
            IO.println("Transaction Failed: Sorry, '" + names.get(index) + "' is already borrowed.");
        } else {
            // Update status flag to false to mark it as unavailable
            availability.set(index, false);
            IO.println("Transaction Success: You have successfully borrowed '" + names.get(index) + "'.");
        }
    }

    /**
     * Updates the status of a returned book to available in the system catalog.
     */
    public static void returnBook(List<String> names, List<Boolean> availability, String targetName) {
        int index = -1;
        // Loop to find the target index matching the input
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(targetName)) {
                index = i;
                break;
            }
        }

        // Apply condition check to ensure proper processing
        if (index == -1) {
            IO.println("Transaction Failed: This book does not belong to our library catalog.");
        } else if (availability.get(index)) {
            IO.println("Notification: This book is already marked as available in the system.");
        } else {
            // Update status flag to true to mark it as available
            availability.set(index, true);
            IO.println("Transaction Success: Thank you for returning '" + names.get(index) + "'.");
        }
    }

    /**
     * Counts and returns the metrics of available and unavailable books via loops and conditions.
     */
    public static int[] countBooks(List<Boolean> availability) {
        int availableCount = 0;
        int unavailableCount = 0;

        // Loop to analyze the Boolean state flags
        for (boolean status : availability) {
            if (status) {
                availableCount++;
            } else {
                unavailableCount++;
            }
        }
        // Bundle both numbers in an array structure
        return new int[]{availableCount, unavailableCount};
    }

    /**
     * Compiles and outputs library statistics and summary dashboard report.
     */
    public static void displayReport(List<String> names, List<Boolean> availability) {
        // Fetch values from the analytic operational helper method
        int[] statistics = countBooks(availability);
        int availableTotal = statistics[0];
        int unavailableTotal = statistics[1];

        // Print final analytical statistics labels using modern IO format
        IO.println("\n=====================================");
        IO.println("       LIBRARY METRICS REPORT        ");
        IO.println("=====================================");
        IO.println("Total Number of Books : " + names.size());
        IO.println("Available Books Count : " + availableTotal);
        IO.println("Unavailable Book Count: " + unavailableTotal);
        IO.println("=====================================");
    }
}
