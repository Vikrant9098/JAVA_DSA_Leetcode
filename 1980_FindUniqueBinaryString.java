class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        // StringBuilder is used to efficiently build the resulting binary string
        StringBuilder ans = new StringBuilder();

        // Loop through each string in the array
        // nums.length is also the length of each binary string
        for (int i = 0; i < nums.length; i++) {

            // Take the ith character from the ith string
            // If it is '0', append '1'
            // If it is '1', append '0'
            // This flips the diagonal bit
            
            // This ensures the resulting string differs from nums[i]
            // at least at position i
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');  
            // Ternary operator:
            // condition ? value_if_true : value_if_false
        }

        // Convert StringBuilder to String and return the result
        return ans.toString();
    }
}