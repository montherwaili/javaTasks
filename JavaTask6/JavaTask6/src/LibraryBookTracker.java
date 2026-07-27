import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LibraryBookTracker {

    public static void main(String[] args) {
        // 4. Create a HashSet to store unique book IDs
        Set<Integer> bookIdSet = new HashSet<>();

        // Create a HashMap to associate each unique book ID with its title
        Map<Integer, String> bookMap = new HashMap<>();

        // 5. Prompt the user to enter the number of books
        IO.print("Enter the number of books: ");
        int totalRecordsEntered = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalRecordsEntered <= 0) {
            IO.println("Invalid number of books.");
            return;
        }

        // 7. Use a for loop to read each book ID and book title
        for (int i = 1; i <= totalRecordsEntered; i++) {
            IO.println("\nEntering details for Book #" + i + ":");
            IO.print("Enter Book ID: ");
            int bookId = Integer.parseInt(IO.readln());

            // Check whether the book ID already exists in the HashSet to prevent duplicates
            if (bookIdSet.contains(bookId)) {
                IO.println("Duplicate Book ID. Record not added.");
                // Decrement the loop counter to allow re-entering this book record properly
                i--;
            } else {
                IO.print("Enter Book Title: ");
                String bookTitle = IO.readln().trim();

                // Add the validated unique ID and title to both collections
                bookIdSet.add(bookId);
                bookMap.put(bookId, bookTitle);
            }
        }

        // 8. Prompt the user to enter a book ID to search for
        IO.print("\nEnter a book ID to search for: ");
        int searchId = Integer.parseInt(IO.readln());

        IO.println("\n=== Search Result ===");
        // 9 & 10. Check if the ID exists in the HashMap and display the corresponding title
        if (bookMap.containsKey(searchId)) {
            IO.println("Book ID   : " + searchId);
            IO.println("Book Title: " + bookMap.get(searchId));
        } else {
            IO.println("Book not found.");
        }

        // 11. Use an if-else if-else statement to classify the library size
        int uniqueCount = bookMap.size();
        String libraryClassification;

        if (uniqueCount < 5) {
            libraryClassification = "Small Library";
        } else if (uniqueCount <= 10) {
            libraryClassification = "Medium Library";
        } else {
            libraryClassification = "Large Library";
        }

        // 12. Display all the calculated metrics and the comprehensive final summary report
        IO.println("\n=== Library Summary Report ===");
        IO.println("Total book records entered           : " + totalRecordsEntered);
        IO.println("Total unique books                   : " + uniqueCount);
        IO.println("All book IDs                         : " + bookIdSet.toString());
        IO.println("All book IDs with corresponding titles: " + bookMap.toString());
        IO.println("Library classification               : " + libraryClassification);
    }
}
