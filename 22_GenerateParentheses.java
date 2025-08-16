import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, "", 0, 0, n);
        return ans;
    }

    private void generate(List<String> ans, String current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            ans.add(current);
            return;
        }
        if (open < n) generate(ans, current + "(", open + 1, close, n);
        if (close < open) generate(ans, current + ")", open, close + 1, n);
    }
}
