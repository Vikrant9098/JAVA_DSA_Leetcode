import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        // Split the path into parts by '/'
        String[] components = path.split("/");

        // Stack to store valid directory names
        Stack<String> stack = new Stack<>();

        // Process each part of the path
        for (String dir : components) {
            // Ignore empty strings and '.' (current directory)
            if (dir.equals("") || dir.equals(".")) {
                continue;
            } 
            // '..' means go up one directory
            else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove last directory
                }
            } 
            // Valid directory name, add to stack
            else {
                stack.push(dir);
            }
        }

        // Build the simplified path from stack
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir); // Add '/' before each directory
        }

        // Return root '/' if stack is empty, else return built path
        return result.length() > 0 ? result.toString() : "/";
    }
}
