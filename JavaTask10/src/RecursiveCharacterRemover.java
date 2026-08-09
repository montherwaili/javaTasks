public class RecursiveCharacterRemover {

    public static void main(String[] args) {
        // Prompt the user to enter a text string using modern Java IO
        IO.print("Enter a string: ");
        String text = IO.readln();

        // Prompt the user to enter the specific character to remove
        IO.print("Enter the character to remove: ");
        String targetInput = IO.readln().trim();

        // Validate that the user entered at least one character for the target
        if (targetInput.isEmpty()) {
            IO.println("Invalid input. Target character cannot be empty.");
            return;
        }

        // Extract the first character from the input string as our target character
        char targetChar = targetInput.charAt(0);

        // Call the recursive method to remove all copies of the target character
        String resultString = removeChar(text, targetChar);

        // Print the final result summary report layout view
        IO.println("\n=== Character Removal Analysis Report ===");
        IO.println("Original String: \"" + text + "\"");
        IO.println("Target Character: '" + targetChar + "'");
        IO.println("Filtered String : \"" + resultString + "\"");
    }

    /**
     * A recursive method that returns a new string with all copies of a given character removed.
     * It builds the string as the recursion returns by attaching non-matching characters.
     */
    public static String removeChar(String str, char target) {
        // Base case: if the string is null or empty, return an empty string
        if (str == null || str.isEmpty()) {
            return "";
        }

        // Look at the first character of the current substring
        char firstChar = str.charAt(0);

        // Recursive step: process the rest of the string first via substring(1)
        String restResult = removeChar(str.substring(1), target);

        // Decision phase: if the first character matches the target, skip it. Otherwise, keep it.
        if (firstChar == target) {
            return restResult;
        } else {
            return firstChar + restResult;
        }
    }
}
