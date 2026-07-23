import java.util.ArrayList;
import java.util.List;


public class EmployeeSalaryManagementSystem {

    public static void main(String[] args) {
        // 1. Create Employee Lists
        ArrayList<Integer> employeeIds = new ArrayList<>();
        ArrayList<String> employeeNames = new ArrayList<>();
        ArrayList<Double> employeeSalaries = new ArrayList<>();

        // Store information for at least 10 employees
        employeeIds.add(1001); employeeNames.add("Ali");     employeeSalaries.add(850.0);
        employeeIds.add(1002); employeeNames.add("Sara");    employeeSalaries.add(1200.0);
        employeeIds.add(1003); employeeNames.add("Ahmed");   employeeSalaries.add(1500.0);
        employeeIds.add(1004); employeeNames.add("Fatima");  employeeSalaries.add(950.0);
        employeeIds.add(1005); employeeNames.add("Mohammed");employeeSalaries.add(450.0);
        employeeIds.add(1006); employeeNames.add("Zainab");  employeeSalaries.add(1100.0);
        employeeIds.add(1007); employeeNames.add("Omar");    employeeSalaries.add(600.0);
        employeeIds.add(1008); employeeNames.add("Mariam");  employeeSalaries.add(1350.0);
        employeeIds.add(1009); employeeNames.add("Hamad");   employeeSalaries.add(480.0);
        employeeIds.add(1010); employeeNames.add("Reem");    employeeSalaries.add(720.0);

        // 2. Display Employee Information
        IO.println("=== 2. Display Employee Information ===");
        displayEmployeeDetails(employeeIds, employeeNames, employeeSalaries);

        // 3. Calculate Salary Statistics
        IO.println("\n=== 3. Calculate Salary Statistics ===");
        int totalEmployees = employeeNames.size();
        double totalSalaryPaid = 0;
        double highestSalary = employeeSalaries.getFirst(); // Modern getFirst() method
        double lowestSalary = employeeSalaries.getFirst();

        for (double salary : employeeSalaries) {
            totalSalaryPaid += salary;
            if (salary > highestSalary) highestSalary = salary;
            if (salary < lowestSalary) lowestSalary = salary;
        }
        // Explicit type casting to double to guarantee decimal output precision
        double averageSalary = (double) totalSalaryPaid / totalEmployees;

        IO.println("Total Employees: " + totalEmployees);
        IO.println("Total Salary: " + totalSalaryPaid);
        IO.println("Average Salary: " + averageSalary);
        IO.println("Highest Salary: " + highestSalary);
        IO.println("Lowest Salary: " + lowestSalary);

        // 4. Salary Category Analysis
        IO.println("\n=== 4. Salary Category Analysis ===");
        int highSalaryCount = 0;
        int mediumSalaryCount = 0;
        int lowSalaryCount = 0;

        for (double salary : employeeSalaries) {
            if (salary > 1000.0) {
                highSalaryCount++;
            } else if (salary >= 500.0) {
                mediumSalaryCount++;
            } else {
                lowSalaryCount++;
            }
        }
        IO.println("High Salary Employees: " + highSalaryCount);
        IO.println("Medium Salary Employees: " + mediumSalaryCount);
        IO.println("Low Salary Employees: " + lowSalaryCount);

        // 5. Search Employee System
        IO.println("\n=== 5. Search Employee System ===");
        IO.print("Enter employee ID to search: ");
        int searchId = Integer.parseInt(IO.readln());
        int foundIndex = employeeIds.indexOf(searchId);

        if (foundIndex != -1) {
            IO.println("Employee Name: " + employeeNames.get(foundIndex));
            IO.println("Employee Salary: " + employeeSalaries.get(foundIndex));
            IO.println("Employee Position in the list: " + foundIndex);
        } else {
            IO.println("Employee not found.");
        }

        // 6. Update Employee Salary
        IO.println("\n=== 6. Update Employee Salary ===");
        IO.print("Enter Employee Index: ");
        int updateIndex = Integer.parseInt(IO.readln());

        if (updateIndex >= 0 && updateIndex < employeeNames.size()) {
            IO.print("Enter New Salary: ");
            double newSalary = Double.parseDouble(IO.readln());
            employeeSalaries.set(updateIndex, newSalary); // Update value using set()
            IO.println("Salary updated successfully.");
            displayEmployeeDetails(employeeIds, employeeNames, employeeSalaries);
        } else {
            IO.println("Invalid index. Update aborted.");
        }

        // 7. Remove Employee
        IO.println("\n=== 7. Remove Employee ===");
        IO.print("Remove Employee Index: ");
        int removeIndex = Integer.parseInt(IO.readln());

        if (removeIndex >= 0 && removeIndex < employeeNames.size()) {
            employeeIds.remove(removeIndex);
            employeeNames.remove(removeIndex);
            employeeSalaries.remove(removeIndex);
            IO.println("Employee removed successfully.");
            displayEmployeeDetails(employeeIds, employeeNames, employeeSalaries);
        } else {
            IO.println("Invalid index. Removal aborted.");
        }

        // 8. Sorting Employees
        IO.println("\n=== 8. Sorting Employees ===");

        // Helper index list strategy to sort our multi-array database safely
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < employeeNames.size(); i++) indices.add(i);

        // A. Lowest to Highest Sorting
        indices.sort((i1, i2) -> Double.compare(employeeSalaries.get(i1), employeeSalaries.get(i2)));
        IO.println("Salary Ranking (Lowest to Highest):");
        for (int i = 0; i < indices.size(); i++) {
            int idx = indices.get(i);
            IO.println((i + 1) + ". " + employeeNames.get(idx) + " - " + employeeSalaries.get(idx));
        }

        // B. Highest to Lowest Sorting
        indices.sort((i1, i2) -> Double.compare(employeeSalaries.get(i2), employeeSalaries.get(i1)));
        IO.println("\nSalary Ranking (Highest to Lowest):");
        for (int i = 0; i < indices.size(); i++) {
            int idx = indices.get(i);
            IO.println((i + 1) + ". " + employeeNames.get(idx) + " - " + employeeSalaries.get(idx));
        }

        // 9. Employee Salary Bonus Calculation
        IO.println("\n=== 9. Employee Salary Bonus Calculation ===");
        for (int i = 0; i < employeeNames.size(); i++) {
            double currentSalary = employeeSalaries.get(i);
            double bonusPercent = (currentSalary >= 1000.0) ? 0.10 : (currentSalary >= 500.0) ? 0.05 : 0.02;
            double bonusAmount = currentSalary * bonusPercent;
            double finalSalary = currentSalary + bonusAmount;

            IO.println("Employee Name: " + employeeNames.get(i));
            IO.println("  Current Salary: " + currentSalary);
            IO.println("  Bonus Amount  : " + bonusAmount);
            IO.println("  Final Salary  : " + finalSalary);
        }
    }

    /**
     * Zipped structural presentation helper to output complete synchronized datasets.
     */
    private static void displayEmployeeDetails(List<Integer> ids, List<String> names, List<Double> salaries) {
        for (int i = 0; i < names.size(); i++) {
            IO.println("Employee " + i + ":");
            IO.println("  ID: " + ids.get(i));
            IO.println("  Name: " + names.get(i));
            IO.println("  Salary: " + salaries.get(i));
        }
    }
}
