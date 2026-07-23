import java.util.ArrayList;
import java.util.List;

public class LibraryBookManagementSystem {

    public static void main(String[] args) {
        // 1. Create Book Lists
        ArrayList<String> bookTitles = new ArrayList<>();
        ArrayList<String> authors = new ArrayList<>();
        ArrayList<Boolean> availability = new ArrayList<>();

        // Store information for at least 10 books
        bookTitles.add("Java Programming");      authors.add("James Gosling");   availability.add(true);
        bookTitles.add("Clean Code");            authors.add("Robert Martin");   availability.add(true);
        bookTitles.add("The Hobbit");            authors.add("J.R.R. Tolkien");  availability.add(false);
        bookTitles.add("Effective Java");         authors.add("Joshua Bloch");    availability.add(true);
        bookTitles.add("Introduction to Algos");  authors.add("Thomas Cormen");   availability.add(true);
        bookTitles.add("Design Patterns");        authors.add("Eric Freeman");    availability.add(true);
        bookTitles.add("Pragmatic Programmer");   authors.add("Andrew Hunt");     availability.add(false);
        bookTitles.add("Coding Interview");       authors.add("Gayle McDowell");  availability.add(true);
        bookTitles.add("AI Fundamentals");        authors.add("Stuart Russell");  availability.add(true);
        bookTitles.add("Data Structures");        authors.add("Robert Lafore");   availability.add(true);

        // 2. Display Library Books
        IO.println("=== 2. Display Library Books ===");
        displayLibraryDetails(bookTitles, authors, availability);

        // 3. Add New Book
        IO.println("\n=== 3. Add New Book ===");
        IO.print("Enter Book Title: ");
        String newTitle = IO.readln();
        IO.print("Enter Author: ");
        String newAuthor = IO.readln();
        IO.print("Available (true/false): ");
        boolean newAvailable = Boolean.parseBoolean(IO.readln());

        bookTitles.add(newTitle);
        authors.add(newAuthor);
        availability.add(newAvailable);
        IO.println("Book added successfully.");
        displayLibraryDetails(bookTitles, authors, availability);

        // 4. Update Book Information
        IO.println("\n=== 4. Update Book Information ===");
        IO.print("Enter Book Index to update: ");
        int updateIndex = Integer.parseInt(IO.readln());

        if (updateIndex >= 0 && updateIndex < bookTitles.size()) {
            IO.print("New Title: ");
            bookTitles.set(updateIndex, IO.readln());
            IO.print("New Author: ");
            authors.set(updateIndex, IO.readln());
            IO.print("Available (true/false): ");
            availability.set(updateIndex, Boolean.parseBoolean(IO.readln()));
            IO.println("Book updated successfully.");
            displayLibraryDetails(bookTitles, authors, availability);
        } else {
            IO.println("Invalid index. Update operation skipped.");
        }

        // 5. Search Book System
        IO.println("\n=== 5. Search Book System ===");
        IO.print("Enter a book title to search: ");
        String searchTarget = IO.readln();
        int foundIndex = -1;

        // Loop to check if the book exists using a case-insensitive match
        for (int i = 0; i < bookTitles.size(); i++) {
            if (bookTitles.get(i).equalsIgnoreCase(searchTarget)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            IO.println("Book Index: " + foundIndex);
            IO.println("Author Name: " + authors.get(foundIndex));
            String availabilityStatus = availability.get(foundIndex) ? "Yes" : "No";
            IO.println("Available: " + availabilityStatus);
        } else {
            IO.println("Book not found.");
        }
    }

    /**
     * Reusable zipped layout presentation helper to output complete synchronized library datasets cleanly.
     */
    private static void displayLibraryDetails(List<String> titles, List<String> authorsList, List<Boolean> statusList) {
        for (int i = 0; i < titles.size(); i++) {
            IO.println("Book " + i + ":");
            IO.println("  Title: " + titles.get(i));
            IO.println("  Author: " + authorsList.get(i));
            String status = statusList.get(i) ? "Yes" : "No";
            IO.println("  Available: " + status);
        }
    }
}
