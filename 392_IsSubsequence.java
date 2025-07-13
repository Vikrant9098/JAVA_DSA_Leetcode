class Solution 
{
    public boolean isSubsequence(String s, String t) 
    {
        int sIndex = 0, tIndex = 0; // s आणि t साठी दोन इंडेक्स
        
        while (sIndex < s.length() && tIndex < t.length()) 
        { 
            if (s.charAt(sIndex) == t.charAt(tIndex)) 
            { 
                // जर कॅरेक्टर जुळत असेल
                sIndex++; // s मधील पुढील अक्षराकडे जा
            }

            tIndex++; // t मधील पुढील अक्षराकडे जा
        }
        
        return sIndex == s.length(); // जर s पूर्ण ट्रॅव्हर्स झाले असेल तर s हे t चे subsequence आहे
    }
}
