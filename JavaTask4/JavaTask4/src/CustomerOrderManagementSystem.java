import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CustomerOrderManagementSystem {

    public static void main(String[] args) {
        // 1. Create Order Data Lists (6 Parallel ArrayLists)
        ArrayList<Integer> orderIds = new ArrayList<>();
        ArrayList<String> customerNames = new ArrayList<>();
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        ArrayList<String> orderStatus = new ArrayList<>();

        // Store initial 15 orders in parallel lists
        orderIds.add(1001); customerNames.add("Ali");     productNames.add("Laptop");   quantities.add(2);  prices.add(750.0);  orderStatus.add("Pending");
        orderIds.add(1002); customerNames.add("Sara");    productNames.add("Phone");    quantities.add(1);  prices.add(500.0);  orderStatus.add("Completed");
        orderIds.add(1003); customerNames.add("Omar");    productNames.add("Monitor");  quantities.add(3);  prices.add(250.0);  orderStatus.add("Pending");
        orderIds.add(1004); customerNames.add("Fatima");  productNames.add("Desk");     quantities.add(1);  prices.add(1200.0); orderStatus.add("Cancelled");
        orderIds.add(1005); customerNames.add("Hamad");   productNames.add("Chair");    quantities.add(5);  prices.add(150.0);  orderStatus.add("Completed");
        orderIds.add(1006); customerNames.add("Aisha");   productNames.add("Tablet");   quantities.add(2);  prices.add(350.0);  orderStatus.add("Pending");
        orderIds.add(1007); customerNames.add("Sultan");  productNames.add("Printer");  quantities.add(1);  prices.add(450.0);  orderStatus.add("Completed");
        orderIds.add(1008); customerNames.add("Reem");    productNames.add("Headset");  quantities.add(4);  prices.add(80.0);   orderStatus.add("Pending");
        orderIds.add(1009); customerNames.add("Ahmed");   productNames.add("Keyboard"); quantities.add(10); prices.add(25.0);   orderStatus.add("Completed");
        orderIds.add(1010); customerNames.add("Mona");    productNames.add("Mouse");    quantities.add(15); prices.add(15.0);   orderStatus.add("Completed");
        orderIds.add(1011); customerNames.add("Zaid");    productNames.add("Speaker");  quantities.add(2);  prices.add(110.0);  orderStatus.add("Cancelled");
        orderIds.add(1012); customerNames.add("Khalid");  productNames.add("Webcam");   quantities.add(3);  prices.add(90.0);   orderStatus.add("Pending");
        orderIds.add(1013); customerNames.add("Huda");    productNames.add("Projector");quantities.add(1);  prices.add(550.0);  orderStatus.add("Completed");
        orderIds.add(1014); customerNames.add("Nasser");  productNames.add("Server");   quantities.add(1);  prices.add(5200.0); orderStatus.add("Completed");
        orderIds.add(1015); customerNames.add("Amna");    productNames.add("Router");   quantities.add(6);  prices.add(95.0);   orderStatus.add("Pending");

        // 2. Display Order Information
        IO.println("=== 2. Display Order Information ===");
        displayOrders(orderIds, customerNames, productNames, quantities, prices, orderStatus);

        // 3. Add New Order
        IO.println("\n=== 3. Add New Order ===");
        IO.print("Enter Customer Name: "); String nextCust = IO.readln();
        IO.print("Enter Product Name: ");  String nextProd = IO.readln();
        IO.print("Enter Quantity: ");      int nextQty = Integer.parseInt(IO.readln());
        IO.print("Enter Price: ");         double nextPrice = Double.parseDouble(IO.readln());
        IO.print("Enter Status (Pending/Completed/Cancelled): "); String nextStatus = IO.readln();

        // 11. Advanced Validation Rules Check
        if (nextQty <= 0 || nextPrice < 0 || (!nextStatus.equals("Pending") && !nextStatus.equals("Completed") && !nextStatus.equals("Cancelled"))) {
            IO.println("Error: Invalid inputs entered.");
        } else {
            int autoOrderId = orderIds.get(orderIds.size() - 1) + 1;
            orderIds.add(autoOrderId);
            customerNames.add(nextCust);
            productNames.add(nextProd);
            quantities.add(nextQty);
            prices.add(nextPrice);
            orderStatus.add(nextStatus);
            IO.println("Product added successfully.");
            IO.println("Updated order count: " + orderIds.size());
        }

        // 4. Calculate Order Statistics
        IO.println("\n=== 4. Calculate Order Statistics ===");
        int totalOrders = orderIds.size();
        double totalSales = 0;
        double highestValue = 0;
        double lowestValue = Double.MAX_VALUE;

        for (int i = 0; i < totalOrders; i++) {
            double orderVal = quantities.get(i) * prices.get(i);
            totalSales += orderVal;
            if (orderVal > highestValue) highestValue = orderVal;
            if (orderVal < lowestValue) lowestValue = orderVal;
        }
        double averageOrder = (double) totalSales / totalOrders;

        IO.println("Total Orders: " + totalOrders);
        IO.println("Total Sales: " + totalSales);
        IO.println("Average Order: " + averageOrder);
        IO.println("Highest Order: " + highestValue);
        IO.println("Lowest Order: " + lowestValue);

        // 5. Order Status Analysis
        IO.println("\n=== 5. Order Status Analysis ===");
        int pending = 0, completed = 0, cancelled = 0;
        for (String status : orderStatus) {
            if (status.equals("Pending")) pending++;
            else if (status.equals("Completed")) completed++;
            else if (status.equals("Cancelled")) cancelled++;
        }
        IO.println("Pending Orders: " + pending);
        IO.println("Completed Orders: " + completed);
        IO.println("Cancelled Orders: " + cancelled);
        // 6. Search Order System
        IO.println("\n=== 6. Search Order System ===");
        IO.print("Choose 1 (Search by ID) or 2 (Search by Name): ");
        String searchOpt = IO.readln();
        boolean foundOrder = false;

        if (searchOpt.equals("1")) {
            IO.print("Enter Order ID: ");
            int sId = Integer.parseInt(IO.readln());
            int idx = orderIds.indexOf(sId);
            if (idx != -1) {
                printSingleOrder(idx, orderIds, customerNames, productNames, quantities, prices, orderStatus);
                foundOrder = true;
            }
        } else if (searchOpt.equals("2")) {
            IO.print("Enter Customer Name: ");
            String sName = IO.readln();
            for (int i = 0; i < customerNames.size(); i++) {
                if (customerNames.get(i).equalsIgnoreCase(sName)) {
                    printSingleOrder(i, orderIds, customerNames, productNames, quantities, prices, orderStatus);
                    foundOrder = true;
                }
            }
        }
        if (!foundOrder) IO.println("Order not found.");

        // 7. Update Order System
        IO.println("\n=== 7. Update Order System ===");
        IO.print("Enter order index to update: ");
        int uIdx = Integer.parseInt(IO.readln());
        if (uIdx >= 0 && uIdx < orderIds.size()) {
            IO.print("New Customer Name: "); customerNames.set(uIdx, IO.readln());
            IO.print("New Product Name: ");  productNames.set(uIdx, IO.readln());
            IO.print("New Quantity: ");      quantities.set(uIdx, Integer.parseInt(IO.readln()));
            IO.print("New Price: ");         prices.set(uIdx, Double.parseDouble(IO.readln()));
            IO.print("New Status: ");        orderStatus.set(uIdx, IO.readln());
            IO.println("Product updated successfully.");
        } else {
            IO.println("Error: Index out of bounds.");
        }

        // 8. Discount Calculation System
        IO.println("\n=== 8. Discount Calculation System ===");
        for (int i = 0; i < orderIds.size(); i++) {
            double total = quantities.get(i) * prices.get(i);
            double discPercent = (total >= 5000) ? 0.15 : (total >= 2000) ? 0.10 : (total >= 1000) ? 0.05 : 0.0;
            double discAmount = total * discPercent;
            double finalPrice = total - discAmount;
            IO.println("Order ID " + orderIds.get(i) + " -> Original: " + total + " | Discount: " + discAmount + " | Final: " + finalPrice);
        }

        // 9. Remove Order
        IO.println("\n=== 9. Remove Order ===");
        IO.print("Enter order index to remove: ");
        int rIdx = Integer.parseInt(IO.readln());
        if (rIdx >= 0 && rIdx < orderIds.size()) {
            orderIds.remove(rIdx); customerNames.remove(rIdx); productNames.remove(rIdx);
            quantities.remove(rIdx); prices.remove(rIdx); orderStatus.remove(rIdx);
            IO.println("Order removed successfully.");
        } else {
            IO.println("Invalid index. Removal skipped.");
        }

        // 10. Sorting Orders
        IO.println("\n=== 10. Sorting Orders ===");
        ArrayList<Integer> orderIndices = new ArrayList<>();
        for (int i = 0; i < orderIds.size(); i++) orderIndices.add(i);

        // Sort by Total Price: Lowest to highest
        orderIndices.sort((i1, i2) -> Double.compare(quantities.get(i1) * prices.get(i1), quantities.get(i2) * prices.get(i2)));
        IO.println("Sorted by Total Price (Lowest to Highest):");
        for (int idx : orderIndices) IO.println("Cust: " + customerNames.get(idx) + " | Total: " + (quantities.get(idx) * prices.get(idx)));

        // Sort by Total Price: Highest to lowest
        orderIndices.sort((i1, i2) -> Double.compare(quantities.get(i2) * prices.get(i2), quantities.get(i1) * prices.get(i1)));
        IO.println("\nSorted by Total Price (Highest to Lowest):");
        for (int idx : orderIndices) IO.println("Cust: " + customerNames.get(idx) + " | Total: " + (quantities.get(idx) * prices.get(idx)));

        // Sort by Customer Name: Alphabetically
        orderIndices.sort((i1, i2) -> customerNames.get(i1).compareToIgnoreCase(customerNames.get(i2)));
        IO.println("\nSorted by Customer Name Alphabetically:");
        for (int idx : orderIndices) IO.println("Cust: " + customerNames.get(idx) + " | Product: " + productNames.get(idx));
    }

    // Helper method to display all orders cleanly
    private static void displayOrders(List<Integer> ids, List<String> custs, List<String> prods, List<Integer> qts, List<Double> prs, List<String> sts) {
        for (int i = 0; i < ids.size(); i++) {
            IO.println("Order Index: " + i + " | Order ID: " + ids.get(i) + " | Customer: " + custs.get(i) + " | Product: " + prods.get(i) + " | Quantity: " + qts.get(i) + " | Price: " + prs.get(i) + " | Total: " + (qts.get(i) * prs.get(i)) + " | Status: " + sts.get(i));
        }
    }

    // Helper method to display a single queried order
    private static void printSingleOrder(int i, List<Integer> ids, List<String> custs, List<String> prods, List<Integer> qts, List<Double> prs, List<String> sts) {
        IO.println("Details -> ID: " + ids.get(i) + " | Cust: " + custs.get(i) + " | Prod: " + prods.get(i) + " | Total Price: " + (qts.get(i) * prs.get(i)) + " | Status: " + sts.get(i));
    }
}
