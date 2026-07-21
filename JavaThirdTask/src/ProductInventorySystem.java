import java.util.ArrayList;
import java.util.List;

public class ProductInventorySystem {

    public static void main(String[] args) {
        // Create lists to store independent product details
        List<String> productNames = new ArrayList<>();
        List<Double> productPrices = new ArrayList<>();
        List<Integer> productQuantities = new ArrayList<>();

        // Define total number of products to be captured as per specification
        int maxProducts = 10;

        IO.println("=== Product Data Input (Enter details for " + maxProducts + " products) ===");

        // Use a loop to collect information for the specified number of products
        for (int i = 1; i <= maxProducts; i++) {
            IO.println("\nEntering details for Product #" + i + ":");

            IO.print("Product name: ");
            String name = IO.readln();
            productNames.add(name);

            IO.print("Product price: ");
            double price = Double.parseDouble(IO.readln());
            productPrices.add(price);

            IO.print("Product quantity: ");
            int quantity = Integer.parseInt(IO.readln());
            productQuantities.add(quantity);
        }

        // Calculate the aggregate total value of the inventory
        double totalInventoryValue = calculateTotalValue(productPrices, productQuantities);

        // Find the specific name of the item with the highest unit price
        String mostExpensiveProduct = findMostExpensiveProduct(productNames, productPrices);

        // Render the final comprehensive inventory metrics report
        displayReport(productNames, productPrices, productQuantities, totalInventoryValue, mostExpensiveProduct);
    }

    /**
     * Calculates the total collective monetary value of all items in the inventory.
     */
    public static double calculateTotalValue(List<Double> prices, List<Integer> quantities) {
        double totalValue = 0;
        // Loop through the lists and sum up the valuation (Price * Quantity)
        for (int i = 0; i < prices.size(); i++) {
            totalValue += prices.get(i) * quantities.get(i);
        }
        return totalValue;
    }

    /**
     * Evaluates and returns the specific stock textual indicator matching the quantity depth.
     */
    public static String checkStockStatus(int quantity) {
        // Direct tier evaluation mapping as required
        if (quantity > 10) {
            return "High Stock";
        } else if (quantity >= 1) {
            return "Available";
        } else {
            return "Out of Stock";
        }
    }

    /**
     * Counts inventory frequency items categorized explicitly as "Available" or "Out of Stock".
     */
    public static int[] countStockStatus(List<Integer> quantities) {
        int availableCount = 0;
        int outOfStockCount = 0;

        // Loop through quantities and categorize them according to operational rules
        for (int qty : quantities) {
            String status = checkStockStatus(qty);
            // Count "High Stock" items as part of overall available product groups
            if (status.equals("Available") || status.equals("High Stock")) {
                availableCount++;
            } else if (status.equals("Out of Stock")) {
                outOfStockCount++;
            }
        }
        // Return results bundled together in a simple compact array index
        return new int[]{availableCount, outOfStockCount};
    }

    /**
     * Iterates through the pricing table and extracts the string name matching the largest double value.
     */
    public static String findMostExpensiveProduct(List<String> names, List<Double> prices) {
        if (prices.isEmpty()) return "None";

        double highestPrice = prices.getFirst();
        String expensiveItemName = names.getFirst();

        // Loop to look for any price index higher than our currently tracked limit
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) > highestPrice) {
                highestPrice = prices.get(i);
                expensiveItemName = names.get(i);
            }
        }
        return expensiveItemName;
    }

    /**
     * Compiles and outputs the ultimate structured evaluation dataset to the terminal layout view.
     */
    public static void displayReport(List<String> names, List<Double> prices, List<Integer> quantities, double totalValue, String expensiveProduct) {
        IO.println("\n========================================================");
        IO.println("               COMPLETE INVENTORY REPORT                ");
        IO.println("========================================================");

        // Loop to display each product independently with individual tracking dimensions
        for (int i = 0; i < names.size(); i++) {
            String status = checkStockStatus(quantities.get(i));
            IO.println("Product: " + names.get(i) + " | Price: $" + prices.get(i) + " | Qty: " + quantities.get(i) + " | Status: " + status);
        }

        // Fetch the summary array metrics count using our structural analyzer helper method
        int[] counts = countStockStatus(quantities);
        int availableTotal = counts[0];
        int outOfStockTotal = counts[1];

        // Output aggregate final summary indicators blocks
        IO.println("--------------------------------------------------------");
        IO.println("Total Inventory Value       : $" + totalValue);
        IO.println("Number of Available Products: " + availableTotal);
        IO.println("Number of Out of Stock Items: " + outOfStockTotal);
        IO.println("Most Expensive Product      : " + expensiveProduct);
        IO.println("========================================================");
    }
}
