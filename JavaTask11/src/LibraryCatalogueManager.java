import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryCatalogueManager {


    public static void main(String[] args) {
        LibraryCatalogueManager manager = new LibraryCatalogueManager();
        manager.startSystem();
    }

    // Central orchestrator method that performs all real system logic outside of main
    public void startSystem() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("--- Single item created at startup ---");
        Book startupBook = new Book();
        standaloneBookConfiguration(startupBook);
        startupBook.printAllInfo();


        List<LibraryItem> catalogue = new ArrayList<>();
        catalogue.add(startupBook);


        boolean isExit = false;
        while (!isExit) {
            System.out.println("\n--- LIBRARY MENU ---");
            System.out.println("1.Add book   2.Add magazine   3.Print all    4.Count    5.Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            consumeLeftoverNewline(scanner);

            switch (choice) {
                case 1 -> {

                    catalogue.add(addBook(scanner));
                    System.out.println("Added.");
                }
                case 2 -> {
                    catalogue.add(addMagazine(scanner));
                    System.out.println("Added.");
                }
                case 3 -> {

                    System.out.println("\n--- Catalogue Items ---");
                    int index = 1;
                    for (LibraryItem item : catalogue) {
                        System.out.print(index + ". ");
                        item.printAllInfo();
                        index++;
                    }
                }
                case 4 -> System.out.println("Total library items in catalogue: " + catalogue.size());
                case 5 -> {
                    System.out.println("Goodbye.");
                    isExit = true;
                }
                default -> System.out.println("Invalid choice. Please select from 1 to 5.");
            }
        }
        scanner.close();
    }

    // Helper method to setup the standalone startup book instance configurations
    private void standaloneBookConfiguration(Book book) {
        book.setTitle("Clean Code");
        book.setAuthor("Robert Martin");
        book.setPages(464);
    }


    private Book addBook(Scanner scanner) {
        Book book = new Book();
        System.out.print("Enter title: ");
        book.setTitle(readStringInput(scanner));
        System.out.print("Enter author: ");
        book.setAuthor(readStringInput(scanner));
        System.out.print("Enter pages: ");
        book.setPages(scanner.nextInt());
        consumeLeftoverNewline(scanner);
        return book;
    }


    private Magazine addMagazine(Scanner scanner) {
        Magazine mag = new Magazine();
        System.out.print("Enter magazine name: ");
        mag.setName(readStringInput(scanner));
        System.out.print("Enter issue number: ");
        mag.setIssueNumber(scanner.nextInt());
        consumeLeftoverNewline(scanner);
        System.out.print("Enter month: ");
        mag.setMonth(readStringInput(scanner));
        return mag;
    }


    private void consumeLeftoverNewline(Scanner scanner) {
        scanner.nextLine();
    }


    private String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
