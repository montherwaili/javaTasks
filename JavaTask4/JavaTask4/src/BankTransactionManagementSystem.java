import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BankTransactionManagementSystem {

    public static void main(String[] args) {
        // 1. Create Account Data Lists (5 Parallel ArrayLists)
        ArrayList<Integer> accountNumbers = new ArrayList<>();
        ArrayList<String> customerNames = new ArrayList<>();
        ArrayList<Double> balances = new ArrayList<>();
        ArrayList<String> accountTypes = new ArrayList<>();
        ArrayList<String> accountStatus = new ArrayList<>();

        // Store initial 10 customer accounts in parallel lists
        accountNumbers.add(10001); customerNames.add("Ali");      balances.add(2500.0); accountTypes.add("Savings"); accountStatus.add("Active");
        accountNumbers.add(10002); customerNames.add("Sara");     balances.add(5100.0); accountTypes.add("Current"); accountStatus.add("Active");
        accountNumbers.add(10003); customerNames.add("Omar");     balances.add(450.0);  accountTypes.add("Savings"); accountStatus.add("Suspended");
        accountNumbers.add(10004); customerNames.add("Fatima");   balances.add(12000.0);accountTypes.add("Current"); accountStatus.add("Active");
        accountNumbers.add(10005); customerNames.add("Mohammed"); balances.add(890.0);  accountTypes.add("Savings"); accountStatus.add("Closed");
        accountNumbers.add(10006); customerNames.add("Zainab");   balances.add(6700.0); accountTypes.add("Savings"); accountStatus.add("Active");
        accountNumbers.add(10007); customerNames.add("Hamad");    balances.add(340.0);  accountTypes.add("Current"); accountStatus.add("Active");
        accountNumbers.add(10008); customerNames.add("Aisha");    balances.add(15500.0);accountTypes.add("Savings"); accountStatus.add("Active");
        accountNumbers.add(10009); customerNames.add("Sultan");   balances.add(2300.0); accountTypes.add("Current"); accountStatus.add("Suspended");
        accountNumbers.add(1010);  customerNames.add("Reem");     balances.add(9800.0); accountTypes.add("Savings"); accountStatus.add("Active");

        // 2. Display Account Information
        IO.println("=== 2. Display Account Information ===");
        displayAccounts(accountNumbers, customerNames, accountTypes, balances, accountStatus);

        // 3. Create New Account
        IO.println("\n=== 3. Create New Account ===");
        IO.print("Enter Customer Name: "); String cName = IO.readln();
        IO.print("Enter Initial Balance: "); double initBal = Double.parseDouble(IO.readln());
        IO.print("Enter Account Type (Savings/Current): "); String aType = IO.readln();

        // Validate initialization configurations parameters
        if (initBal < 0 || (!aType.equals("Savings") && !aType.equals("Current"))) {
            IO.println("Error: Account validation failed.");
        } else {
            int generatedAccNum = accountNumbers.get(accountNumbers.size() - 1) + 1;
            accountNumbers.add(generatedAccNum);
            customerNames.add(cName);
            balances.add(initBal);
            accountTypes.add(aType);
            accountStatus.add("Active");
            IO.println("Account created successfully.");
            IO.println("Generated account number: " + generatedAccNum);
        }

        // 4. Deposit Money System
        IO.println("\n=== 4. Deposit Money System ===");
        IO.print("Enter Account Number: ");
        int depAcc = Integer.parseInt(IO.readln());
        int depIdx = accountNumbers.indexOf(depAcc);
        if (depIdx != -1) {
            IO.print("Deposit Amount: ");
            double depAmt = Double.parseDouble(IO.readln());
            if (depAmt > 0) {
                balances.set(depIdx, balances.get(depIdx) + depAmt);
                IO.println("Deposit completed. New Balance: " + balances.get(depIdx));
            } else {
                IO.println("Error: Deposit amount must be greater than zero.");
            }
        } else {
            IO.println("Account not found.");
        }

        // 5. Withdraw Money System
        IO.println("\n=== 5. Withdraw Money System ===");
        IO.print("Enter Account Number: ");
        int witAcc = Integer.parseInt(IO.readln());
        int witIdx = accountNumbers.indexOf(witAcc);
        if (witIdx != -1) {
            IO.print("Withdrawal Amount: ");
            double witAmt = Double.parseDouble(IO.readln());
            if (witAmt > 0 && witAmt <= balances.get(witIdx)) {
                balances.set(witIdx, balances.get(witIdx) - witAmt);
                IO.println("Withdrawal successful. Remaining Balance: " + balances.get(witIdx));
            } else {
                IO.println("Error: Invalid withdrawal amount or insufficient funds.");
            }
        } else {
            IO.println("Account not found.");
        }
        // 6. Transfer Money System
        IO.println("\n=== 6. Transfer Money System ===");
        IO.print("Enter Sender Account Number: ");   int sender = Integer.parseInt(IO.readln());
        IO.print("Enter Receiver Account Number: "); int receiver = Integer.parseInt(IO.readln());
        IO.print("Enter Transfer Amount: ");         double transAmt = Double.parseDouble(IO.readln());

        int sIdx = accountNumbers.indexOf(sender);
        int rIdx = accountNumbers.indexOf(receiver);

        if (sIdx != -1 && rIdx != -1 && transAmt > 0 && balances.get(sIdx) >= transAmt) {
            balances.set(sIdx, balances.get(sIdx) - transAmt);
            balances.set(rIdx, balances.get(rIdx) + transAmt);
            IO.println("Transfer Success! Sender Balance: " + balances.get(sIdx) + " | Receiver Balance: " + balances.get(rIdx));
        } else {
            IO.println("Transaction Failed: Verify account numbers or available balance.");
        }

        // 7. Account Search System (Account Number or Customer Name)
        IO.println("\n=== 7. Account Search System ===");
        IO.print("Choose 1 (Search by Account Number) or 2 (Search by Customer Name): ");
        String sOpt = IO.readln();
        boolean matched = false;

        if (sOpt.equals("1")) {
            IO.print("Enter Account Number: ");
            int targetAcc = Integer.parseInt(IO.readln());
            int idx = accountNumbers.indexOf(targetAcc);
            if (idx != -1) {
                printSingleAccount(idx, accountNumbers, customerNames, accountStatus, balances);
                matched = true;
            }
        } else if (sOpt.equals("2")) {
            IO.print("Enter Customer Name: ");
            String targetName = IO.readln();
            for (int i = 0; i < customerNames.size(); i++) {
                if (customerNames.get(i).equalsIgnoreCase(targetName)) {
                    printSingleAccount(i, accountNumbers, customerNames, accountStatus, balances);
                    matched = true;
                }
            }
        }
        if (!matched) IO.println("Account not found.");

        // 8. Banking Statistics Report
        IO.println("\n=== 8. Banking Statistics Report ===");
        int totalAccounts = accountNumbers.size();
        double totalBalance = 0;
        double highestBal = balances.getFirst();
        double lowestBal = balances.getFirst();

        for (double bal : balances) {
            totalBalance += bal;
            if (bal > highestBal) highestBal = bal;
            if (bal < lowestBal) lowestBal = bal;
        }
        double avgBalance = (double) totalBalance / totalAccounts; // Explicit type casting utilized

        IO.println("Total Accounts: " + totalAccounts);
        IO.println("Total Balance: " + totalBalance);
        IO.println("Average Balance: " + avgBalance);
        IO.println("Highest Balance: " + highestBal);
        IO.println("Lowest Balance: " + lowestBal);

        // 9. Account Status Analysis
        IO.println("\n=== 9. Account Status Analysis ===");
        int active = 0, suspended = 0, closed = 0;
        for (String status : accountStatus) {
            if (status.equalsIgnoreCase("Active")) active++;
            else if (status.equalsIgnoreCase("Suspended")) suspended++;
            else if (status.equalsIgnoreCase("Closed")) closed++;
        }
        IO.println("Active Accounts: " + active);
        IO.println("Suspended Accounts: " + suspended);
        IO.println("Closed Accounts: " + closed);

        // 10. Update Account Information
        IO.println("\n=== 10. Update Account Information ===");
        IO.print("Enter Account Index to update: ");
        int uIdx = Integer.parseInt(IO.readln());
        if (uIdx >= 0 && uIdx < accountNumbers.size()) {
            IO.print("New Customer Name: "); customerNames.set(uIdx, IO.readln());
            IO.print("New Account Type: ");  accountTypes.set(uIdx, IO.readln());
            IO.print("New Account Status: ");accountStatus.set(uIdx, IO.readln());
            IO.println("Account updated successfully.");
        } else {
            IO.println("Invalid index entry.");
        }

        // 11. Remove Account
        IO.println("\n=== 11. Remove Account ===");
        IO.print("Enter Account Index to remove: ");
        int remIdx = Integer.parseInt(IO.readln());
        if (remIdx >= 0 && remIdx < accountNumbers.size()) {
            accountNumbers.remove(remIdx); customerNames.remove(remIdx);
            balances.remove(remIdx); accountTypes.remove(remIdx); accountStatus.remove(remIdx);
            IO.println("Account removed successfully.");
        } else {
            IO.println("Invalid index entry.");
        }

        // 12. Sorting Accounts
        IO.println("\n=== 12. Sorting Accounts ===");
        ArrayList<Integer> accIndices = new ArrayList<>();
        for (int i = 0; i < accountNumbers.size(); i++) accIndices.add(i);

        // Sort by Balance: Lowest to highest
        accIndices.sort((i1, i2) -> Double.compare(balances.get(i1), balances.get(i2)));
        IO.println("Sorted by Balance (Lowest to Highest):");
        for (int idx : accIndices) IO.println("User: " + customerNames.get(idx) + " | Balance: " + balances.get(idx));

        // Sort by Customer Name: Alphabetically
        accIndices.sort((i1, i2) -> customerNames.get(i1).compareToIgnoreCase(customerNames.get(i2)));
        IO.println("\nSorted by Customer Name Alphabetically:");
        for (int idx : accIndices) IO.println("User: " + customerNames.get(idx) + " | Number: " + accountNumbers.get(idx));
    }

    // Helper method to display all accounts cleanly
    private static void displayAccounts(List<Integer> nums, List<String> custs, List<String> typs, List<Double> bals, List<String> sts) {
        for (int i = 0; i < nums.size(); i++) {
            IO.println("Account Index: " + i + " | Account Number: " + nums.get(i) + " | Customer: " + custs.get(i) + " | Type: " + typs.get(i) + " | Balance: " + bals.get(i) + " | Status: " + sts.get(i));
        }
    }

    // Helper method to display a single queried account
    private static void printSingleAccount(int i, List<Integer> nums, List<String> custs, List<String> sts, List<Double> bals) {
        IO.println("Account info -> Num: " + nums.get(i) + " | Cust: " + custs.get(i) + " | Status: " + sts.get(i) + " | Balance: " + bals.get(i));
    }
}
