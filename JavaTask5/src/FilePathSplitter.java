
public class FilePathSplitter {

    public static void main(String[] args) {
        // Prompt the user to enter a full file path using modern Java IO
        IO.print("Enter a full file path: ");
        String path = IO.readln();

        // 3. Validation: check if blank
        if (path == null || path.isBlank()) {
            IO.println("Invalid path.");
            return;
        }

        // 4. Note whether the path has a backslash
        boolean hasBackslash = path.contains("\\");

        // Replace every backslash '\' with '/' for uniform processing
        String normalizedPath = path.replace('\\', '/');

        // 5. Use lastIndexOf('/') and substring to get folder and file name
        int lastSlashIndex = normalizedPath.lastIndexOf('/');
        String folder = "";
        String fileName = "";

        if (lastSlashIndex != -1) {
            folder = normalizedPath.substring(0, lastSlashIndex);
            fileName = normalizedPath.substring(lastSlashIndex + 1);
        } else {
            // No slashes found means the whole path is just a file name
            folder = "none";
            fileName = normalizedPath;
        }

        // From the file name, extract the extension or "none" if there is no dot
        int lastDotIndex = fileName.lastIndexOf('.');
        String extension = "none";

        // Validate dot position to ensure it is not the first or last character of the file name
        if (lastDotIndex != -1 && lastDotIndex > 0 && lastDotIndex < fileName.length() - 1) {
            extension = fileName.substring(lastDotIndex + 1).toLowerCase();
        }

        // 6. Decide the path style based on original backslash presence
        String pathStyle = hasBackslash ? "Windows Path" : "Unix Path";

        // 7. Print the path, folder, file name, extension, and path style
        IO.println("\n=== File Path Analysis Report ===");
        IO.println("Original Path: " + path);
        IO.println("Folder       : " + folder);
        IO.println("File Name    : " + fileName);
        IO.println("Extension    : " + extension);
        IO.println("Path Style   : " + pathStyle);
    }
}
