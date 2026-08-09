public class RecursiveFastPower {

    public static void main(String[] args) {
        // Prompt the user to enter the base integer using modern Java IO
        IO.print("Enter the base (b): ");
        int base = Integer.parseInt(IO.readln().trim());

        // Prompt the user to enter the exponent integer (n)
        IO.print("Enter the exponent (n): ");
        int exponent = Integer.parseInt(IO.readln().trim());

        // Validate that the exponent is a non-negative integer
        if (exponent < 0) {
            IO.println("Invalid input. Exponent must be a non-negative integer.");
            return;
        }

        // Call the fast recursive power method
        long result = power(base, exponent);

        // Print the final calculated result with a descriptive summary report
        IO.println("\n=== Fast Power Analysis Report ===");
        IO.println("Operation : " + base + "^" + exponent);
        IO.println("Result    : " + result + " (Calculated via logarithmic halving)");
    }

    /**
     * An optimized recursive method that computes base^exponent using the halving method.
     * This achieves logarithmic time complexity O(log n) instead of linear time O(n).
     */
    public static long power(int b, int n) {
        // Base case: any number raised to the power of 0 is 1
        if (n == 0) {
            return 1;
        }

        // Recursive step: calculate the power of half the exponent once to save computation frames
        long halfPower = power(b, n / 2);

        // Decision phase: if the exponent is even, combine the halves. If odd, multiply one extra base.
        if (n % 2 == 0) {
            return halfPower * halfPower;
        } else {
            return b * halfPower * halfPower;
        }
    }
}
