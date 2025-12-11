import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        // Map to store: row -> all column positions where buildings exist
        Map<Integer, TreeSet<Integer>> rowToCol = new HashMap<>();
        // Map to store: column -> all row positions where buildings exist
        Map<Integer, TreeSet<Integer>> colToRow = new HashMap<>();

        // Loop through each building coordinate
        for (int building[] : buildings) {
            int x = building[0], y = building[1]; // get row and column

            // Add this column 'y' to the TreeSet of row 'x'
            rowToCol.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
            // Add this row 'x' to the TreeSet of column 'y'
            colToRow.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }

        int cnt = 0; // count covered buildings

        // Check each building again
        for (int building[] : buildings) {
            int x = building[0], y = building[1]; // current building position
            
            // Get all columns on this row
            TreeSet<Integer> cols = rowToCol.get(x);
            // Get all rows on this column
            TreeSet<Integer> rows = colToRow.get(y);
            
            // Find nearest building on the left
            Integer left = cols.lower(y);
            // Find nearest building on the right
            Integer right = cols.higher(y);
            // Find nearest building above
            Integer up = rows.lower(x);
            // Find nearest building below
            Integer down = rows.higher(x);
            
            // If all four sides have a building, it's covered
            if ((left != null) && (right != null) && (up != null) && (down != null)) {
                cnt++; // increase count
            }
        }

        return cnt; // return total covered buildings
    }
}
