import java.util.*; 
// Import utility classes

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        TreeMap<Integer, List<List<String>>> byTime = new TreeMap<>();
        // TreeMap to group events by time in sorted order

        for (List<String> ev : events) {
            int t = Integer.parseInt(ev.get(1));
            // Extract event time
            byTime.computeIfAbsent(t, k -> new ArrayList<>()).add(ev);
            // Add event into list for that time
        }

        int[] mentions = new int[numberOfUsers];
        // Count mentions for each user

        boolean[] isOnline = new boolean[numberOfUsers];
        // Track if a user is online

        int[] offlineUntil = new int[numberOfUsers];
        // Track when offline users will come back online

        Arrays.fill(isOnline, true);
        // All users start online

        for (Map.Entry<Integer, List<List<String>>> entry : byTime.entrySet()) {
            int t = entry.getKey();
            // Current time

            List<List<String>> evs = entry.getValue();
            // All events at this time

            for (int i = 0; i < numberOfUsers; ++i) {
                if (!isOnline[i] && offlineUntil[i] <= t) {
                    isOnline[i] = true;
                    // User comes online again

                    offlineUntil[i] = 0;
                    // Clear offline timeout
                }
            }

            for (List<String> ev : evs) {
                if (ev.get(0).equals("OFFLINE")) {
                    int id = Integer.parseInt(ev.get(2));
                    // Get user ID going offline

                    isOnline[id] = false;
                    // Mark user offline

                    offlineUntil[id] = t + 60;
                    // They come back online after 60s
                }
            }

            for (List<String> ev : evs) {
                if (!ev.get(0).equals("MESSAGE")) continue;
                // Only process message events

                String mentionsStr = ev.get(2);
                // Get mention string

                String[] tokens = mentionsStr.split("\\s+");
                // Split by spaces

                for (String token : tokens) {
                    if (token.equals("ALL")) {
                        // Message mentions everyone
                        for (int i = 0; i < numberOfUsers; ++i) mentions[i]++;

                    } else if (token.equals("HERE")) {
                        // Mentions only online users
                        for (int i = 0; i < numberOfUsers; ++i)
                            if (isOnline[i]) mentions[i]++;

                    } else if (token.startsWith("id")) {
                        // Mentions single user by id
                        int id = Integer.parseInt(token.substring(2));
                        if (id >= 0 && id < numberOfUsers) mentions[id]++;
                    }
                }
            }
        }

        return mentions;
        // Return final count
    }
}
