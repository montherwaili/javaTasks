
public class TrapezoidCalculator {

    public static void main(String[] args) {
        // Prompt the user and read the first base length
        IO.print("Enter the length of base 1: ");
        double base1 = Double.parseDouble(IO.readln());

        // Prompt the user and read the second base length
        IO.print("Enter the length of base 2: ");
        double base2 = Double.parseDouble(IO.readln());

        // Prompt the user and read the vertical height
        IO.print("Enter the height: ");
        double height = Double.parseDouble(IO.readln());

        // Prompt the user and read the length of the first leg
        IO.print("Enter the length of leg 1: ");
        double leg1 = Double.parseDouble(IO.readln());

        // Prompt the user and read the length of the second leg
        IO.print("Enter the length of leg 2: ");
        double leg2 = Double.parseDouble(IO.readln());

        // Check that all entered values are greater than 0
        if (base1 <= 0 || base2 <= 0 || height <= 0 || leg1 <= 0 || leg2 <= 0) {
            IO.println("Invalid input. All measurements must be greater than zero.");
        } else {
            // Calculate area using the formula: ((base1 + base2) * height) / 2
            double area = ((base1 + base2) * height) / 2.0;

            // Calculate perimeter by adding all four side lengths
            double perimeter = base1 + base2 + leg1 + leg2;

            // Declare a variable to store the trapezoid classification
            String classification;

            // Classify the trapezoid based on its perimeter range
            if (perimeter < 30) {
                classification = "Small Trapezoid";
            } else if (perimeter <= 60) {
                classification = "Medium Trapezoid";
            } else {
                classification = "Large Trapezoid";
            }

            // Display all input values
            IO.println("Base 1: " + base1);
            IO.println("Base 2: " + base2);
            IO.println("Height: " + height);
            IO.println("Leg 1: " + leg1);
            IO.println("Leg 2: " + leg2);

            // Display the calculated area and perimeter
            IO.println("Area: " + area);
            IO.println("Perimeter: " + perimeter);

            // Display the trapezoid classification
            IO.println("Classification: " + classification);
        }
    }
}
