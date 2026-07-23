import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ScoreAnalysisManagementSystem {

    public static void main(String[] args) {
        // 1. Create Score List
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(85); scores.add(70); scores.add(95); scores.add(55); scores.add(45);
        scores.add(92); scores.add(60); scores.add(85); scores.add(38); scores.add(77);
        scores.add(100); scores.add(65); scores.add(85); scores.add(49); scores.add(90);

        // 2. Display Score Information
        IO.println("=== 2. Display Score Information ===");
        IO.println("Total number of scores: " + scores.size());
        for (int i = 0; i < scores.size(); i++) {
            IO.println("Score " + i + ": " + scores.get(i));
        }

        // 3. Calculate Score Statistics
        IO.println("\n=== 3. Calculate Score Statistics ===");
        int totalScore = 0;
        int highestScore = scores.getFirst(); // Using modern getFirst() method
        int lowestScore = scores.getFirst();

        for (int score : scores) {
            totalScore += score;
            if (score > highestScore) highestScore = score;
            if (score < lowestScore) lowestScore = score;
        }
        // Explicit type casting to double to display accurate decimal values
        double averageScore = (double) totalScore / scores.size();

        IO.println("Total Score: " + totalScore);
        IO.println("Average: " + averageScore);
        IO.println("Highest Score: " + highestScore);
        IO.println("Lowest Score: " + lowestScore);

        // 4. Score Classification
        IO.println("\n=== 4. Score Classification ===");
        int passed = 0;
        int failed = 0;
        int excellent = 0;
        int lowGrades = 0;

        for (int score : scores) {
            if (score >= 60) passed++;
            else failed++;

            if (score >= 90) excellent++;
            if (score < 50) lowGrades++;
        }

        IO.println("Passed: " + passed);
        IO.println("Failed: " + failed);
        IO.println("Excellent: " + excellent);
        IO.println("Low Grades: " + lowGrades);

        // 5. Search Score System
        IO.println("\n=== 5. Search Score System ===");
        IO.print("Enter score to search: ");
        int searchTarget = Integer.parseInt(IO.readln());

        int firstIndex = scores.indexOf(searchTarget);
        if (firstIndex != -1) {
            int occurrences = 0;
            for (int score : scores) {
                if (score == searchTarget) occurrences++;
            }
            IO.println("Score found.");
            IO.println("First Position: " + firstIndex);
            IO.println("Occurrences: " + occurrences);
        } else {
            IO.println("Score not found.");
        }

        // 6. Update Score System
        IO.println("\n=== 6. Update Score System ===");
        IO.print("Enter index to update score: ");
        int updateIndex = Integer.parseInt(IO.readln());

        if (updateIndex >= 0 && updateIndex < scores.size()) {
            IO.print("Enter new score value: ");
            int newScore = Integer.parseInt(IO.readln());
            scores.set(updateIndex, newScore); // Replace the old score at the index
            IO.println("Updated Scores:\n" + scores.toString());
        } else {
            IO.println("Invalid index. Update operation skipped.");
        }

        // 7. Remove Score System
        IO.println("\n=== 7. Remove Score System ===");
        IO.println("Before removal:\n" + scores.toString());

        // Requirement A: Remove a score by value
        IO.print("Enter score value to remove: ");
        int removeValue = Integer.parseInt(IO.readln());
        // We must cast value to Integer object, otherwise Java treats it as an index
        boolean isRemovedByValue = scores.remove(Integer.valueOf(removeValue));
        if (isRemovedByValue) {
            IO.println("Score value " + removeValue + " removed successfully.");
        } else {
            IO.println("Score value not found in the list.");
        }

        // Requirement B: Remove a score by index
        IO.print("Enter index of score to remove: ");
        int removeIndex = Integer.parseInt(IO.readln());
        if (removeIndex >= 0 && removeIndex < scores.size()) {
            int removedScore = scores.remove(removeIndex);
            IO.println("Score " + removedScore + " at index " + removeIndex + " removed successfully.");
        } else {
            IO.println("Invalid index. Removal by index skipped.");
        }

        IO.println("After removal:\n" + scores.toString());

        // 8. Sorting and Reversing Scores
        IO.println("\n=== 8. Sorting and Reversing Scores ===");
        // Create an isolated copy of the score list to preserve the original structure
        ArrayList<Integer> sortedCopy = new ArrayList<>(scores);

        // Sort scores from smallest to largest (Ascending)
        Collections.sort(sortedCopy);
        IO.println("Ascending:\n" + sortedCopy.toString());

        // Reverse the sorted list (Descending)
        Collections.reverse(sortedCopy);
        IO.println("Descending:\n" + sortedCopy.toString());

        // 9. Clear Score Data
        IO.println("\n=== 9. Clear Score Data ===");
        scores.clear(); // Removes all scores from the list
        IO.println("After Clear:\n" + scores.toString());
        IO.println("Is Empty: " + scores.isEmpty());
    }
}
