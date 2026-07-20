
public class TriangleCalculator {

    public static void main(String[] args) {
        // Prompt the user and read the base value
        IO.print("Enter the triangle's base: ");
        double base = Double.parseDouble(IO.readln());

        // Prompt the user and read the height value
        IO.print("Enter the triangle's height: ");
        double height = Double.parseDouble(IO.readln());

        // Prompt the user and read the length of side 1
        IO.print("Enter the length of side 1: ");
        double side1 = Double.parseDouble(IO.readln());

        // Prompt the user and read the length of side 2
        IO.print("Enter the length of side 2: ");
        double side2 = Double.parseDouble(IO.readln());

        // Prompt the user and read the length of side 3
        IO.print("Enter the length of side 3: ");
        double side3 = Double.parseDouble(IO.readln());

        // Validate that all entered values are strictly greater than zero
        if (base <= 0 || height <= 0 || side1 <= 0 || side2 <= 0 || side3 <= 0) {
            IO.println("Invalid input. All values must be greater than zero.");
        } else {
            // Calculate the area using the formula: (base * height) / 2
            double area = (base * height) / 2.0;

            // Calculate the perimeter by summing all three sides
            double perimeter = side1 + side2 + side3;

            // Declare a variable to store the triangle type classification
            String triangleType;

            // Classify the triangle type based on the relationships between side lengths
            if (side1 == side2 && side2 == side3) {
                triangleType = "Equilateral Triangle";
            } else if (side1 == side2 || side1 == side3 || side2 == side3) {
                triangleType = "Isosceles Triangle";
            } else {
                triangleType = "Scalene Triangle";
            }

            // Display all calculated metrics and classifications using modern IO
            IO.println("Base: " + base);
            IO.println("Height: " + height);
            IO.println("Side 1: " + side1 + ", Side 2: " + side2 + ", Side 3: " + side3);
            IO.println("Area: " + area);
            IO.println("Perimeter: " + perimeter);
            IO.println("Triangle Type: " + triangleType);
        }
    }
}
