class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0; // पुढील शून्ये नसलेला (non-zero) घटक घालण्यासाठी स्थिती ठेवणारा इंडेक्स

        // पहिला पास: सर्व शून्ये नसलेले घटक (non-zero elements) सुरुवातीला हलवतो
        for (int num : nums) {  
            if (num != 0) { // जर संख्येचे मूल्य 0 नसेल तर 
                nums[insertPos++] = num; // त्या संख्येला पुढील उपलब्ध स्थितीत ठेवतो आणि इंडेक्स वाढवतो
            }
        }

        // दुसरा पास: उर्वरित स्थान शून्यांनी भरण्यासाठी
        while (insertPos < nums.length) { 
            nums[insertPos++] = 0; // उर्वरित घटकांना 0 सेट करतो
        }
    }
}
