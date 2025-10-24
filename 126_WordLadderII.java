class Solution {
    private int L;          // Length of each word
    private boolean hasPath; // Flag to indicate if endWord is reachable

    // Main function to find all shortest transformation sequences
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        this.L = beginWord.length();              // Store word length
        Set<String> wordSet = new HashSet<>();    
        wordSet.addAll(wordList);                 // Convert list to set for fast lookup
        if(!wordSet.contains(endWord)) return new ArrayList<>(); // If endWord not in set, return empty

        // BFS to build graph with beginWord as root
        Map<String, List<String>> adjList = new HashMap<String, List<String>>(); // Graph: word -> neighbors
        wordSet.remove(beginWord);                // Remove beginWord if present
        buildAdjList(beginWord, endWord, wordSet, adjList); // Build adjacency graph
        if(this.hasPath==false) return new ArrayList<>(); // If no path exists, return empty

        // DFS to get all paths knowing all are shortest
        return backtrack(adjList, beginWord, endWord, new HashMap<>()); // Return all paths
    }

    // DFS helper to backtrack paths from currWord to endWord
    public List<List<String>> backtrack(
        Map<String, List<String>> adjList, 
        String currWord, 
        String endWord,
        Map<String, List<List<String>>> cache
    ){
        if(cache.containsKey(currWord)) return cache.get(currWord); // Return cached result if exists
        List<List<String>> result = new ArrayList<>();             // Store paths from currWord to endWord
        if(currWord.equals(endWord)){
            result.add(new ArrayList<>(Arrays.asList(currWord))); // Base case: path reaches endWord
        }else{
            List<String> neighbors = adjList.getOrDefault(currWord, new ArrayList<>()); // Get neighbors
            for(String neighbor: neighbors){
                List<List<String>> paths = backtrack(adjList, neighbor, endWord, cache); // Recursive DFS
                for(List<String> path: paths){
                    List<String> copy = new ArrayList<>(path); // Copy path
                    copy.add(0, currWord);                    // Add current word at beginning
                    result.add(copy);                         // Add new path to result
                }
            }
        }
        cache.put(currWord, result); // Cache result
        return result;               // Return paths from currWord
    }

    // BFS to build adjacency list
    public void buildAdjList(String beginWord, String endWord, Set<String> unvisitedWords, Map<String, List<String>> adjList){
        Queue<String> q = new LinkedList<>(); // Queue for BFS
        q.add(beginWord);                     // Add start word

        while(!q.isEmpty()){
            if(this.hasPath) break;           // Stop if endWord found
            int size = q.size();              // Current level size
            Set<String> nextLevelWords = new HashSet<>(); // Words for next BFS level
            for(int i=0; i<size; i++){
                String currWord = q.poll();                   // Take next word
                List<String> nextLevelNeighbors = getNextLevelNeighbors(currWord, unvisitedWords, adjList); // Generate neighbors
                for(String nextLevelNeighbor: nextLevelNeighbors){
                    if(!nextLevelWords.contains(nextLevelNeighbor)){ 
                        if(nextLevelNeighbor.equals(endWord)) this.hasPath = true; // Mark path found
                        nextLevelWords.add(nextLevelNeighbor); // Add to next level set
                        q.add(nextLevelNeighbor);             // Add to queue
                    }
                }
            }
            // Remove next level words from unvisited after adding edges
            for(String w: nextLevelWords){
                unvisitedWords.remove(w);
            }
        }
    }

    // Generate neighbors for a word by changing one letter at a time
    public List<String> getNextLevelNeighbors(String word, Set<String> unvisitedWords, Map<String, List<String>> adjList){
        List<String> neighbors = new ArrayList<>(); // Store neighbors
        char[] wordSeq = word.toCharArray();       // Convert word to char array
        for(int i=0; i<this.L; i++){              // For each position in word
            char oldC = wordSeq[i];               // Save original char
            for(int j=0; j<26; j++){              // Try all letters 'a' to 'z'
                char newC = (char)('a'+j);
                if(newC==oldC) continue;          // Skip same letter
                wordSeq[i]=newC;                  // Replace char
                String newWord = new String(wordSeq); // Form new word
                if(unvisitedWords.contains(newWord)){ // If word is unvisited
                    neighbors.add(newWord);        // Add to neighbors
                }
                wordSeq[i] = oldC;                // Restore original char
            }
        }
        adjList.put(word, neighbors);              // Add neighbors to graph
        return neighbors;                          // Return neighbors
    }
}
