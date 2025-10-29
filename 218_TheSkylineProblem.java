import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();  // store all building start and end points
        
        // convert each building into two points: start and end
        for (int[] b : buildings) {
            points.add(new int[]{b[0], -b[2]}); // start point (height negative to mark start)
            points.add(new int[]{b[1], b[2]});  // end point (height positive to mark end)
        }

        // sort points by x; if same x, sort by height
        Collections.sort(points, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // sort by x
            return a[1] - b[1];                   // then by height
        });

        // max-heap to keep track of current heights
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.add(0); // ground level height
        int prevHeight = 0; // previous skyline height
        List<List<Integer>> result = new ArrayList<>(); // final skyline list

        // process each point
        for (int[] p : points) {
            if (p[1] < 0) {       // if start point
                heap.add(-p[1]);  // add building height
            } else {              // if end point
                heap.remove(p[1]); // remove building height
            }

            int currHeight = heap.peek(); // get current max height

            // if skyline height changes, record the point
            if (currHeight != prevHeight) {
                result.add(Arrays.asList(p[0], currHeight)); // add new skyline point
                prevHeight = currHeight; // update previous height
            }
        }

        return result; // return final skyline
    }
}
