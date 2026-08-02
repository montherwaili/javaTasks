package src;

import java.util.Stack;

public class BookStackManager {

    public static void main(String[] args) {
        // 4. Create a Stack to store book titles (LIFO principle)
        Stack<String> bookStack = new Stack<>();

        // 5. Prompt the user to enter the initial number of books
        IO.print("Enter the number of initial books: ");
        int totalBooks = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalBooks <= 0) {
            IO.println("Invalid number of books.");
            return;
        }

        // 7. Use a for loop to read each book title and push onto the stack
        for (int i = 1; i <= totalBooks; i++) {
            IO.print("Enter book title #" + i + ": ");
            String title = IO.readln().trim();
            bookStack.push(title);
        }

        // 8. Display the menu system using a do-while loop
        int choice;
        do {
            IO.println("\n=== Book Stack Management Menu ===");
            IO.println("1. Add Book");
            IO.println("2. Remove Top Book");
            IO.println("3. View Top Book");
            IO.println("4. Search Book");
            IO.println("5. Display All Books");
            IO.println("6. Display Stack Statistics");
            IO.println("7. Exit");
            IO.print("Choose an option: ");

            choice = Integer.parseInt(IO.readln().trim());

            // 10. Use a switch-case statement to process user selection
            switch (choice) {
                case 1 -> {
                    // Add Book Option using push()
                    IO.print("Enter new book title: ");
                    String newTitle = IO.readln().trim();
                    bookStack.push(newTitle);
                    IO.println("Book added successfully.");
                }
                case 2 -> {
                    // Remove Top Book Option using pop()
                    if (bookStack.isEmpty()) {
                        IO.println("No books available.");
                    } else {
                        String removedBook = bookStack.pop();
                        IO.println("Removed Book: " + removedBook);
                    }
                }
                case 3 -> {
                    // View Top Book Option using peek()
                    if (bookStack.isEmpty()) {
                        IO.println("No books available.");
                    } else {
                        IO.println("Top Book: " + bookStack.peek());
                    }
                }
                case 4 -> {
                    // Search Book Option using search()
                    IO.print("Enter book title to search: ");
                    String searchTitle = IO.readln().trim();
                    int position = bookStack.search(searchTitle);

                    // search() returns 1-based position from the top, or -1 if not found
                    if (position != -1) {
                        IO.println("Book found. Position from the top of the stack: " + position);
                    } else {
                        IO.println("Book not found.");
                    }
                }
                case 5 -> {
                    // Display All Books Option
                    if (bookStack.isEmpty()) {
                        IO.println("The stack is empty.");
                    } else {
                        IO.println("\n--- All Books in Stack (Bottom to Top) ---");
                        for (String book : bookStack) {
                            IO.println("- " + book);
                        }
                    }
                }
                case 6 -> {
                    // Display Stack Statistics Option using size() and isEmpty()
                    IO.println("\n--- Stack Statistics Report ---");
                    IO.println("Total number of books: " + bookStack.size());

                    if (bookStack.isEmpty()) {
                        IO.println("Top book             : None (Stack is empty)");
                    } else {
                        IO.println("Top book             : " + bookStack.peek());
                    }
                    IO.println("Is stack empty?      : " + bookStack.isEmpty());
                }
                case 7 -> IO.println("Exiting the program. Goodbye!");
                default -> IO.println("Invalid choice. Please enter a valid number from 1 to 7.");
            }
        } while (choice != 7);
    }
}
