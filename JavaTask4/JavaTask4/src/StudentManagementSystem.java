import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManagementSystem {

    public static void main(String[] args) {
        // 1. Create Student List
        ArrayList<String> students = new ArrayList<>();
        students.add("Ali");
        students.add("Sara");
        students.add("Omar");
        students.add("Fatima");
        students.add("Zaid");
        students.add("Mona");
        students.add("Hamad");
        students.add("Aisha");
        students.add("Sultan");
        students.add("Reem");

        // 2. Display Student Information
        IO.println("=== 2. Display Student Information ===");
        IO.println("Total number of students: " + students.size());
        for (int i = 0; i < students.size(); i++) {
            IO.println("Student " + i + ": " + students.get(i));
        }

        // 3. Add New Students
        IO.println("\n=== 3. Add New Students ===");
        // Requirement A: Add a student at the end of the list
        IO.print("Enter student name to add at the end: ");
        String endStudent = IO.readln();
        students.add(endStudent);
        IO.println("Student added successfully.");

        // Requirement B: Add a student at a specific position
        IO.print("Enter position (index) to insert new student: ");
        int insertIndex = Integer.parseInt(IO.readln());
        if (insertIndex >= 0 && insertIndex <= students.size()) {
            IO.print("Enter student name to insert: ");
            String insertStudent = IO.readln();
            students.add(insertIndex, insertStudent);
            IO.println("Student inserted successfully.");
        } else {
            IO.println("Invalid index. Insertion skipped.");
        }

        // Requirement C: Display the updated list
        IO.println("Updated List:");
        IO.println(students.toString());

        // 4. Update Student Information
        IO.println("\n=== 4. Update Student Information ===");
        IO.print("Enter index to update: ");
        int updateIndex = Integer.parseInt(IO.readln());
        if (updateIndex >= 0 && updateIndex < students.size()) {
            IO.print("Enter new name: ");
            String newName = IO.readln();
            students.set(updateIndex, newName);
            IO.println("Updated List:");
            IO.println(students.toString());
        } else {
            IO.println("Index out of bounds. Update aborted.");
        }

        // 5. Search Student System
        IO.println("\n=== 5. Search Student System ===");
        IO.print("Enter student name to search: ");
        String searchName = IO.readln();

        int foundIndex = students.indexOf(searchName);
        if (foundIndex != -1) {
            IO.println("Student found message.");
            IO.println("Student index position: " + foundIndex);
        } else {
            IO.println("Student not found.");
        }

        // 6. Remove Student System
        IO.println("\n=== 6. Remove Student System ===");
        IO.println("Before removal:\n" + students.toString());

        // Requirement A: Remove a student by name
        IO.print("Enter student name to remove: ");
        String removeName = IO.readln();
        boolean isRemovedByName = students.remove(removeName);
        if (isRemovedByName) {
            IO.println("Student '" + removeName + "' removed successfully.");
        } else {
            IO.println("Student name not found.");
        }

        // Requirement B: Remove a student by index
        IO.print("Enter index of student to remove: ");
        int removeIndex = Integer.parseInt(IO.readln());
        if (removeIndex >= 0 && removeIndex < students.size()) {
            String removedStudent = students.remove(removeIndex);
            IO.println("Student '" + removedStudent + "' removed successfully.");
        } else {
            IO.println("Invalid index. Removal by index skipped.");
        }

        // Requirement C: Display the list after removal
        IO.println("After removal:\n" + students.toString());

        // 7. Student List Analysis
        IO.println("\n=== 7. Student List Analysis ===");
        IO.println("Count total students: " + students.size());
        IO.println("Check if the list is empty: " + students.isEmpty());
        // Using modern Java getFirst() and getLast() methods for clean code
        if (!students.isEmpty()) {
            IO.println("First student: " + students.getFirst());
            IO.println("Last student: " + students.getLast());
        }

        // 8. Sorting Students
        IO.println("\n=== 8. Sorting Students ===");
        // Create an isolated shallow copy clone of the original student list
        ArrayList<String> sortedStudentsCopy = new ArrayList<>(students);

        // Sort students alphabetically
        Collections.sort(sortedStudentsCopy);

        IO.println("Original (Unchanged verification):");
        IO.println(students.toString());
        IO.println("Sorted (Alphabetically):");
        IO.println(sortedStudentsCopy.toString());
    }
}
