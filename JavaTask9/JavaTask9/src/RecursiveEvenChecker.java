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

        // Print the final result summary with a descriptive status message
        IO.println("\n=== Even Number Analysis Report ===");
        IO.println("Original Number: " + number);
        IO.println("Is Even Number? : " + isEvenResult + " (Calculated via subtraction subtraction)");
    }






    
    }
}