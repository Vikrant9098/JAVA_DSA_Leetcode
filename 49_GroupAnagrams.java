import java.util.Map;

class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        // Create a HashMap to group words by their sorted version (key = sorted word)
        Map<String, List<String>> map = new HashMap<>();

        // Loop through each string in the input array
        for(String s : strs)
        {
            // Convert the string into a char array (so we can sort the characters)
            char[] charArray = s.toCharArray();

            // Sort the characters in the array
            Arrays.sort(charArray);

            // Convert the sorted char array back to a string (this will be the key)
            String sortedKey = new String(charArray);

            // If the sortedKey is not already in the map, put it with a new empty list
            map.putIfAbsent(sortedKey, new ArrayList<>());
            
            // Add the original string to the list for this sortedKey
            map.get(sortedKey).add(s);
        }

        // Return all the grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }
}
