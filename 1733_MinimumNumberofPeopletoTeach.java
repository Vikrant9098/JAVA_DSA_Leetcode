import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        // Step 1: Convert each user's known languages into a set for quick lookup
        Map<Integer, Set<Integer>> userLanguages = new HashMap<>();
        for (int i = 0; i < languages.length; i++) {
            userLanguages.put(i + 1, new HashSet<>());
            for (int lang : languages[i]) {
                userLanguages.get(i + 1).add(lang);
            }
        }

        // Step 2: Find friendships where users cannot communicate (no common language)
        Set<Integer> needTeach = new HashSet<>();
        for (int[] pair : friendships) {
            int u = pair[0];
            int v = pair[1];

            // Check if they already share a common language
            boolean canCommunicate = false;
            for (int lang : userLanguages.get(u)) {
                if (userLanguages.get(v).contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }

            // If they cannot communicate, mark them as needing to be taught
            if (!canCommunicate) {
                needTeach.add(u);
                needTeach.add(v);
            }
        }

        // Step 3: If everyone can already communicate, no teaching needed
        if (needTeach.isEmpty()) {
            return 0;
        }

        // Step 4: Try teaching one language to minimize the number of users to teach
        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;

            // Count how many users in the "needTeach" set don't know this language
            for (int user : needTeach) {
                if (!userLanguages.get(user).contains(lang)) {
                    count++;
                }
            }

            // Keep the minimum number across all possible languages
            minTeach = Math.min(minTeach, count);
        }

        // Step 5: Return the minimum number of users to teach
        return minTeach;
    }
}
