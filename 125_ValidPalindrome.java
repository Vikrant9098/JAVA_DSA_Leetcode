class Solution {
    public boolean isPalindrome(String s) {
        int left = 0; // pointer at start
        int right = s.length() - 1; // pointer at end

        while (left < right) {
            // Move left pointer until it points to an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer until it points to an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // Not palindrome
            }

            left++;
            right--;
        }

        return true; // If all checks pass, it's a palindrome
    }
}
