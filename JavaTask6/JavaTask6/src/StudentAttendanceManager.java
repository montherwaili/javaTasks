import java.util.HashMap;
import java.util.Map;

public class StudentAttendanceManager {

    public static void main(String[] args) {
        // 4. Create a HashMap to store student IDs as keys and attendance days as values
        Map<Integer, Integer> attendanceMap = new HashMap<>();

        // 5. Prompt the user to enter the initial number of students
        IO.print("Enter the number of initial students: ");
        int totalStudents = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalStudents <= 0) {
            IO.println("Invalid number of students.");
            return;
        }

        // 7. Use a for loop to read each student ID and attendance days
        for (int i = 1; i <= totalStudents; i++) {
            IO.println("\nEntering details for Student #" + i + ":");
            IO.print("Enter Student ID: ");
            int studentId = Integer.parseInt(IO.readln());

            // Check if the student ID already exists in the map
            if (attendanceMap.containsKey(studentId)) {
                IO.println("Student ID already exists. Record not added.");
                i--; // Decrement counter to repeat this student entry slot properly
            } else {
                IO.print("Enter Attendance Days: ");
                int days = Integer.parseInt(IO.readln());
                attendanceMap.put(studentId, days);
            }
        }

        // 8. Display the menu system using a do-while loop
        int choice;
        do {
            IO.println("\n=== Student Attendance Management Menu ===");
            IO.println("1. Add Student Record");
            IO.println("2. Search Student Attendance");
            IO.println("3. Update Attendance");
            IO.println("4. Remove Student Record");
            IO.println("5. Display All Attendance Records");
            IO.println("6. Display Attendance Statistics");
            IO.println("7. Exit");
            IO.print("Choose an option: ");

            choice = Integer.parseInt(IO.readln().trim());

            // 10. Use a switch case statement to process the user selection
            switch (choice) {
                case 1 -> {
                    // Add Student Record Option
                    IO.print("Enter New Student ID: ");
                    int newId = Integer.parseInt(IO.readln());
                    if (attendanceMap.containsKey(newId)) {
                        IO.println("Student ID already exists. Record not added.");
                    } else {
                        IO.print("Enter Attendance Days: ");
                        int newDays = Integer.parseInt(IO.readln());
                        attendanceMap.put(newId, newDays);
                        IO.println("Student record added successfully.");
                    }
                }
                case 2 -> {
                    // Search Student Attendance Option
                    IO.print("Enter Student ID to search: ");
                    int searchId = Integer.parseInt(IO.readln());
                    if (attendanceMap.containsKey(searchId)) {
                        IO.println("Student ID: " + searchId + " | Attendance: " + attendanceMap.get(searchId) + " days");
                    } else {
                        IO.println("Student not found.");
                    }
                }
                case 3 -> {
                    // Update Attendance Option using replace()
                    IO.print("Enter Student ID to update: ");
                    int updateId = Integer.parseInt(IO.readln());
                    if (attendanceMap.containsKey(updateId)) {
                        IO.print("Enter New Attendance Days: ");
                        int updatedDays = Integer.parseInt(IO.readln());
                        attendanceMap.replace(updateId, updatedDays);
                        IO.println("Attendance updated successfully.");
                    } else {
                        IO.println("Student not found.");
                    }
                }
                case 4 -> {
                    // Remove Student Record Option using remove()
                    IO.print("Enter Student ID to remove: ");
                    int removeId = Integer.parseInt(IO.readln());
                    if (attendanceMap.containsKey(removeId)) {
                        attendanceMap.remove(removeId);
                        IO.println("Student record removed successfully.");
                    } else {
                        IO.println("Student not found.");
                    }
                }
                case 5 -> {
                    // Display All Attendance Records Option using keySet()
                    if (attendanceMap.isEmpty()) {
                        IO.println("No attendance records found.");
                    } else {
                        IO.println("\n--- All Attendance Records ---");
                        for (int id : attendanceMap.keySet()) {
                            IO.println("ID: " + id + " | Attendance: " + attendanceMap.get(id) + " days");
                        }
                    }
                }
                case 6 -> {
                    // Display Attendance Statistics Option using entrySet() and size()
                    int size = attendanceMap.size();
                    if (size == 0) {
                        IO.println("No statistics available. Database is empty.");
                    } else {
                        int totalDays = 0;
                        int highestAttendance = Integer.MIN_VALUE;
                        int lowestAttendance = Integer.MAX_VALUE;
                        int topStudentId = -1;
                        int bottomStudentId = -1;

                        // Loop through map entries using entrySet() to calculate statistics
                        for (Map.Entry<Integer, Integer> entry : attendanceMap.entrySet()) {
                            int currentId = entry.getKey();
                            int currentDays = entry.getValue();

                            totalDays += currentDays;

                            // Track the highest attendance
                            if (currentDays > highestAttendance) {
                                highestAttendance = currentDays;
                                topStudentId = currentId;
                            }
                            // Track the lowest attendance
                            if (currentDays < lowestAttendance) {
                                lowestAttendance = currentDays;
                                bottomStudentId = currentId;
                            }
                        }
                        double averageAttendance = (double) totalDays / size;

                        IO.println("\n--- Attendance Statistics Report ---");
                        IO.println("Total Number of Students    : " + size);
                        IO.println("Total Attendance Days       : " + totalDays);
                        IO.println("Average Attendance          : " + averageAttendance + " days");
                        IO.println("Highest Attendance Record   : Student ID " + topStudentId + " (" + highestAttendance + " days)");
                        IO.println("Lowest Attendance Record    : Student ID " + bottomStudentId + " (" + lowestAttendance + " days)");
                    }
                }
                case 7 -> IO.println("Exiting the program. Goodbye!");
                default -> IO.println("Invalid choice. Please enter a valid number from 1 to 7.");
            }
        } while (choice != 7);
    }
}
