public class RecursiveCounter {

    public static void main(String[] args) {
        // Prompt the user to enter a positive integer
        IO.print("Enter a positive integer N: ");
        int number = Integer.parseInt(IO.readln().trim());

        // Validate the input to ensure it is a positive integer
        if (number <= 0) {
            IO.println("Invalid input. Please enter a number greater than 0.");
            return;
        }

        IO.println("\n=== Starting Recursive Count Down and Up ===");
        // Call the recursive method with the validated user input
        countDownAndUp(number);
        IO.println("\n=============================================");
    }


    public static void countDownAndUp(int n) {
        // New Base Case - when N reaches 1, print it once and return immediately
        if (n == 1) {
            IO.print(n + " ");
            return;
        }

        // 1. Code running BEFORE the recursive call (Handles the Count Down)
        IO.print(n + " ");

        // 2. The Recursive Call: pushes a new frame onto the execution stack with N - 1
        countDownAndUp(n - 1);

        // 3. Code running AFTER the recursive call as frames pop off (Handles the Count Up from 2 to N)
        IO.print(n + " ");
    }
}
