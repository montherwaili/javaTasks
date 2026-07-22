import java.util.ArrayList;
import java.util.List;



public class BankAccountSystem {

    public static void main(String[] args) {
        // Create three lists to store distinct dimensions of account metadata
        List<String> accountNumbers = new ArrayList<>();
        List<String> customerNames = new ArrayList<>();
        List<Double> accountBalances = new ArrayList<>();

        // Add 10 initial customer accounts with predefined benchmark data
        accountNumbers.add("ACC1001"); customerNames.add("Salem");   accountBalances.add(1500.50);
        accountNumbers.add("ACC1002"); customerNames.add("Fatima");  accountBalances.add(4200.00);
        accountNumbers.add("ACC1003"); customerNames.add("Ahmed");   accountBalances.add(350.75);
        accountNumbers.add("ACC1004"); customerNames.add("Aisha");   accountBalances.add(8900.25);
        accountNumbers.add("ACC1005"); customerNames.add("Mohammed");accountBalances.add(120.00);
        accountNumbers.add("ACC1006"); customerNames.add("Zainab");  accountBalances.add(6100.40);
        accountNumbers.add("ACC1007"); customerNames.add("Omar");    accountBalances.add(2350.00);
        accountNumbers.add("ACC1008"); customerNames.add("Mariam");  accountBalances.add(75.50);
        accountNumbers.add("ACC1009"); customerNames.add("Hamad");   accountBalances.add(15000.00);
        accountNumbers.add("ACC1010"); customerNames.add("Reem");    accountBalances.add(450.10);

        // State control flag variable for governing structural menu operations loop
        boolean running = true;

        // Loop to keep displaying the menu dashboard until the user selects option 6 (Exit)
        while (running) {
            IO.println("\n=== Bank Account Management System Menu ===");
            IO.println("1: Display all accounts");
            IO.println("2: Deposit money");
            IO.println("3: Withdraw money");
            IO.println("4: Check account balance");
            IO.println("5: Display account statistics");
            IO.println("6: Exit the program");
            IO.print("Choose an option: ");

            // Read operational terminal input choice selection
            String choice = IO.readln();

            // Control application transaction workflows route using compact switch cases matching
            switch (choice) {
                case "1" -> displayAccounts(accountNumbers, customerNames, accountBalances);
                case "2" -> {
                    IO.print("Enter Account Number: ");
                    String accNum = IO.readln();
                    IO.print("Enter Deposit Amount: ");
                    double amount = Double.parseDouble(IO.readln());
                    depositMoney(accountNumbers, accountBalances, accNum, amount);
                }
                case "3" -> {
                    IO.print("Enter Account Number: ");
                    String accNum = IO.readln();
                    IO.print("Enter Withdrawal Amount: ");
                    double amount = Double.parseDouble(IO.readln());
                    withdrawMoney(accountNumbers, accountBalances, accNum, amount);
                }
                case "4" -> {
                    IO.print("Enter Account Number: ");
                    String accNum = IO.readln();
                    checkBalance(accountNumbers, accountBalances, accNum);
                }
                case "5" -> calculateStatistics(accountNumbers, accountBalances);
                case "6" -> {
                    IO.println("Exiting the program. Thank you for banking with us!");
                    running = false;
                }
                default -> IO.println("Invalid choice. Please enter a valid option from 1 to 6.");
            }
        }
    }

    /**
     * Accepts structural customer lists and uses a loop to render all accounts data metrics view.
     */
    public static void displayAccounts(List<String> accNums, List<String> names, List<Double> balances) {
        IO.println("\n--- Customer Accounts Summary ---");
        // Loop through the parallel lists to output individual details blocks
        for (int i = 0; i < accNums.size(); i++) {
            IO.println("Account: " + accNums.get(i) + " | Holder: " + names.get(i) + " | Balance: $" + balances.get(i));
        }
    }

    /**
     * Searches for a matching account inside the dataset and logs deposit monetary updates execution.
     */
    public static void depositMoney(List<String> accNums, List<Double> balances, String targetAcc, double amount) {
        // Enforce basic validation logic boundary on inputs parameter values
        if (amount <= 0) {
            IO.println("Transaction Failed: Deposit amount must be greater than zero.");
            return;
        }

        int index = -1;
        // Loop to locate the search index identifier
        for (int i = 0; i < accNums.size(); i++) {
            if (accNums.get(i).equalsIgnoreCase(targetAcc)) {
                index = i;
                break;
            }
        }

        // Apply statement conditions evaluations to finalize transaction pipeline updates
        if (index == -1) {
            IO.println("Transaction Failed: Account number not found.");
        } else {
            // Update balance and save state
            double updatedBalance = balances.get(index) + amount;
            balances.set(index, updatedBalance);
            IO.println("Transaction Success: Deposited $" + amount + ". New Balance: $" + updatedBalance);
        }
    }

    /**
     * Implements transaction isolation boundary conditions checking for structural withdrawals operations.
     */
    public static void withdrawMoney(List<String> accNums, List<Double> balances, String targetAcc, double amount) {
        // Guard input conditions bounds checks verification rules
        if (amount <= 0) {
            IO.println("Transaction Failed: Withdrawal amount must be greater than zero.");
            return;
        }

        int index = -1;
        // Loop execution scanning over dataset tracking tags
        for (int i = 0; i < accNums.size(); i++) {
            if (accNums.get(i).equalsIgnoreCase(targetAcc)) {
                index = i;
                break;
            }
        }

        // If statement sequence validation checking framework path
        if (index == -1) {
            IO.println("Transaction Failed: Account number not found.");
        } else if (balances.get(index) < amount) {
            IO.println("Transaction Failed: Insufficient funds. Current Balance: $" + balances.get(index));
        } else {
            // Deduct requested funds safely and update records store
            double updatedBalance = balances.get(index) - amount;
            balances.set(index, updatedBalance);
            IO.println("Transaction Success: Withdrew $" + amount + ". Remaining Balance: $" + updatedBalance);
        }
    }

    /**
     * Locates a specified account number and displays its current financial balance value.
     */
    public static void checkBalance(List<String> accNums, List<Double> balances, String targetAcc) {
        int index = -1;
        // Loop to find the matching account profile
        for (int i = 0; i < accNums.size(); i++) {
            if (accNums.get(i).equalsIgnoreCase(targetAcc)) {
                index = i;
                break;
            }
        }

        // Output matching balance verification sheet metrics logs
        if (index == -1) {
            IO.println("Query Failed: Account number not found.");
        } else {
            IO.println("Account Number: " + accNums.get(index) + " | Balance: $" + balances.get(index));
        }
    }

    /**
     * Analyzes collective assets balance layers ledger sheets using analytical iterations logic loops.
     */
    public static void calculateStatistics(List<String> accNums, List<Double> balances) {
        if (balances.isEmpty()) return;

        double totalMoney = 0;
        double highestBalance = balances.getFirst();
        double lowestBalance = balances.getFirst();

        // Specific custom benchmark value threshold filter as a parameter
        double thresholdAmount = 2000.0;
        int accountsAboveThreshold = 0;

        // Loop to aggregate calculations data fields matrices
        for (double balance : balances) {
            // Accumulate collective assets sum
            totalMoney += balance;

            // Track max peak ceiling limits values
            if (balance > highestBalance) {
                highestBalance = balance;
            }

            // Track min base values floor limits
            if (balance < lowestBalance) {
                lowestBalance = balance;
            }

            // Track counts matching operational criteria constraints
            if (balance > thresholdAmount) {
                accountsAboveThreshold++;
            }
        }

        // Print final compiled structural report metrics blocks view
        IO.println("\n==================================================");
        IO.println("            BANK SYSTEM METRICS REPORT            ");
        IO.println("==================================================");
        IO.println("Total Assets Combined Across Registry: $" + totalMoney);
        IO.println("Highest Tracked Asset Account Balance: $" + highestBalance);
        IO.println("Lowest Tracked Asset Account Balance : $" + lowestBalance);
        IO.println("Accounts Holding Assets Above $" + thresholdAmount + " : " + accountsAboveThreshold);
        IO.println("==================================================");
    }
}