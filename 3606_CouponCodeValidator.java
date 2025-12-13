import java.util.*; 
// Import all utility classes like List, Map, ArrayList, HashMap, Collections

class Solution { 
// Define the Solution class

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
    // Method to filter and sort valid coupon codes

        // Business line priority
        Map<String, Integer> priority = new HashMap<>();
        // Map to store business line with its priority

        priority.put("electronics", 0);
        // Electronics has highest priority

        priority.put("grocery", 1);
        // Grocery has next priority

        priority.put("pharmacy", 2);
        // Pharmacy has next priority

        priority.put("restaurant", 3);
        // Restaurant has lowest priority

        List<Pair> valid = new ArrayList<>();
        // List to store valid coupons with priority

        for (int i = 0; i < code.length; i++) {
        // Loop through all coupons

            if (isActive[i] && priority.containsKey(businessLine[i]) && isValidCode(code[i])) {
            // Check if coupon is active, business line is valid, and code format is valid

                valid.add(new Pair(priority.get(businessLine[i]), code[i]));
                // Add coupon with its priority
            }
        }

        // Sort by business priority, then by code
        Collections.sort(valid, (a, b) -> {
        // Sort the valid coupons list

            if (a.priority != b.priority)
                return a.priority - b.priority;
                // Sort by business priority

            return a.code.compareTo(b.code);
            // If priority is same, sort by code alphabetically
        });

        List<String> result = new ArrayList<>();
        // List to store final sorted coupon codes

        for (Pair p : valid) {
        // Loop through sorted valid coupons

            result.add(p.code);
            // Add coupon code to result list
        }

        return result;
        // Return the final list of coupon codes
    }

    private boolean isValidCode(String s) {
    // Method to check if coupon code is valid

        if (s.length() == 0) return false;
        // Return false if code is empty

        for (char c : s.toCharArray()) {
        // Loop through each character in the code

            if (!Character.isLetterOrDigit(c) && c != '_')
            // Check if character is not letter, digit, or underscore

                return false;
                // Return false for invalid character
        }

        return true;
        // Return true if all characters are valid
    }

    // Helper class to store (priority, code)
    static class Pair {
    // Class to hold coupon priority and code

        int priority;
        // Stores business priority

        String code;
        // Stores coupon code

        Pair(int priority, String code) {
        // Constructor to initialize values

            this.priority = priority;
            // Set priority value

            this.code = code;
            // Set coupon code
        }
    }
}
