public class RecursiveLetterCounter {

    public static void main(String[] args) {
        // Prompt the user to enter a text string using modern Java IO
        IO.print("Enter a string: ");
        String text = IO.readln();

        // Prompt the user to enter the target letter to count
        IO.print("Enter the letter to count: ");
        String targetInput = IO.readln().trim();

        // Validate that the user entered at least one character for the target letter
        if (targetInput.isEmpty()) {
            IO.println("Invalid input. Target letter cannot be empty.");
            return;
        }
        // Extract the first character from the input string as our target letter
        char targetLetter = targetInput.charAt(0);

        // Call the recursive method to count occurrences
        int totalOccurrences = countLetter(text, targetLetter);

        // Print the final calculated result with a descriptive summary report
        IO.println("\n=== Letter Occurrence Report ===");
        IO.println("Original String: \"" + text + "\"");
        IO.println("Target Letter  : '" + targetLetter + "'");
        IO.println("Total Times    : " + totalOccurrences);
    }
    /**
     * A recursive method that counts how many times a given letter appears in a string.
     * It checks the first character and recursively processes the rest of the string using substring(1).
     */
    public static int countLetter(String str, char letter) {
        // Base case: if the string is null or empty, it contains the letter 0 times
        if (str == null || str.isEmpty()) {
            return 0;
        }
    }
}