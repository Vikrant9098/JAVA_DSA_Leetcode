import java.util.TreeSet;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;        // number of rows
        int n = grid[0].length;     // number of columns

        TreeSet<Integer> set = new TreeSet<>(); // stores unique rhombus sums in sorted order

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                set.add(grid[i][j]); // single cell is also a rhombus of size 0

                for(int k=1;;k++){   // k represents the rhombus radius (distance from center to corner)

                    // stop if rhombus goes outside grid
                    if(i-k<0 || i+k>=m || j-k<0 || j+k>=n) break;

                    int sum = 0;

                    // traverse top -> right edge
                    int r=i-k, c=j;
                    for(int t=0;t<k;t++) 
                        sum += grid[r+t][c+t];

                    // traverse right -> bottom edge
                    r=i; c=j+k;
                    for(int t=0;t<k;t++) 
                        sum += grid[r+t][c-t];

                    // traverse bottom -> left edge
                    r=i+k; c=j;
                    for(int t=0;t<k;t++) 
                        sum += grid[r-t][c-t];

                    // traverse left -> top edge
                    r=i; c=j-k;
                    for(int t=0;t<k;t++) 
                        sum += grid[r-t][c+t];

                    set.add(sum); // store rhombus border sum
                }
            }
        }

        int size = Math.min(3, set.size()); // we only need top 3 sums
        int[] ans = new int[size];

        // get largest sums from TreeSet
        for(int i=size-1;i>=0;i--){
            ans[i] = set.pollLast(); // remove and return largest element
        }

        return ans;
    }
}