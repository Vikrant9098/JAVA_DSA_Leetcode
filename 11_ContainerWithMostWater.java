class Solution {
    public int maxArea(int[] height) 
    {
        int left = 0; // डावीकडील पॉईंटर सुरुवातीला ठेवा
        int right = height.length - 1; // उजवीकडील पॉईंटर शेवटी ठेवा

        int maxArea = 0; // सर्वात मोठ्या क्षेत्रफळासाठी व्हेरिएबल

        // जोपर्यंत डावा आणि उजवा पॉईंटर भेटत नाहीत तोपर्यंत लूप चालवा
        while (left < right) 
        {
            // दोन पॉईंटर्समधील अंतर (रुंदी) शोधा
            int width = right - left;

            // डावीकडील आणि उजवीकडील उंचींपैकी लहान उंची निवडा
            int minHeight = Math.min(height[left], height[right]);

            // सध्याच्या रुंदी आणि उंचीचा वापर करून क्षेत्रफळ शोधा
            int currentArea = width * minHeight;

            // जर सध्याचे क्षेत्रफळ आधीच्या क्षेत्रफळापेक्षा मोठे असेल, तर अपडेट करा
            maxArea = Math.max(maxArea, currentArea);

            // ज्या पॉईंटरची उंची कमी आहे तो पुढे सरकवा, कारण जास्त उंची मिळवणे फायदेशीर ठरेल
            if (height[left] < height[right]) 
            {
                left++; // डावा पॉईंटर उजवीकडे हलवा
            } 
            else 
            {
                right--; // उजवा पॉईंटर डावीकडे हलवा
            }
        }

        return maxArea; // सर्वात मोठे क्षेत्रफळ परत करा
    }
}
