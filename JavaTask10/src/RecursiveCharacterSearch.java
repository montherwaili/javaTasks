public class RecursiveCharacterSearch {

    public static void main(String[] args) {
        // Prompt the user to enter a text string using modern Java IO
        IO.print("Enter a string: ");
        String text = IO.readln();

        // Prompt the user to enter the target character to search for
        IO.print("Enter the character to search for: ");
        String targetInput = IO.readln().trim();

        // Validate that the user entered at least one character for the target
        if (targetInput.isEmpty()) {
            IO.println("Invalid input. Target character cannot be empty.");
            return;
        }

        // Extract the first character from the input string as our target character
        char targetChar = targetInput.charAt(0);

        // Call the recursive method to check if the string contains the character
        boolean isFound = containsChar(text, targetChar);

        // Print the final result summary with a descriptive status message
        IO.println("\n=== Character Search Analysis Report ===");
        IO.println("Original String : \"" + text + "\"");
        IO.println("Target Character: '" + targetChar + "'");
        IO.println("Is Found?       : " + isFound);
    }

    /**
     * A recursive method that returns true if a string contains a given character.
     * It implements an early exit by stopping as soon as the character is found.
     */
    public static boolean containsChar(String str, char target) {
        // Base case 1: if the string is null or empty, it contains nothing, return false
        if (str == null || str.isEmpty()) {
            return false;
        }

        // Look at the first character of the current substring
        // Base case 2 (Early Exit): if it matches the target, return true immediately
        if (str.charAt(0) == target) {
            return true;
        }

        // Recursive step: if it does not match, check the rest of the string via substring(1)
        return containsChar(str.substring(1), target);
    }
}
