class Solution {
    public long maximumTotalDamage(int[] power) {
        // Create a HashMap to store how many times each damage value appears
        Map<Integer, Long> damageFrequency = new HashMap<>();
        // Loop through each damage value in the input array
        for (int damage : power) {
            // Increase the count of this damage value by 1 (or start from 1 if not seen before)
            damageFrequency.put(damage, damageFrequency.getOrDefault(damage, 0L) + 1);
        }

        // Create a list of all unique damage values from the map
        List<Integer> uniqueDamages = new ArrayList<>(damageFrequency.keySet());
        // Sort the unique damage values in increasing order
        Collections.sort(uniqueDamages);

        // Store how many unique damage values we have
        int totalUniqueDamages = uniqueDamages.size();
        // Create a DP array to store the maximum total damage up to each index
        long[] maxDamageDP = new long[totalUniqueDamages];

        // Calculate the total damage for the first unique damage value
        maxDamageDP[0] = uniqueDamages.get(0) * damageFrequency.get(uniqueDamages.get(0));

        // Loop through the remaining unique damage values
        for (int i = 1; i < totalUniqueDamages; i++) {
            // Get the current damage value
            int currentDamageValue = uniqueDamages.get(i);
            // Calculate total damage for this damage value (damage * frequency)
            long currentDamageTotal = currentDamageValue * damageFrequency.get(currentDamageValue);

            // Start by taking the previous maximum damage (skip current one)
            maxDamageDP[i] = maxDamageDP[i - 1];

            // Start checking from the previous damage value
            int previousIndex = i - 1;
            // Move backward while damage values are too close (difference ≤ 2)
            while (previousIndex >= 0 && 
                   (uniqueDamages.get(previousIndex) == currentDamageValue - 1 || 
                    uniqueDamages.get(previousIndex) == currentDamageValue - 2 || 
                    uniqueDamages.get(previousIndex) == currentDamageValue + 1 || 
                    uniqueDamages.get(previousIndex) == currentDamageValue + 2)) {
                // Go one step back
                previousIndex--;
            }

            // If a non-conflicting previous value exists
            if (previousIndex >= 0) {
                // Take the max between skipping current or including it
                maxDamageDP[i] = Math.max(maxDamageDP[i], maxDamageDP[previousIndex] + currentDamageTotal);
            } else {
                // If no valid previous found, compare with just taking current damage
                maxDamageDP[i] = Math.max(maxDamageDP[i], currentDamageTotal);
            }
        }

        // Return the maximum total damage from the last DP index
        return maxDamageDP[totalUniqueDamages - 1];
    }
}
