package src;

import java.util.Stack;

public class UndoActionManager {

    public static void main(String[] args) {
        // 4. Create a Stack to store user text editor actions (LIFO principle)
        Stack<String> actionStack = new Stack<>();

        // 5. Prompt the user to enter the initial number of actions
        IO.print("Enter the number of initial actions: ");
        int totalActions = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalActions <= 0) {
            IO.println("Invalid number of actions.");
            return;
        }

        // 7. Use a for loop to read each initial action and push onto the stack
        for (int i = 1; i <= totalActions; i++) {
            IO.print("Enter action #" + i + ": ");
            String action = IO.readln().trim();
            actionStack.push(action);
        }

        // 8. Display the menu system using a do-while loop
        int choice;
        do {
            IO.println("\n=== Undo Action System Menu ===");
            IO.println("1. Add Action");
            IO.println("2. Undo Last Action");
            IO.println("3. View Last Action");
            IO.println("4. Search Action");
            IO.println("5. Display All Actions");
            IO.println("6. Display Action Statistics");
            IO.println("7. Clear All Actions");
            IO.println("8. Exit");
            IO.print("Choose an option: ");

            choice = Integer.parseInt(IO.readln().trim());

            // 10. Use a switch-case statement to process user selection
            switch (choice) {
                case 1 -> {
                    // Add Action Option using push()
                    IO.print("Enter new action description: ");
                    String newAction = IO.readln().trim();
                    actionStack.push(newAction);
                    IO.println("Action added successfully.");
                }
                case 2 -> {
                    // Undo Last Action Option using pop()
                    if (actionStack.isEmpty()) {
                        IO.println("No actions to undo.");
                    } else {
                        String removedAction = actionStack.pop();
                        IO.println("Undone Action: " + removedAction);
                    }
                }
                case 3 -> {
                    // View Last Action Option using peek()
                    if (actionStack.isEmpty()) {
                        IO.println("No actions available.");
                    } else {
                        IO.println("Last Action: " + actionStack.peek());
                    }
                }
                case 4 -> {
                    // Search Action Option using search()
                    IO.print("Enter action description to search: ");
                    String searchTarget = IO.readln().trim();
                    int position = actionStack.search(searchTarget);

                    // search() returns 1-based position from top, or -1 if not found
                    if (position != -1) {
                        IO.println("Action found. Position from the top of the stack: " + position);
                    } else {
                        IO.println("Action not found.");
                    }
                }
                case 5 -> {
                    // Display All Actions Option
                    if (actionStack.isEmpty()) {
                        IO.println("The action stack is empty.");
                    } else {
                        IO.println("\n--- All Stored Actions (Oldest to Newest) ---");
                        for (String action : actionStack) {
                            IO.println("- " + action);
                        }
                    }
                }
                case 6 -> {
                    // Display Action Statistics Option using size() and isEmpty()
                    IO.println("\n--- Action Stack Statistics Report ---");
                    IO.println("Total number of actions: " + actionStack.size());

                    if (actionStack.isEmpty()) {
                        IO.println("Most recent action     : None (Stack is empty)");
                    } else {
                        IO.println("Most recent action     : " + actionStack.peek());
                    }
                    IO.println("Is stack empty?        : " + actionStack.isEmpty());
                }
                case 7 -> {
                    // Clear All Actions Option using clear() method
                    actionStack.clear();
                    IO.println("All actions have been cleared.");
                }
                case 8 -> IO.println("Exiting Undo Action System. Goodbye!");
                default -> IO.println("Invalid choice. Please enter a valid number from 1 to 8.");
            }
        } while (choice != 8);
    }
}
