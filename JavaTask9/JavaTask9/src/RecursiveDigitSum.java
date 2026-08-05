public class RecursiveDigitSum {

    public static void main(String[] args) {
        // Prompt the user to enter a positive integer using modern Java IO
        IO.print("Enter a positive integer: ");
        int number = Integer.parseInt(IO.readln().trim());

        // Validate that the input is a positive number greater than or equal to 0
        if (number < 0) {
            IO.println("Invalid input. Please enter a non-negative integer.");
            return;
        }

        // Call the recursive method to compute the sum of all digits
        int computedSum = sumDigits(number);

        // Print the final calculated result with a descriptive summary report
        IO.println("\n=== Digit Sum Analysis Report ===");
        IO.println("Original Number: " + number);
        IO.println("Sum of Digits  : " + computedSum + " (Calculated via mathematical extraction)");
    }

    /**
     * A recursive method that adds all the digits of a number together.
     * It uses % 10 to extract the last digit and / 10 to remove it.
     */
    public static int sumDigits(int n) {
        // Base case: if the number becomes 0, the extraction chain is complete, return 0
        if (n == 0) {
            return 0;
        }

        // Recursive step: get the last digit via % 10 and add it to the sum of the remaining digits via n / 10
        return (n % 10) + sumDigits(n / 10);
    }
}
