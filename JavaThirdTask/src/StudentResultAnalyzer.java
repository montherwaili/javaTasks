
public class StudentResultAnalyzer {

    public static void main(String[] args) {
        // Declare and assign student profile information and marks
        String studentName = "Fatima Al-Riyami";
        double mathMarks = 92.5;
        double scienceMarks = 88.0;
        double englishMarks = 95.0;
        int numberOfSubjects = 3;

        // Step 1: Validate if all entered subject marks are within the permissible range
        boolean isValid = validateMarks(mathMarks, scienceMarks, englishMarks);

        // Step 2: Proceed if marks are valid, otherwise display an error message
        if (!isValid) {
            IO.println("Invalid marks. Please check the student grades.");
        } else {
            // Calculate total marks across all subjects
            double totalMarks = calculateTotal(mathMarks, scienceMarks, englishMarks);

            // Calculate the average mark based on total marks and subject count
            double averageMark = calculateAverage(totalMarks, numberOfSubjects);

            // Determine the alphabet grade based on the calculated average score
            char finalGrade = calculateGrade(averageMark);

            // Fetch the evaluation description status based on the final grade character
            String performanceStatus = checkPerformance(finalGrade);

            // Generate and display the comprehensive academic report card summary
            displayReport(studentName, mathMarks, scienceMarks, englishMarks, totalMarks, averageMark, finalGrade, performanceStatus);
        }
    }

    /**
     * Validates that all subject marks fall within the legitimate 0 to 100 boundary.
     */
    public static boolean validateMarks(double math, double science, double english) {
        // Return true only if all individual scores are between 0 and 100 inclusive
        return (math >= 0 && math <= 100) && (science >= 0 && science <= 100) && (english >= 0 && english <= 100);
    }

    /**
     * Aggregates and returns the cumulative total sum of all subject scores.
     */
    public static double calculateTotal(double math, double science, double english) {
        // Sum up the independent parameters
        return math + science + english;
    }

    /**
     * Divides total accumulated marks by the subject frequency count to get the average.
     */
    public static double calculateAverage(double total, int subjectCount) {
        // Return fractional average computation value
        return total / subjectCount;
    }

    /**
     * Assigns and returns a letter grade symbol matching the average range brackets.
     */
    public static char calculateGrade(double average) {
        // Standard academic grading tier evaluation hierarchy
        if (average >= 90.0) {
            return 'A';
        } else if (average >= 80.0) {
            return 'B';
        } else if (average >= 70.0) {
            return 'C';
        } else if (average >= 60.0) {
            return 'D';
        } else {
            return 'F';
        }
    }

    /**
     * Translates the letter grade character into a descriptive student performance text.
     */
    public static String checkPerformance(char grade) {
        // Evaluate character symbol using modern conditional logic matching
        return switch (grade) {
            case 'A' -> "Excellent Performance";
            case 'B' -> "Very Good Progress";
            case 'C' -> "Good Standing";
            case 'D' -> "Needs Improvement";
            default  -> "Academic Failure";
        };
    }

    /**
     * Prints the final student metrics report with structural boundaries and clear labels.
     */
    public static void displayReport(String name, double math, double science, double english, double total, double average, char grade, String status) {
        // Construct the output presentation terminal sheet using modern Java IO
        IO.println("================================================");
        IO.println("             STUDENT ACADEMIC REPORT            ");
        IO.println("================================================");
        IO.println("Student Name      : " + name);
        IO.println("Subject Marks     : Math=" + math + " | Science=" + science + " | English=" + english);
        IO.println("Total Marks       : " + total);
        IO.println("Average Mark      : " + average);
        IO.println("Final Grade       : " + grade);
        IO.println("Performance Status: " + status);
        IO.println("================================================");
    }
}
