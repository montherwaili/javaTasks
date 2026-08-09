public class RecursiveUppercaseCounter {

    public static void main(String[] args) {
        // Prompt the user to enter a text string using modern Java IO
        IO.print("Enter a string: ");
        String text = IO.readln();

        // Call the recursive method to count uppercase letters
        int totalUppercase = countUppercase(text);

        // Print the final calculated result with a descriptive summary report
        IO.println("\n=== Uppercase Letter Analysis Report ===");
        IO.println("Original String   : \"" + text + "\"");
        IO.println("Total Capitals    : " + totalUppercase + " (A-Z)");
    }

    /**
     * A recursive method that counts how many capital letters (A–Z) are in a string.
     * It uses Character.isUpperCase() to check the first character and processes the rest via substring(1).
     */
    public static int countUppercase(String str) {
        // Base case: if the string is null or empty, it contains 0 uppercase letters
        if (str == null || str.isEmpty()) {
            return 0;
        }

        // Look at the first character of the current substring
        char firstChar = str.charAt(0);

        // Use the built-in helper method to check if the first character is uppercase (count 1 or 0)
        int matchCount = Character.isUpperCase(firstChar) ? 1 : 0;

        // Recursive step: add current match count to the result of checking the rest of the string via substring(1)
        return matchCount + countUppercase(str.substring(1));
    }
}
