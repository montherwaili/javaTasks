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

    }
}