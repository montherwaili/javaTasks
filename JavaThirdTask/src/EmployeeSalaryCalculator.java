
public class EmployeeSalaryCalculator {

    public static void main(String[] args) {
        // Declare and assign predefined values for the employee profile
        String employeeName = "Salem Al-Harthi";
        double basicSalary = 1200.0;
        double bonusAmount = 350.0;
        double deductionAmount = 100.0;

        // Call calculateNetSalary to compute the final net salary value
        double netSalary = calculateNetSalary(basicSalary, bonusAmount, deductionAmount);

        // Call checkSalaryStatus to get the classification grade text
        String salaryStatus = checkSalaryStatus(netSalary);

        // Call displaySalaryDetails to print the comprehensive payroll summary report
        displaySalaryDetails(employeeName, basicSalary, bonusAmount, deductionAmount, netSalary, salaryStatus);
    }

    /**
     * Calculates the net salary using the basic salary, bonus, and deduction amounts.
     */
    public static double calculateNetSalary(double basicSalary, double bonus, double deduction) {
        // Apply the payroll equation: netSalary = basicSalary + bonus - deduction
        return basicSalary + bonus - deduction;
    }

    /**
     * Classifies the net salary tier status based on predefined monetary limits.
     */
    public static String checkSalaryStatus(double netSalary) {
        // Evaluate the numeric salary level against corporate structural brackets
        if (netSalary < 500.0) {
            return "Low Salary";
        } else if (netSalary <= 1500.0) {
            return "Medium Salary";
        } else {
            return "High Salary";
        }
    }

    /**
     * Displays all gathered payroll information with clear, human-readable labels.
     */
    public static void displaySalaryDetails(String name, double basic, double bonus, double deduction, double net, String status) {
        // Print the employee profile summary utilizing modern Java IO features
        IO.println("--- Employee Payroll Summary ---");
        IO.println("Employee Name: " + name);
        IO.println("Basic Salary : " + basic);
        IO.println("Bonus Amount : " + bonus);
        IO.println("Deductions   : " + deduction);
        IO.println("Net Salary   : " + net);
        IO.println("Salary Status: " + status);
    }
}
