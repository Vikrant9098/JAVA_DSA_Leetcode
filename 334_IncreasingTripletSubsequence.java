class Solution 
{
    public boolean increasingTriplet(int[] nums) 
    {
        int first = Integer.MAX_VALUE;  // पहिली सर्वात लहान संख्या
        int second = Integer.MAX_VALUE; // दुसरी सर्वात लहान संख्या
        
        for (int num : nums) 
        {
            // संपूर्ण अ‍ॅरेवर लूप चालवा
            if (num <= first) 
            { 
                first = num;  // पहिली सर्वात लहान संख्या साठवा
            } 
            else if (num <= second) 
            { 
                second = num; // दुसरी लहान संख्या साठवा (ती first पेक्षा मोठी हवी)
            } 
            else 
            { 
                return true;  // जर तिसरी संख्या 'second' पेक्षा मोठी असेल तर triplet सापडला!
            }
        }
        return false;  // जर लूप पूर्ण झाला आणि काहीही सापडलं नाही तर false परत करा
    }
}
