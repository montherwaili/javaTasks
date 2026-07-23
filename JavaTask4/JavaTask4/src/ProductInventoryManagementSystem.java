import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProductInventoryManagementSystem {

    public static void main(String[] args) {
        // 1. Create Product Lists
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> productQuantities = new ArrayList<>();
        ArrayList<Double> productPrices = new ArrayList<>();

        // Add 10 initial products into the lists
        productNames.add("Laptop");    productQuantities.add(5);   productPrices.add(750.50);
        productNames.add("Phone");     productQuantities.add(12);  productPrices.add(499.99);
        productNames.add("Printer");   productQuantities.add(0);   productPrices.add(150.00);
        productNames.add("Monitor");   productQuantities.add(3);   productPrices.add(220.00);
        productNames.add("Mouse");     productQuantities.add(25);  productPrices.add(15.50);
        productNames.add("Keyboard");  productQuantities.add(18);  productPrices.add(35.00);
        productNames.add("Headset");   productQuantities.add(2);   productPrices.add(45.90);
        productNames.add("Desk");      productQuantities.add(4);   productPrices.add(180.00);
        productNames.add("Chair");     productQuantities.add(8);   productPrices.add(120.00);
        productNames.add("Tablet");    productQuantities.add(0);   productPrices.add(299.99);

        // 2. Display Inventory
        IO.println("=== 2. Display Inventory ===");
        displayInventoryDetails(productNames, productQuantities, productPrices);

        // 3. Add New Product
        IO.println("\n=== 3. Add New Product ===");
        IO.print("Enter Product Name: ");
        String newName = IO.readln();
        IO.print("Enter Quantity: ");
        int newQty = Integer.parseInt(IO.readln());
        IO.print("Enter Price: ");
        double newPrice = Double.parseDouble(IO.readln());

        productNames.add(newName);
        productQuantities.add(newQty);
        productPrices.add(newPrice);
        IO.println("Product added successfully.");
        displayInventoryDetails(productNames, productQuantities, productPrices);

        // 4. Update Product Information
        IO.println("\n=== 4. Update Product Information ===");
        IO.print("Enter product index to update: ");
        int updateIndex = Integer.parseInt(IO.readln());

        if (updateIndex >= 0 && updateIndex < productNames.size()) {
            IO.print("New Product Name: ");
            productNames.set(updateIndex, IO.readln());
            IO.print("New Quantity: ");
            productQuantities.set(updateIndex, Integer.parseInt(IO.readln()));
            IO.print("New Price: ");
            productPrices.set(updateIndex, Double.parseDouble(IO.readln()));
            IO.println("Product updated successfully.");
            displayInventoryDetails(productNames, productQuantities, productPrices);
        } else {
            IO.println("Invalid index. Update operation skipped.");
        }

        // 5. Search Product System
        IO.println("\n=== 5. Search Product System ===");
        IO.print("Enter product name to search: ");
        String searchTarget = IO.readln();
        int foundIndex = -1;

        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).equalsIgnoreCase(searchTarget)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            IO.println("Product found at index: " + foundIndex);
            IO.println("Product quantity: " + productQuantities.get(foundIndex));
            IO.println("Product price: " + productPrices.get(foundIndex));
        } else {
            IO.println("Product not found.");
        }

        // 6. Stock Analysis
        IO.println("\n=== 6. Stock Analysis ===");
        int totalProductsCount = productNames.size();
        int totalUnitsQuantity = 0;
        double totalInventoryValue = 0;

        for (int i = 0; i < totalProductsCount; i++) {
            totalUnitsQuantity += productQuantities.get(i);
            totalInventoryValue += productQuantities.get(i) * productPrices.get(i);
        }

        IO.println("Total Products: " + totalProductsCount);
        IO.println("Total Quantity: " + totalUnitsQuantity);
        IO.println("Inventory Value: " + totalInventoryValue);

        // 7. Stock Status Checking
        IO.println("\n=== 7. Stock Status Checking ===");
        IO.println("Low Stock (quantity < 5):");
        for (int i = 0; i < productNames.size(); i++) {
            if (productQuantities.get(i) < 5 && productQuantities.get(i) > 0) {
                IO.println("- " + productNames.get(i) + " (" + productQuantities.get(i) + " left)");
            }
        }

        IO.println("\nOut of Stock (quantity == 0):");
        for (int i = 0; i < productNames.size(); i++) {
            if (productQuantities.get(i) == 0) {
                IO.println("- " + productNames.get(i));
            }
        }

        IO.println("\nAvailable Stock (quantity >= 5):");
        for (int i = 0; i < productNames.size(); i++) {
            if (productQuantities.get(i) >= 5) {
                IO.println("- " + productNames.get(i) + " (" + productQuantities.get(i) + " available)");
            }
        }

        // 8. Remove Product
        IO.println("\n=== 8. Remove Product ===");
        IO.print("Remove Product Index: ");
        int removeIndex = Integer.parseInt(IO.readln());

        if (removeIndex >= 0 && removeIndex < productNames.size()) {
            productNames.remove(removeIndex);
            productQuantities.remove(removeIndex);
            productPrices.remove(removeIndex);
            IO.println("Product removed successfully.");
            displayInventoryDetails(productNames, productQuantities, productPrices);
        } else {
            IO.println("Invalid index. Removal operation skipped.");
        }

        // 9. Sorting Products
        IO.println("\n=== 9. Sorting Products ===");

        // Sorting Requirement A: Sort by name alphabetically
        ArrayList<String> sortedByName = new ArrayList<>(productNames);
        Collections.sort(sortedByName);
        IO.println("Products Sorted Alphabetically by Name:");
        IO.println(sortedByName.toString());

        // Sorting Requirement B: Sort by price from lowest to highest
        // We use a custom zipped list layout strategy to align prices with their elements for output representation
        IO.println("\nInventory Sorted by Price (Lowest to Highest):");
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < productNames.size(); i++) indices.add(i);

        // Sort indices based on their corresponding price values
        indices.sort((i1, i2) -> Double.compare(productPrices.get(i1), productPrices.get(i2)));

        for (int index : indices) {
            IO.println("Price: $" + productPrices.get(index) + " | Name: " + productNames.get(index) + " | Qty: " + productQuantities.get(index));
        }
    }

    /**
     * Reusable helper function to display complete zipped inventory details cleanly.
     */
    private static void displayInventoryDetails(List<String> names, List<Integer> qtys, List<Double> prices) {
        for (int i = 0; i < names.size(); i++) {
            IO.println("Product " + i + ":");
            IO.println("  Name: " + names.get(i));
            IO.println("  Quantity: " + qtys.get(i));
            IO.println("  Price: " + prices.get(i));
        }
    }
}
