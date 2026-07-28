import java.util.HashMap;
import java.util.Map;

public class EmployeeSalaryManager {

    public static void main(String[] args) {
        // 4. Create a HashMap to store employee IDs as keys and salaries as values
        Map<Integer, Double> salaryMap = new HashMap<>();

        // 5. Prompt the user to enter the number of employees
        IO.print("Enter the number of initial employees: ");
        int totalEmployees = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalEmployees <= 0) {
            IO.println("Invalid number of employees.");
            return;
        }

        // 7. Use a for loop to read each employee ID and salary
        for (int i = 1; i <= totalEmployees; i++) {
            IO.println("\nEntering details for Employee #" + i + ":");
            IO.print("Enter Employee ID: ");
            int empId = Integer.parseInt(IO.readln());

            // Check whether the employee ID already exists
            if (salaryMap.containsKey(empId)) {
                IO.println("Employee ID already exists. Record not added.");
                i--; // Decrement counter to re-enter this employee record properly
            } else {
                IO.print("Enter Employee Salary: ");
                double empSalary = Double.parseDouble(IO.readln());
                salaryMap.put(empId, empSalary);
            }
        }

        // 8. Display the menu system using a do-while loop
        int choice;
        do {
            IO.println("\n=== Employee Salary Management Menu ===");
            IO.println("1. Add Employee");
            IO.println("2. Search Employee");
            IO.println("3. Update Salary");
            IO.println("4. Remove Employee");
            IO.println("5. Display All Employees");
            IO.println("6. Display Salary Statistics");
            IO.println("7. Exit");
            IO.print("Choose an option: ");

            choice = Integer.parseInt(IO.readln().trim());

            // 10. Use a switch case statement to process user selection
            switch (choice) {
                case 1 -> {
                    // Add Employee Option
                    IO.print("Enter New Employee ID: ");
                    int newId = Integer.parseInt(IO.readln());
                    if (salaryMap.containsKey(newId)) {
                        IO.println("Employee ID already exists. Record not added.");
                    } else {
                        IO.print("Enter Salary: ");
                        double newSalary = Double.parseDouble(IO.readln());
                        salaryMap.put(newId, newSalary);
                        IO.println("Employee added successfully.");
                    }
                }
                case 2 -> {
                    // Search Employee Option
                    IO.print("Enter Employee ID to search: ");
                    int searchId = Integer.parseInt(IO.readln());
                    if (salaryMap.containsKey(searchId)) {
                        IO.println("Employee ID: " + searchId + " | Salary: $" + salaryMap.get(searchId));
                    } else {
                        IO.println("Employee not found.");
                    }
                }
                case 3 -> {
                    // Update Salary Option using replace()
                    IO.print("Enter Employee ID to update: ");
                    int updateId = Integer.parseInt(IO.readln());
                    if (salaryMap.containsKey(updateId)) {
                        IO.print("Enter New Salary: ");
                        double updatedSalary = Double.parseDouble(IO.readln());
                        salaryMap.replace(updateId, updatedSalary);
                        IO.println("Salary updated successfully.");
                    } else {
                        IO.println("Employee not found.");
                    }
                }
                case 4 -> {
                    // Remove Employee Option using remove()
                    IO.print("Enter Employee ID to remove: ");
                    int removeId = Integer.parseInt(IO.readln());
                    if (salaryMap.containsKey(removeId)) {
                        salaryMap.remove(removeId);
                        IO.println("Employee record removed successfully.");
                    } else {
                        IO.println("Employee not found.");
                    }
                }
                case 5 -> {
                    // Display All Employees Option using keySet()
                    if (salaryMap.isEmpty()) {
                        IO.println("No employee records found.");
                    } else {
                        IO.println("\n--- All Employee Records ---");
                        for (int id : salaryMap.keySet()) {
                            IO.println("ID: " + id + " | Salary: $" + salaryMap.get(id));
                        }
                    }
                }
                case 6 -> {
                    // Display Salary Statistics Option using values() and size()
                    int size = salaryMap.size();
                    if (size == 0) {
                        IO.println("No statistics available. Database is empty.");
                    } else {
                        double totalPayroll = 0;
                        double highestSalary = Double.MIN_VALUE;
                        double lowestSalary = Double.MAX_VALUE;

                        for (double salary : salaryMap.values()) {
                            totalPayroll += salary;
                            if (salary > highestSalary) highestSalary = salary;
                            if (salary < lowestSalary) lowestSalary = salary;
                        }
                        double averageSalary = totalPayroll / size;

                        IO.println("\n--- Salary Statistics Report ---");
                        IO.println("Total Payroll   : $" + totalPayroll);
                        IO.println("Highest Salary  : $" + highestSalary);
                        IO.println("Lowest Salary   : $" + lowestSalary);
                        IO.println("Average Salary  : $" + averageSalary);
                    }
                }
                case 7 -> IO.println("Exiting the program. Goodbye!");
                default -> IO.println("Invalid choice. Please enter a valid number from 1 to 7.");
            }
        } while (choice != 7);
    }
}
