class Solution 
{
    public boolean canPlaceFlowers(int[] flowerbed, int n) 
    {
        int count = 0; // किती फुले लावता येतील याची मोजणी करण्यासाठी व्हेरिएबल

        int len = flowerbed.length; // flowerbed ऍरेची लांबी (संपूर्ण बागेतील प्लॉट्स)

        for (int i = 0; i < len; i++) 
        {   
            // प्रत्येक प्लॉट तपासण्यासाठी लूप
            if (flowerbed[i] == 0) 
            { 
                // जर सध्याचा प्लॉट रिकामा असेल तरच पुढे तपास
                // डावीकडील आणि उजवीकडील प्लॉट रिकामे आहेत का ते तपासा
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0); // डावीकडील प्लॉट नाही किंवा तो रिकामा आहे
                boolean rightEmpty = (i == len - 1) || (flowerbed[i + 1] == 0); // उजवीकडील प्लॉट नाही किंवा तो रिकामा आहे

                if (leftEmpty && rightEmpty) 
                {   
                    // जर दोन्ही बाजूचे प्लॉट रिकामे असतील तरच फुल लावू शकतो
                    flowerbed[i] = 1; // फुल लावा

                    count++; // फुलांची मोजणी वाढवा
                    
                    if (count >= n) return true; // जर आवश्यक फुले लावली गेली असतील तर लगेच true परत करा

                }
            }
        }

        return count >= n; // शेवटी तपासा की गरजेइतकी फुले लावली आहेत का, आणि तसे असेल तर true परत करा
    }
}
