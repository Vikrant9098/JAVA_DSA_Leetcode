class Solution {
    public int longestOnes(int[] nums, int k) {
            int left = 0, right = 0; // दोन पॉईंटर्स स्लाइडिंग विंडोसाठी
        int zeroCount = 0; // सध्याच्या विंडोमध्ये असलेल्या 0s ची संख्या
        int maxOnes = 0; // जास्तीत जास्त सलग 1s मोजण्यासाठी

        // उजव्या दिशेने (right pointer) स्लाइडिंग विंडो वाढवत जाऊ
        while (right < nums.length) {
            // जर nums[right] = 0 असेल तर zeroCount वाढवतो
            if (nums[right] == 0) {
                zeroCount++;
            }

            // जर 0 ची संख्या k पेक्षा जास्त झाली, तर विंडो संकुचित करतो
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--; // डावीकडील 0 काढतो
                }
                left++; // डावा पॉईंटर पुढे नेत विंडो छोटा करतो
            }

            // नवीन विंडोचा आकार मोजतो
            maxOnes = Math.max(maxOnes, right - left + 1);

            // उजवा पॉईंटर पुढे नेत विंडो मोठा करतो
            right++;
        }

        return maxOnes; // जास्तीत जास्त सलग 1s परत करतो
    }
}