public class RecursiveMultiplier {

    public static void main(String[] args) {
        // Prompt the user to enter the first positive integer (a)
        IO.print("Enter first positive integer (a): ");
        int numberA = Integer.parseInt(IO.readln().trim());

        // Prompt the user to enter the second positive integer (b)
        IO.print("Enter second positive integer (b): ");
        int numberB = Integer.parseInt(IO.readln().trim());

        // Validate that both inputs are positive numbers greater than or equal to 0
        if (numberA < 0 || numberB < 0) {
            IO.println("Invalid input. Please enter positive numbers only.");
            return;
        }

        // Call the recursive method to multiply the two numbers using addition only
        int product = multiply(numberA, numberB);

        // Print the final calculation result with descriptive labels
        IO.println("\n=== Multiplication Analysis Report ===");
        IO.println("Operation : " + numberA + " x " + numberB);
        IO.println("Product   : " + product + " (Calculated via repeated addition)");
    }

    /**
     * A recursive method that multiplies two numbers using only addition.
     * It adds 'a' to itself 'b' times.
     */
    public static int multiply(int a, int b) {
        // Base case: if b reaches 0, the multiplication is finished, return 0
        if (b == 0) {
            return 0;
        }

        // Recursive step: add 'a' and call the method with b - 1 to repeat the addition
        return a + multiply(a, b - 1);
    }
}
