import java.util.ArrayList;
import java.util.List;


public class StudentListManager {

    public static void main(String[] args) {
        // Create an ArrayList to store student names
        List<String> students = new ArrayList<>();

        // Add 10 student names to the collection
        students.add("Ahmed");
        students.add("Fatima");
        students.add("Mohammed");
        students.add("Aisha");
        students.add("Ali");
        students.add("Zainab");
        students.add("Omar");
        students.add("Mariam");
        students.add("Hamad");
        students.add("Reem");

        // Display all students currently in the list using an enhanced for loop
        IO.println("--- Complete Student List ---");
        for (String student : students) {
            IO.println("- " + student);
        }

        // Display the total count of students using the size method
        IO.println("\nTotal number of students: " + students.size());

        // Retrieve and display the first student using the modern getFirst() method
        IO.println("First student in the list: " + students.getFirst());

        // Retrieve and display the last student using the modern getLast() method
        IO.println("Last student in the list: " + students.getLast());

        // Define a specific name to search within the collection
        String searchName = "Aisha";

        // Check if the target name exists in the list using the contains method
        if (students.contains(searchName)) {
            IO.println("\nSearch Result: '" + searchName + "' exists in the student list.");
        } else {
            IO.println("\nSearch Result: '" + searchName + "' does NOT exist in the student list.");
        }

        // Define a specific name to be removed from the list
        String nameToRemove = "Ali";

        // Perform the removal operation
        students.remove(nameToRemove);
        IO.println("\nNotification: '" + nameToRemove + "' has been successfully removed.");

        // Display the newly updated list to verify the removal operation
        IO.println("\n--- Updated Student List ---");
        for (String student : students) {
            IO.println("- " + student);
        }
    }
}
