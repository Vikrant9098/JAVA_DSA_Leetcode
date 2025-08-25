class Solution 
{
    public int majorityElement(int[] nums) 
    {
        int count = 0;
        int candidate = 0;

        // प्रत्येक element वर loop
        for (int num : nums)                                                                             
        {
            if (count == 0) 
            {
                candidate = num; // नवीन candidate ठरवा
            }

            // जर candidate आणि num समान असतील तर count वाढवा, अन्यथा कमी करा
            if (num == candidate) 
            {
                count++;
            } 
            else 
            {
                count--;
            }
        }

        return candidate; // शेवटी candidate हा majority element असेल
    }
}
