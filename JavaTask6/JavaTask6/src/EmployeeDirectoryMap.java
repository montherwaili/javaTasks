import java.util.HashMap;
import java.util.Map;

public class EmployeeDirectoryMap {

    public static void main(String[] args) {
        // 4. Create a HashMap to store unique employee IDs as keys and names as values
        Map<Integer, String> employeeMap = new HashMap<>();

        // 5. Prompt the user to enter the number of employees
        IO.print("Enter the number of employees: ");
        int totalRecordsEntered = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalRecordsEntered <= 0) {
            IO.println("Invalid number of employees.");
            return;
        }

        // 7. Use a for loop to read each employee ID and name
        for (int i = 1; i <= totalRecordsEntered; i++) {
            IO.println("\nEntering details for Employee #" + i + ":");
            IO.print("Enter Employee ID: ");
            int empId = Integer.parseInt(IO.readln());

            // Check whether the ID already exists in the HashMap before adding
            if (employeeMap.containsKey(empId)) {
                IO.println("Employee ID already exists. Please enter a unique ID.");
                // Decrement loop counter to re-enter this employee record properly
                i--;
            } else {
                IO.print("Enter Employee Name: ");
                String empName = IO.readln().trim();
                employeeMap.put(empId, empName);
            }
        }

        // 8. Prompt the user to enter an employee ID to search for
        IO.print("\nEnter an employee ID to search: ");
        int searchId = Integer.parseInt(IO.readln());

        // 9 & 10. Use containsKey() method to determine whether the employee ID exists
        String searchResult;
        if (employeeMap.containsKey(searchId)) {
            String foundName = employeeMap.get(searchId);
            searchResult = "Employee Found: " + foundName;
        } else {
            searchResult = "Employee ID not found.";
        }

        // 11. Classify the company size based on the number of registered employees
        int uniqueCount = employeeMap.size();
        String companyClassification;

        if (uniqueCount < 5) {
            companyClassification = "Small Company";
        } else if (uniqueCount <= 10) {
            companyClassification = "Medium Company";
        } else {
            companyClassification = "Large Company";
        }

        // 12. Display all the calculated metrics and the comprehensive summary report
        IO.println("\n=== Employee Directory Summary Report ===");
        IO.println("Total employee records entered: " + totalRecordsEntered);
        IO.println("Total unique employees        : " + uniqueCount);
        IO.println("All employee IDs and names    : " + employeeMap.toString());
        IO.println("Search result                 : " + searchResult);
        IO.println("Company classification        : " + companyClassification);
    }
}
