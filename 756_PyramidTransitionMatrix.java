class Solution {

    // Map to store rules: two chars -> list of possible top chars
    Map<String, List<Character>> rules = new HashMap<>();

    // Set to store invalid rows (memoization)
    Set<String> bad = new HashSet<>();

    // Main function to check if pyramid can be built
    public boolean pyramidTransition(String bottom, List<String> allowed) {

        // Loop through each allowed rule
        for (String s : allowed) {

            // Use first two chars as key, add third char as possible top
            rules.computeIfAbsent(s.substring(0, 2), k -> new ArrayList<>())
                 .add(s.charAt(2));
        }

        // Start DFS from bottom row, index 0, empty next row
        return dfs(bottom, 0, new StringBuilder());
    }

    // DFS function to try building pyramid
    private boolean dfs(String row, int idx, StringBuilder next) {

        // If only one block left, pyramid is valid
        if (row.length() == 1) return true;

        // If current row is fully processed
        if (idx == row.length() - 1) {

            // Convert next row to string
            String nextRow = next.toString();

            // If this row already failed before, return false
            if (bad.contains(nextRow)) return false;

            // Recursively try building above this row
            boolean ok = dfs(nextRow, 0, new StringBuilder());

            // If failed, mark this row as bad
            if (!ok) bad.add(nextRow);

            // Return result
            return ok;
        }

        // Take two adjacent blocks as key
        String key = row.substring(idx, idx + 2);

        // If no rule exists for this pair, fail
        if (!rules.containsKey(key)) return false;

        // Try each possible top character
        for (char c : rules.get(key)) {

            // Add character to next row
            next.append(c);

            // Move to next index
            if (dfs(row, idx + 1, next)) return true;

            // Backtrack: remove last character
            next.deleteCharAt(next.length() - 1);
        }

        // If no option works, return false
        return false;
    }
}
