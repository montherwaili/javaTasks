public class RecursiveVowelCounter {

    public static void main(String[] args) {
        // Prompt the user to enter a text string using modern Java IO
        IO.print("Enter a string: ");
        String text = IO.readln();
// Call the recursive method to count vowels
        int totalVowels = countVowels(text);
    }
}