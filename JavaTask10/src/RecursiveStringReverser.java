public class RecursiveStringReverser {

    public static void main(String[] args) {
        // Prompt the user to enter a text string using modern Java IO
        IO.print("Enter a string: ");
        String text = IO.readln();

        IO.println("\n=== Reversed String Output ===");
        // Call the recursive method with the user input string
        printReverse(text);
        IO.println("\n==============================");
    }
    /**
     * A recursive method that prints a string in reverse, one character per call,
     * by executing the print statement AFTER the recursive call.
     */
    public static void printReverse(String str) {
        // Base case: stop the recursion if the string is null or empty
        if (str == null || str.isEmpty()) {
            return;
        }
        // 1. The Recursive Call: dive to the end of the string first using substring(1)
        printReverse(str.substring(1));

    }
}