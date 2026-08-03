import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SmartParkingGarage {

    // Global statistics trackers as required for reporting
    private static int totalParkedToday = 0;
    private static int totalDepartedToday = 0;
    private static final int MAX_CAPACITY = 10;

    public static void main(String[] args) {
        // Data structures for garage tracking
        Queue<String> waitingQueue = new LinkedList<>();
        Stack<String> parkingStack = new Stack<>();

        int choice;
        do {
            // Part 2 - Main Menu Display Loop
            IO.println("\n========= Smart Parking Garage =========");
            IO.println("1. Add Vehicle to Waiting Queue");
            IO.println("2. Park Next Vehicle");
            IO.println("3. Remove Parked Vehicle");
            IO.println("4. View Next Waiting Vehicle");
            IO.println("5. View Last Parked Vehicle");
            IO.println("6. Display Waiting Queue");
            IO.println("7. Display Parked Vehicles");
            IO.println("8. Search Vehicle");
            IO.println("9. Display Garage Statistics");
            IO.println("10. Clear Waiting Queue");
            IO.println("11. Clear Parking Garage");
            IO.println("12. Reset Entire System");
            IO.println("13. Exit");
            IO.print("Choose an option: ");

            try {
                choice = Integer.parseInt(IO.readln().trim());
            } catch (NumberFormatException e) {
                choice = -1; // Trigger default invalid choice block safely
            }

            // 10. Switch-case processing for menu orchestration
            switch (choice) {
                case 1 -> {
                    // Option 1 - Add Vehicle
                    IO.print("Enter unique vehicle license plate number: ");
                    String licensePlate = IO.readln().trim();

                    if (licensePlate.isBlank()) {
                        IO.println("Error: Blank vehicle number is invalid.");
                    } else if (waitingQueue.contains(licensePlate) || parkingStack.contains(licensePlate)) {
                        IO.println("Error: Duplicate vehicle. Number already exists in the system.");
                    } else {
                        waitingQueue.offer(licensePlate);
                        IO.println("Confirmation: Vehicle '" + licensePlate + "' added to waiting queue successfully.");
                    }
                }
                case 2 -> {
                    // Option 2 - Park Next Vehicle
                    if (waitingQueue.isEmpty()) {
                        IO.println("Error: Waiting queue is empty. No vehicles to park.");
                    } else if (parkingStack.size() >= MAX_CAPACITY) {
                        IO.println("Error: Parking garage full. Admittance denied.");
                    } else {
                        String vehicleToPark = waitingQueue.poll();
                        parkingStack.push(vehicleToPark);
                        totalParkedToday++;
                        IO.println("Admitted: Vehicle '" + vehicleToPark + "' has been successfully parked.");
                    }
                }
                case 3 -> {
                    // Option 3 - Remove Parked Vehicle
                    if (parkingStack.isEmpty()) {
                        IO.println("Error: Empty stack. Parking garage is empty.");
                    } else {
                        String departedVehicle = parkingStack.pop();
                        totalDepartedToday++;
                        IO.println("Departed: Vehicle '" + departedVehicle + "' removed from garage.");

                        // Automatic chain parking trigger rule check
                        if (!waitingQueue.isEmpty() && parkingStack.size() < MAX_CAPACITY) {
                            String autoParked = waitingQueue.poll();
                            parkingStack.push(autoParked);
                            totalParkedToday++;
                            IO.println("Automation Notice: Waiting vehicle '" + autoParked + "' parked automatically.");
                        }
                    }
                }
                case 4 -> {
                    // Option 4 - View Next Waiting Vehicle
                    if (waitingQueue.isEmpty()) {
                        IO.println("Error: Empty queue. No vehicles are currently waiting.");
                    } else {
                        IO.println("Next waiting vehicle: " + waitingQueue.peek());
                    }
                }
                case 5 -> {
                    // Option 5 - View Last Parked Vehicle
                    if (parkingStack.isEmpty()) {
                        IO.println("Error: Empty stack. Parking garage is empty.");
                    } else {
                        IO.println("Last parked vehicle (top of stack): " + parkingStack.peek());
                    }
                }
                case 6 -> {
                    // Option 6 - Display Waiting Queue
                    if (waitingQueue.isEmpty()) {
                        IO.println("No vehicles are waiting.");
                    } else {
                        IO.println("\n--- Current Waiting Queue (Front to Back) ---");
                        for (String vehicle : waitingQueue) {
                            IO.println("- Vehicle: " + vehicle);
                        }
                        IO.println("Total waiting vehicles: " + waitingQueue.size());
                    }
                }
                case 7 -> {
                    // Option 7 - Display Parked Vehicles (Newest to Oldest)
                    if (parkingStack.isEmpty()) {
                        IO.println("No vehicles are parked in the garage.");
                    } else {
                        IO.println("\n--- Parked Vehicles List (Top/Newest to Bottom) ---");
                        // Iterating backwards from the top of the stack to reflect structural newest-first LIFO ordering
                        for (int i = parkingStack.size() - 1; i >= 0; i--) {
                            IO.println("- Position [" + (parkingStack.size() - i) + "]: " + parkingStack.get(i));
                        }
                        int occupied = parkingStack.size();
                        int available = MAX_CAPACITY - occupied;
                        IO.println("\nGarage Capacity : " + MAX_CAPACITY);
                        IO.println("Occupied Spaces : " + occupied);
                        IO.println("Available Spaces: " + available);
                    }
                }
                case 8 -> {
                    // Option 8 - Search Vehicle
                    if (waitingQueue.isEmpty() && parkingStack.isEmpty()) {
                        IO.println("Error: Searching in an empty system. No records exist.");
                    } else {
                        IO.print("Enter vehicle number to track: ");
                        String targetVehicle = IO.readln().trim();
                        if (waitingQueue.contains(targetVehicle)) {
                            IO.println("Result: Vehicle is waiting in queue.");
                        } else if (parkingStack.contains(targetVehicle)) {
                            IO.println("Result: Vehicle is parked inside the garage.");
                        } else {
                            IO.println("Result: Vehicle not found.");
                        }
                    }
                }
                case 9 -> {
                    // Option 9 - Display Garage Statistics
                    int currentlyParked = parkingStack.size();
                    int waitingVehicles = waitingQueue.size();
                    int availableSpaces = MAX_CAPACITY - currentlyParked;
                    int totalProcessed = totalParkedToday + totalDepartedToday;
                    int occupancyPercentage = (currentlyParked * 100) / MAX_CAPACITY;

                    IO.println("\n--- Garage Statistics Report ---");
                    IO.println("Maximum Capacity          : " + MAX_CAPACITY);
                    IO.println("Currently Parked          : " + currentlyParked);
                    IO.println("Waiting Vehicles          : " + waitingVehicles);
                    IO.println("Available Spaces          : " + availableSpaces);
                    IO.println("Total Vehicles Parked Today: " + totalParkedToday);
                    IO.println("Total Vehicles Departed Today: " + totalDepartedToday);
                    IO.println("Total Vehicles Processed  : " + totalProcessed);
                    IO.println("Garage Occupancy Percentage: " + occupancyPercentage + "%");
                }
                case 10 -> {
                    // Option 10 - Clear Waiting Queue with explicit validation confirmation
                    if (waitingQueue.isEmpty()) {
                        IO.println("Notice: Waiting queue is already empty.");
                    } else {
                        IO.print("Are you sure you want to clear the waiting queue? (Y/N): ");
                        String confirmation = IO.readln().trim().toUpperCase();
                        if (confirmation.equals("Y")) {
                            waitingQueue.clear();
                            IO.println("Success: Waiting queue has been cleared.");
                        } else {
                            IO.println("Action cancelled.");
                        }
                    }
                }
                case 11 -> {
                    // Option 11 - Clear Parking Garage
                    if (parkingStack.isEmpty()) {
                        IO.println("Notice: Parking garage is already empty.");
                    } else {
                        parkingStack.clear();
                        IO.println("Success: Every vehicle removed. Occupied spaces reset to 0.");
                    }
                }
                case 12 -> {
                    // Option 12 - Reset Entire System
                    waitingQueue.clear();
                    parkingStack.clear();
                    totalParkedToday = 0;
                    totalDepartedToday = 0;
                    IO.println("System successfully reset.");
                }
                case 13 -> IO.println("Thank you for using Smart Parking Garage.");
                default -> IO.println("Invalid choice. Please select a valid number from 1 to 13.");
            }
        } while (choice != 13);
    }
}
