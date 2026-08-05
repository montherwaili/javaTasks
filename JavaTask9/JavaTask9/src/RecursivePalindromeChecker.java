public class RecursivePalindromeChecker {
    public static void main(String[] args) {

        // Prompt the user to enter a word using modern Java IO
        IO.print("Enter a word: ");
        String word = IO.readln().trim();

        // Call the recursive method to check if the word is a palindrome
        boolean isPalindromeResult = isPalindrome(word);

        // Print the final result summary with a descriptive status message
        IO.println("\n=== Palindrome Analysis Report ===");
        IO.println("Original Word : \"" + word + "\"");
        IO.println("Is Palindrome?: " + isPalindromeResult);
    }
    /**
     * A recursive method that checks if a string is a palindrome
     * by comparing the first and last characters iteratively.
     */
    public static boolean isPalindrome(String str) {
        // Base case: a string of length 0 or 1 is always a palindrome
        if (str == null || str.length() <= 1) {
            return true;
        }



}
