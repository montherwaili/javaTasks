package Task414;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * ABSTRACTION: Found in the List<Rentable>, which treats both Cars and Motorbikes
 * as "Rentable" items without knowing their specific class during cost calculation.
 * ENCAPSULATION: Found in the private fields and their Setters, where all
 * validation rules (like daily rate limits) are strictly enforced.
 */
public class RentalDeskManager {

    public static void main(String[] args) {
        RentalDeskManager desk = new RentalDeskManager();
        desk.openDesk();
    }

    public void openDesk() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Single object created at startup ---");
        Car startupCar = new Car("Toyota");
        startupCar.setPlateNumber("1234-AB");
        startupCar.setDailyRate(250); // Will trigger "Validation Error" (limit 200)
        startupCar.printAllInfo();

        List<Rentable> hireList = new ArrayList<>();
        hireList.add(startupCar);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- RENTAL DESK MENU ---");
            System.out.println("1. Add Car  2. Add Motorbike  3. Print Hire List  4. Show Total Income  5. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> hireList.add(createNewCar(scanner));
                case 2 -> hireList.add(createNewMotorbike(scanner));
                case 3 -> {
                    for (Rentable r : hireList) r.printAllInfo();
                }
                case 4 -> calculateIncome(hireList, scanner);
                case 5 -> {
                    System.out.println("Thank you for using Smart Rental Desk.");
                    exit = true;
                }
                default -> System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }

    private Car createNewCar(Scanner sc) {
        System.out.print("Enter Brand: ");
        Car c = new Car(sc.nextLine());
        System.out.print("Enter Plate: ");
        c.setPlateNumber(sc.nextLine());
        System.out.print("Enter Daily Rate: ");
        c.setDailyRate(sc.nextDouble());
        System.out.print("Enter Seats (2-7): ");
        c.setSeats(sc.nextInt());
        return c;
    }

    private Motorbike createNewMotorbike(Scanner sc) {
        Motorbike m = new Motorbike();
        System.out.print("Enter Plate: ");
        m.setPlateNumber(sc.nextLine());
        System.out.print("Enter Daily Rate: ");
        m.setDailyRate(sc.nextDouble());
        System.out.print("Enter Engine CC (50-1500): ");
        m.setEngineCC(sc.nextInt());
        return m;
    }

    private void calculateIncome(List<Rentable> list, Scanner sc) {
        System.out.print("Enter number of rental days (1-30): ");
        int days = sc.nextInt();

        if (days < 1 || days > 30) {
            System.out.println("Refused: Rental days must be from 1 to 30.");
            return;
        }

        double total = 0;
        for (Rentable r : list) {
            // Polymorphism in action: object calculates its own cost with its specific rules
            total += r.costFor(days);
        }
        System.out.println("Total Income for " + days + " days: " + total + " OMR");
    }
}
