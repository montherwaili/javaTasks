package utils;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner = new Scanner(System.in);

    public String getStringInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }

}
