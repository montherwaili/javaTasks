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

    }// Print the final calculated result with a descriptive summary report
        IO.println("\n=== Even Number Summation Report ===");
        IO.println("Upper Limit N  : " + number);
        IO.println("Sum of Evens   : " + totalEvenSum + " (Calculated via recursive conditions)");
}

}