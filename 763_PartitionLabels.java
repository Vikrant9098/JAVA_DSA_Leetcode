class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>(); // to store sizes of partitions
        int[] lastIndex = new int[26]; // store last occurrence of each character

        // Step 1: Record the last index of every character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0; // start and end of current partition

        // Step 2: Iterate through the string to determine partitions
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']); // extend end to last occurrence of current char
            if (i == end) { // current index reaches end of partition
                result.add(end - start + 1); // add partition size
                start = i + 1; // start next partition
            }
        }

        return result; // return list of partition sizes
    }
}
