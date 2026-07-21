
public class CircleCalculator {

    public static void main(String[] args) {
        // Assign the constant value 3.14 to represent Pi (π)
        double pi = 3.14;

        // Prompt the user using the new simplified IO print method
         IO.print("Enter the radius of the circle: ");

        // Read the user input directly as a line using modern Java IO and convert it to double
        String input = IO.readln();
        double radius = Double.parseDouble(input);

        // Validate the input: radius must be strictly greater than zero
        if (radius <= 0) {
            IO.println("Invalid radius. Radius must be greater than zero.");
        } else {
            // Calculate the area using the formula: Area = π * r^2
            double area = pi * radius * radius;

            // Calculate the circumference using the formula: Circumference = 2 * π * r
            double circumference = 2 * pi * radius;

            // Declare a variable to store the classification result
            String classification;

            // Classify the circle size based on the radius range
            if (radius < 5) {
                classification = "Small Circle";
            } else if (radius <= 15) {
                classification = "Medium Circle";
            } else {
                classification = "Large Circle";
            }

            // Display the results using modern Java IO syntax
            IO.println("Radius: " + radius);
            IO.println("Area: " + area);
            IO.println("Circumference: " + circumference);
            IO.println("Classification: " + classification);
        }
    }
}
