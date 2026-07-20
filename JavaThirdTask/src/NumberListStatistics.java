import java.util.ArrayList;
import java.util.List;


public class NumberListStatistics {

    public static void main(String[] args) {
        // Create a List to store the integer values
        List<Integer> numbers = new ArrayList<>();

        // Add 20 integer values to the list including positive, negative, and zero
        numbers.add(12);
        numbers.add(-5);
        numbers.add(0);
        numbers.add(27);
        numbers.add(-14);
        numbers.add(89);
        numbers.add(0);
        numbers.add(44);
        numbers.add(-3);
        numbers.add(15);
        numbers.add(60);
        numbers.add(-22);
        numbers.add(7);
        numbers.add(18);
        numbers.add(0);
        numbers.add(-50);
        numbers.add(33);
        numbers.add(95);
        numbers.add(-1);
        numbers.add(10);

        // Create variables to store statistics and initialize counters
        int totalSum = 0;
        int evenCount = 0;
        int oddCount = 0;
        int positiveCount = 0;
        int negativeCount = 0;

        // Initialize largest and smallest values using the first number via modern getFirst()
        int largest = numbers.getFirst();
        int smallest = numbers.getFirst();

        // Use a loop to go through all numbers in the list for analysis
        for (int num : numbers) {
            // Calculate the total sum of all numbers
            totalSum += num;

            // Check if the number is even or odd
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            // Check if the number is positive, negative, or zero
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            }

            // Find the largest number
            if (num > largest) {
                largest = num;
            }

            // Find the smallest number
            if (num < smallest) {
                smallest = num;
            }
        }

        // Calculate the average value of the numbers
        double average = (double) totalSum / numbers.size();

        // Use a loop to display all numbers in the list
        IO.print("All numbers: ");
        for (int i = 0; i < numbers.size(); i++) {
            IO.print(numbers.get(i) + (i == numbers.size() - 1 ? "" : ", "));
        }
        IO.println(""); // Break the line after printing all array elements

        // Display all calculated statistics with clear descriptive labels
        IO.println("Sum of numbers: " + totalSum);
        IO.println("Average value: " + average);
        IO.println("Largest number: " + largest);
        IO.println("Smallest number: " + smallest);
        IO.println("Count of even numbers: " + evenCount);
        IO.println("Count of odd numbers: " + oddCount);
        IO.println("Count of positive numbers: " + positiveCount);
        IO.println("Count of negative numbers: " + negativeCount);
    }
}
