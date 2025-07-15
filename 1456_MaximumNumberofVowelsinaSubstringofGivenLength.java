class Solution {
    public int maxVowels(String s, int k) {  
        // स्वर (vowels) साठवण्यासाठी Set तयार करतो  
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        // सर्वाधिक (max) आणि सध्याचा (current) स्वर संख्या जतन करण्यासाठी व्हेरिएबल्स  
        int maxCount = 0, currentCount = 0;

        // पहिल्या k अक्षरांसाठी स्वरांची गणना करतो  
        for (int i = 0; i < k; i++) {  
            if (vowels.contains(s.charAt(i))) {  // जर अक्षर स्वर असेल तर
                currentCount++;  // स्वर संख्या वाढवा  
            }
        }

        // प्रारंभिक स्वर संख्या maxCount मध्ये ठेवा  
        maxCount = currentCount;

        // पुढील अक्षरांवर स्लायडिंग विंडो वापरून प्रक्रिया करतो  
        for (int i = k; i < s.length(); i++) {  
            if (vowels.contains(s.charAt(i))) {  // नवीन अक्षर जर स्वर असेल तर
                currentCount++;  // स्वर संख्या वाढवा  
            }
            if (vowels.contains(s.charAt(i - k))) {  // मागील हटविलेले अक्षर जर स्वर असेल तर
                currentCount--;  // स्वर संख्या कमी करा  
            }
            // सर्वाधिक स्वर असलेल्या उपस्ट्रिंगची गणना करतो  
            maxCount = Math.max(maxCount, currentCount);
        }

        return maxCount;  // सर्वाधिक स्वर असलेल्या k लांबीच्या उपस्ट्रिंगची संख्या परत करा  
    }
}
