class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        // Create a HashSet to track seen numbers
        java.util.HashSet<Integer> seen = new java.util.HashSet<>();
        
        // Create a list to store duplicate numbers
        java.util.List<Integer> duplicates = new java.util.ArrayList<>();
        
        // Loop through each number in the array
        for (int num : nums) {
            // If number already exists in the set, it's a duplicate
            if (seen.contains(num)) {
                duplicates.add(num); // Add duplicate to the list
            } else {
                seen.add(num); // Otherwise, mark it as seen
            }
        }
        
        // Convert list of duplicates to an int array
        return new int[]{duplicates.get(0), duplicates.get(1)};
    }
}
