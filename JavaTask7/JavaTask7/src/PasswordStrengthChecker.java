package src;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        // Initialize the password variable with an empty string
        String password = "";

        // Prompt the user to enter the initial password
        IO.print("Enter your password: ");
        password = IO.readln();

        // 6. Validate if the initial password length is less than or equal to 0
        if (password == null || password.length() == 0) {
            IO.println("Invalid password.");
            return;
        }

        // 8. Display the menu system using a do-while loop
        int choice;
        do {
            IO.println("\n=== Password Strength Checker Menu ===");
            IO.println("1. Enter Password");
            IO.println("2. Check Password Length");
            IO.println("3. Analyze Password Characters");
            IO.println("4. Check Password Strength");
            IO.println("5. Convert Password Format");
            IO.println("6. Display Password Report");
            IO.println("7. Exit");
            IO.print("Choose an option: ");

            choice = Integer.parseInt(IO.readln().trim());

            // 10. Use a switch-case statement to process the user's menu selection
            switch (choice) {
                case 1 -> {
                    // Enter Password Option
                    IO.print("Enter a new password: ");
                    password = IO.readln();
                    if (password == null || password.length() == 0) {
                        IO.println("Invalid password. Keeping the previous one.");
                    } else {
                        IO.println("Password saved successfully.");
                    }
                }
                case 2 -> {
                    // Check Password Length Option
                    int len = password.length();
                    IO.println("Total number of characters: " + len);
                    if (len < 8) {
                        IO.println("Password is too short.");
                    } else {
                        IO.println("Password length is acceptable.");
                    }
                }
                case 3 -> {
                    // Analyze Password Characters Option using loops and conditions
                    int uppercaseCount = 0;
                    int lowercaseCount = 0;
                    int digitCount = 0;
                    int specialCount = 0;

                    // Loop through each character of the password string using charAt()
                    for (int i = 0; i < password.length(); i++) {
                        char ch = password.charAt(i);
                        if (Character.isUpperCase(ch)) {
                            uppercaseCount++;
                        } else if (Character.isLowerCase(ch)) {
                            lowercaseCount++;
                        } else if (Character.isDigit(ch)) {
                            digitCount++;
                        } else {
                            specialCount++;
                        }
                    }

                    // Display the counted character distribution categories
                    IO.println("\n--- Password Characters Analysis ---");
                    IO.println("Uppercase letters : " + uppercaseCount);
                    IO.println("Lowercase letters : " + lowercaseCount);
                    IO.println("Digits            : " + digitCount);
                    IO.println("Special characters: " + specialCount);
                }
                case 4 -> {
                    // Check Password Strength Option
                    int len = password.length();
                    boolean hasUpper = false;
                    boolean hasLower = false;
                    boolean hasDigit = false;
                    boolean hasSpecial = false;

                    // Loop to evaluate and update security flag criteria
                    for (int i = 0; i < len; i++) {
                        char ch = password.charAt(i);
                        if (Character.isUpperCase(ch)) hasUpper = true;
                        else if (Character.isLowerCase(ch)) hasLower = true;
                        else if (Character.isDigit(ch)) hasDigit = true;
                        else hasSpecial = true;
                    }

                    // Score calculation based on security parameters met
                    int score = 0;
                    if (len >= 8) score++;
                    if (hasUpper) score++;
                    if (hasLower) score++;
                    if (hasDigit) score++;
                    if (hasSpecial) score++;

                    // Determine the password strength level classification
                    if (score <= 2) {
                        IO.println("Strength Level: Weak Password");
                    } else if (score <= 4) {
                        IO.println("Strength Level: Medium Password");
                    } else {
                        IO.println("Strength Level: Strong Password");
                    }
                }
                case 5 -> {
                    // Convert Password Format Option using standard string operations
                    IO.println("\n--- Password Formatting Conversion ---");
                    IO.println("Uppercase Format: " + password.toUpperCase());
                    IO.println("Lowercase Format: " + password.toLowerCase());
                }
                case 6 -> {
                    // Display Password Report Option compiling all metrics gathered
                    int len = password.length();
                    char firstChar = password.charAt(0);
                    char lastChar = password.charAt(len - 1);

                    int up = 0, low = 0, dig = 0, sp = 0;
                    for (int i = 0; i < len; i++) {
                        char ch = password.charAt(i);
                        if (Character.isUpperCase(ch)) up++;
                        else if (Character.isLowerCase(ch)) low++;
                        else if (Character.isDigit(ch)) dig++;
                        else sp++;
                    }

                    int finalScore = 0;
                    if (len >= 8) finalScore++;
                    if (up > 0) finalScore++;
                    if (low > 0) finalScore++;
                    if (dig > 0) finalScore++;
                    if (sp > 0) finalScore++;

                    String strengthLevel = (finalScore <= 2) ? "Weak" : (finalScore <= 4) ? "Medium" : "Strong";

                    // Printing the unified final dashboard security report
                    IO.println("\n=========================================");
                    IO.println("         PASSWORD SECURITY REPORT        ");
                    IO.println("=========================================");
                    IO.println("Password Length    : " + len);
                    IO.println("First Character    : " + firstChar);
                    IO.println("Last Character     : " + lastChar);
                    IO.println("Uppercase Letters  : " + up);
                    IO.println("Lowercase Letters  : " + low);
                    IO.println("Digits Count       : " + dig);
                    IO.println("Special Characters : " + sp);
                    IO.println("Overall Strength   : " + strengthLevel);
                    IO.println("=========================================");
                }
                case 7 -> IO.println("Exiting Password Strength Checker. Stay Secure!");
                default -> IO.println("Invalid choice. Please select a valid number from 1 to 7.");
            }
        } while (choice != 7);
    }
}
