public class RecursiveBinaryConverter {

    public static void main(String[] args) {
        // Prompt the user to enter a non-negative integer using modern Java IO
        IO.print("Enter a non-negative integer: ");
        int number = Integer.parseInt(IO.readln().trim());

        // Validate that the input is a non-negative number greater than or equal to 0
        if (number < 0) {
            IO.println("Invalid input. Please enter a non-negative integer.");
            return;
        }

        // Call the recursive method to get the binary representation
        String binaryResult = toBinary(number);

        // Print the final result summary with a descriptive status message
        IO.println("\n=== Binary Conversion Analysis Report ===");
        IO.println("Original Decimal Number: " + number);
        IO.println("Binary Representation  : " + binaryResult + " (Calculated via recursive division)");
    }

    /**
     * A recursive method that returns the binary representation of a number as a string.
     * It attaches the remainder after the recursive call to ensure the correct bit order.
     */
    public static String toBinary(int n) {
        // Base case: when the number is 0 or 1, return it as-is (converted to String)
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }

        // Recursive step: divide the number by 2 repeatedly
        String restResult = toBinary(n / 2);

        // Calculate the remainder for the current binary digit (% 2)
        int remainder = n % 2;

        // Attach the remainder AFTER the recursive call so higher bits build first (LIFO order)
        return restResult + remainder;
    }
}
