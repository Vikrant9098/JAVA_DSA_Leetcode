class Solution 
{
    public double findMaxAverage(int[] nums, int k) 
    {
        int n = nums.length; // संख्यांच्या array ची लांबी
        int sum = 0; // सध्याचा जोडलेला सम (sum) स्टोअर करण्यासाठी  

        // पहिल्या 'k' घटकांचा एकत्रित सम काढा
        for (int i = 0; i < k; i++) 
        {
            sum += nums[i]; // sum मध्ये प्रत्येक घटक (element) जोडा
        }

        int maxSum = sum; // सुरुवातीला, जास्तीत जास्त सम (max sum) पहिल्या k घटकांचा सम आहे

        // संपूर्ण array वरून sliding window ने iterate करा
        for (int i = k; i < n; i++) 
        {
            sum += nums[i] - nums[i - k]; // नवीन घटक जोडा आणि जुन्या घटकाला वजा करा
            maxSum = Math.max(maxSum, sum); // जास्तीत जास्त सम अपडेट करा
        }

        // जास्तीत जास्त सरासरी परत द्या (maxSum / k)
        return (double) maxSum / k;
    }
}
