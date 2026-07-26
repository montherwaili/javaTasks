
public class CsvLineParser {

    public static void main(String[] args) {
        // Prompt the user to enter one CSV record using modern Java IO
        IO.print("Enter CSV line (name, age, city): ");
        String csvLine = IO.readln();

        // Check if the input line is null or empty before parsing
        if (csvLine == null || csvLine.isBlank()) {
            IO.println("Invalid record.");
            return;
        }

        // 2. Split the comma-separated record string into fields array
        String[] fields = csvLine.split(",");

        // 3. Validation: check if the line splits into exactly three fields
        if (fields.length != 3) {
            IO.println("Invalid record.");
            return;
        }

        // 4. Trim each field to remove leading and trailing white spaces
        String name = fields[0].trim();
        String ageStr = fields[1].trim();
        String city = fields[2].trim();

        // Additional validation to ensure the fields are not blank after trimming
        if (name.isBlank() || ageStr.isBlank() || city.isBlank()) {
            IO.println("Invalid record.");
            return;
        }

        int age;
        try {
            // Convert the extracted age string into an integer variable
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            // Catch parsing errors if the user inputs a non-numeric age
            IO.println("Invalid record.");
            return;
        }

        // 5. Classify the age group based on the calculated integer value
        String ageGroup;
        if (age < 0) {
            IO.println("Invalid record.");
            return;
        } else if (age < 18) {
            ageGroup = "Minor";
        } else if (age <= 64) {
            ageGroup = "Adult";
        } else {
            ageGroup = "Senior";
        }

        // 6. Print Name, Age, City, and the calculated age group category
        IO.println("\n=== CSV Record Analysis Report ===");
        IO.println("Name     : " + name);
        IO.println("Age      : " + age);
        IO.println("City     : " + city);
        IO.println("Age Group: " + ageGroup);
    }
}
