public class DigitCounter {

    public static void main(String[] args) {
        // Prompt the user to enter a positive integer
        IO.print("Enter a positive integer: ");
        int number = Integer.parseInt(IO.readln().trim());

        // Validate that the input is a positive number greater than 0
        if (number <= 0) {
            IO.println("Invalid input. Please enter a number greater than 0.");
            return;
        }

        // Call the recursive method and store the result
        int totalDigits = countDigits(number);

        // Print the final result summary with a descriptive label
        IO.println("\n=== Digit Analysis Report ===");
        IO.println("Original Number: " + number);
        IO.println("Total Digits   : " + totalDigits);
    }

    /**
     * A recursive method that counts the number of digits in a positive number
     * by peeling off the last digit via integer division by 10.
     */
    public static int countDigits(int n) {
        // Base case: if the number is less than 10, it means only one digit is left
        if (n < 10) {
            return 1;
        }

        // Recursive step: add 1 for the peeled-off digit, then call the method with n / 10
        return 1 + countDigits(n / 10);
    }
}
