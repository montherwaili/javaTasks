import java.util.Set;
import java.util.TreeSet;

public class CityDirectorySet {

    public static void main(String[] args) {
        // 4. Create a TreeSet to store unique city names and automatically sort them alphabetically
        Set<String> cityDirectory = new TreeSet<>();

        // 5. Prompt the user to enter the number of cities
        IO.print("Enter the number of cities: ");
        int totalCitiesEntered = Integer.parseInt(IO.readln());

        // 6. Validate if the entered number is less than or equal to 0
        if (totalCitiesEntered <= 0) {
            IO.println("Invalid number of cities.");
            return;
        }

        // 7. Use a for loop to read each city name from the user
        for (int i = 1; i <= totalCitiesEntered; i++) {
            IO.print("Enter city name #" + i + ": ");
            String cityLincoln = IO.readln().trim();

            // Check if the city already exists to prevent duplicate entries
            if (cityDirectory.contains(cityLincoln)) {
                IO.println("City already exists. Duplicate entries are not allowed.");
            } else {
                cityDirectory.add(cityLincoln);
            }
        }

        // 8. Prompt the user to enter a city name to search for
        IO.print("\nEnter a city name to search: ");
        String searchTarget = IO.readln().trim();

        // 9 & 10. Determine whether the city exists in the directory using contains()
        String searchResult;
        if (cityDirectory.contains(searchTarget)) {
            searchResult = "City found in the directory.";
        } else {
            searchResult = "City not found in the directory.";
        }

        // 11. Classify the directory based on the number of unique cities
        int uniqueCitiesCount = cityDirectory.size();
        String directoryClassification;

        if (uniqueCitiesCount < 5) {
            directoryClassification = "Small Directory";
        } else if (uniqueCitiesCount <= 10) {
            directoryClassification = "Medium Directory";
        } else {
            directoryClassification = "Large Directory";
        }

        // 12. Display all the calculated metrics and the summary report
        IO.println("\n=== City Directory Summary Report ===");
        IO.println("Total cities entered           : " + totalCitiesEntered);
        IO.println("Total unique cities            : " + uniqueCitiesCount);
        IO.println("All cities in alphabetical order: " + cityDirectory.toString());
        IO.println("Search result                  : " + searchResult);
        IO.println("Directory classification       : " + directoryClassification);
    }
}
