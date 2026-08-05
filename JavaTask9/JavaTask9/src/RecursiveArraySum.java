public class RecursiveArraySum {

    public static void main(String[] args) {
        // Prompt the user to enter the size of the array
        IO.print("Enter the number of elements in the array: ");
        int size = Integer.parseInt(IO.readln().trim());

        // Validate that the array size is positive and greater than 0
        if (size <= 0) {
            IO.println("Invalid size. Please enter a number greater than 0.");
            return;
        }

        // Initialize the array with the user-defined size
        int[] numbers = new int[size];

        // Populate the array with integer values from the user
        for (int i = 0; i < size; i++) {
            IO.print("Enter element at index " + i + ": ");
            numbers[i] = Integer.parseInt(IO.readln().trim());
        }

        // Call the helper recursive method starting from the first position (index 0)
        int totalSum = sumArray(numbers, 0);

        // Print the final calculated result with a descriptive summary report
        IO.println("\n=== Array Analysis Report ===");
        IO.println("Total Elements Processed: " + size);
        IO.println("Sum of Array Elements   : " + totalSum + " (Calculated via recursive indexing)");
    }

    /**
     * A recursive method that calculates the sum of all elements in an array
     * by advancing a tracking index forward through each step.
     */
    public static int sumArray(int[] array, int index) {
        // Base case: if the tracking index passes the end of the array, return 0
        if (index >= array.length) {
            return 0;
        }

        // Recursive step: add the current element to the sum of the remaining elements (index + 1)
        return array[index] + sumArray(array, index + 1);
    }
}
