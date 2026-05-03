class Solution {
    public boolean rotateString(String s, String goal) {
        // First check: lengths must be equal
        if (s.length() != goal.length()) {
            return false;
        }

        // Concatenate s+s → contains all rotations
        String doubled = s + s;

        // Check if goal is substring of doubled string
        return doubled.contains(goal);
    }
}
