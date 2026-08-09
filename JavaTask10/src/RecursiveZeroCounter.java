public class RecursiveZeroCounter {

    public static void main(String[] args) {
        // Prompt the user to enter a non-negative integer using modern Java IO
        IO.print("Enter a non-negative integer: ");
        int number = Integer.parseInt(IO.readln().trim());

        // Validate that the input is a non-negative number greater than or equal to 0
        if (number < 0) {
            IO.println("Invalid input. Please enter a non-negative integer.");
            return;
        }

        // Call the recursive method to count zeros
        int zeroCount = countZeros(number);

        // Print the final calculated result with a descriptive summary report
        IO.println("\n=== Zero Occurrence Analysis Report ===");
        IO.println("Original Number: " + number);
        IO.println("Total Zeros    : " + zeroCount);
    }

    /**
     * A recursive method that counts how many zeros appear in a number.
     * It handles the special case for the number 0 itself and checks each digit via % 10.
     */
    public static int countZeros(int n) {
        // Special Base Case: If the number itself is exactly 0, return 1
        if (n == 0) {
            return 1;
        }

        // Standard Base Case: If only a single non-zero digit is left, it contains 0 zeros
        if (n < 10) {
            return 0;
        }

        // Look at the last digit using % 10 and determine if it is a zero (count 1 or 0)
        int currentMatch = (n % 10 == 0) ? 1 : 0;

        // Recursive step: add the current match count to the result of processing the remaining digits via n / 10
        return currentMatch + countZeros(n / 10);
    }
}
