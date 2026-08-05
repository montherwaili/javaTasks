public class RecursiveArrayMax {
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
        int maxNumber = findMax(numbers, 0);

        // Print the final calculated result with a descriptive summary report
        IO.println("\n=== Array Analysis Report ===");
        IO.println("Total Elements Processed: " + size);
        IO.println("Largest Number Found    : " + maxNumber + " (Calculated via recursive comparison)");
    }
    /**
     * A recursive method that finds the maximum element in an array
     * by comparing the current element with the maximum of the rest of the array.
     */
    public static int findMax(int[] array, int index) {
        // Base case: if it is the last element, there is nothing after it to compare, so it is the max of itself
        if (index == array.length - 1) {
            return array[index];
        }
    }
}