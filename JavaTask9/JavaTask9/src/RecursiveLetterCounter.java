public class RecursiveLetterCounter {

    public static void main(String[] args) {
        // Prompt the user to enter a text string using modern Java IO
        IO.print("Enter a string: ");
        String text = IO.readln();

        // Prompt the user to enter the target letter to count
        IO.print("Enter the letter to count: ");
        String targetInput = IO.readln().trim();
    }
}