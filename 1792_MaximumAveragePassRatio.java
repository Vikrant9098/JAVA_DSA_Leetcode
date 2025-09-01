import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max heap to store (gain, pass, total) for each class
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        // Put all classes into heap with their initial gain
        for (int[] cls : classes) {
            int pass = cls[0], total = cls[1];
            double gain = gain(pass, total); // calculate first gain
            maxHeap.offer(new double[]{gain, pass, total}); // add to heap
        }
        
        // Distribute extra students one by one
        while (extraStudents-- > 0) {
            double[] top = maxHeap.poll();   // pick class with highest gain
            int pass = (int) top[1];         // current passing students
            int total = (int) top[2];        // current total students
            
            pass++;   // add one brilliant student who will pass
            total++;  // total students increase by 1
            
            double newGain = gain(pass, total);   // calculate new gain
            maxHeap.offer(new double[]{newGain, pass, total}); // push back updated class
        }
        
        // Now calculate final average pass ratio
        double sum = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] cls = maxHeap.poll(); 
            sum += cls[1] / cls[2];   // pass / total for each class
        }
        
        return sum / classes.length;  // divide by number of classes
    }
    
    // Helper to calculate improvement (gain) if one student is added
    private double gain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double)pass / total;
    }
}
