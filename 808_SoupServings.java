class Solution {
    public double soupServings(int n) {
        // For large n, probability approaches 1
        if (n > 5000) return 1.0;

        // Convert mL to servings of 25 mL units
        int units = (n + 24) / 25;

        // Memoization table
        Double[][] memo = new Double[units + 1][units + 1];

        return dfs(units, units, memo);
    }

    private double dfs(int a, int b, Double[][] memo) {
        // Base cases
        if (a <= 0 && b <= 0) return 0.5; // Both empty
        if (a <= 0) return 1.0;           // A empty first
        if (b <= 0) return 0.0;           // B empty first

        // Check memoization
        if (memo[a][b] != null) return memo[a][b];

        // Four operations each with probability 0.25
        memo[a][b] = 0.25 * (
            dfs(a - 4, b, memo) +       // 100 mL from A, 0 from B
            dfs(a - 3, b - 1, memo) +   // 75 mL from A, 25 from B
            dfs(a - 2, b - 2, memo) +   // 50 mL from A, 50 from B
            dfs(a - 1, b - 3, memo)     // 25 mL from A, 75 from B
        );

        return memo[a][b];
    }
}
