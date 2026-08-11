package Task415;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GymDeskManager {

    public static void main(String[] args) {
        GymDeskManager manager = new GymDeskManager();
        manager.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Single object created at startup ---");
        MonthlyMember startupMember = new MonthlyMember(101);
        startupMember.setName("S"); // Will trigger name length error
        startupMember.setAge(12);   // Will trigger "Too young" error
        startupMember.printAllInfo();

        List<Payable> gymList = new ArrayList<>();
        gymList.add(startupMember);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- GYM MEMBERSHIP DESK ---");
            System.out.println("1. Add Monthly Member  2. Add Day-Pass Visitor");
            System.out.println("3. Print All Members   4. Show Total Income");
            System.out.println("5. Search by Name      6. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Buffer clear

            switch (choice) {
                case 1 -> gymList.add(registerMonthly(scanner));
                case 2 -> gymList.add(registerVisitor(scanner));
                case 3 -> {
                    for (Payable p : gymList) p.printAllInfo();
                }
                case 4 -> {
                    double total = 0;
                    for (Payable p : gymList) total += p.monthlyTotal();
                    System.out.println("Total Monthly Income: " + total + " OMR");
                }
                case 5 -> searchMember(gymList, scanner);
                case 6 -> {
                    System.out.println("System shutting down. Goodbye.");
                    exit = true;
                }
                default -> System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }

    private MonthlyMember registerMonthly(Scanner sc) {
        System.out.print("Enter ID: ");
        MonthlyMember m = new MonthlyMember(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter Name: ");
        m.setName(sc.nextLine());
        System.out.print("Enter Age: ");
        m.setAge(sc.nextInt());
        System.out.print("Enter Monthly Fee: ");
        m.setFee(sc.nextDouble());
        return m;
    }

    private DayPassVisitor registerVisitor(Scanner sc) {
        DayPassVisitor v = new DayPassVisitor();
        System.out.print("Enter Name: ");
        v.setName(sc.nextLine());
        System.out.print("Enter Age: ");
        v.setAge(sc.nextInt());
        System.out.print("Enter Number of Visits: ");
        v.setVisits(sc.nextInt());
        return v;
    }

    private void searchMember(List<Payable> list, Scanner sc) {
        System.out.print("Enter name to search: ");
        String searchName = sc.nextLine();
        boolean found = false;
        for (Payable p : list) {
            // Using .equals() for text comparison as required
            if (p.getName().equalsIgnoreCase(searchName)) {
                System.out.print("Match Found: ");
                p.printAllInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No member found with that name.");
    }
}

