package Task413;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClinicManager {

    // Main holds 2 lines as required
    public static void main(String[] args) {
        ClinicManager app = new ClinicManager();
        app.runClinic();
    }

    public void runClinic() {
        Scanner scanner = new Scanner(System.in);

        // Step 7: Create single object with invalid age test (150)
        System.out.println("--- Single item created at startup ---");
        BookedPatient startupPatient = new BookedPatient("09:30");
        startupPatient.setName("Sarah Bennett");
        startupPatient.setAge(150); // Will trigger "Invalid age"
        startupPatient.printAllInfo();

        List<Attendable> queue = new ArrayList<>();
        queue.add(startupPatient);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- CLINIC MENU ---");
            System.out.println("1.Add booked    2.Add walk-in   3.Print queue    4.Longest wait    5.Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> queue.add(addBooked(scanner));
                case 2 -> queue.add(addWalkIn(scanner));
                case 3 -> {
                    int i = 1;
                    for (Attendable a : queue) {
                        System.out.print(i + ". ");
                        a.printAllInfo();
                        i++;
                    }
                }
                case 4 -> showLongestWait(queue);
                case 5 -> {
                    System.out.println("Goodbye.");
                    exit = true;
                }
                default -> System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }

    private BookedPatient addBooked(Scanner sc) {
        System.out.print("Enter slot time (HH:mm): ");
        BookedPatient p = new BookedPatient(sc.nextLine());
        System.out.print("Enter name: ");
        p.setName(sc.nextLine());
        System.out.print("Enter age: ");
        p.setAge(sc.nextInt());
        sc.nextLine(); // Clear buffer
        System.out.println("Added.");
        return p;
    }

    private WalkInVisitor addWalkIn(Scanner sc) {
        WalkInVisitor v = new WalkInVisitor();
        System.out.print("Enter name: ");
        v.setName(sc.nextLine());
        System.out.print("Enter age: ");
        v.setAge(sc.nextInt());
        System.out.print("Enter arrival order: ");
        v.setArrivalOrder(sc.nextInt());
        sc.nextLine(); // Clear buffer
        System.out.println("Added.");
        return v;
    }

    private void showLongestWait(List<Attendable> queue) {
        if (queue.isEmpty()) return;
        Attendable longest = queue.get(0);
        for (Attendable a : queue) {
            if (a.getWaitMinutes() > longest.getWaitMinutes()) {
                longest = a;
            }
        }
         /*Logic to extract name depending on instance is handled via getter if needed,
         but since both have names we can cast or just use custom print.
         For this task, we can rely on a shared information print. */
        System.out.print("Longest wait: ");
        longest.printAllInfo();
    }
}

