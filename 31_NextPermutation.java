class Solution 
{
    public void nextPermutation(int[] nums) 
    {
        // 1️⃣ मागून पहिला असा index शोधा जिथे nums[i] < nums[i+1]
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) 
        {
            i--; // मागे जात राहा जोपर्यंत कमी संख्या मिळत नाही
        }

        // 2️⃣ जर i सापडला असेल, तर पुढील मोठी संख्या शोधा आणि त्याची जागा बदलून swap करा
        if (i >= 0) 
        {
            int j = nums.length - 1;
            
            while (nums[j] <= nums[i])
            {
                j--; // जिथे nums[j] > nums[i] असेल तेथपर्यंत मागे जा
            }
            swap(nums, i, j); // दोन्ही संख्या अदलाबदल करा
        }

        // 3️⃣ i नंतरचा पूर्ण भाग उलट करून लहान permutation बनवा
        reverse(nums, i + 1);
    }

    // दोन element swap करणारा फंक्शन
    private void swap(int[] nums, int i, int j) 
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // दिलेल्या index पासून पूर्ण ऍरे reverse करणारा फंक्शन
    private void reverse(int[] nums, int start) 
    {
        int end = nums.length - 1;

        while (start < end) 
        {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
