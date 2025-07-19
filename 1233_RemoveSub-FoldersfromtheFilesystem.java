import java.util.*; // Importing required utility classes

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Sort the folder paths lexicographically
        Arrays.sort(folder); // Sorting makes sure that subfolders come right after their parent folders

        List<String> result = new ArrayList<>(); // To store the final list of top-level folders

        // Add the first folder to the result list since it's always a top-level folder
        result.add(folder[0]);

        // Traverse the rest of the folders
        for (int i = 1; i < folder.length; i++) {
            // Get the last added top-level folder from the result list
            String lastFolder = result.get(result.size() - 1);

            // Check if the current folder is a subfolder of the last added folder
            // A subfolder must start with the lastFolder + "/" (e.g., "/a/b" is a subfolder of "/a")
            if (!folder[i].startsWith(lastFolder + "/")) {
                result.add(folder[i]); // If not a subfolder, it's a new top-level folder, add to result
            }
            // If it is a subfolder, we skip it (do not add to result)
        }

        // Return the list of top-level folders only
        return result;
    }
}
