public class RecursiveDigitOccurrenceCounter {

    public static void main(String[] args) {
        // Prompt the user to enter a positive integer using modern Java IO
        IO.print("Enter a positive integer: ");
        int number = Integer.parseInt(IO.readln().trim());

        // Prompt the user to enter the specific target digit to count (0-9)
        IO.print("Enter the target digit to count (0-9): ");
        int targetDigit = Integer.parseInt(IO.readln().trim());

        // Validate that the number is non-negative and the digit is a single valid digit
        if (number < 0 || targetDigit < 0 || targetDigit > 9) {
            IO.println("Invalid input. Please enter valid non-negative numbers.");
            return;
        }

        // Call the recursive method to count occurrences
        int totalOccurrences = countDigitOccurrences(number, targetDigit);

        // Print the final calculated result with a descriptive summary report
        IO.println("\n=== Digit Occurrence Analysis Report ===");
        IO.println("Original Number: " + number);
        IO.println("Target Digit   : " + targetDigit);
        IO.println("Total Times    : " + totalOccurrences);
    }

    /**
     * A recursive method that counts how many times a specific target digit appears in a number.
     * It uses % 10 to extract the last digit and / 10 to shrink the number.
     */
    public static int countDigitOccurrences(int n, int digit) {
        // Base case: if the number becomes 0, the extraction chain is complete, return 0
        if (n == 0) {
            return 0;
        }

        // Check if the extracted last digit via % 10 matches the target digit
        int currentMatch = (n % 10 == digit) ? 1 : 0;

        // Recursive step: add current match to the result of processing the remaining digits via n / 10
        return currentMatch + countDigitOccurrences(n / 10, digit);
    }
}
