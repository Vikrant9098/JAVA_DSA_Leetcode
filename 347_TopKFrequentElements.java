class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>(); // map to store frequency of each number
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1); // update frequency
        }

        List<Integer>[] buckets = new List[nums.length + 1]; // array of lists, index = frequency
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key); // get frequency of current number
            if (buckets[freq] == null) buckets[freq] = new ArrayList<>(); // initialize bucket if null
            buckets[freq].add(key); // add number to corresponding frequency bucket
        }

        List<Integer> result = new ArrayList<>(); // list to collect top k frequent elements
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) { // iterate from high freq to low
            if (buckets[i] != null) {
                result.addAll(buckets[i]); // add all numbers in this bucket
            }
        }

        int[] topK = new int[k]; // convert list to array
        for (int i = 0; i < k; i++) {
            topK[i] = result.get(i); // copy first k elements
        }
        return topK; // return result array
    }
}
