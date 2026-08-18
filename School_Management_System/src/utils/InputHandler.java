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

public int getIntInput(String prompt, int min, int max) {
    while (true) {
        int value = getIntInput(prompt);
        if (HelperUtils.isValidNumber(value, min, max)) {
            return value;
        }
        System.out.println("Please enter a number between " + min + " and " + max + ".");
    }
}

public double getDoubleInput(String prompt) {
    System.out.print(prompt + " ");
    while (!scanner.hasNextDouble()) {
        System.out.print("Please type a number: ");
        scanner.next();
    }
    double value = scanner.nextDouble();
    scanner.nextLine();
    return value;
}
}
