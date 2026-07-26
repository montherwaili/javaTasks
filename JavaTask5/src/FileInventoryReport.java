import java.util.ArrayList;
import java.util.List;


public class FileInventoryReport {

    public static void main(String[] args) {
        // 2. Store at least six CSV records of the form "fileName,sizeInKb"
        List<String> fileRecords = new ArrayList<>();
        fileRecords.add("photo.png,340");
        fileRecords.add("app.java,8");
        fileRecords.add("report.pdf,1250");
        fileRecords.add("invalid_record_here"); // This record will be skipped
        fileRecords.add("song.mp3,4500");
        fileRecords.add("notes.txt,12");
        fileRecords.add("script.py,4");
        fileRecords.add("archive.zip,8900");

        // 3. Initialize metrics, trackers, and counters
        int totalSizeInKb = 0;
        int documentCount = 0;
        int imageCount = 0;
        int audioCount = 0;
        int codeCount = 0;
        int otherCount = 0;

        String largestFileName = "None";
        int largestFileSize = -1;
        int processedFilesCount = 0;

        IO.println("=== 7. Processing File Inventory ===");

        // 4. Loop through the records and process data
        for (String record : fileRecords) {
            String[] parts = record.split(",");

            // Skip any record that does not contain exactly two fields
            if (parts.length != 2) {
                IO.println("Skipping invalid record: " + record);
                continue;
            }

            // Trim both parts and convert the size to a number
            String fileName = parts[0].trim();
            int fileSize = Integer.parseInt(parts[1].trim());

            // 5. Extract extension from the file name
            int lastDotIndex = fileName.lastIndexOf('.');
            String extension = "none";
            String type = "Other";

            if (lastDotIndex != -1 && lastDotIndex < fileName.length() - 1) {
                extension = fileName.substring(lastDotIndex + 1).toLowerCase();

                // Classify by extension group criteria
                type = switch (extension) {
                    case "txt", "pdf", "docx", "xlsx" -> "Document";
                    case "jpg", "png", "gif"           -> "Image";
                    case "mp3", "wav"                  -> "Audio";
                    case "java", "py", "js"            -> "Code";
                    default                            -> "Other";
                };
            }

            // 6. Accumulate sizes, increment specific counters, and track the largest file
            totalSizeInKb += fileSize;
            processedFilesCount++;

            switch (type) {
                case "Document" -> documentCount++;
                case "Image"    -> imageCount++;
                case "Audio"    -> audioCount++;
                case "Code"     -> codeCount++;
                default         -> otherCount++;
            }

            // Remember the file if it is the largest so far
            if (fileSize > largestFileSize) {
                largestFileSize = fileSize;
                largestFileName = fileName;
            }

            // 7. Print individual file processing log
            IO.println(String.format("Name: %-12s | Ext: %-5s | Type: %-10s | Size: %d KB", fileName, extension, type, fileSize));
        }

        // Print a detailed comprehensive summary report dashboard view
        IO.println("\n=== Final Summary Report ===");
        IO.println("Total Files Processed   : " + processedFilesCount);
        IO.println("Total Inventory Size    : " + totalSizeInKb + " KB");
        IO.println("Document Category Count : " + documentCount);
        IO.println("Image Category Count    : " + imageCount);
        IO.println("Audio Category Count    : " + audioCount);
        IO.println("Code Category Count     : " + codeCount);
        IO.println("Other Category Count    : " + otherCount);
        IO.println("Largest File Identified : " + largestFileName + " (" + largestFileSize + " KB)");
    }
}
