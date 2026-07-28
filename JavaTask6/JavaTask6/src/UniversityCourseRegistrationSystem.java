import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UniversityCourseRegistrationSystem {

    public static void main(String[] args) {
        // 4. Create collections to store student records and their registered courses
        Set<Integer> studentIdSet = new HashSet<>();
        Map<Integer, HashSet<String>> studentCourseMap = new HashMap<>();

        // 5. Prompt the user to enter the initial number of students
        IO.print("Enter the number of initial students: ");
        int totalStudents = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalStudents <= 0) {
            IO.println("Invalid number of students.");
            return;
        }

        // 7. Loop through each student to read initial data setup
        for (int i = 1; i <= totalStudents; i++) {
            IO.println("\nEntering details for Student #" + i + ":");
            IO.print("Enter Student ID: ");
            int studentId = Integer.parseInt(IO.readln());

            // Check if the student ID already exists
            if (studentIdSet.contains(studentId)) {
                IO.println("Student ID already exists. Record skipped.");
                i--; // Decrement counter to repeat this student entry slot properly
            } else {
                studentIdSet.add(studentId);

                IO.print("Enter the number of courses to register: ");
                int courseCount = Integer.parseInt(IO.readln());

                // Bonus Challenge: Prevent a student from having more than 6 registered courses
                if (courseCount < 0 || courseCount > 6) {
                    IO.println("Invalid course count. A student can only register between 0 and 6 courses.");
                    courseCount = 0; // Defaulting to 0 courses on violation
                }

                HashSet<String> courseSet = new HashSet<>();
                for (int j = 1; j <= courseCount; j++) {
                    IO.print("Enter course name #" + j + ": ");
                    String courseName = IO.readln().trim();

                    // Prevent duplicate course registrations within the student's set
                    if (courseSet.contains(courseName)) {
                        IO.println("Course already added. Duplicate entry skipped.");
                        j--; // Repeat current course slot
                    } else {
                        courseSet.add(courseName);
                    }
                }
                // Save the student's courses set into the map database
                studentCourseMap.put(studentId, courseSet);
            }
        }

        // 8. Display an interactive menu system that repeats until option 8 is selected
        boolean running = true;
        while (running) {
            IO.println("\n=== University Course Registration Menu ===");
            IO.println("1. Search Student");
            IO.println("2. Add Course to Student");
            IO.println("3. Remove Course from Student");
            IO.println("4. Display All Students (Ascending Order)");
            IO.println("5. Display Registration Statistics");
            IO.println("6. Register a New Student (Bonus)");
            IO.println("7. Find Students by Enrolled Course (Bonus)");
            IO.println("8. Exit and Print Complete Summary");
            IO.print("Choose an option: ");

            String choice = IO.readln().trim();

            // 10. Control workflows routes using switch case blocks
            switch (choice) {
                case "1" -> {
                    IO.print("Enter Student ID to search: ");
                    int searchId = Integer.parseInt(IO.readln());
                    if (studentCourseMap.containsKey(searchId)) {
                        IO.println("Registered Courses: " + studentCourseMap.get(searchId).toString());
                    } else {
                        IO.println("Student not found.");
                    }
                }
                case "2" -> {
                    IO.print("Enter Student ID: ");
                    int targetId = Integer.parseInt(IO.readln());
                    if (studentCourseMap.containsKey(targetId)) {
                        HashSet<String> currentCourses = studentCourseMap.get(targetId);

                        if (currentCourses.size() >= 6) {
                            IO.println("Registration Denied: Student has already reached the maximum limit of 6 courses.");
                        } else {
                            IO.print("Enter course name to add: ");
                            String courseName = IO.readln().trim();
                            if (currentCourses.contains(courseName)) {
                                IO.println("Operation Failed: Duplicate course. Student already registered.");
                            } else {
                                currentCourses.add(courseName);
                                IO.println("Course added successfully.");
                            }
                        }
                    } else {
                        IO.println("Student not found.");
                    }
                }
                case "3" -> {
                    IO.print("Enter Student ID: ");
                    int targetId = Integer.parseInt(IO.readln());
                    if (studentCourseMap.containsKey(targetId)) {
                        HashSet<String> currentCourses = studentCourseMap.get(targetId);
                        IO.print("Enter course name to remove: ");
                        String courseName = IO.readln().trim();

                        if (currentCourses.remove(courseName)) {
                            IO.println("Course removed successfully.");
                        } else {
                            IO.println("Operation Failed: Course not found in student's schedule.");
                        }
                    } else {
                        IO.println("Student not found.");
                    }
                }
                case "4" -> {
                    // Bonus Challenge: Display all students in ascending order of their IDs
                    if (studentCourseMap.isEmpty()) {
                        IO.println("No registered students found.");
                    } else {
                        List<Integer> sortedIds = new ArrayList<>(studentCourseMap.keySet());
                        Collections.sort(sortedIds);
                        IO.println("\n--- Registered Students (Ascending Order) ---");
                        for (int id : sortedIds) {
                            IO.println("Student ID: " + id + " | Courses: " + studentCourseMap.get(id).toString());
                        }
                    }
                }
                case "5" -> {
                    // Display Registration Statistics Option
                    int totalStudentsCount = studentCourseMap.size();
                    if (totalStudentsCount == 0) {
                        IO.println("No statistics available. Database is empty.");
                    } else {
                        int totalRegistrations = 0;
                        int highestCount = -1;
                        int lowestCount = Integer.MAX_VALUE;
                        int topStudentId = -1;
                        int lowestStudentId = -1;

                        for (int id : studentCourseMap.keySet()) {
                            int currentSize = studentCourseMap.get(id).size();
                            totalRegistrations += currentSize;

                            if (currentSize > highestCount) {
                                highestCount = currentSize;
                                topStudentId = id;
                            }
                            if (currentSize < lowestCount) {
                                lowestCount = currentSize;
                                lowestStudentId = id;
                            }
                        }
                        double averageCourses = (double) totalRegistrations / totalStudentsCount;

                        IO.println("\n--- Registration Statistics Report ---");
                        IO.println("Total Number of Students : " + totalStudentsCount);
                        IO.println("Total Course Registrations: " + totalRegistrations);
                        IO.println("Average Courses/Student   : " + averageCourses);
                        IO.println("Highest Courses Registered: Student ID " + topStudentId + " (" + highestCount + " courses)");
                        IO.println("Lowest Courses Registered : Student ID " + lowestStudentId + " (" + lowestCount + " courses)");
                    }
                }
                case "6" -> {
                    // Challenge Requirement Bonus: Allow user to register a new student from the menu
                    IO.print("Enter New Student ID: ");
                    int newId = Integer.parseInt(IO.readln());
                    if (studentIdSet.contains(newId)) {
                        IO.println("Student ID already exists. Registration aborted.");
                    } else {
                        studentIdSet.add(newId);
                        studentCourseMap.put(newId, new HashSet<>());
                        IO.println("Student ID " + newId + " registered successfully with empty profile.");
                    }
                }
                case "7" -> {
                    // Challenge Requirement Bonus: Display all students registered in a user-entered course
                    IO.print("Enter course name to filter students: ");
                    String targetCourse = IO.readln().trim();
                    boolean matchFound = false;
                    IO.println("Students Enrolled in [" + targetCourse + "]:");

                    for (Map.Entry<Integer, HashSet<String>> entry : studentCourseMap.entrySet()) {
                        if (entry.getValue().contains(targetCourse)) {
                            IO.println("- Student ID: " + entry.getKey());
                            matchFound = true;
                        }
                    }
                    if (!matchFound) IO.println("No students are currently registered in this course.");
                }
                case "8" -> {
                    IO.println("\nExiting system. Preparing final registry data sheet...");
                    running = false;
                }
                default -> IO.println("Invalid input choice. Please enter a valid number from 1 to 8.");
            }
        }

        // Challenge Requirement Bonus: Complete Summary at program termination
        IO.println("\n========================================================");
        IO.println("          FINAL UNIVERSITY REGISTRY SUMMARY             ");
        IO.println("========================================================");
        if (studentCourseMap.isEmpty()) {
            IO.println("No data recorded inside database tables.");
        } else {
            for (Map.Entry<Integer, HashSet<String>> entry : studentCourseMap.entrySet()) {
                IO.println("Student ID: " + entry.getKey() + " -> Total Enrolled: " + entry.getValue().size() + " | Schedule: " + entry.getValue().toString());
            }
        }
        IO.println("========================================================");
    }
}
