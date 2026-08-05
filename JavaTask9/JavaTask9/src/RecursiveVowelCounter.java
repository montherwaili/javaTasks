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
    }
}