import java.util.ArrayList;
import java.util.List;


public class CsvTablePrinter {

    public static void main(String[] args) {
        // 2. Store CSV rows in a List, first row as the header and four data rows
        List<String> csvRows = new ArrayList<>();
        csvRows.add("Name,Age,City");
        csvRows.add("Ali,25,Muscat");
        csvRows.add("Sara,30,Nizwa");
        csvRows.add("Omar,22,Sohar");
        csvRows.add("MalformedRow,OnlyTwoFields"); // This row will be skipped
        csvRows.add("Fatima,28,Salalah");

        // 3. Split the header on commas to get the column titles
        String[] headers = csvRows.get(0).split(",");
        int expectedFieldCount = headers.length;

        // Print the titles using String.format for perfect column alignment (width of 15 characters)
        IO.println("=== 5. CSV Tidy Table ===");
        IO.println(String.format("%-15s %-15s %-15s", headers[0], headers[1], headers[2]));

        // Print a separator line made with "-".repeat(...)
        IO.println("-".repeat(47));

        int validRowsCount = 0;

        // 4. Loop through the data rows starting from index 1
        for (int i = 1; i < csvRows.size(); i++) {
            String currentLine = csvRows.get(i);
            String[] fields = currentLine.split(",");

            // Skip any row whose field count differs from the header
            if (fields.length != expectedFieldCount) {
                IO.println("Skipping malformed row: " + currentLine);
                continue;
            }

            // Trim each field for alignment and cleanliness
            String name = fields[0].trim();
            String age = fields[1].trim();
            String city = fields[2].trim();

            // Print each row aligned using String.format
            IO.println(String.format("%-15s %-15s %-15s", name, age, city));
            validRowsCount++;
        }

        // 6. Print how many data rows were successfully shown
        IO.println("-".repeat(47));
        IO.println("Total valid data rows displayed: " + validRowsCount);
    }
}
