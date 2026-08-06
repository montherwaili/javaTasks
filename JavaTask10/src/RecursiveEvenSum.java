public class RecursiveEvenSum {

    public static void main(String[] args) {
        // Prompt the user to enter a positive integer N using modern Java IO
        IO.print("Enter a positive integer N: ");
        int number = Integer.parseInt(IO.readln().trim());

        // Validate that the input is a positive number greater than 0
        if (number <= 0) {
            IO.println("Invalid input. Please enter a number greater than 0.");
            return;
        }

        // Call the recursive method to compute the sum of even numbers
        int totalEvenSum = sumEvens(number);

        // Print the final calculated result with a descriptive summary report
        IO.println("\n=== Even Number Summation Report ===");
        IO.println("Upper Limit N  : " + number);
        IO.println("Sum of Evens   : " + totalEvenSum + " (Calculated via recursive conditions)");
    }

    /**
     * A recursive method that adds only the even numbers from 1 up to N.
     * It evaluates each N before continuing with N - 1.
     */
    public static int sumEvens(int n) {
        // Base case: stop the recursion when N drops below 1
        if (n < 1) {
            return 0;
        }

        // Check if the current value of N is even
        int currentCount = (n % 2 == 0) ? n : 0;

        // Recursive step: combine the current value decision with the result of N - 1
        return currentCount + sumEvens(n - 1);
    }
}
