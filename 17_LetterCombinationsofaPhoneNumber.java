class Solution {

    // Map to store digit-to-letter mapping like on a phone keypad
    private Map<Character, List<Character>> dial = new HashMap<>();
    
    // Instance initializer block to populate the map with digit-letter mappings
    {
        dial.put('2', List.of('a', 'b', 'c'));
        dial.put('3', List.of('d', 'e', 'f'));
        dial.put('4', List.of('g', 'h', 'i'));
        dial.put('5', List.of('j', 'k', 'l'));
        dial.put('6', List.of('m', 'n', 'o'));
        dial.put('7', List.of('p', 'q', 'r', 's'));
        dial.put('8', List.of('t', 'u', 'v'));
        dial.put('9', List.of('w', 'x', 'y', 'z'));
    }
    
    // Main function to generate all letter combinations of the input digits
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>(); // Stores final combinations

        // If input is empty, return empty list
        if (digits.length() == 0) {
            return ans;
        }

        // Start backtracking from index 0
        backtrack(ans, new ArrayList<>(), digits.toCharArray(), 0);
        return ans;
    }
    
    // Backtracking function to build combinations
    private void backtrack(List<String> ans, List<Character> curr, char[] digits, int next) {
        
        // If current combination size matches digits length, it's complete
        if (curr.size() == digits.length) {
            // Convert list of characters to a string and add to answer
            ans.add(curr.stream().map(String::valueOf).collect(Collectors.joining()));
            return;
        }
        
        // Get the digit we are processing next
        Character nextDigit = digits[next];

        // Loop through all letters mapped to this digit
        for (int i = 0; i < dial.get(nextDigit).size(); i++) {
            curr.add(dial.get(nextDigit).get(i));     // Add one letter
            backtrack(ans, curr, digits, next+1);     // Move to next digit
            curr.removeLast();                        // Backtrack: remove last letter
        }
    }
}
