public class RecursiveUpCounter {

    public static void main(String[] args) {
        // Prompt the user to enter a positive integer N
        IO.print("Enter a positive integer N: ");
        int number = Integer.parseInt(IO.readln().trim());

        // Validate the input to ensure it is a positive integer
        if (number <= 0) {
            IO.println("Invalid input. Please enter a number greater than 0.");
            return;
        }

        IO.println("\n=== Printing Numbers from 1 to " + number + " ===");
        // Call the recursive method with the validated user input
        printUpToN(number);
        IO.println("=================================");
    }

    /**
     * A recursive method that prints numbers from 1 up to N,
     * each on a new line, by ordering the call before the print.
     */
    public static void printUpToN(int n) {
        // Base case: stop the recursion when N drops below 1
        if (n < 1) {
            return;
        }

        // 1. The Recursive Call: call the method first to process smaller numbers (N - 1)
        printUpToN(n - 1);

        // 2. Code running AFTER the recursive call: prints as the call stack unwinds (From 1 to N)
        IO.println(n);
    }
}
