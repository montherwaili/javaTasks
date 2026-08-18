package utils;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner = new Scanner(System.in);

    public String getStringInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }

    // OVERLOADING: get an int, or get an int inside a range
    public int getIntInput(String prompt) {
        System.out.print(prompt + " ");
        while (!scanner.hasNextInt()) {
            System.out.print("Please type a whole number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();   // clear the line
        return value;
    }

}
