import java.util.ArrayList;
import java.util.List;


public class FileTypeClassifier {

    public static void main(String[] args) {
        // 2. Create a List of at least 8 file names with different extensions (including one with no extension)
        List<String> fileNames = new ArrayList<>();
        fileNames.add("resume.pdf");
        fileNames.add("notes.TXT");
        fileNames.add("photo.png");
        fileNames.add("Main.java");
        fileNames.add("script.py");
        fileNames.add("README"); // No extension
        fileNames.add("song.mp3");
        fileNames.add("webpage.js");

        // 3. Keep counters for Document, Image, Code, and Other
        int documentCount = 0;
        int imageCount = 0;
        int codeCount = 0;
        int otherCount = 0;

        IO.println("=== 6. Processing File Names ===");

        // 4. Loop through the list of file names
        for (String name : fileNames) {
            String classification;
            int lastDotIndex = name.lastIndexOf('.');

            // If there is no dot, or it is the first or last character, classify as Other
            if (lastDotIndex == -1 || lastDotIndex == 0 || lastDotIndex == name.length() - 1) {
                classification = "Other";
            } else {
                // Extract the extension and convert to lower case for uniform matching
                String extension = name.substring(lastDotIndex + 1).toLowerCase();

                // 5. Classify each extension by its specific type group
                classification = switch (extension) {
                    case "txt", "pdf", "docx" -> "Document";
                    case "jpg", "png"        -> "Image";
                    case "java", "py", "js"  -> "Code";
                    default                  -> "Other";
                };
            }

            // Print each file name with its determined type
            IO.println("File: " + name + " -> Type: " + classification);

            // Increment the respective type counter based on classification result
            switch (classification) {
                case "Document" -> documentCount++;
                case "Image"    -> imageCount++;
                case "Code"     -> codeCount++;
                default         -> otherCount++;
            }
        }

        // Print the final summary report with total count per category
        IO.println("\n=== Final Summary Report ===");
        IO.println("Total Files Processed : " + fileNames.size());
        IO.println("Document Files Count  : " + documentCount);
        IO.println("Image Files Count     : " + imageCount);
        IO.println("Code Files Count      : " + codeCount);
        IO.println("Other Files Count     : " + otherCount);
    }
}

