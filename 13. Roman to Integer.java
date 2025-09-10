import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        // Step 1: Map each Roman symbol to its value
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;  // final answer
        int prevValue = 0;  // value of previous symbol (to check subtraction cases)

        // Step 2: Loop through the string from **end to start**
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = map.get(s.charAt(i)); // Get value of current symbol

            // Step 3: If current < previous → subtract; else → add
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }

            // Step 4: Update previous value
            prevValue = currentValue;
        }

        return total;
    }
}
