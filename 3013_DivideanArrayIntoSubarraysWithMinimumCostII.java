class Solution {

    // This method calculates the minimum cost based on constraints k and dist
    public long minimumCost(int[] nums, int k, int dist) {

        // result stores the minimum answer found so far (initialized to max value)
        long result = Long.MAX_VALUE;

        // windowSum stores the sum of currently selected (k - 1) elements
        long windowSum = 0L;

        // Length of the input array
        int n = nums.length;

        /*
         * TreeSet 'using':
         * - Stores indices of the currently selected (k - 1) smallest elements
         * - Sorted by nums[index], and by index if values are equal
         */
        TreeSet<Integer> using = new TreeSet<>(
            (a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]
        );

        /*
         * TreeSet 'waiting':
         * - Stores remaining indices inside the window that are not selected
         * - Same sorting logic as 'using'
         */
        TreeSet<Integer> waiting = new TreeSet<>(
            (a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]
        );

        // --------------------------------------------------
        // STEP 1: Initialize the first window
        // --------------------------------------------------

        // Add the first (dist + 1) elements (excluding index 0) into 'using'
        for (int i = 1; i <= dist + 1; i++) {
            using.add(i);           // add index to using set
            windowSum += nums[i];   // add value to windowSum
        }

        /*
         * We only need (k - 1) elements in 'using'
         * If 'using' has more, move the largest ones to 'waiting'
         */
        while (using.size() > k - 1) {
            int i = using.pollLast(); // remove the largest element
            windowSum -= nums[i];     // subtract its value from sum
            waiting.add(i);           // move it to waiting set
        }

        // Update result with the sum of current (k - 1) elements
        result = Math.min(result, windowSum);

        // --------------------------------------------------
        // STEP 2: Slide the window
        // --------------------------------------------------

        // i represents the left boundary of the sliding window
        for (int i = 1; i + dist + 1 < n; i++) {

            // Add the new element entering the window into waiting set
            waiting.add(i + dist + 1);

            /*
             * Now remove index 'i' since it is leaving the window
             */
            if (using.contains(i)) {
                /*
                 * Case 1: index 'i' is currently part of the selected (k - 1) elements
                 */

                windowSum -= nums[i]; // remove its value from sum
                using.remove(i);      // remove index from using

                // Take the smallest available element from waiting
                int j = waiting.pollFirst();

                windowSum += nums[j]; // add its value to sum
                using.add(j);         // move it into using

            } else {
                /*
                 * Case 2: index 'i' is NOT in using, so it must be in waiting
                 */

                waiting.remove(i); // simply remove it from waiting

                /*
                 * Now check if swapping improves the sum:
                 * - j1: smallest element in waiting
                 * - j2: largest element in using
                 */
                int j1 = waiting.first();
                int j2 = using.last();

                // If waiting has a smaller value than the largest in using
                if (nums[j1] < nums[j2]) {

                    // Remove the larger value from using
                    windowSum -= nums[j2];
                    using.remove(j2);
                    waiting.add(j2);

                    // Add the smaller value from waiting into using
                    windowSum += nums[j1];
                    using.add(j1);
                    waiting.remove(j1);
                }
            }

            // Update result after each window slide
            result = Math.min(result, windowSum);
        }

        // Add nums[0] because the problem requires including index 0 in final cost
        return result + nums[0];
    }
}
