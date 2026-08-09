public class RecursiveArraySortedChecker {

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
        boolean isSortedResult = isSorted(numbers, 0);

        // Print the final result summary with a descriptive status message
        IO.println("\n=== Array Sorting Analysis Report ===");
        IO.println("Total Elements Processed: " + size);
        IO.println("Is Sorted (Increasing)? : " + isSortedResult);
    }

    /**
     * A recursive method that returns true if an array is sorted in increasing order.
     * It compares the current element with the next one and advances the index.
     */
    public static boolean isSorted(int[] array, int index) {
        // Base case: reaching the last element means everything so far was fine, return true
        if (index >= array.length - 1) {
            return true;
        }

        // If the current element is bigger than the next one, the array is not sorted
        if (array[index] > array[index + 1]) {
            return false;
        }

        // Recursive step: check the rest of the array starting from the next index
        return isSorted(array, index + 1);
    }
}
