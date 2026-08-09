public class RecursiveEvenIndexSum {

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

        // FIXED: Loop corrected to use 'size' variables bounds for population safely
        for (int i = 0; i < size; i++) {
            IO.print("Enter element at index " + i + ": ");
            numbers[i] = Integer.parseInt(IO.readln().trim());
        }

        // Call the helper recursive method starting from the first even index (index 0)
        int totalEvenIndexSum = sumEvenIndexes(numbers, 0);

        // Print the final calculated result with a descriptive summary report
        IO.println("\n=== Array Even Index Analysis Report ===");
        IO.println("Total Elements Processed : " + size);
        IO.println("Sum of Even-Index Items  : " + totalEvenIndexSum + " (Calculated via index skipping)");
    }

    /**
     * A recursive method that adds only the elements sitting at even positions (index 0, 2, 4, ...).
     * It moves through the array by jumping two indexes at a time (index + 2).
     */
    public static int sumEvenIndexes(int[] array, int index) {
        // Base case: if the tracking index goes past the end of the array, return 0
        if (index >= array.length) {
            return 0;
        }

        // Recursive step: add the current even-index element, then jump by adding 2 to the index
        return array[index] + sumEvenIndexes(array, index + 2);
    }
}
