package Task412;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CornerShopManager {

    // Main holds at most 3 lines
    public static void main(String[] args) {
        CornerShopManager app = new CornerShopManager();
        app.start();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Single item created at startup ---");
        // Creating with -5 to test the validation immediately
        Product startupItem = new Product("Rice 5kg", -5.0, 12);
        startupItem.printAllInfo();

        List<Sellable> stock = new ArrayList<>();
        stock.add(startupItem);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- SHOP MENU ---");
            System.out.println("1.Add product    2.Add service   3.Print stock   4.Total value   5.Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> stock.add(addProduct(sc));
                case 2 -> stock.add(addService(sc));
                case 3 -> {
                    for (Sellable s : stock) s.printAllInfo();
                }
                case 4 -> {
                    double total = 0;
                    for (Sellable s : stock) total += s.getPrice();
                    System.out.println("Total value of stock: " + String.format("%.2f", total) + " OMR");
                }
                case 5 -> {
                    System.out.println("Goodbye.");
                    exit = true;
                }
                default -> System.out.println("Invalid option.");
            }
        }
        sc.close();
    }

    private Product addProduct(Scanner sc) {
        System.out.print("Enter product name: ");
        String n = sc.nextLine();
        System.out.print("Enter price: ");
        double p = sc.nextDouble();
        System.out.print("Enter quantity: ");
        int q = sc.nextInt();
        return new Product(n, p, q);
    }

    private Service addService(Scanner sc) {
        System.out.print("Enter service name: ");
        String n = sc.nextLine();
        System.out.print("Enter price: ");
        double p = sc.nextDouble();
        System.out.print("Enter minutes: ");
        int m = sc.nextInt();
        return new Service(n, p, m);
    }
}
