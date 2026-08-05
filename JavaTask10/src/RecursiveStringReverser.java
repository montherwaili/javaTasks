public class RecursiveStringReverser {

    public static void main(String[] args) {
        // Prompt the user to enter a text string using modern Java IO
        IO.print("Enter a string: ");
        String text = IO.readln();
        
        IO.println("\n=== Reversed String Output ===");
        // Call the recursive method with the user input string
        printReverse(text);
        IO.println("\n==============================");
    }
    }
}