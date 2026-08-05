public class RecursiveEvenChecker {

    public static void main(String[] args) {
        // Prompt the user to enter a positive integer using modern Java IO
        IO.print("Enter a non-negative integer: ");
        int number = Integer.parseInt(IO.readln().trim());

        // Validate that the input is a non-negative integer
        if (number < 0) {
            IO.println("Invalid input. Please enter a non-negative integer.");
            return;
        }
        // Call the recursive method to check if the number is even
        boolean isEvenResult = isEven(number);
    }
}