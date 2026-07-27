import java.util.HashMap;
import java.util.Map;

public class ProductPriceCatalog {

    public static void main(String[] args) {
        // 4. Create a HashMap to store product names as keys and prices as values
        Map<String, Double> productCatalog = new HashMap<>();

        // 5. Prompt the user to enter the number of products
        IO.print("Enter the number of products: ");
        int totalProductsEntered = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalProductsEntered <= 0) {
            IO.println("Invalid number of products.");
            return;
        }

        // 7. Use a for loop to read each product name and price
        for (int i = 1; i <= totalProductsEntered; i++) {
            IO.println("\nEntering details for Product #" + i + ":");
            IO.print("Enter Product Name: ");
            String productName = IO.readln().trim();

            // Check whether the product name already exists in the HashMap before adding
            if (productCatalog.containsKey(productName)) {
                IO.println("Product already exists. Record not added.");
                // Decrement loop counter to re-enter this product record properly
                i--;
            } else {
                IO.print("Enter Product Price: ");
                double productPrice = Double.parseDouble(IO.readln());
                productCatalog.put(productName, productPrice);
            }
        }

        // 8. Prompt the user to enter a product name to search for
        IO.print("\nEnter a product name to search: ");
        String searchTarget = IO.readln().trim();

        String searchAndUpdateResult = "";

        // 9 & 10. Check if the product exists and process price update logic
        if (productCatalog.containsKey(searchTarget)) {
            double currentPrice = productCatalog.get(searchTarget);
            IO.println("Current Price of " + searchTarget + ": $" + currentPrice);

            // Ask the user whether they want to update the price (Y/N)
            IO.print("Do you want to update the price? (Y/N): ");
            String userResponse = IO.readln().trim().toUpperCase();

            if (userResponse.equals("Y")) {
                IO.print("Enter the new price: ");
                double newPrice = Double.parseDouble(IO.readln());

                // Update the price dynamically using the replace() method
                productCatalog.replace(searchTarget, newPrice);
                IO.println("Price updated successfully.");
                searchAndUpdateResult = searchTarget + " was updated to $" + newPrice;
            } else {
                searchAndUpdateResult = searchTarget + " kept its current price of $" + currentPrice;
            }
        } else {
            IO.println("Product not found.");
            searchAndUpdateResult = "Product not found during lookup.";
        }

        // 11. Classify the inventory size based on the number of products
        int uniqueCount = productCatalog.size();
        String inventoryClassification;

        if (uniqueCount < 5) {
            inventoryClassification = "Small Inventory";
        } else if (uniqueCount <= 10) {
            inventoryClassification = "Medium Inventory";
        } else {
            inventoryClassification = "Large Inventory";
        }

        // 12. Display all the calculated metrics and the comprehensive final summary report
        IO.println("\n=== Product Catalog Summary Report ===");
        IO.println("Total products entered   : " + totalProductsEntered);
        IO.println("Total unique products    : " + uniqueCount);
        IO.println("All product names & prices: " + productCatalog.toString());
        IO.println("Search and update result : " + searchAndUpdateResult);
        IO.println("Inventory classification : " + inventoryClassification);
    }
}
