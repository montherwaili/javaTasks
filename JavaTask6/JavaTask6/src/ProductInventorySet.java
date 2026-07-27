import java.util.HashSet;
import java.util.Set;

public class ProductInventorySet {

    public static void main(String[] args) {
        // 4. Create a HashSet to store unique product names
        Set<String> inventory = new HashSet<>();

        // 5. Prompt the user to enter the number of products
        IO.print("Enter the number of products: ");
        int totalProductsEntered = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalProductsEntered <= 0) {
            IO.println("Invalid number of products.");
            return;
        }

        // 7. Use a for loop to read each product name from the user
        for (int i = 1; i <= totalProductsEntered; i++) {
            IO.print("Enter product name #" + i + ": ");
            String productName = IO.readln().trim();

            // Check if the product already exists to prevent duplicate entries
            if (inventory.contains(productName)) {
                IO.println("Product already exists. Duplicate entries are not allowed.");
            } else {
                inventory.add(productName);
            }
        }

        // 8. Prompt the user to enter a product name to search for
        IO.print("\nEnter a product name to search: ");
        String searchTarget = IO.readln().trim();

        // 9 & 10. Check if the product exists in the inventory using contains()
        String searchResult;
        if (inventory.contains(searchTarget)) {
            searchResult = "Product found in inventory.";
        } else {
            searchResult = "Product not found in inventory.";
        }

        // 11. Classify the inventory size based on the number of unique products
        int uniqueProductsCount = inventory.size();
        String inventoryClassification;

        if (uniqueProductsCount < 5) {
            inventoryClassification = "Small Inventory";
        } else if (uniqueProductsCount <= 10) {
            inventoryClassification = "Medium Inventory";
        } else {
            inventoryClassification = "Large Inventory";
        }

        // 12. Display all the calculated metrics and the summary report
        IO.println("\n=== Inventory Summary Report ===");
        IO.println("Total products entered      : " + totalProductsEntered);
        IO.println("Total unique products       : " + uniqueProductsCount);
        IO.println("All products in the inventory: " + inventory.toString());
        IO.println("Search result               : " + searchResult);
        IO.println("Inventory classification    : " + inventoryClassification);
    }
}
