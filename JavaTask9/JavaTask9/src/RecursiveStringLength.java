public class RecursiveStringLength {

    public static void main(String[] args) {
        // Prompt the user to enter a text string using modern Java IO
        IO.print("Enter any text/string: ");
        String userText = IO.readln();

        // Call the recursive method to compute the string length without using .length()
        int evaluatedLength = getStringLength(userText);

        // Print the final calculated result with a descriptive label
        IO.println("\n=== String Analysis Report ===");
        IO.println("Original Text : \"" + userText + "\"");
        IO.println("Computed Length: " + evaluatedLength + " (Calculated via character peeling)");
    }

    /**
     * A recursive method that calculates the length of a string without using .length().
     * It peels off one character at a time using substring(1).
     */
    public static int getStringLength(String str) {
        // Base case: if the string is null, empty, or blank, its remaining length is 0
        if (str == null || str.equals("")) {
            return 0;
        }

        // Recursive step: count 1 for the first character, then slice the rest using substring(1)
        return 1 + getStringLength(str.substring(1));
    }
}
