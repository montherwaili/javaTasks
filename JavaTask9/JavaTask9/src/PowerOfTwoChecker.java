public class PowerOfTwoChecker {
    public static void main(String[] args) {
        // Prompt the user to enter a positive integer using modern Java IO
        IO.print("Enter a positive integer: ");
        int number = Integer.parseInt(IO.readln().trim());
        // Validate that the input is a non-negative integer
        if (number < 0) {
            IO.println("Invalid input. Please enter a non-negative integer.");
            return;
        }
// Call the recursive method to check if the number is a power of 2
        boolean isPower = isPowerOfTwo(number);

        // Print the final result summary with a descriptive status message
        IO.println("\n=== Power of 2 Analysis Report ===");
        IO.println("Original Number: " + number);
        IO.println("Is Power of 2? : " + isPower);
    }
    /**
     * A recursive method that checks if a positive number is a power of 2
     * by continuously dividing it by 2.
     */
    public static boolean isPowerOfTwo(int n) {
        // Base case 1: 0 is not a power of 2
        if (n == 0) {
            return false;
        }
        // Base case 2: 1 is a power of 2 (2^0)
        if (n == 1) {
            return true;
        }
// Base case 3: if the number becomes odd and greater than 1, it cannot be a power of 2
        if (n % 2 != 0) {
            return false;
        }

}
