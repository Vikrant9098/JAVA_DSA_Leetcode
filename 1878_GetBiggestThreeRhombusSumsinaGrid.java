import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;          // number of rows
        int n = grid[0].length;       // number of columns

        // TreeSet with descending order to keep largest sums first
        TreeSet<Integer> ts = new TreeSet<>((a,b) -> Integer.compare(b,a));

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                ts.add(grid[i][j]);   // single cell rhombus (size 0)

                // try all possible rhombus sizes
                for(int size = 1; size <= Math.min(m,n); size++){

                    int sum = 0;
                    boolean valid = true;  // check if rhombus stays inside grid

                    int x1 = i, y1 = j;    // first pointer
                    int x2 = i, y2 = j;    // second pointer (for opposite side)

                    int dir1 = -1, dir2 = 1; // movement directions for columns
                    int temp = 0;            // step counter along rhombus edges

                    // traverse rhombus border
                    while(temp <= 2 * size){

                        // check boundaries
                        if(Math.min(x1,x2) < 0 || Math.max(x1,x2) >= m ||
                           Math.min(y1,y2) < 0 || Math.max(y1,y2) >= n){
                            valid = false;
                            break;
                        }

                        // avoid double counting if both pointers meet
                        if(x1 == x2 && y1 == y2){
                            sum += grid[x1][y1];
                        }else{
                            sum += grid[x1][y1];
                            sum += grid[x2][y2];
                        }

                        // change direction when reaching middle of rhombus
                        if(temp == size){
                            dir2 = dir2 * dir1;
                            dir1 = dir2 * dir1;
                        }

                        // move pointers upward diagonally
                        x1--;
                        x2--;
                        y1 = y1 + dir1;
                        y2 = y2 + dir2;

                        temp++;
                    }

                    // if rhombus was valid, store its sum
                    if(valid){
                        ts.add(sum);
                    }
                }
            }
        }

        List<Integer> lst = new ArrayList<>();

        // take top 3 largest sums
        while(!ts.isEmpty() && lst.size() < 3){
            lst.add(ts.getFirst());  // largest element
            ts.removeFirst();        // remove it
        }

        // convert list to int array
        return lst.stream().mapToInt(Integer::intValue).toArray();
    }
}