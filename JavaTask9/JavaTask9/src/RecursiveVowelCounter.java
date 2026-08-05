public class RecursiveVowelCounter {

    public static void main(String[] args) {
        // Prompt the user to enter a text string using modern Java IO
        IO.print("Enter a string: ");
        String text = IO.readln();
// Call the recursive method to count vowels
        int totalVowels = countVowels(text);
        // Print the final calculated result with a descriptive summary report
        IO.println("\n=== Vowel Analysis Report ===");
        IO.println("Original String: \" " + text + " \"");
        IO.println("Total Vowels   : " + totalVowels + " (a, e, i, o, u)");
    }
    /**
     * A recursive method that counts the total number of vowels in a string.
     * It checks the first character against the five vowel letters and processes the rest using substring(1).
     */
    public static int countVowels(String str) {
        // Base case: if the string is null or empty, it contains 0 vowels
        if (str == null || str.isEmpty()) {
            return 0;
        }
// Look at the first character and convert to lower case for uniform comparison
        char firstChar = Character.toLowerCase(str.charAt(0));
    }
}