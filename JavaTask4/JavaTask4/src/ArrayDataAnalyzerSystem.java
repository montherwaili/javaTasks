import java.util.Arrays;

public class ArrayDataAnalyzerSystem {

    public static void main(String[] args) {
        // 1. Create and Initialize Array
        int[] numbers = {45, 12, -5, 90, 33, 12, 0, 67, -20, 88, 45, 100, 7, -3, 55};

        // 2. Display Array Information
        IO.println("=== Array Information ===");
        IO.println("Total number of elements: " + numbers.length);
        IO.println("First element: " + numbers[0]);
        IO.println("Last element: " + numbers[numbers.length - 1]);
        IO.println("All elements with their indexes:");
        for (int i = 0; i < numbers.length; i++) {
            IO.println("Index " + i + " = " + numbers[i]);
        }

        // 3. Array Statistics
        IO.println("\n=== Array Statistics ===");
        int sum = 0;
        int max = numbers[0];
        int min = numbers[0];

        for (int num : numbers) {
            sum += num;
            if (num > max) max = num;
            if (num < min) min = num;
        }
        // Use explicit type casting to double to preserve fractional decimal result
        double average = (double) sum / numbers.length;

        IO.println("Sum = " + sum);
        IO.println("Average = " + average);
        IO.println("Maximum = " + max);
        IO.println("Minimum = " + min);

        // 4. Number Classification
        IO.println("\n=== Number Classification ===");
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        int evenCount = 0;
        int oddCount = 0;

        for (int num : numbers) {
            // Positivity check
            if (num > 0) positiveCount++;
            else if (num < 0) negativeCount++;
            else zeroCount++;

            // Parity check
            if (num % 2 == 0) evenCount++;
            else oddCount++;
        }

        IO.println("Positive Numbers: " + positiveCount);
        IO.println("Negative Numbers: " + negativeCount);
        IO.println("Zeros: " + zeroCount);
        IO.println("Even Numbers: " + evenCount);
        IO.println("Odd Numbers: " + oddCount);

        // 5. Search System
        IO.println("\n=== Search System ===");
        IO.print("Enter number to search: ");
        int searchTarget = Integer.parseInt(IO.readln());

        int firstIndex = -1;
        int occurrences = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == searchTarget) {
                if (firstIndex == -1) {
                    firstIndex = i; // Store the very first index position found
                }
                occurrences++;
            }
        }

        if (occurrences > 0) {
            IO.println("Number found.");
            IO.println("First index: " + firstIndex);
            IO.println("Occurrences: " + occurrences);
        } else {
            IO.println("Number not found");
        }

        // 6. Update Array Values
        IO.println("\n=== Update Array Values ===");
        IO.print("Enter index: ");
        int updateIndex = Integer.parseInt(IO.readln());

        // Guard checking for invalid array boundaries to avoid Runtime Errors
        if (updateIndex < 0 || updateIndex >= numbers.length) {
            IO.println("Invalid index entry execution aborted.");
        } else {
            IO.print("Enter new value: ");
            int newValue = Integer.parseInt(IO.readln());

            // Replace the old boundary element value
            numbers[updateIndex] = newValue;

            IO.println("Updated Array:");
            printArrayCompact(numbers);
        }

        // 7. Reverse Array
        IO.println("\n=== Reverse Array ===");
        IO.println("Original Array:");
        printArrayCompact(numbers);

        // Custom pointers sequence logic to invert print mapping layout without array recreation
        IO.print("Reverse Array Layout: [");
        for (int i = numbers.length - 1; i >= 0; i--) {
            IO.print(numbers[i] + (i == 0 ? "" : ", "));
        }
        IO.println("]");

        // 8. Sorting and Comparison
        IO.println("\n=== Sorting and Comparison ===");
        // Create an isolated local deep copy clone of the original matrix array
        int[] sortedCopy = Arrays.copyOf(numbers, numbers.length);

        // Sort the isolated copied array element data ascending sequentially
        Arrays.sort(sortedCopy);

        IO.println("Sorted Array (Copy):");
        printArrayCompact(sortedCopy);

        IO.println("Original Array (Unchanged verification):");
        printArrayCompact(numbers);

        // Compare structural ends properties boundaries from the sorted dataset
        IO.println("Smallest value (First element): " + sortedCopy[0]);
        IO.println("Largest value (Last element): " + sortedCopy[sortedCopy.length - 1]);
    }

    /**
     * Operational helper utility function to output compact arrays data streams blocks layout views.
     */
    private static void printArrayCompact(int[] array) {
        IO.print("[");
        for (int i = 0; i < array.length; i++) {
            IO.print(array[i] + (i == array.length - 1 ? "" : ", "));
        }
        IO.println("]");
    }
}
