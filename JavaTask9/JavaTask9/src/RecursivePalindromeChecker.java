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




}
