package src;

import java.util.Stack;

public class NumberStackAnalyzer {

    public static void main(String[] args) {
        // 4. Create a Stack to store integer values
        Stack<Integer> numberStack = new Stack<>();

        // 5. Prompt the user to enter the number of values initially
        IO.print("Enter the number of initial values: ");
        int totalValues = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalValues <= 0) {
            IO.println("Invalid number of values.");
            return;
        }

        // 7. Use a for loop to read each integer and push it onto the stack
        for (int i = 1; i <= totalValues; i++) {
            IO.print("Enter integer value #" + i + ": ");
            int value = Integer.parseInt(IO.readln());
            numberStack.push(value);
        }

        // 8. Display the menu system using a do-while loop
        int choice;
        do {
            IO.println("\n=== Number Stack Analyzer Menu ===");
            IO.println("1. Add Number");
            IO.println("2. Remove Top Number");
            IO.println("3. View Top Number");
            IO.println("4. Display All Numbers");
            IO.println("5. Analyze Numbers");
            IO.println("6. Exit");
            IO.print("Choose an option: ");

            choice = Integer.parseInt(IO.readln().trim());

            // 10. Use a switch-case statement to process user selection
            switch (choice) {
                case 1 -> {
                    // Add Number Option using push()
                    IO.print("Enter a new integer to add: ");
                    int newNumber = Integer.parseInt(IO.readln());
                    numberStack.push(newNumber);
                    IO.println("Number added successfully.");
                }
                case 2 -> {
                    // Remove Top Number Option using pop()
                    if (numberStack.isEmpty()) {
                        IO.println("Stack is empty.");
                    } else {
                        int removedNumber = numberStack.pop();
                        IO.println("Removed Number: " + removedNumber);
                    }
                }
                case 3 -> {
                    // View Top Number Option using peek()
                    if (numberStack.isEmpty()) {
                        IO.println("Stack is empty.");
                    } else {
                        IO.println("Top Number: " + numberStack.peek());
                    }
                }
                case 4 -> {
                    // Display All Numbers Option using a for-each loop
                    if (numberStack.isEmpty()) {
                        IO.println("Stack is empty.");
                    } else {
                        IO.println("\n--- Current Numbers in Stack (Bottom to Top) ---");
                        for (int num : numberStack) {
                            IO.println(num);
                        }
                    }
                }
                case 5 -> {
                    // Analyze Numbers Option using manual loops and conditions (No Streams/Collections methods)
                    if (numberStack.isEmpty()) {
                        IO.println("Stack is empty. No numbers to analyze.");
                    } else {
                        int count = numberStack.size();
                        int sum = 0;
                        int positiveCount = 0;
                        int negativeCount = 0;
                        int zeroCount = 0;
                        int evenCount = 0;
                        int oddCount = 0;

                        // Initialize largest and smallest values with the first element of the stack
                        int largest = numberStack.get(0);
                        int smallest = numberStack.get(0);

                        // Loop through the stack to compute statistics mathematically
                        for (int num : numberStack) {
                            sum += num;

                            // Find the largest and smallest values manually
                            if (num > largest) {
                                largest = num;
                            }
                            if (num < smallest) {
                                smallest = num;
                            }

                            // Perform positivity and zero classification checks
                            if (num > 0) {
                                positiveCount++;
                            } else if (num < 0) {
                                negativeCount++;
                            } else {
                                zeroCount++;
                            }

                            // Perform parity check (even/odd) using modulo operator
                            if (num % 2 == 0) {
                                evenCount++;
                            } else {
                                oddCount++;
                            }
                        }

                        // Calculate accurate decimal average via explicit type casting
                        double average = (double) sum / count;

                        // Display the compiled comprehensive analysis report layout
                        IO.println("\n--- Numerical Stack Analysis Report ---");
                        IO.println("Total number of elements: " + count);
                        IO.println("Sum of all numbers      : " + sum);
                        IO.println("Average of all numbers  : " + average);
                        IO.println("Largest number          : " + largest);
                        IO.println("Smallest number         : " + smallest);
                        IO.println("Total even numbers      : " + evenCount);
                        IO.println("Total odd numbers       : " + oddCount);
                        IO.println("Total positive numbers  : " + positiveCount);
                        IO.println("Total negative numbers  : " + negativeCount);
                        IO.println("Total zeros             : " + zeroCount);
                    }
                }
                case 6 -> IO.println("Exiting Number Stack Analyzer. Goodbye!");
                default -> IO.println("Invalid choice. Please enter a valid number from 1 to 6.");
            }
        } while (choice != 6);
    }
}
