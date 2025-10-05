import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // Convert the bank array to a set for quick lookup
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        
        // If endGene is not in the bank, we can’t reach it
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        
        // Possible mutation characters
        char[] genes = {'A', 'C', 'G', 'T'};
        
        // Queue for BFS (gene string + mutation count)
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        
        // Keep track of visited genes to avoid cycles
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        
        int steps = 0; // Mutation count
        
        // BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process each level in BFS
            for (int s = 0; s < size; s++) {
                String gene = queue.poll();
                
                // If we reach the target gene, return steps
                if (gene.equals(endGene)) {
                    return steps;
                }
                
                // Try mutating each position
                for (int i = 0; i < gene.length(); i++) {
                    for (char c : genes) {
                        // Skip if same character
                        if (gene.charAt(i) == c) continue;
                        
                        // Create a mutated gene string
                        String mutated = gene.substring(0, i) + c + gene.substring(i + 1);
                        
                        // If it's a valid and unvisited mutation
                        if (bankSet.contains(mutated) && !visited.contains(mutated)) {
                            visited.add(mutated);
                            queue.offer(mutated);
                        }
                    }
                }
            }
            // After processing one BFS level, increment step count
            steps++;
        }
        
        // If no valid path found
        return -1;
    }
}
