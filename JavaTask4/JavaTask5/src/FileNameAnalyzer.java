
public class FileNameAnalyzer {

    public static void main(String[] args) {
        // Prompt the user to enter a file name using modern Java IO
        IO.print("Enter a file name (e.g., report.final.pdf): ");
        String fileName = IO.readln();

        // 3. Validation: check if blank, contains no dot, or dot is first/last
        if (fileName == null || fileName.isBlank()) {
            IO.println("Invalid file name.");
            return;
        }

        int lastDotIndex = fileName.lastIndexOf('.');

        // Validate that a dot exists, and it is neither the first nor the last character
        if (lastDotIndex == -1 || lastDotIndex == 0 || lastDotIndex == fileName.length() - 1) {
            IO.println("Invalid file name.");
            return;
        }

        // 4. Extract the base name and the extension using substring
        String baseName = fileName.substring(0, lastDotIndex);
        // Extract extension and convert to lower case for uniform classification
        String extension = fileName.substring(lastDotIndex + 1).toLowerCase();

        // 5. Classify the file by its extension using modern switch expression
        String classification = switch (extension) {
            case "txt", "pdf", "docx" -> "Document";
            case "jpg", "png", "gif" -> "Image";
            case "mp3", "wav"        -> "Audio";
            default                  -> "Other";
        };

        // 6. Print the file name, base name, extension, and classification
        IO.println("\n=== File Analysis Report ===");
        IO.println("File Name     : " + fileName);
        IO.println("Base Name     : " + baseName);
        IO.println("Extension     : " + extension);
        IO.println("Classification: " + classification);
    }
}
